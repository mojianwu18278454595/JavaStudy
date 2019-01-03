package com.sc.domain;
/**
 * @author 沈翀
 * CSDN 知飞翀
 * QQ 610254602
 */

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book
{
	private Integer bk_id;
	private String bk_code;
	private String bk_name;
	private String bk_author;
	private String bk_press;
	private Date bk_datePress;
	private String bk_ISBN;
	private String bk_catalog;
	private String bk_language; 
	private Integer bk_pages;
	private Double bk_price;
	private Timestamp bk_dateIn;
	private String bk_brief;
	private byte[] bk_cover;
	private String bk_status;
	private Set<Reader> readers=new HashSet<Reader>();

	public Set<Reader> getReaders()
	{
		return readers;
	}

	public void setReaders(Set<Reader> readers)
	{
		this.readers = readers;
	}

	public Book()
	{
	}

	public Integer getBk_id()
	{
		return bk_id;
	}

	public void setBk_id(Integer bk_id)
	{
		this.bk_id = bk_id;
	}

	public String getBk_code()
	{
		return bk_code;
	}

	public void setBk_code(String bk_code)
	{
		this.bk_code = bk_code;
	}

	public String getBk_name()
	{
		return bk_name;
	}

	public void setBk_name(String bk_name)
	{
		this.bk_name = bk_name;
	}

	public String getBk_author()
	{
		return bk_author;
	}

	public void setBk_author(String bk_author)
	{
		this.bk_author = bk_author;
	}

	public String getBk_press()
	{
		return bk_press;
	}

	public void setBk_press(String bk_press)
	{
		this.bk_press = bk_press;
	}

	public Date getBk_datePress()
	{
		return bk_datePress;
	}

	public void setBk_datePress(Date bk_datePress)
	{
		this.bk_datePress = bk_datePress;
	}

	public String getBk_ISBN()
	{
		return bk_ISBN;
	}

	public void setBk_ISBN(String bk_ISBN)
	{
		this.bk_ISBN = bk_ISBN;
	}

	public String getBk_catalog()
	{
		return bk_catalog;
	}

	public void setBk_catalog(String bk_catalog)
	{
		this.bk_catalog = bk_catalog;
	}

	
	public String getBk_language()
	{
		return bk_language;
	}

	public void setBk_language(String bk_language)
	{
		this.bk_language = bk_language;
	}

	public Integer getBk_pages()
	{
		return bk_pages;
	}

	public void setBk_pages(Integer bk_pages)
	{
		this.bk_pages = bk_pages;
	}

	public Double getBk_price()
	{
		return bk_price;
	}

	public void setBk_price(Double bk_price)
	{
		this.bk_price = bk_price;
	}

	public Timestamp getBk_dateIn()
	{
		return bk_dateIn;
	}

	public void setBk_dateIn(Timestamp bk_dateIn)
	{
		this.bk_dateIn = bk_dateIn;
	}

	public String getBk_brief()
	{
		return bk_brief;
	}

	public void setBk_brief(String bk_brief)
	{
		this.bk_brief = bk_brief;
	}

	public byte[] getBk_cover()
	{
		return bk_cover;
	}

	public void setBk_cover(byte[] bk_cover)
	{
		this.bk_cover = bk_cover;
	}

	public String getBk_status()
	{
		return bk_status;
	}

	public void setBk_status(String bk_status)
	{
		this.bk_status = bk_status;
	}

	

	@Override
	public String toString()
	{
		return "Book [bk_id=" + bk_id + ", bk_code=" + bk_code + ", bk_name=" + bk_name + ", bk_author=" + bk_author
				+ ", bk_press=" + bk_press + ", bk_datePress=" + bk_datePress + ", bk_ISBN=" + bk_ISBN + ", bk_catalog="
				+ bk_catalog + ", bk_language=" + bk_language + ", bk_pages=" + bk_pages + ", bk_price=" + bk_price
				+ ", bk_dateIn=" + bk_dateIn + ", bk_brief=" + bk_brief + ", bk_cover=" + Arrays.toString(bk_cover)
				+ ", bk_status=" + bk_status + "]";
	}
	
	
}
