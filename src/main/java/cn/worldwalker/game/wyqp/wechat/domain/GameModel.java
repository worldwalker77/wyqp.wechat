package cn.worldwalker.game.wyqp.wechat.domain;

import java.math.BigDecimal;

import org.springframework.util.StringUtils;

public class GameModel {
	/**代理id*/
	private Integer proxyId;
	/**游戏昵称*/
	private String nickName;
	/**游戏id*/
	private Integer playerId;
	/**手机号*/
	private String mobilePhone;
	/**微信号*/
	private String wechatNum;
	/**微信号*/
	private String realName;
	/**提现前金额*/
	private double beforeWithdrawalAmount;
	/**提现金额*/
	private double withdrawalAmount;
	/**总提成*/
	private Long extractAmount;
	/**账户余额*/
	private Long remainderAmount;
	/**累计收益*/
	private Long totalIncome;
	/**密码*/
	private String password;
	
	private String wxPayPrice;
	/**时间*/
	private String createTime;
	
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWechatNum() {
		return wechatNum;
	}
	public void setWechatNum(String wechatNum) {
		this.wechatNum = wechatNum;
	}
	public Long getExtractAmount() {
		return extractAmount;
	}
	public void setExtractAmount(Long extractAmount) {
		this.extractAmount = extractAmount;
	}
	public Long getRemainderAmount() {
		return remainderAmount;
	}
	public void setRemainderAmount(Long remainderAmount) {
		this.remainderAmount = remainderAmount;
	}
	public Integer getProxyId() {
		return proxyId;
	}
	public void setProxyId(Integer proxyId) {
		this.proxyId = proxyId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public double getBeforeWithdrawalAmount() {
		return beforeWithdrawalAmount;
	}
	public void setBeforeWithdrawalAmount(double beforeWithdrawalAmount) {
		this.beforeWithdrawalAmount = beforeWithdrawalAmount;
	}
	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCreateTime() {
		if (StringUtils.isEmpty(createTime)) {
			return null;
		}
		return createTime.substring(0, createTime.length() - 2);
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getWxPayPrice() {
		if (StringUtils.isEmpty(wxPayPrice)) {
			return null;
		}
		return BigDecimal.valueOf(Long.valueOf(wxPayPrice)).divide(new BigDecimal(100)).toString();
	}
	public void setWxPayPrice(String wxPayPrice) {
		this.wxPayPrice = wxPayPrice;
	}
	public Long getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(Long totalIncome) {
		this.totalIncome = totalIncome;
	}
	
}
