<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style type="text/css">
    	#title{
    		font-size: 50px;
    		text-align: center;
    		line-height: 80px;
    		font-weight: bold;
    	}
    	#loginInformation{
    		text-align: right;
    		margin-right: 20px;
    		margin-bottom: 5px;
    		font-size: 14px;
    	}
    </style>
  </head>
  
  <body>
    	<div id="title">协同OA管理系统</div>
    	<div id="loginInformation">
    		欢迎你，<s:property value="%{#session.user.userName}"/>&nbsp;&nbsp;
    		<!-- 使用_parent的方法在父窗体中打开链接 -->
    		<a id="logout" href="UserAction_logout.action" target="_parent">
    			注销
    		</a>
    	</div>
	</body>
</html>
