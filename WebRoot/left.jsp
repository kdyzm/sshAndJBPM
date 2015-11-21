<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style type="text/css">
    	ul{
    		margin-top: 30px;
    	}
    	ul li{
    		font-size: 20px;
    		line-height: 30px;
    	}
    	a{
    		text-decoration: none;
    		color: gray;
    	}
    	a:HOVER {
			color: red;
		}
    </style>
  </head>
  <body>
  	<ul>
  		<li>
	  		<a href="ApproveAction_toIndex.action" target="right">审批流程管理</a>
  		</li>
  		<li>
  			<a href="FormTemplateAction_toFormTemplateIndex.action" target="right">表单模板管理</a>
  		</li>
  		<li>
  			<a href="FormTemplateAction_showAllFormTemplate.action" target="right">发起申请</a>
  		</li>
  		<li>
  			<a href="ApproveAction_listAllApprvements.action" target="right">审批处理</a>
  		</li>
  		<li>
  			<a href="FormAction_listAllApplication.action" target="right">查询状态</a>
  		</li>
  	</ul>
  </body>
</html>
