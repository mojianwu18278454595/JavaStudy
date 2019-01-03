<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>维护图书信息</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/book_edit.action"
		method=post>
		<input type="hidden" name="lkmId" value="${linkman.lkmId }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
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
								<TD class=manageHead>当前位置：图书管理 &gt; 维护图书信息</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<font color="red" size="4"><s:actionmessage/></font>
							<TR>
								<td>图书代号：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_code" value="<s:property value='#session.showEditBook.bk_code'/>">
								</td>
								<td>出版社：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_press" value="<s:property value='#session.showEditBook.bk_press'/>">
								</td>
							</TR>
							<TR>
								<td>书名：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_name" value="<s:property value='#session.showEditBook.bk_name'/>">
								</td>
								<td>作者：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_author" value="<s:property value='#session.showEditBook.bk_author'/>">
								</td>
							</TR>
							<TR>
								<td>ISBN ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_ISBN" value="<s:property value='#session.showEditBook.bk_ISBN'/>">
								</td>
								<td>出版日期 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="datePress" value="<s:property value='#request.bk_datePress'/>">
								</td>
							</TR>
							<TR>
								<td>语言 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_language" value="<s:property value='#session.showEditBook.bk_language'/>">
								</td>
								<td>页数 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_pages" value="<s:property value='#session.showEditBook.bk_pages'/>">
								</td>
							</TR>
							<TR>
								<td>价格 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_price" value="<s:property value='#session.showEditBook.bk_price'/>">
								</td>
								<td>图书状态 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
									style="WIDTH: 180px" maxLength=50 name="bk_status" value="<s:property value='#session.showEditBook.bk_status'/>">
								</td>
							</TR>
							
							<TR>
								<td>内容简介 ：</td>
								<td>
								<textarea rows="12" cols="18" name="bk_brief"><s:property value='#session.showEditBook.bk_brief'/></textarea>
								</td>
								<td>图书封面 ：</td>
								<td >
									<img src="${ pageContext.request.contextPath }/<s:property value='#request.imagePath'/>" width="140px" height="140px"/>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="提交修改" name=sButton2>
								</td>
								<td>
									<a href="${pageContext.request.contextPath }/book_delete.action">移除图书</a>
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
