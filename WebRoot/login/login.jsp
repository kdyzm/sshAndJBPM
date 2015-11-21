<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!-- 登陆页面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style type="text/css">
    	table {
			margin-top: 200px;
		}
		table td{
			text-align: center;
			padding: 5px;
		}
    </style>
  </head>
  
  <body>
    <s:form action="UserAction_checkUserNameAndPassword.action">
    	<table align="center">
    		<tr>
    			<td>用户名：</td>
    			<td>
    				<s:textfield name="userName"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td>
    				<s:textfield name="password"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="submit" value="登陆" id="confirm">
    			</td>
    			<td>
    				<input type="reset" value="重置" id="reset">
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
