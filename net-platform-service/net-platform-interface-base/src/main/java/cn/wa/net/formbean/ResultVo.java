package cn.wa.net.formbean;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by dell on 2015/6/2.
 **/

@XmlRootElement(name = "root")
@XmlType(propOrder={"status","message","results"})//定义xml中元素的顺序
public class ResultVo<T> implements Serializable {

    //本次API访问状态，如果成功返回200，如果失败返回其他数字
    int status=200;

    //对API访问状态值的英文说明，如果成功返回"success"，并返回结果字段，如果失败返回错误说明。
    String message="success";

    //结果集
    T results;

    public ResultVo() {
    }

    public ResultVo(int status, String message, T results) {
        this.message = message;
        this.results = results;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
