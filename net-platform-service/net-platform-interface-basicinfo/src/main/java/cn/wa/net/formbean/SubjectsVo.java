package cn.wa.net.formbean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dell on 2015/6/3.
 **/
public class SubjectsVo implements Serializable {
    private String id;
    /**
    * 业务主键
    */
    private String businessKey;

    /**
     * 名称
     */
    private String name;

    /**
     *创建者业务主键
     */
    private String userBusinessKey;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
    private String isDelete;

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

    public String getUserBusinessKey() {
        return userBusinessKey;
    }

    public void setUserBusinessKey(String userBusinessKey) {
        this.userBusinessKey = userBusinessKey;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
