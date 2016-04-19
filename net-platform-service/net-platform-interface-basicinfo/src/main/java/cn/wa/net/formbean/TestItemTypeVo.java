package cn.wa.net.formbean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/6/26 0026.
 **/
public class TestItemTypeVo implements Serializable {

    String id;
    /**
     * 业务主键
     */
    String businessKey;

    /**
     * 题型名称
     */
    String name;

    /**
     * 主客观（N：主观，Y：客观）
     */
    String isObject;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 修改时间
     */
    Date updateTime;


    String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsObject() {
        return isObject;
    }

    public void setIsObject(String isObject) {
        this.isObject = isObject;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
