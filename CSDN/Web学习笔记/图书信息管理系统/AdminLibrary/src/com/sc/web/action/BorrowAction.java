package com.sc.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sc.domain.Reader;
import com.sc.service.BorrowService;
import com.sc.service.impl.BorrowServiceImpl;

public class BorrowAction extends ActionSupport implements ModelDriven<Reader>
{
	private BorrowService borrowService=new BorrowServiceImpl();
	private Integer bk_id;
	//模型驱动
	private Reader reader=new Reader();
	@Override
	public Reader getModel()
	{
		return reader;
	}
	
	//借书
	public String borrow()
	{
		Reader curReader=(Reader)ServletActionContext.getRequest().getSession().getAttribute("reader");
		String operationName=curReader.getRd_name();
		bk_id=Integer.parseInt((String)ServletActionContext.getRequest().getParameter("bk_id"));
		String result=borrowService.borrow(reader,bk_id,operationName);
		this.addActionMessage(result);
		return "borrow";
	}
	
	//还书
	public String back()
	{
		Reader curReader=(Reader)ServletActionContext.getRequest().getSession().getAttribute("reader");
		String operationName=curReader.getRd_name();
		bk_id=Integer.parseInt((String)ServletActionContext.getRequest().getParameter("bk_id"));
		String result=borrowService.back(reader,bk_id,operationName);
		this.addActionMessage(result);
		return "back";
	}
	
	//续借
	public String renewal()
	{
		Reader curReader=(Reader)ServletActionContext.getRequest().getSession().getAttribute("reader");
		String operationName=curReader.getRd_name();
		bk_id=Integer.parseInt((String)ServletActionContext.getRequest().getParameter("bk_id"));
		String result=borrowService.renewal(reader,bk_id,operationName);
		this.addActionMessage(result);
		return "renewal";
	}
	
	//借阅管理页面跳转
	public String borrowJsp()
	{
		return "borrowJsp";
	}
	public String backJsp()
	{
		return "backJsp";
	}
	public String renewalJsp()
	{
		return "renewalJsp";
	}
}
