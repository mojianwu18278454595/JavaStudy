package com.sc.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sc.domain.Reader;

public class PunishMoneyInterceptor extends MethodFilterInterceptor
{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		Reader reader=(Reader)ServletActionContext.getRequest().getSession().getAttribute("reader");
		if(reader.getReaderType().getType_id()==1||reader.getReaderType().getType_id()==5)
		{
			//管理员||缴费管理员
			return invocation.invoke();
		}else
		{
			ActionSupport actionSupport=(ActionSupport)invocation.getAction();
			actionSupport.addActionError("当前登录用户无权访问此功能！");
			return "right";
		}

	}

}
