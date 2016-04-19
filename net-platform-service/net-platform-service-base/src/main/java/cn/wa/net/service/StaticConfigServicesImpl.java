package cn.wa.net.service;

import cn.wa.net.formbean.StaticConfigVo;
import cn.wa.net.myBatisDao.ConfigServicesDao;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Liupd on 15-12-17.
 **/
@Service
public class StaticConfigServicesImpl implements StaticConfigServices {

    private static final Logger logger = Logger.getLogger(StaticConfigServicesImpl.class);

    @Resource
    private ConfigServicesDao configServicesDao;

    @Override
    public List<StaticConfigVo> getAllCategroy() {
        return configServicesDao.getAllCategroy();
    }

    @Override
    public List<StaticConfigVo> getAllQuestionType() {
        return configServicesDao.getAllQuestionType();
    }

    @Override
    public List<StaticConfigVo> getAllEbookType() {
        return configServicesDao.getAllEbookType();
    }

    @Override
    public List<StaticConfigVo> getAllResourceCategroy() {
        return configServicesDao.getAllResourceCategroy();
    }

    @Override
    public List<StaticConfigVo> getAllResourceTeachType() {
        return configServicesDao.getAllResourceTeachType();
    }

    @Override
    public List<StaticConfigVo> getAllTextbookType() {
        return configServicesDao.getAllTextbookType();
    }
}
