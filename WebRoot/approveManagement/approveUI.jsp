<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>进行审批的主界面</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style type="text/css">
    	#div1{
    		margin-left: 40px;
    		margin-top: 50px;
    		padding-bottom: 5px;
    		font-size: 20px;
    		border-bottom: 1px solid black;
    	}
    	#div2{
    		margin-top: 7px;
    		margin-left: 50px;
    	}
    	#div3{
    		margin-left: 40px;
    		margin-top: 50px;
    		padding-bottom: 5px;
    		font-size: 20px;
    		border-bottom: 1px solid black;
    	}
    	#div4{
    		margin-top: 7px;
    		margin-left: 50px;
    	}
    	#comment{
    		width: 700px;
    		height: 200px;
    		border: 1px solid black;
    		margin-bottom: 10px;
    	}
    	a{
    		text-decoration: none;
    		color: gray;
    	}
    	a:HOVER {
			color: red;
		}
    </style>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
    	$().ready(function(){
    		$("#confirm").unbind("click");
    		$("#confirm").bind("click",function(){
    			var parameter=$("form").serialize();
    			$.post("ApproveActionJson_confirm.action",parameter,function(data){
    				if(data.message=="1"){
	    				window.location.href="ApproveAction_listAllApprvements.action";
    				}else{
    					window.alert("提交失败！");
    				}
    			});
    		});
    		$("#unconfirm").unbind("click");
    		$("#unconfirm").bind("click",function(){
    			var parameter=$("form").serialize();
    			$.post("ApproveActionJson_unConfirm.action",parameter,function(data){
    				if(data.message=="1"){
	    				window.location.href="ApproveAction_listAllApprvements.action";
    				}else{
    					window.alert("提交失败！");
    				}
    			});
    		});
    		$("#back").unbind("click");
    		$("#back").bind("click",function(){
    			history.go(-1);
    		});
    	});
    </script>
  </head>
  
  <body>
    <div id="div1">申请信息</div>
    <div id="div2">
    	<s:a action="FormAction_downloadFormByFormId.action">
    		<s:param name="fid" value="%{#form.fid}"></s:param>
    	[点击下载申请的文档]</s:a>
    </div>
    <div id="div3">审批信息</div>
    <div id="div4">
    	<s:form>
    		<s:textarea name="comment" id="comment"></s:textarea><br/>
    		<s:hidden name="fid" value="%{#form.fid}"></s:hidden>
    		<s:hidden name="taskId" value="%{#task.id}"></s:hidden>
    		<div id="button">
	    		<input type="button" value="同意" id="confirm">
	    		<input type="button" value="不同意" id="unconfirm">
	    		<input type="button" value="返回" id="back">
    		</div>
    	</s:form>
    </div>
  </body>
</html>
