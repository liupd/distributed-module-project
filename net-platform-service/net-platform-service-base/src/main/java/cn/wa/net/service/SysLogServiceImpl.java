package cn.wa.net.service;

import cn.wa.net.domain.SysLog;
import cn.wa.net.formbean.SysLogVo;
import cn.wa.net.myBatisDao.SysLogDao;
import cn.wa.net.utils.EntityUtils;
import cn.wa.net.utils.IdSequence;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogServices {

    private static final Logger logger = Logger.getLogger(SysLogServiceImpl.class);

    @Resource
    private SysLogDao sysLogDao;

    @Override
    public List<SysLogVo> findSysLog(SysLogVo sysLogVo) {
        List<SysLog> list = sysLogDao.findSysLog(sysLogVo);
        return EntityUtils.copyListProperties(SysLogVo.class, list);

    }

    @Override
    public int findSysLogCount(SysLogVo sysLogVo) {
        int count = sysLogDao.findSysLogCount(sysLogVo);
        return count;
    }

    @Override
    public String addSysLog(SysLogVo sysLogVo) {
        SysLog sysLog =  EntityUtils.copyProperties(SysLog.class, sysLogVo);
        sysLog.setId(IdSequence.nextId());
        logger.debug("--------sysLogVo-------" + JSON.toJSONString(sysLogVo));
        sysLogDao.addSysLog(sysLog);
        return sysLog.getId();
    }

    @Override
    public int delSysLog(String id) {
         return sysLogDao.delSysLog(id);
    }
}
