package cn.wa.net.webapp.utils;

/**
 * Created by Administrator on 16-4-18.
 **/
public class JsonResult {

    AjaxStatus status;

    String resultstr;

    Object bean;

    public JsonResult(AjaxStatus status, String resultstr) {
        this.status = status;
        this.resultstr = resultstr;
    }

    public JsonResult(AjaxStatus status) {
        this.status = status;
        this.resultstr = "";
    }

    public JsonResult(AjaxStatus status, Object bean) {
        this.status = status;
        this.bean = bean;
    }

    public AjaxStatus getStatus() {
        return status;
    }

    public void setStatus(AjaxStatus status) {
        this.status = status;
    }

    public String getResultstr() {
        return resultstr;
    }

    public void setResultstr(String resultstr) {
        this.resultstr = resultstr;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
