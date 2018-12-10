package com.sc.domain;
import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * @author 沈翀
 * CSDN 知飞翀
 * QQ 610254602
 */
import java.util.Set;


public class Borrow
{
	private Long bw_id;
	private Integer bw_rd_id;
	private Integer bw_bk_id;
	private Integer bw_idContinueTimes;
	private Timestamp bw_idDateOut;
	private Timestamp bw_idDateRetPlan;
	private Timestamp bw_idDateRetAct;
	private Integer bw_idOverDay;
	private BigDecimal bw_idOverMoney;
	private BigDecimal bw_idPunishMoney;
	private String bw_isHasReturn;
	private String bw_operatorLend;
	private String bw_operatorRet;
	
	
	
	public BigDecimal getBw_idPunishMoney()
	{
		return bw_idPunishMoney;
	}

	public BigDecimal getBw_idOverMoney()
	{
		return bw_idOverMoney;
	}

	public void setBw_idPunishMoney(BigDecimal bw_idPunishMoney)
	{
		this.bw_idPunishMoney = bw_idPunishMoney;
	}

	public void setBw_idOverMoney(BigDecimal bw_idOverMoney)
	{
		this.bw_idOverMoney = bw_idOverMoney;
	}

	public Borrow()
	{
	}

	public String getBw_isHasReturn()
	{
		return bw_isHasReturn;
	}

	public void setBw_isHasReturn(String bw_isHasReturn)
	{
		this.bw_isHasReturn = bw_isHasReturn;
	}

	public String getBw_operatorLend()
	{
		return bw_operatorLend;
	}



	public void setBw_operatorLend(String bw_operatorLend)
	{
		this.bw_operatorLend = bw_operatorLend;
	}



	public String getBw_operatorRet()
	{
		return bw_operatorRet;
	}



	public void setBw_operatorRet(String bw_operatorRet)
	{
		this.bw_operatorRet = bw_operatorRet;
	}



	public Long getBw_id()
	{
		return bw_id;
	}

	public void setBw_id(Long bw_id)
	{
		this.bw_id = bw_id;
	}

	public Integer getBw_rd_id()
	{
		return bw_rd_id;
	}

	public void setBw_rd_id(Integer bw_rd_id)
	{
		this.bw_rd_id = bw_rd_id;
	}

	public Integer getBw_bk_id()
	{
		return bw_bk_id;
	}

	public void setBw_bk_id(Integer bw_bk_id)
	{
		this.bw_bk_id = bw_bk_id;
	}

	public Integer getBw_idContinueTimes()
	{
		return bw_idContinueTimes;
	}

	public void setBw_idContinueTimes(Integer bw_idContinueTimes)
	{
		this.bw_idContinueTimes = bw_idContinueTimes;
	}

	public Timestamp getBw_idDateOut()
	{
		return bw_idDateOut;
	}

	public void setBw_idDateOut(Timestamp bw_idDateOut)
	{
		this.bw_idDateOut = bw_idDateOut;
	}

	public Timestamp getBw_idDateRetPlan()
	{
		return bw_idDateRetPlan;
	}

	public void setBw_idDateRetPlan(Timestamp bw_idDateRetPlan)
	{
		this.bw_idDateRetPlan = bw_idDateRetPlan;
	}

	public Timestamp getBw_idDateRetAct()
	{
		return bw_idDateRetAct;
	}

	public void setBw_idDateRetAct(Timestamp bw_idDateRetAct)
	{
		this.bw_idDateRetAct = bw_idDateRetAct;
	}

	public Integer getBw_idOverDay()
	{
		return bw_idOverDay;
	}

	public void setBw_idOverDay(Integer bw_idOverDay)
	{
		this.bw_idOverDay = bw_idOverDay;
	}

	

	@Override
	public String toString()
	{
		return "Borrow [bw_id=" + bw_id + ", bw_rd_id=" + bw_rd_id + ", bw_bk_id=" + bw_bk_id + ", bw_idContinueTimes="
				+ bw_idContinueTimes + ", bw_idDateOut=" + bw_idDateOut + ", bw_idDateRetPlan=" + bw_idDateRetPlan
				+ ", bw_idDateRetAct=" + bw_idDateRetAct + ", bw_idOverDay=" + bw_idOverDay + ", bw_idOverMoney="
				+ bw_idOverMoney + ", bw_isHasReturn=" + bw_isHasReturn + ", bw_operatorLend=" + bw_operatorLend
				+ ", bw_operatorRet=" + bw_operatorRet + "]";
	}
	
}
