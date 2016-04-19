package cn.wa.net.service;

import cn.wa.net.formbean.SysLogVo;

import java.util.List;

/**
 * Created by Administrator on 16-4-15.
 **/

public interface SysLogServices {
    /**
     *日志列表
     * **/
    public List<SysLogVo> findSysLog(SysLogVo sysLogVo);
    /**
     * 日志总数
     */
    public int findSysLogCount(SysLogVo sysLogVo);
    /**
     * 增加日志
     * **/
    public String addSysLog(SysLogVo sysLogVo);
    /**
     * 删除日志
     **/
    public int delSysLog(String id);

}
