<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
    <style type="text/css">
    	table {
    		border: 1px solid black;
    		border-collapse: collapse;
    		width:100%;
    	}
    	table td{
    		border: 1px solid black;
    		padding: 5px;
    	}
    </style>
    <script type="text/javascript">
    	$().ready(function(){
    		$("#confirm").unbind("click");
    		$("#confirm").bind("click",function(){
    			$("form").submit();
    		});
    		$("#cancel").unbind("click");
    		$("#cancel").bind("click",function(){
    			history.go("-1");
    		});
    	});
    </script>
  </head>
  
  <body>
	<s:form action="PDManagementAction_deploy.action" enctype="multipart/form-data" method="post">
		<table width="50%" align="center">
			<tr>
				<td colspan="2" align="center">
					<s:file name="file"></s:file>
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="确定" id="confirm">
				</td>
				<td align="left">
					<input type="button" id="cancel" value="取消">
				</td>
			</tr>
		</table>
	</s:form>
  </body>
</html>
