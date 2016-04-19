package cn.wa.net.mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liupd on 16-4-15.
 **/

@Repository
public class MongoDaoImpl implements MongoDao{

    @Autowired
    private MongoTemplate template;

    @Override
    public String saveFileResource(File resource) {
        try {
            DB db = template.getDb();
            GridFS fs = new GridFS(db);
            GridFSInputFile inputFile = fs.createFile(resource);
            inputFile.setFilename(resource.getName());
            inputFile.setContentType(getContentType(resource.getAbsolutePath()));
            inputFile.save();
            return  inputFile.getId().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String updateFileResource(String fileId, File resource) {
        try {
            DB db = template.getDb();
            GridFS fs = new GridFS(db);
            GridFSInputFile inputFile = fs.createFile(resource);
            inputFile.setFilename(resource.getName());
            inputFile.setContentType(getContentType(resource.getAbsolutePath()));
            inputFile.save();
            if(fileId!=null){
                ObjectId oid = new ObjectId(fileId);
                fs.remove(oid);
            }
            return  inputFile.getId().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delFileResource(String fileId) {
        boolean succ = false;
        try{
            DB db = template.getDb();
            GridFS fs = new GridFS(db);
            ObjectId oid = new ObjectId(fileId);
            fs.remove(oid);
            succ = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return succ;
    }

    @Override
    public String getFileIdByResId(String resFileId) {
        DBCollection dbc= template.getCollection("fs");
        DB db=dbc.getDB();
        GridFS myFS = new GridFS(db);
        GridFSDBFile gfsFile = myFS.find(new ObjectId(resFileId));
        if(null!=gfsFile)
        {
            return String.valueOf(gfsFile.getId());
        }
        return null;
    }

    @Override
    public Map<String, Object> getFileInfo(String resFileId) {
        DBCollection dbc= template.getCollection("fs");
        DB db=dbc.getDB();
        GridFS myFS = new GridFS(db);
        GridFSDBFile gfsFile = myFS.find(new ObjectId(resFileId));
        Map<String,Object> map=new HashMap<>();
        if(null!=gfsFile){
            map.put("contentType",gfsFile.get("contentType"));
            map.put("fileName",gfsFile.get("filename"));
            return map;
        }
        return null;
    }

    @Override
    public boolean getResFileById(String resId, File outfile) {
        try {
            DBCollection dbc= this.template.getCollection("fs");
            DB db=dbc.getDB();
            GridFS myFS = new GridFS(db);
            GridFSDBFile gfsFile = myFS.find(new ObjectId(resId));
            if(null==gfsFile)
            {
                return false;
            }
            gfsFile.writeTo(outfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    private String getContentType(String pathStr)throws IOException {
        Path path = Paths.get(pathStr);
        return Files.probeContentType(path);
    }
}
