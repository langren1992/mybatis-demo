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
	
		<script src="${pageContext.request.contextPath}/static/js/common/common.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/authority/role_detail.js"></script>
	  	<title>角色管理</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit: true">
		<div data-options="region: 'north',title:'角色详情',collapsible:false">
			<div class="easyui-layout" data-options="fit: true" style="height:105px;">
				<div data-options="region: 'north'" style="overflow: hidden;">
					<div  style="padding-top:5px;padding-left:5px;height:34px">
						<div style="margin-bottom:5px">
							<a id="btnEdit" href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="false">修改</a>
							<a id="btnSave" href="#" class="easyui-linkbutton" iconCls="icon-save" plain="false">保存</a>
						</div>
					</div>
				</div>
				<div data-options="region: 'center'" >
					<form id="roleDetail" method="post">
						<table cellspacing="10" style="margin:0 auto">
							<tr style="text-align: right">
								<td>角色编号：</td>
								<td><input class="easyui-validatebox" type="text" name="code"  id="code" data-options="required:true"/></td>
								<td>名称：</td>
								<td><input class="easyui-validatebox" type="text" name="alias" id="alias"  data-options="required:true"/>
								<td>角色：</td>
								<td><input class="easyui-validatebox" type="text" name="name" id="name"data-options="required:true"/>
								<td>可用状态：</td>
								<td><input type="text" name="available" id="available"   /></td>
							</tr>
							<tr style="display:none">
								<td>角色id：</td>
								<td><input class="easyui-textbox" type="text" name="id"  id="id"/></td>
								<td>创建者ID：</td>
								<td><input class="easyui-textbox" type="text" name="createUserId"  id="createUserId"/></td>
								<td>创建者：</td>
								<td><input class="easyui-textbox" type="text" name="createUser"  id="createUser"/></td>
								<td>创建时间：</td>
								<td><input class="easyui-datebox" type="text" name="createTime" id="createTime"/>
								<td>最近修改者ID：</td>
								<td><input class="easyui-textbox" type="text" name="updateUserId" id="updateUserId"  />
								<td>最近修改者：</td>
								<td><input class="easyui-textbox" type="text" name="updateUser" id="updateUser"  />
								<td>最近修改者：</td>
								<td><input class="easyui-datebox" type="text" name="updateTime" id="updateTime"   /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div data-options="region: 'center',title:'已有资源',collapsible:false" >
			<table id="ownResTable"></table>
			<div id="tb" style="padding-top:5px;padding-left:5px;height:auto">
				<div style="margin-bottom:5px">
					<a id="btnAddRes" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false">分配资源</a>
				</div>
			</div>
		</div>
		<div id = "allResWin">
			<div class="easyui-layout" data-options="fit: true">
			<div data-options="region: 'north'" style="overflow: hidden;">
				<div id="allResTableTb" style="padding-top:5px;padding-left:5px;height:auto">
					<div style="margin-bottom:5px">
						<a id="btnSaveRes" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false">保存</a>
						<a id="btnCancelRes" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="false">取消</a>
					</div>
				</div>
			</div>
			<div data-options="region: 'center'">
				<table id="allResTable"></table>
			</div>
		</div>
	</div>
	
</body>
</html>