<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.zengrui.common.authority.shared.entity.*" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link href="${pageContext.request.contextPath}/static/theme/metro-standard/easyui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/static/theme/icon.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/static/icons/icon-all.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" type="text/css" />
	
		<script src="${pageContext.request.contextPath}/static/jquery/jquery-2.1.1.min.js"></script>
	
		<script src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	
		<script src="${pageContext.request.contextPath}/static/release/jquery.jdirk.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/release/jeasyui.extensions.all.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/release/jeasyui.icons.all.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/common.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/authority/resource.js"></script>
		
	  	<title>资源管理</title>
		<style>
			.s-btn-downarrow{
				background:none;
			}
			body { 
				font-size: 12pt;
				font-family: 微软雅黑;
				padding: 0; 
				margin: 0;
				overflow: hidden;
			}
			.treeClass li div{
				font-family: 微软雅黑;
				height: 20px;
				margin: 0 auto;
			}
			.tree-title{
				font-size: 12pt;
			}
		</style>

	
</head>
<body>
	<div class="easyui-layout" data-options="fit: true">
		<div data-options="region: 'west', title: '菜单资源', iconCls: 'icon-standard-application-view-tile', split: true, minWidth: 250, maxWidth: 500" style="width: 250px;">
			<div id="searchbar">
                <input id="topSearchbox" name="topSearchbox" class="easyui-searchbox" data-options="width: 242, height: 26, prompt: '目录相关信息', menu: '#topSearchboxMenu'" />
                <div id="topSearchboxMenu" style="width: 60px;">
                    <div data-options="name:'mame', iconCls: 'icon-standard-book-addresses'">名称</div>
                    <div data-options="name:'code', iconCls: 'icon-standard-calculator-add'">编码</div>
                </div>
            </div>
			<ul id="menuRes" style="padding-top:3px;"></ul>
		</div>
		<div data-options="region: 'center',title: '资源维护', split: true">
			<div class="easyui-layout" data-options="fit: true">
				<div data-options="region: 'north', minWidth: 250, maxWidth: 500" style="overflow:hidden" >
					
					<form id="resDetail">
						<table cellspacing="5" style="margin:0 auto">
							<tr style="display:none">
								<td>资源名称ID：</td>
								<td><input class="easyui-textbox" type="text" name="id" id="id"/></td>
								<td>父资源名称ID：</td>
								<td><input class="easyui-textbox" type="text" name="parentId" id="parentId"/></td>
							</tr>
							<tr style="text-align: right">
								<td>资源名称：</td>
								<td><input class="easyui-validatebox" type="text" name="name"  id="name" data-options="required: true"/></td>
								<td>父资源名称：</td>
								<td><input class="easyui-textbox" type="text" name="parentName" id="parentName"/></td>
								<td>类型：</td>
								<td><input class="easyui-textbox" type="text" name="type" id="type"  /></td>
							</tr>
							<tr style="text-align: right">
								<td>资源编码：</td>
								<td><input class="easyui-textbox" type="text" name="code" id="code"  /></td>
								<td>权限项：</td>
								<td><input class="easyui-textbox" type="text" name="permission" id="permission"  /></td>
								<td>可用状态：</td>
								<td><input class="easyui-textbox" type="text" name="available" id="available"  /></td>
							</tr>
							<tr style="text-align: right">
								<td>图标：</td>
								<td><input class="easyui-textbox" type="text" name="iconCls" id="iconCls"/></td>
								<td>路径：</td>
								<td><input class="easyui-textbox" type="text" name="href" id="href"  /></td>
							</tr>
							<tr style="text-align: right">
								<td>资源描述：</td>
								<td colspan="3"><input class="easyui-textbox" type="text" name="description" id="description" style="width:455px;"/></td>
							</tr>
							<tr style="display:none">
								<td>创建者ID：</td>
								<td><input class="easyui-textbox" type="text" name="createUserId"/></td>
								<td>最近修改者ID：</td>
								<td><input class="easyui-textbox" type="text" name="updateUserId"/></td>
							</tr>
							<tr  style="text-align: right">
								<td>创建者：</td>
								<td><input class="easyui-textbox" type="text" name="createUser" id="createUser"  /></td>
								<td>创建时间：</td>
								<td><input class="easyui-datebox" type="text" name="createTime" id="createTime"  /></td>
							</tr>
							<tr  style="text-align: right">
								<td>最近更新者：</td>
								<td><input class="easyui-textbox" type="text" name="updateUser" id="updateUser"  /></td>
								<td>最近更新时间：</td>
								<td><input class="easyui-datebox" type="text" name="updateTime" id="updateTime"  /></td>
							</tr>
						</table>
					</form>
				</div>
				<div data-options="region: 'center',title: '按钮资源'" >
					<table id="buttonDataGird"></table>
					<div id="tb" style="padding:5px;height:auto">
						<div style="margin-bottom:5px">
							<shiro:hasPermission name="resource:create">
								<a id="add" href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false">新增</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="resource:update">
								<a id="save" href="#" class="easyui-linkbutton" iconCls="icon-save" plain="false">保存</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="resource:delete">
								<a id="cancel" href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="false">删除</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="resource:start">
								<a id="start" href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="false">启用</a>
							</shiro:hasPermission>
							<shiro:hasPermission name="resource:end">
								<a id="end" href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="false">停用</a>
							</shiro:hasPermission>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>