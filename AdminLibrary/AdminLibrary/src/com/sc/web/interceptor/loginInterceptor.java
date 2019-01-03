package com.sc.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sc.domain.Reader;

public class loginInterceptor extends MethodFilterInterceptor
{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		Reader reader=(Reader)ServletActionContext.getRequest().getSession().getAttribute("reader");
		if(reader==null)
		{
			ActionSupport actionSupport=(ActionSupport)invocation.getAction();
			actionSupport.addActionError("亲，您还没有登录哟！");
			return actionSupport.ERROR;
		}
		return invocation.invoke();
	}
	

}
