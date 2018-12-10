package com.sc.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sc.domain.Borrow;
import com.sc.service.BorrowService;
import com.sc.service.impl.BorrowServiceImpl;

public class CompSelectAction extends ActionSupport
{
	public String bookBw()
	{
		Integer bk_id=new Integer((String)ServletActionContext.getRequest().getParameter("bk_id"));
		BorrowService borrowService= new BorrowServiceImpl();
		List<Borrow>bookBws= borrowService.compBw(0,bk_id);
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.set("bookBws", bookBws);
		return "bookBw";
	}
	
	public String readerBw()
	{
		Integer rd_id=new Integer((String)ServletActionContext.getRequest().getParameter("rd_id"));
		BorrowService borrowService= new BorrowServiceImpl();
		List<Borrow>readerBws= borrowService.compBw(rd_id,0);
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.set("readerBws", readerBws);
		return "readerBw";
	}
	
	public String punishMoney()
	{
		Double punishMoney =new Double((String)ServletActionContext.getRequest().getParameter("punishMoney"));
		Integer rd_id=new Integer((String)ServletActionContext.getRequest().getParameter("bw_rd_id"));
		Integer bk_id=new Integer((String)ServletActionContext.getRequest().getParameter("bw_bk_id"));
		BorrowService borrowService= new BorrowServiceImpl();
		String result=borrowService.givePunishMoney(rd_id,bk_id,punishMoney);
		this.addActionMessage(result);
		return "punishMoney";
	}
	
	public String showPunish()
	{
		Integer rd_id=new Integer((String)ServletActionContext.getRequest().getParameter("rd_id"));
		Integer bk_id=new Integer((String)ServletActionContext.getRequest().getParameter("bk_id"));
		ServletActionContext.getRequest().setAttribute("rd_id", rd_id);
		ServletActionContext.getRequest().setAttribute("bk_id", bk_id);
		return "showPunish";
	}
	
	//页面跳转权限
	public String bookBwJsp()
	{
		return "bookBwJsp";
	}
	public String readerBwJsp()
	{
		return "readerBwJsp";
	}
}
