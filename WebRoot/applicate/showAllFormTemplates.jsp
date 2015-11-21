<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有申请模板</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
    <style type="text/css">
    #description{
    	margin-left: 50px;
    	margin-top: 40px;
    	font-size: 16px;
    	line-height:30px;
    	border-bottom: 1px solid black;
    }
    #formTemplates{
    	margin-left: 50px;
    	margin-top: 40px;
    }
    	.formTemplate{
    		display:inline-block;
    		font-size: 14px;
    		margin-left: 30px;
    		margin-bottom: 20px;
    	}
    	a{
    		text-decoration: none;
    		color:gray;
    	}
    	a:HOVER {
			color:blue;
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
  	<div id="description">
  		请在以下模板中选择一个发起申请
  	</div>
  	<div id="formTemplates">
  			<s:iterator value="%{#formTemplates}">
  				<div class="formTemplate">
	  				<img src="${pageContext.servletContext.contextPath}/imgs/doc.gif">
					<s:a action="FormAction_showApplicationUI.action">
						<s:param name="formTemplateId" value="%{formTemplateId}"></s:param>
						<s:property value="%{name}"/>
					</s:a>
				</div>
  			</s:iterator>
  	</div>
  </body>
</html>
