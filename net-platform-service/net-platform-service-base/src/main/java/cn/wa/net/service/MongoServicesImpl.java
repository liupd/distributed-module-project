package cn.wa.net.service;

import cn.wa.net.mongo.MongoDao;
import com.alibaba.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.Map;

/**
 * Created by liupd on 16-4-15.
 **/
@Service
public class MongoServicesImpl implements MongoServices{

    @Resource
    private MongoDao mongoDao;

    @Override
    public String saveFileResource(File resource) {
        return mongoDao.saveFileResource(resource);
    }

    @Override
    public String updateFileResource(String fileId, File resource) {
        return mongoDao.updateFileResource(fileId, resource);
    }

    @Override
    public boolean delFileResource(String fileId) {
        return mongoDao.delFileResource(fileId);
    }

    @Override
    public String getFileIdByResId(String resFileId) {
        return mongoDao.getFileIdByResId(resFileId);
    }

    @Override
    public Map<String, Object> getFileInfo(String resFileId) {
        return mongoDao.getFileInfo(resFileId);
    }

    @Override
    public boolean getResFileById(String resId, File outfile) {
        return mongoDao.getResFileById(resId, outfile);
    }
}
