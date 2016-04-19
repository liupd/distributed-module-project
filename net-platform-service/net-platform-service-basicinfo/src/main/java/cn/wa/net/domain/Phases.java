package cn.wa.net.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 学段表
 */
@TableName(value = "bd_phases")
public class Phases implements Serializable {

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
	 * 是否删除（Y：删除，N：不删除）
	 */
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
