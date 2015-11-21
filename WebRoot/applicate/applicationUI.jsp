<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Insert title here !</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <style type="text/css">
    	.div1{
    		margin-left: 40px;
    		padding-bottom: 10px;
    		border-bottom: 1px solid black;
    	}
    	.div2{
    		margin-top:10px;
    		margin-left: 50px;
    		margin-bottom: 100px;
    	}
    	.div3{
    		margin-left: 40px;
    		padding-bottom: 10px;
    		border-bottom: 1px solid black;
    	}
    	.div4{
    		margin-top:10px;
    		margin-left: 50px;
    	}
    	body{
    		margin-top: 40px;
    	}
    	a{
    		text-decoration: none;
    		color:gray;
    	}
    	a:HOVER {
			color:red;
		}
    </style>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
    	$().ready(function(){
    		$("#btn").unbind("click");
    		$("#btn").bind("click",function(){
    			$("form").submit();
    		});
    	});
    </script>
  </head>
  
  <body>
    <div class="div1">
    	请下载模板文件
    </div>
    <div class="div2">
    	<s:a action="FormTemplateAction_downloadFormTemplateById.action">
    		<s:param name="formTemplateId" value="%{#formTemplate.formTemplateId}"></s:param>
    		[单击下载模板文件]
    	</s:a>
    </div>
     <div class="div3">
    	请上传已经填写好的文件
    </div>
    <div class="div4">
    	<s:form action="FormAction_uploadForm.action" method="post" enctype="multipart/form-data">
    		<s:file name="formFile"></s:file>
    		<s:hidden name="formTemplateId" value="%{#formTemplate.formTemplateId}"></s:hidden>
    		<input type="button" id="btn" value="确定"><br/>
    	</s:form>
    </div>
  </body>
</html>
