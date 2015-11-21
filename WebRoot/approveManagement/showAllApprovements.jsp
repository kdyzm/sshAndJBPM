<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 显示当前用户所有的申请列表 -->
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style type="text/css">
    	#div1{
    		margin-left: 30px;
    		margin-top: 20px;
    		margin-bottom: 30px;
    		padding-bottom: 5px;
    		font-size: 20px;
    		border-bottom: 1px solid black;
    	}
    	
    	#div2{
    		
    	}
    	table{
    		border: 1px solid black;
    		border-collapse: collapse;
    		width: 100%;
    	}
    	table td{
    		border:1px solid black;
    		padding:5px;
    		text-align: center;
    	}
    	a{
    		text-decoration: none;
    		color:gray;
    	}
    	a:HOVER {
			color: red;
		}
    </style>
  </head>
  
  <body>
  	<div id="div1">
  		我的所有审批任务
  	</div>
  	<div id="div2">
  		<table>
  			<thead>
  				<tr>
  					<td>标题</td>
  					<td>申请人</td>
  					<td>申请日期</td>
  					<td>相关操作</td>
  				</tr>
  			</thead>
  			<tbody>
  				<s:iterator value="%{#taskViews}">
  					<tr>
  						<td>
  							<s:property value="%{form.title}"/>
  						</td>
  						<td>
  							<s:property value="%{form.applicator}"/>
  						</td>
  						<td>
  							<s:property value="%{form.date}"/>
  						</td>
  						<td>
  							<s:a>查看流转记录</s:a>
  							<s:a action="ApproveAction_approveUI.action">
  								<s:param name="taskId" value="task.id"></s:param>
  								<s:param name="fid" value="form.fid"></s:param>
  							审批处理</s:a>
  						</td>
  					</tr>
  				</s:iterator>
  			</tbody>
  		</table>
  	</div>
  </body>
</html>
