package cn.wa.net.domain;


import java.io.Serializable;

/**
 *
 * 系统静态参数配置表
 * Created by liupd
 */
public class StaticConfig implements Serializable{

    /**
     * primary key
     */
    private String  id;

    /**
     * 显示名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 类别
     */
    private String type;

    /**
     * 排序
     */
    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
