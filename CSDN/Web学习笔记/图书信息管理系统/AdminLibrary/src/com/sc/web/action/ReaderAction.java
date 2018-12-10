package com.sc.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sc.domain.Reader;
import com.sc.service.ReaderService;
import com.sc.service.impl.ReaderServiceImpl;
import com.sc.utils.FileUtils;

public class ReaderAction extends ActionSupport implements ModelDriven<Reader>
{
	private Reader reader=new Reader();
	@Override
	public Reader getModel()
	{
		return reader;
	}
	
	//用户登录
	public String login()
	{
		//验证用户
		ReaderService readerService=new ReaderServiceImpl();
		Reader checkReader=readerService.login(reader);
		if(checkReader==null) //验证失败
		{
			this.addActionError("亲，您输入的用户名或密码有误！");
			return ERROR;
		}
		else
		{
			//验证成功，将当前登录用户添加至session中
			ServletActionContext.getRequest().getSession().setAttribute("reader", checkReader);
		}
		
		return "login";
	}

	//修改当前登录用户密码
	public String changePwd()
	{
		String pwd=(String)ServletActionContext.getRequest().getParameter("pwd");
		String pwdAgin=(String)ServletActionContext.getRequest().getParameter("pwdAgin");
		if(pwd.equals(pwdAgin))
		{
			Reader rd=(Reader)ServletActionContext.getRequest().getSession().getAttribute("reader");
			rd.setRd_pwd(pwd);
			Integer type_id=rd.getReaderType().getType_id();
			ReaderService readerService =new ReaderServiceImpl();
			Reader editReader=readerService.edit(rd,type_id);
			if(editReader!=null)
			{
				this.addActionError("密码修改成功！");
				ServletActionContext.getRequest().getSession().setAttribute("reader", null);
			}		
		}
		return "changePwd";
	}
	
	//用户安全退出
	public String securityExit()
	{
		//清除session，安全退出
		ServletActionContext.getRequest().getSession().setAttribute("reader", null);
		this.addActionError("亲，您已安全退出！");
		return "securityExit";
	}
	
	//办理借书证
	public String add()
	{
		//获取表单信息
		
		try
		{
			Properties proper=new Properties(); 
			InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("config.properties");
			proper.load(inputStream);
			inputStream.close();
			String localRdImgPath=proper.getProperty("localRdImgPath");
			Integer rd_type=Integer.parseInt((String)ServletActionContext.getRequest().getParameter("rd_type"));
			String imgPath=(String)ServletActionContext.getRequest().getParameter("reader_photo");
			imgPath=localRdImgPath+imgPath;
			byte[] rd_photo=FileUtils.imageToBinary(imgPath);
			reader.setRd_photo(rd_photo);
			//向下传递
			ReaderService readerService=new ReaderServiceImpl();
			String result=readerService.add(reader,rd_type);
			this.addActionMessage(result);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return "add";
	}
	
	//查询借书证
	public String select()
	{
		ReaderService readerService=new ReaderServiceImpl();
		List<Reader> readers=readerService.select(reader);
		//利用值栈来存取list数据
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.set("listReaders", readers);
		return "select";
	}
	
	//展示变更读者信息
	public String showEdit()
	{
		ReaderService readerService=new ReaderServiceImpl();
		List<Reader> readers=readerService.select(reader);
		for (Reader rd : readers)
		{
			if(rd.getRd_id().equals(reader.getRd_id()))
			{
				
				try
				{
					Properties proper=new Properties(); 
					InputStream inputStream=this.getClass().getClassLoader().getResourceAsStream("config.properties");
					proper.load(inputStream);
					inputStream.close();
					String tomcatRdImgPath=proper.getProperty("tomcatRdImgPath");
					byte[] bytes=rd.getRd_photo();
					String imagePath=tomcatRdImgPath+"rd"+rd.getRd_id()+".jpg";
					String theImg=ServletActionContext.getServletContext().getRealPath(imagePath);
					FileUtils.binaryToImage(bytes,theImg); //将数据库中的图片写入指定文件中
					ServletActionContext.getRequest().setAttribute("imagePath", imagePath);
					ServletActionContext.getRequest().getSession().setAttribute("showEditReader", rd);
					ServletActionContext.getRequest().getSession().setAttribute("editReader", rd);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				
				break;
			}
		}
		return "showEdit";
	}
	
	//变更读者
	public String edit()
	{
		Integer readerType=Integer.parseInt((String)ServletActionContext.getRequest().getParameter("rd_type"));
		ReaderService readerService =new ReaderServiceImpl();
		Reader editReader=readerService.edit(reader,readerType);
		ServletActionContext.getRequest().getSession().setAttribute("editReader", editReader);
		return "edit";
	}
	
	//挂失&解挂&注销&补办
	public String operation()
	{
		int number=Integer.parseInt((String)ServletActionContext.getRequest().getParameter("number"));
		Reader editReader=(Reader)ServletActionContext.getRequest().getSession().getAttribute("editReader");
		ReaderService readerService=new ReaderServiceImpl();
		Reader changeReader=readerService.operation(editReader,number);
		ServletActionContext.getRequest().getSession().setAttribute("message", "操作成功!");
		ServletActionContext.getRequest().getSession().setAttribute("showEditReader", changeReader);
		
		return "operation";
	}
	
	//读者管理页面跳转权限
	public String addJsp()
	{
		return "addJsp";
	}
	public String editJsp()
	{
		return "editJsp";
	}

}
