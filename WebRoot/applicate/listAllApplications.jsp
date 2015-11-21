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
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
    	$().ready(function(){
    		$("a").each(function(){
    			if($(this).text()=="查看流转记录图"){
    				$(this).unbind("click");
    				$(this).bind("click",function(){
    					var left=(screen.width-800)/2;
    			         var top=(screen.height-500)/2;
    			        // window.open($(this).attr("href"),"_blank","height=500,width=800,left="+left+",top="+top+",scrollbars=1",false);
    			        window.open("FormAction_showImageUI.action?"+$(this).attr("href").split("?")[1],"_blank","height=500,width=800,left="+left+",top="+top+",scrollbars=1",false);
    			         return false;
    				});
    			}
    		});
    	});
    </script>
  </head>
  
  <body>
  	<div id="div1">
  		我的所有申请查询
  	</div>
  	<div id="div2">
  		<table>
  			<thead>
  				<tr>
  					<td>标题</td>
  					<td>申请人</td>
  					<td>申请日期</td>
  					<td>当前状态</td>
  					<td>相关操作</td>
  				</tr>
  			</thead>
  			<tbody>
  				<s:iterator value="%{#forms}">
  					<tr>
  						<td>
  							<s:property value="%{title}"/>
  						</td>
  						<td>
  							<s:property value="%{applicator}"/>
  						</td>
  						<td>
  							<s:property value="%{date}"/>
  						</td>
  						<td>
  							<s:property value="%{state}"/>
  						</td>
  						<td>
  							<s:a>查看申请信息</s:a>
  							<s:a>查看流转记录</s:a>
  							<s:if test="%{state!='完成申请'}">
  								<s:a  action="FormAction_showCurrentActivityImage.action">
  								<s:param name="processId" value="%{processId}"></s:param>
  							查看流转记录图</s:a>
  							</s:if>
  						</td>
  					</tr>
  				</s:iterator>
  			</tbody>
  		</table>
  	</div>
  </body>
</html>
