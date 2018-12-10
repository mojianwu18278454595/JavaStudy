package com.sc.domain;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * CSDN 知飞翀
 * @author sc
 * QQ 610254602
 */
public class Reader
{
	private Integer rd_id;
	private String rd_name;
	private String rd_sex;
	private String rd_dept;
	private String rd_phone;
	private String rd_email;
	private Timestamp rd_dateReg;
	private byte[] rd_photo;
	private String rd_status;
	private Integer rd_borrowQty;
	private String rd_pwd;
	private Integer rd_adminRoles;
	private ReaderType readerType;
	private Set<Book> books =new HashSet<Book>();

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setBooks(Set<Book> books)
	{
		this.books = books;
	}

	public Reader()
	{
	}

	public Integer getRd_id()
	{
		return rd_id;
	}

	public void setRd_id(Integer rd_id)
	{
		this.rd_id = rd_id;
	}

	public String getRd_name()
	{
		return rd_name;
	}

	public void setRd_name(String rd_name)
	{
		this.rd_name = rd_name;
	}

	public String getRd_sex()
	{
		return rd_sex;
	}

	public void setRd_sex(String rd_sex)
	{
		this.rd_sex = rd_sex;
	}

	public String getRd_dept()
	{
		return rd_dept;
	}

	public void setRd_dept(String rd_dept)
	{
		this.rd_dept = rd_dept;
	}

	public String getRd_phone()
	{
		return rd_phone;
	}

	public void setRd_phone(String rd_phone)
	{
		this.rd_phone = rd_phone;
	}

	public String getRd_email()
	{
		return rd_email;
	}

	public void setRd_email(String rd_email)
	{
		this.rd_email = rd_email;
	}

	public Timestamp getRd_dateReg()
	{
		return rd_dateReg;
	}

	public void setRd_dateReg(Timestamp rd_dateReg)
	{
		this.rd_dateReg = rd_dateReg;
	}	

	public byte[] getRd_photo()
	{
		return rd_photo;
	}

	public void setRd_photo(byte[] rd_photo)
	{
		this.rd_photo = rd_photo;
	}

	public String getRd_status()
	{
		return rd_status;
	}

	public void setRd_status(String rd_status)
	{
		this.rd_status = rd_status;
	}

	public Integer getRd_borrowQty()
	{
		return rd_borrowQty;
	}

	public void setRd_borrowQty(Integer rd_borrowQty)
	{
		this.rd_borrowQty = rd_borrowQty;
	}

	public String getRd_pwd()
	{
		return rd_pwd;
	}

	public void setRd_pwd(String rd_pwd)
	{
		this.rd_pwd = rd_pwd;
	}

	public Integer getRd_adminRoles()
	{
		return rd_adminRoles;
	}

	public void setRd_adminRoles(Integer rd_adminRoles)
	{
		this.rd_adminRoles = rd_adminRoles;
	}

	public ReaderType getReaderType()
	{
		return readerType;
	}

	public void setReaderType(ReaderType readerType)
	{
		this.readerType = readerType;
	}

	@Override
	public String toString()
	{
		return "Reader [rd_id=" + rd_id + ", rd_name=" + rd_name + ", rd_sex=" + rd_sex + ", rd_dept=" + rd_dept
				+ ", rd_phone=" + rd_phone + ", rd_email=" + rd_email + ", rd_dateReg=" + rd_dateReg + ", rd_photo="
				+ rd_photo + ", rd_status=" + rd_status + ", rd_borrowQty=" + rd_borrowQty
				+ ", rd_pwd=" + rd_pwd + ", rd_adminRoles=" + rd_adminRoles + ", readerType=" + readerType.getType_name() + "]";
	}

	
	
	
	
}
