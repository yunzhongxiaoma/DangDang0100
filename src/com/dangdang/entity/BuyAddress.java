package com.dangdang.entity;

public class BuyAddress {
	// id
	private Integer addrId;
	// 收件人姓名
	private String username;
	// 收件人详细地址
	private String posthome;
	// 邮政编码
	private String postcode;
	// 收货电话
	private String telephone;
	// 收货手机
	private String mobilephone;
	// 收货地址状态
//	(还不清楚业务，暂时用0,1)
	private Integer addrstatus;
	//是否是默认地址,0代表是默认地址，1代表不是默认地址
	private Integer isDefault;
	//用户信息
	private Integer uId;
	private User user;
	
	
	public BuyAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyAddress(Integer addrId, String username, String posthome,
			String postcode, String telephone, String mobilephone,
			Integer addrstatus, Integer isDefault, Integer uId, User user) {
		super();
		this.addrId = addrId;
		this.username = username;
		this.posthome = posthome;
		this.postcode = postcode;
		this.telephone = telephone;
		this.mobilephone = mobilephone;
		this.addrstatus = addrstatus;
		this.isDefault = isDefault;
		this.uId = uId;
		this.user = user;
	}


	public BuyAddress(String username, String posthome, String postcode,
			String telephone, String mobilephone, Integer addrstatus,
			Integer isDefault, Integer uId, User user) {
		super();
		this.username = username;
		this.posthome = posthome;
		this.postcode = postcode;
		this.telephone = telephone;
		this.mobilephone = mobilephone;
		this.addrstatus = addrstatus;
		this.isDefault = isDefault;
		this.uId = uId;
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPosthome() {
		return posthome;
	}
	public void setPosthome(String posthome) {
		this.posthome = posthome;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public int getAddrstatus() {
		return addrstatus;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Integer getAddrId() {
		return addrId;
	}
	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public void setAddrstatus(Integer addrstatus) {
		this.addrstatus = addrstatus;
	}

	@Override
	public String toString() {
		return "BuyAddress [addrId=" + addrId + ", username=" + username
				+ ", posthome=" + posthome + ", postcode=" + postcode
				+ ", telephone=" + telephone + ", mobilephone=" + mobilephone
				+ ", addrstatus=" + addrstatus + ", isDefault=" + isDefault
				+ ", uId=" + uId + ", user=" + user + "]";
	}

	
}
