<%@page import="com.kdyzm.domain.Rectangle"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 显示活动节点的图片 -->
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
    <img alt="显示活动的节点图片" src="FormAction_showCurrentActivityImage.action?processId=<s:property value='%{#processId}'/>">
    <s:iterator value="%{#rectanglelist}">
    	<div style="position:absolute;border:3px solid red;left:<s:property value="%{x+10}"/>;top:<s:property value="%{y+10}"/>;height:<s:property value="%{height-10}"/>;width:<s:property value="%{width-10}"/>;">
    		
    	</div>
    </s:iterator>
  </body>
</html>
