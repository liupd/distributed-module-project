package cn.wa.net.mongo;


import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 16-4-15.
 **/
public interface MongoDao {

    public String saveFileResource(File resource);

    public String updateFileResource(String fileId, File resource);

    public boolean delFileResource(String fileId);

    public String getFileIdByResId(String resFileId);

    public Map<String,Object> getFileInfo(String resFileId);

    public boolean getResFileById(String resId, File outfile) ;

}
