<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 添加新模板的jsp页面！ -->
<html>
  <head>
    <title>添加新表单模板</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
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
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
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
    <s:form action="FormTemplateAction_addNewFormTemplate.action" method="post" enctype="multipart/form-data">
    	<table>
    		<tr>
    			<td>模板名称</td>
    			<td>
    				<s:textfield name="formTemplateName"></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>所用的流程</td>
    			<td>
    				<s:select list="#processDefinitionNames" name="processDefinitionKey" value="#processDefinitionNames[0]"></s:select>
    			</td>
    		</tr>
    		<tr>
    			<td>请选择上传的模板文件</td>
    			<td>
    				<s:file name="formTemplateFile"></s:file>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<input type="button" id="confirm" value="上传">
    			</td>
    			<td>
    				<input type="button" id="cancel" value="取消">
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
