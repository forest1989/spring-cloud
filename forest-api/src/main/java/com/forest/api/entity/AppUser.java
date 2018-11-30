package com.forest.api.entity;

import org.hibernate.validator.constraints.Length;

import com.forest.api.common.persistence.DataEntity;

/**
 * 
 * @author forest
 *
 */
public class AppUser extends DataEntity<AppUser>{

	private static final long serialVersionUID = 1L;
	private String loginName; // 登录名
	private String password; // 密码
	private String photo; // 用户图像
	private String name; // 用户姓名
	private String nickName; // 用户昵称
	private String sex; // 性别
	private String phone; // 手机号码
	private String email; // 邮箱
	private String loginFlag; // 是否可登陆（0：正常 1：禁止登录）
	private String newPassWord;
	private String areaId;
	
	private String shopAccountId;//购物币 账户id
	
	
	
	public String getShopAccountId() {
		return shopAccountId;
	}

	public void setShopAccountId(String shopAccountId) {
		this.shopAccountId = shopAccountId;
	}

	public AppUser() {
		super();
	}

	public AppUser(String id) {
		super(id);
	}

	/**
	 * @param password
	 * @param id
	 */
	public AppUser(String password, String id) {
		super();
		this.password = password;
		this.id = id;
	}

	@Length(min = 1, max = 100, message = "登录名长度必须介于 1 和 100 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Length(min = 1, max = 200, message = "密码长度必须介于 1 和 200 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Length(min = 0, max = 1000, message = "用户图像长度必须介于 0 和 1000 之间")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Length(min = 0, max = 100, message = "用户姓名长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Length(min = 0, max = 100, message = "用户昵称长度必须介于 0 和 100 之间")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Length(min = 0, max = 10, message = "性别长度必须介于 0 和 10 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Length(min = 0, max = 200, message = "手机号码长度必须介于 0 和 200 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min = 0, max = 200, message = "邮箱长度必须介于 0 和 200 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Length(min = 1, max = 64, message = "是否可登陆（0：正常  1：禁止登录）长度必须介于 1 和 64 之间")
	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
