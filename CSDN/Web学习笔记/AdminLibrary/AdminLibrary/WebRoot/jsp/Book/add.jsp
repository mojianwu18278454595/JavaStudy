<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>新书入库</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>

<script language="javascript">
  function imgLoaded() {
//判断图片大小
    var image = document.getElementById("filesInput").files[0];
    var fileSize = image.size;
    if(fileSize/1024 > 1024){
        info.innerHTML = "图片大小超过1M!";
        document.getElementById("imageBox").innerHTML = "";
        img.src="";
        filesInput.value = "";
    }
    else{
            var reader = new FileReader(); 
            reader.readAsDataURL(image);
            reader.onload = function(e){
            imageBox.innerHTML = "<li><img src='" + this.result + "' width='150px' height='150px'>"  + "</li>";
            info.innerHTML = "";
          }
        }
}
  </script>

</head>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/book_add.action"
		method=post>
		

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
								<TD class=manageHead>当前位置：图书管理 &gt; 新书入库</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<font color="red" size="4"><s:actionmessage/></font>
							<TR>
								<td>条码号：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_code">
								</td>
								<td>出版社：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_press">
								</td>
							</TR>
							<TR>
								<td>书名：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_name">
								</td>
								<td>作者：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_author">
								</td>
							</TR>
							<TR>
								<td>ISBN ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_ISBN">
								</td>
								<td>出版日期 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="datePress">
								</td>
							</TR>
							<TR>
								<td>语言 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_language">
								</td>
								<td>页数 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_pages">
								</td>
							</TR>
							<TR>
								<td>价格 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_price">
								</td>
								<td>图书状态 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="bk_status">
								</td>
							</TR>
							
							<TR>
								<td>内容简介 ：</td>
								<td>
								<textarea rows="12" cols="18" name="bk_brief"></textarea>
								</td>
								
								
								<td>图书封面 ：</td> 
								<td> 
								<input style="width:150px;" type="file" accept="image/*" name="book_cover" id="filesInput" onchange="imgLoaded()"><br>  
									<ul id="imageBox"></ul>
								</td>
							
<script>   
$("#reader_photo").change(function(){  
		 var objUrl = getObjectURL(this.files[0]) ;//获取文件信息  
		 console.log("objUrl = "+objUrl);  
		  if (objUrl) {  
		  $("#img0").attr("src", "E:\\JavaEEProject\\imges\\"+objUrl);  
		 }   
}) ;  
function getObjectURL(file) {  
		 var url = null;   
		 if (window.createObjectURL!=undefined) {  
		  url = window.createObjectURL(file) ;  
		 } else if (window.URL!=undefined) { // mozilla(firefox)  
		  url = window.URL.createObjectURL(file) ;  
		 } else if (window.webkitURL!=undefined) { // webkit or chrome  
		  url = window.webkitURL.createObjectURL(file) ;  
		 }  
		 return url ;  
		}  
</script>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="保存 " name=sButton2>
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
