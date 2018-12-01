package com.yhy.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yhy.model.UserInfo;

public class privilagelInterceptor extends MethodFilterInterceptor
{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		UserInfo userInfo=(UserInfo)ServletActionContext.getRequest().getSession().getAttribute("userInfo");
		if(userInfo==null)
		{
			ActionSupport actionSupport=(ActionSupport)invocation.getAction();
			actionSupport.addActionError("亲，您还没有登录！请先登录");
			return actionSupport.ERROR;
		}
		return invocation.invoke();
	}

}
