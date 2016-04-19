package cn.wa.net.formbean;

/**
 * Created by liupd on 2015/3/25.
 **/
public enum LoginStatus{

    SUCCESS,CODEERROR,PWDERROR,INVALID,NOAUTH;

    public String toDescribe(){
        switch (this){
            case SUCCESS:
                return "成功";
            case CODEERROR:
                return "用户名错误";
            case PWDERROR:
                return "密码错误";
            case INVALID:
                return "用户无效";
            case NOAUTH:
                return "无权限";
        }
        return null;
    }
}