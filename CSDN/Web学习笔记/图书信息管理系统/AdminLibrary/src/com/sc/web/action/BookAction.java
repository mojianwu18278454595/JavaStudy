package com.sc.web.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sc.dao.BookDao;
import com.sc.dao.impl.BookDaoImpl;
import com.sc.domain.Book;
import com.sc.domain.Reader;
import com.sc.service.BookService;
import com.sc.service.ReaderService;
import com.sc.service.impl.BookServiceImpl;
import com.sc.service.impl.ReaderServiceImpl;
import com.sc.utils.FileUtils;

public class BookAction extends ActionSupport implements ModelDriven<Book> 
{
	private Book book=new Book();
	@Override
	public Book getModel()
	{
		return book;
	}
	
	//新书入库
	public String add()
	{
		String datePress=(String)ServletActionContext.getRequest().getParameter("datePress");
		String imgPath=(String)ServletActionContext.getRequest().getParameter("book_cover");
		try
		{
			Properties proper=new Properties(); 
			InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("config.properties");
			proper.load(inputStream);
			inputStream.close();
			String localBkImgPath=proper.getProperty("localBkImgPath");
			imgPath=localBkImgPath+imgPath;
			byte[] book_cover=FileUtils.imageToBinary(imgPath);
			book.setBk_cover(book_cover);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try
		{
			Date bk_datePress=new SimpleDateFormat("yyyy-MM-dd").parse(datePress);
			book.setBk_datePress(bk_datePress);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		BookService bookService =new BookServiceImpl();
		String result=bookService.add(book);
		this.addActionMessage(result);
		return "add";
	}
	
	//查询图书
	public String select()
	{
		BookService bookService=new BookServiceImpl();
		List<Book> books=bookService.select(book);
		//利用值栈来存取list数据
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.set("listBooks", books);
		ServletActionContext.getRequest().getSession().setAttribute("listBooks", books);
		return "select";
	}
	
	//变更信息显示
	public String showEdit()
	{
		BookDao bookDao=new BookDaoImpl();
		Book giveBook=bookDao.giveBook(book);
		
		if(giveBook!=null)
		{
			Properties proper=new Properties(); 
			InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("config.properties");
			try
			{
				proper.load(inputStream);
				inputStream.close();
				String tomcatBkImgPath=proper.getProperty("tomcatBkImgPath");
				byte[] bytes=giveBook.getBk_cover();
				String imagePath=tomcatBkImgPath+"bk"+giveBook.getBk_id()+".jpg";
				String theImg=ServletActionContext.getServletContext().getRealPath(imagePath);
				FileUtils.binaryToImage(bytes,theImg); //将数据库中的图片写入指定文件中
				ServletActionContext.getRequest().setAttribute("imagePath", imagePath);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String bk_datePress=sdf.format(giveBook.getBk_datePress());
				ServletActionContext.getRequest().setAttribute("bk_datePress", bk_datePress);
				ServletActionContext.getRequest().getSession().setAttribute("showEditBook", giveBook);
				ServletActionContext.getRequest().getSession().setAttribute("editBook", giveBook);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
		return "showEdit";
	}
	
	//图书信息维护
	public String edit()
	{
		Book giveBook=(Book)ServletActionContext.getRequest().getSession().getAttribute("showEditBook");
		book.setBk_id(giveBook.getBk_id());
		String datePress=(String)ServletActionContext.getRequest().getParameter("datePress");
		try
		{
			Date bk_datePress=new SimpleDateFormat("yyyy-MM-dd").parse(datePress);
			book.setBk_datePress(bk_datePress);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		BookService bookService =new BookServiceImpl();
		String result=bookService.edit(book);
		this.addActionMessage(result);
		
		return "edit";
	}
	
	//旧书移除
	public String delete()
	{
		Book giveBook=(Book)ServletActionContext.getRequest().getSession().getAttribute("showEditBook");
		BookService bookService =new BookServiceImpl();
		String result=bookService.delete(giveBook.getBk_id());
		this.addActionMessage(result);
		return "delete";
	}
	
	
	//图书管理页面跳转
	public String addJsp()
	{
		return "addJsp";
	}
	public String editJsp()
	{
		return "editJsp";
	}
}
