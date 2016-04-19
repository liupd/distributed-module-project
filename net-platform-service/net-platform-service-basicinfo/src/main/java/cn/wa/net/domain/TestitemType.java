package cn.wa.net.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 试题类型表
 */
@TableName(value = "bd_testitem_type")
public class TestitemType implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	@TableId
	private String id;

	@TableField(value = "business_key")
	private String businessKey;

	@TableField(value = "create_time")
	private Date createTime;

	@TableField(value = "is_object")
	private String isObject;

	private String name;

	@TableField(value = "update_time")
	private Date updateTime;

	@TableField(value = "is_delete")
	private String isDelete;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getIsObject() {
		return this.isObject;
	}

	public void setIsObject(String isObject) {
		this.isObject = isObject;
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

	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

}
