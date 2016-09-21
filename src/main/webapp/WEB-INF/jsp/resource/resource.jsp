<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.zengrui.common.authority.shared.entity.*" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>资源</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/icons/icon-all.css"/>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common/common.js" ></script>

	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jquery.jdirk.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.menu.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.tabs.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.panel.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.datagrid.js" type="text/javascript"></script>
	
	
	<style>
		.s-btn-downarrow{
			background:none;
		}
	</style>

	<script type="text/javascript">
		function initComponent(){
			var formResStatus = $("#form_resStatus");
			formResStatus.combobox({
				panelHeight:"auto",
				valueField: 'value',
				textField: 'label',
				data: [{
					label: '显示',
					value: '1'
				},{
					label: '隐藏',
					value: '0'
				}]
			});
			$("#res_menu").tree({
				method: "get",
				url: "./res/resList",
				onClick:function(node){
					$("#form_menu").form("load",node);
					
				},
				loadFilter:function(rows){
					 return convert(rows.dataList);
				}
			});
			$("#res_btn").datagrid({
				fit:true,
				method: "get",
				idField: 'resNo',
				rownumbers: true,
				pagination: true,
				enableRowContextMenu: true,         //此属性开启表头列名称右键点击菜单
				pagingMenu: { submenu: false},//开启行右键菜单的翻页功能，此属性可丰富配置，详情见 API 文档
				exportMenu:{submenu: false},
				toolbar:'#tb',
				columns: [[
					{ field: 'resNo', title: '名称', width: 80, sortable: true },
					{ field: 'resName', title: '编码', width: 80, sortable: true },
					{ field: 'resPermission', title: '权限项', width: 120, sortable: true },
					{ field: 'Name', title: '描述', width: 140, sortable: true }
				]],
				 enableHeaderClickMenu: true,        //此属性开启表头列名称右侧那个箭头形状的鼠标左键点击菜单
	             enableHeaderContextMenu: true,      //此属性开启表头列名称右键点击菜单
	             enableRowContextMenu: false
			});
		}
	
	
		$(function(){
			initComponent();
		});
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit: true">

		<div data-options="region: 'west', title: '菜单资源', iconCls: 'icon-standard-application-view-tile', split: true,collapsible:false" style="width: 250px;">
			<ul id="res_menu"></ul>
		</div>
		<div data-options="region: 'center', split: true">
			<div class="easyui-layout" data-options="fit: true">
				<div data-options="region: 'north',title: '菜单维护',collapsible:false" style="height:30%;overflow:hidden" >

					<div id="dlg-toolbar">
						<table style="width:100%">
							<tr>
								<td>
									<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false">新增</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="false">编辑</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="false">保存</a>
									<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="false">删除</a>
								</td>
							</tr>
						</table>
					</div>
					<form id="form_menu" style="padding:5px;">
						<table>
							<tr style="text-align: right">
								<td style="width:25%"><input class="easyui-textbox" label ="上级编码：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" name="resParentNo"  id="form_resParentNo"   /></td>
								<td style="width:25%"><input class="easyui-textbox" label ="上级名称：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" name="resParentName" id="form_resParentName"  /></td>
								<td style="width:25%"><input class="easyui-textbox" label ="资源编码：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" name="resNo" id="form_resNo"  /></td>
								<td style="width:25%"><input class="easyui-textbox" label ="资源名称：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" name="resName" id="form_resName"  /></td>
							</tr>
							<tr style="text-align: right">
								<!-- <td style="width:25%"><input class="easyui-textbox" label ="资源图标：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" name="resIconcls" id="form_resIconcls"  /></td> -->
								<td colspan=3><input class="easyui-textbox" label ="资源路径：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" style="" name="resUrl"  id="form_resUrl"   /></td>
								<td style="width:25%"><input class="easyui-combobox" label ="是否可见：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" name="resStatus" id="form_resStatus"  /></td>
							</tr>
							<tr style="text-align: right">
								<td colspan=4><input class="easyui-textbox" label ="资源描述：" labelWidth="65" labelAlign="right" type="text" style="width: 100%;" multiline="true" style="" name="resDescribe"  id="form_resDescribe"   /></td>
							</tr>
						</table>
					</form>
				</div>
				<div data-options="region: 'center',title: '按钮明细'" >
					<table id="res_btn"></table>
					<div id="tb">
						<table cellpadding="5"  style="width:100%">
							<tr>
								<td>
								<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="false">添加</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="false">删除</a>
								</td>
							</tr>
						</table>
					</div>
				</div>

			</div>
		</div>

	</div>
</body>
</html>