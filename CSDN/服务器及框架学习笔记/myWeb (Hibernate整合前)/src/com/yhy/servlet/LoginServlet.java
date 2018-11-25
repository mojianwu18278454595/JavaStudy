package com.yhy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;



import javax.print.DocFlavor.URL;
import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yhy.dao.UserDao;
import com.yhy.model.User;
/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = null;
	private User f;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        userDao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);// 执行doPost()方法
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User f = new User();
	
		//获取打印流对象
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		f.setUsername(request.getParameter("username")); // 获取并设置用户名
		f.setPwd(request.getParameter("pwd")); // 获取并设置密码
		String strCookie=request.getParameter("cookie");
		String strSession=request.getParameter("session");
		
		if(request.getParameter("pwdAgin")!=null)
		{
			if(f.getPwd().equals(request.getParameter("pwdAgin"))
				&&!f.getUsername().trim().equals(""))
		{
			f.setType(0);
			f.setGender(request.getParameter("gender"));//获取并设置性别
			f.setTel(request.getParameter("tel"));//获取并设置电话
			int i=userDao.register(f);
			if(i==2)
				{
					pw.print("<script>alert('此用户名已被注册,请重新输入！');window.location.href='style/myRegister.jsp';</script>");
				}
			
		}
		
		if(f.getUsername().trim().equals(""))
		{
			pw.print("<script>alert('用户名不能为空！');window.location.href='style/myRegister.jsp';</script>");
		}
			
		if(!f.getPwd().equals(request.getParameter("pwdAgin"))&&request.getParameter("pwdAgin")!=null)
		{
			pw.print("<script>alert('您输入的密码不一致，请重新输入！');window.location.href='style/myRegister.jsp';</script>");

		}
		
		}
			
		
		int r = userDao.login(f);
		
		if (r > 0) {// 当用户登录成功时
			
			//用户选择了cookie记住密码
			if(strCookie!=null)
			{
				int timeout=Integer.parseInt(strCookie);
				Cookie user=new Cookie("username",URLEncoder.encode(f.getUsername(),"UTF-8")); //Cookie中文转码
				Cookie pwd=new Cookie("pwd",URLEncoder.encode(f.getPwd(),"UTF-8"));
				user.setMaxAge(60*60*24*timeout);
				pwd.setMaxAge(60*60*24*timeout);
				response.addCookie(user);
				response.addCookie(pwd);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("username", f.getUsername());
			Integer integer=r;
			Integer type=f.getType();
			session.setAttribute("id", integer.toString());// 保存用户ID
			session.setAttribute("ReturnValue", "登录成功！");// 保存提示信息
			session.setAttribute("address", f.getAddress());
			session.setAttribute("gender", f.getGender());
			session.setAttribute("tel",f.getTel());
			session.setAttribute("type", type.toString());
			
			request.getRequestDispatcher("main/main.jsp").forward(request,response);// 请求转发页面
		} else {
			// 当用户登录不成功时 （只提供消息）
			pw.print("<script>alert('您输入的用户名或密码错误，请重新输入！');window.location.href='style/myLogin.jsp';</script>");
		}
		
		
		} 
	
	
	/**
	 * 功能：用户退出
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();// 获取HttpSession的对象
		session.invalidate();// 销毁session
		request.getRequestDispatcher("DiaryServlet?action=listAllDiary")
				.forward(request, response);// 请求转发页面
	}
	
}
