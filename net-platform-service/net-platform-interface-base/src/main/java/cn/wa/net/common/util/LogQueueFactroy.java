package cn.wa.net.common.util;

import cn.wa.net.formbean.SysLogVo;

/**
 * Created by Administrator on 16-4-18.
 **/
public class LogQueueFactroy {

    private static FIFOQueue<SysLogVo> logQueue = null;

    static{
        if(logQueue==null) logQueue = new FIFOQueue<SysLogVo>();
    }

    public static void pushLog(SysLogVo log){
        logQueue.push(log);
    }

    public static SysLogVo popLog(){
        return logQueue.pop();
    }

    public static int getLogQueueSize(){
        return logQueue.size();
    }

}
