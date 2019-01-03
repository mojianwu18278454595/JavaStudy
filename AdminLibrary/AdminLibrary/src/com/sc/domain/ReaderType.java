package com.sc.domain;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author 沈翀
 * CSDN 知飞翀
 * QQ 610254602
 */
public class ReaderType
{

	private Integer type_id;
	private String type_name;
	private Integer type_canLendQty;
	private Integer type_canLendDay;
	private Integer type_canContinueTimes;
	private BigDecimal type_punishRate;
	private Integer type_dateVaild ;
	private Set<Reader> readers;
	
	public ReaderType()
	{
	}

	public Set<Reader> getReaders()
	{
		return readers;
	}

	public void setReaders(Set<Reader> readers)
	{
		this.readers = readers;
	}

	public Integer getType_id()
	{
		return type_id;
	}

	public void setType_id(Integer type_id)
	{
		this.type_id = type_id;
	}

	public String getType_name()
	{
		return type_name;
	}

	public void setType_name(String type_name)
	{
		this.type_name = type_name;
	}

	public Integer getType_canLendQty()
	{
		return type_canLendQty;
	}

	public void setType_canLendQty(Integer type_canLendQty)
	{
		this.type_canLendQty = type_canLendQty;
	}

	public Integer getType_canLendDay()
	{
		return type_canLendDay;
	}

	public void setType_canLendDay(Integer type_canLendDay)
	{
		this.type_canLendDay = type_canLendDay;
	}

	public Integer getType_canContinueTimes()
	{
		return type_canContinueTimes;
	}

	public void setType_canContinueTimes(Integer type_canContinueTimes)
	{
		this.type_canContinueTimes = type_canContinueTimes;
	}

	public BigDecimal getType_punishRate()
	{
		return type_punishRate;
	}

	public void setType_punishRate(BigDecimal type_punishRate)
	{
		this.type_punishRate = type_punishRate;
	}

	public Integer getType_dateVaild()
	{
		return type_dateVaild;
	}

	public void setType_dateVaild(Integer type_dateVaild)
	{
		this.type_dateVaild = type_dateVaild;
	}

	@Override
	public String toString()
	{
		return "ReaderType [type_id=" + type_id + ", type_name=" + type_name + ", type_canLendQty=" + type_canLendQty
				+ ", type_canLendDay=" + type_canLendDay + ", type_canContinueTimes=" + type_canContinueTimes
				+ ", type_punishRate=" + type_punishRate + ", type_dateVaild=" + type_dateVaild + "]";
	}
	
}
