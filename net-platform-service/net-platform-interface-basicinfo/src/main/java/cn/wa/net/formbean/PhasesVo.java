package cn.wa.net.formbean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/17.
 **/
public class PhasesVo implements Serializable {
    /**
     * 主键
     *
     */
    String id;
    /**
     * 业务主键
     */
    String businessKey;

    /**
     * 名称
     */
    String name;


    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 修改时间
     */
    Date updateTime;

    /**
     * 是否删除（Y：删除，N：不删除）
     */
    String isDelete="N";

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
