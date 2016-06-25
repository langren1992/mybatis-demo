<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.zengrui.common.authority.shared.entity.*" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="${pageContext.request.contextPath}/static/theme/gray/easyui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/static/theme/icon.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/static/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" type="text/css" />
	
		<script src="${pageContext.request.contextPath}/static/jquery/jquery-2.1.1.min.js"></script>
	
		<script src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	
		<script src="${pageContext.request.contextPath}/static/release/jquery.jdirk.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/release/jeasyui.extensions.all.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/authority/role.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/common.js"></script>
		
		
	  	<title>角色明细</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit: true">
		<div data-options="region: 'center', split: true" >
			<div class="easyui-layout" data-options="fit: true">
				<div data-options="region: 'north',title:'查询条件',collapsible:false" style="height:100px;">
					<form id="role_condi">
						<table cellspacing="10" style="margin:0 auto">
							<tr style="text-align: right">
								<td>编号：</td>
								<td><input class="easyui-textbox" type="text" name="code"  id="code_condi"   /></td>
								<td>名称：</td>
								<td><input class="easyui-textbox" type="text" name="alias" id="alias_condi"  />
								<td>角色：</td>
								<td><input class="easyui-textbox" type="text" name="name" id="name_condi"  />
								<td>可用状态：</td>
								<td style="text-align: left;"><input class="easyui-textbox" type="text" name="available" id="available_condi"/></td>
							</tr>
						</table>
					</form>
					<div style="margin-bottom:5px;text-align: right;padding-right: 50px"  >
						<a id="btnReset" href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="false">重置</a>
						<a id="btnSearch" href="#" class="easyui-linkbutton" iconCls="icon-search" plain="false">查询</a>
					</div>
				</div>
				<div data-options="region: 'center', title: '列表结果'">
					<table id="roleList"></table>
					<div id="roleListTool" style="padding:5px;height:auto">
						<div style="margin-bottom:5px">
							<a id="btnAddRole" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false">新增</a>
							<a id ="btnStartRole" href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="false">启用</a>
							<a id ="bEndRole" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="false">停用</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>