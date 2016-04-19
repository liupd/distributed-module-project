package cn.wa.net.webapp.aop;


import cn.wa.net.common.util.Constants;
import cn.wa.net.common.util.LogQueueFactroy;
import cn.wa.net.formbean.LogType;
import cn.wa.net.formbean.SysLogVo;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by liupd on 16-4-18.
 **/
@Component
@Aspect
public class SysLogAop {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void operation() {}

    @Around(value = "operation()")
    public Object operationAop(ProceedingJoinPoint pjp) throws Throwable {
        Object resultObject = null;
        String methodName = pjp.getSignature().getName();
        SysLogVo sysLogVo = new SysLogVo();
        //执行目标方法
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            //请求的IP
            String ip = getRemoteAddr(request);
            String requestUrl = request.getRequestURL().toString();
            String agent = request.getHeader("User-Agent");
            String requestParams = getRequestParamsForJSON(request);
            String method = request.getMethod();
            //读取session中的用户
            String userCode = (String)session.getAttribute(Constants.user_code);
            String userName = (String)session.getAttribute(Constants.user_name);
            String userBusinesskey = (String)session.getAttribute(Constants.user_key);
            resultObject = pjp.proceed();
            String result = JSON.toJSONString(resultObject);
            sysLogVo.setType(LogType.SYSTEM);
            sysLogVo.setUserKey(userBusinesskey);
            sysLogVo.setUserName(userName);
            sysLogVo.setAgent(agent);
            sysLogVo.setMethod(method);
            sysLogVo.setParams(requestParams);
            sysLogVo.setRequestUrl(requestUrl);
            sysLogVo.setRemoteAddr(getRemoteAddr(request));
            sysLogVo.setResult(result);
            sysLogVo.setRequestTime(new Date());
        } catch (Throwable e) {
            //异常通知
            sysLogVo.setType(LogType.EXCEPTION);
            String exception = e.toString();
            if(exception.length()>50000){
                exception = exception.substring(0,30000);
            }
            sysLogVo.setResult(exception);
            System.out.println("The method " + methodName + " occurs expection : " + e);
            throw new RuntimeException(e);
        }finally{
            LogQueueFactroy.pushLog(sysLogVo);
        }
        return resultObject;
    }

    public String getRequestParamsForJSON(HttpServletRequest request) {

        Map<String, String[]> requestMap = request.getParameterMap();
        if (requestMap != null && !requestMap.isEmpty()) {
            return JSON.toJSONString(requestMap);
        } else {
            return "";
        }
    }

    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }


}
