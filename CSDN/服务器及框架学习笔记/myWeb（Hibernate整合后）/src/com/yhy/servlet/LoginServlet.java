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
import com.yhy.model.UserInfo;
/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private  UserInfo userInfo; 
	private UserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        userInfo = new UserInfo();
        userDao=new UserDao();
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
		
	
		//获取打印流对象
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		userInfo.setUser_name(request.getParameter("username")); // 获取并设置用户名
		userInfo.setUser_pwd(request.getParameter("pwd")); // 获取并设置密码
		String strCookie=request.getParameter("cookie");
		String strSession=request.getParameter("session");
		
		if(request.getParameter("pwdAgin")!=null)
		{
			if(userInfo.getUser_pwd().equals(request.getParameter("pwdAgin"))
				&&!userInfo.getUser_name().trim().equals(""))
			{
				userInfo.setUser_type(0);
				userInfo.setUser_gender(request.getParameter("gender"));//获取并设置性别
				userInfo.setUser_tel(request.getParameter("tel"));//获取并设置电话
			int i=userDao.registerUser(userInfo);
			if(i==0)
				{
					pw.print("<script>alert('此用户名已被注册,请重新输入！');window.location.href='style/myRegister.jsp';</script>");
				}
			
		}
		
		if(userInfo.getUser_name().trim().equals(""))
		{
			pw.print("<script>alert('用户名不能为空！');window.location.href='style/myRegister.jsp';</script>");
		}
			
		if(!userInfo.getUser_pwd().equals(request.getParameter("pwdAgin"))&&request.getParameter("pwdAgin")!=null)
		{
			pw.print("<script>alert('您输入的密码不一致，请重新输入！');window.location.href='style/myRegister.jsp';</script>");

		}
		
		return;
	}
			
		
		int r = userDao.loginCheck(userInfo);
		
		if (r > 0) {// 当用户登录成功时
			
			//用户选择了cookie记住密码
			if(strCookie!=null)
			{
				int timeout=Integer.parseInt(strCookie);
				Cookie user=new Cookie("username",URLEncoder.encode(userInfo.getUser_name(),"UTF-8")); //Cookie中文转码
				Cookie pwd=new Cookie("pwd",URLEncoder.encode(userInfo.getUser_pwd(),"UTF-8"));
				user.setMaxAge(60*60*24*timeout);
				pwd.setMaxAge(60*60*24*timeout);
				response.addCookie(user);
				response.addCookie(pwd);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("username", userInfo.getUser_name());
			Integer integer=r;
			//Integer type=userInfo.getUser_type();
			session.setAttribute("id", integer.toString());// 保存用户ID
			session.setAttribute("ReturnValue", "登录成功！");// 保存提示信息
			session.setAttribute("address", userInfo.getUser_address());
			session.setAttribute("gender", userInfo.getUser_gender());
			session.setAttribute("tel",userInfo.getUser_tel());
			session.setAttribute("type",userInfo.getUser_type().toString());
			
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
