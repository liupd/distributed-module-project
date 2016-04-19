package cn.wa.net.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 学科表
 */
@TableName(value = "bd_subjects")
public class Subjects implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	@TableId
	private String id;
	/**
	 * 业务主键
	 */
	@TableField(value = "business_key")
	private String businessKey;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	private Date createTime;
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 修改时间
	 */
	@TableField(value = "update_time")
	private Date updateTime;

	/**
	 *创建者业务主键
	 */
	@TableField(value = "user_business_key")
	private String userBusinessKey;

	@TableField(value = "is_delete")
	private String isDelete;

	public String getBusinessKey() {
		return this.businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserBusinessKey() {
		return this.userBusinessKey;
	}

	public void setUserBusinessKey(String userBusinessKey) {
		this.userBusinessKey = userBusinessKey;
	}

	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
