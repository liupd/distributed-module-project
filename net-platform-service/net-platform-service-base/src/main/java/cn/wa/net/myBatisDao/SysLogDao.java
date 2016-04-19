package cn.wa.net.myBatisDao;



import cn.wa.net.domain.SysLog;
import cn.wa.net.formbean.SysLogVo;

import java.util.List;

/**
 * Created by liupd on 2015/11/13
 */
public interface SysLogDao {

    public List<SysLog> findSysLog(SysLogVo sysLogVo);

    public Integer findSysLogCount(SysLogVo sysLogVo);

    public int addSysLog(SysLog sysLog);

    public int delSysLog(String id);
}
