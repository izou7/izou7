package cn.chinattclub.izou7.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import cn.chinattclub.izou7.entity.ActivityCrowdfundingSetting;
import cn.chinattclub.izou7.enumeration.CrowdfundingStatus;



/**
 * 活动众筹设置DTO
 * 
 * @author ZY
 * 
 */
public class ActivityCrowdfundingSettingDto {

	private Integer id;
	
	/**
	 * 活动
	 */
	private Integer activity;
	
	/**
	 * 众筹总金额
	 */
	private Integer amount;
	
	/**
	 * 众筹金额上限
	 */
	@Column(name="high_lines")
	private Integer highLines;
	
	/**
	 * 已筹到的金额
	 */
	@Column(name="got_amount")
	private Integer gotAmount;
	
	/**
	 * 众筹天数
	 */
	private Integer days;
	
	/**
	 * 收款人姓名
	 */
	@Column(name="account_name")
	private String accountName;
	
	/**
	 * 收款人账号
	 */
	@Column(name="account_number")
	private String accountNumber;
	
	/**
	 * 银行表id
	 */
	@Column(name="account_bank")
	private Integer accountBank;
	
	/**
	 * 账户类型0：个人 1：企业
	 */
	@Column(name="account_type")
	private Integer accountType;
	
	/**
	 * 支行
	 */
	@Column(name="sub_bank")
	private String subBank;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getHighLines() {
		return highLines;
	}

	public void setHighLines(Integer highLines) {
		this.highLines = highLines;
	}

	public Integer getGotAmount() {
		return gotAmount;
	}

	public void setGotAmount(Integer gotAmount) {
		this.gotAmount = gotAmount;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(Integer accountBank) {
		this.accountBank = accountBank;
	}

	public String getSubBank() {
		return subBank;
	}

	public void setSubBank(String subBank) {
		this.subBank = subBank;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	
	public ActivityCrowdfundingSetting convert(){
		ActivityCrowdfundingSetting setting = new ActivityCrowdfundingSetting();
		setting.setAccountBank(accountBank);
		setting.setAccountName(accountName);
		setting.setAccountNumber(accountNumber);
		setting.setAccountType(accountType);
		setting.setAmount(amount);
		setting.setDays(days);
		setting.setGotAmount(gotAmount);
		setting.setHighLines(highLines);
		setting.setId(id);
		setting.setSubBank(subBank);
		setting.setCreateTime(new Date());
		setting.setStatus(CrowdfundingStatus.SPONSORED);
		setting.setGotAmount(0);
		return setting;
	}
}
