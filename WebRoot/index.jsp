<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  <frameset rows="120px,*" framespacing="0">
  	<frame noresize name="top" src="${pageContext.servletContext.contextPath}/DispatcherAction_toTop.action">
  	<frameset cols="200px,*">
  		<frame noresize name="left" src="${pageContext.servletContext.contextPath}/DispatcherAction_toLeft.action">
  		<frame noresize name="right" src="${pageContext.servletContext.contextPath}/ApproveAction_toIndex.action">
  	</frameset>
  </frameset>
</html>
