<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>模板管理主界面</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
    <style type="text/css">
    	table {
			border: 1px solid black;
			border-collapse: collapse;
		}
		table td{
			border:1px solid black;
			padding: 5px;
			text-align: center;
		}
		#createNew{
			margin-top:30px;
			text-align: center;
		}
    </style>
    <script type="text/javascript">
    	$().ready(function(){
    		$("#btn").unbind("click");
    		$("#btn").bind("click",function(){
    			
    		});
    		$("a").each(function(){
    			if($(this).text()=="删除"){
    				$(this).unbind("click");
    				$(this).bind("click",function(){
    					var result=window.confirm("你确定要删除吗");
    					if(result==false){
    						return false;
    					}
    					return true;
    				});
    			}
    			if($(this).text()=="查看流程图"){
    				$(this).unbind("click");
    				$(this).bind("click",function(){
    					 var left=(screen.width-800)/2;
    			         var top=(screen.height-500)/2;
    			        // window.open($(this).attr("href"),"_blank","height=500,width=800,left="+left+",top="+top+",scrollbars=1",false);
    			        window.open("PDManagementAction_showImageUI?"+$(this).attr("href").split("?")[1],"_blank","height=500,width=800,left="+left+",top="+top+",scrollbars=1",false);
    			         return false;
    				});
    			}
    		});
    	});
    </script>
  </head>
  
  <body>
  	<table width="100%">
  		<thead>
  			<tr>
  				<td width="300px">模板名称</td>
  				<td width="200px">所用流程</td>
  				<td width="300px">相关操作</td>
  			</tr>
  		</thead>
  		<tbody>
  			<s:iterator value="%{#formTemplates}">
  				<tr>
  					<td>
  						<s:property value="%{name}"/>
  					</td>
  					<td>
  						<s:property value="%{processKey}"/>
  					</td>
  					<td>
						<s:a action="FormTemplateAction_deleteByFormTemplateId.action">
							<s:param name="formTemplateId" value="%{formTemplateId}"></s:param>
						删除</s:a>  						
						<s:a action="FormTemplateAction_updateByFormTemplateId.action">
							<s:param name="formTemplateId" value="%{formTemplateId}"></s:param>
						修改</s:a>
						<s:a action="FormTemplateAction_downloadFormTemplateById.action">
							<s:param name="formTemplateId" value="%{formTemplateId}"></s:param>
						下载</s:a>
  					</td>
  				</tr>
  			</s:iterator>
  		</tbody>
  	</table>
  	<div id="createNew">
		<a href="${pageContext.servletContext.contextPath}/FormTemplateAction_createNewUI.action">  		
  			<button id="btn">添加新模板</button>
  		</a>
  	</div>
  </body>
</html>
