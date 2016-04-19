package cn.wa.net.formbean;


import java.io.Serializable;

/**
 *
 * 系统静态参数配置表
 *
 * Created by heizhiqiang on 2015/11/16
 */
public class StaticConfigVo implements Serializable{

    /**
     * 显示名称
     */
    private String name;

    /**
     * 值
     */
    private String value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
