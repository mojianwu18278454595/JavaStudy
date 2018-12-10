<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/reader_edit.action"
		method=post>
		<input type="hidden" name="custId" value="${customer.custId }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：读者管理 &gt; 变更读者</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  	
						  	<s:property value="#request.curReader.rd_id"/>
					  		<s:actionmessage/>
					  		<font color="red" size="5"><s:property value="#session.message"/></font>
						  	
						  	<TR>
								<td colspan="4">
									<h4>证件照</h4>
									<img src="${pageContext.request.contextPath }/<s:property value='#request.imagePath'/>" width="140px" height="140px"/>
								</td>
							</TR>
							
						  	<TR>
								<td>读者编号 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px;user-select:none;" 
														maxLength=50 name="rd_id" value="<s:property value='#session.showEditReader.rd_id'/>">
								</td>
								<td>读者状态 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px;user-select:none;" maxLength=50 name="rd_status" value="<s:property value='#session.showEditReader.rd_status'/>">
								</td>
							</TR>
						    
							<TR>
								<td>读者名称(必填) ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px;" maxLength=50 name="rd_name" value="<s:property value='#session.showEditReader.rd_name'/>">
								</td>
								<td>读者性别(必填) ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="rd_sex" value="<s:property value='#session.showEditReader.rd_sex'/>">
								</td>
							</TR>
							
							<TR>
								
								<td>读者类别(必填) ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="rd_type" value="<s:property value='#session.showEditReader.getReaderType().type_name'/>">
								</td>
								<td>读者单位(必填) ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="rd_dept" value="<s:property value='#session.showEditReader.rd_dept'/>">
								</td>
							</TR>
							
							<TR>
								<td>读者电话(选填) ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="rd_phone" value="<s:property value='#session.showEditReader.rd_phone'/>">
								</td>
								<td>读者邮箱(选填) ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="rd_email" value="<s:property value='#session.showEditReader.rd_email'/>">
								</td>
							</TR>
																					
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
													value=" 提交 " name=sButton2>
								<a href="${pageContext.request.contextPath }/reader_operation.action?number=1">挂失</a>
								<a href="${pageContext.request.contextPath }/reader_operation.action?number=2">解挂</a>
								<a href="${pageContext.request.contextPath }/reader_operation.action?number=3">注销</a>
								<a href="${pageContext.request.contextPath }/reader_operation.action?number=4">补办</a>
								</td>
							</tr>
						
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
