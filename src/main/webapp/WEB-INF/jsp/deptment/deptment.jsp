<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.zengrui.common.authority.shared.entity.*" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>部门</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/icons/icon-all.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.easyui.min.js"></script>

	<style>
		.s-btn-downarrow{
			background:none;
		}

	</style>

	<script type="text/javascript">
		$(function(){
			$("#menu_res").tree({
				url: "../data/org.json"
			});
			$("#t1").datagrid({
				fit:true,
				method: "get",
				url: "datagrid/datagrid-data.json",
				idField: 'ID',
				rownumbers: true,
				pagination: true,
				enableRowContextMenu: true,         //此属性开启表头列名称右键点击菜单
				pagingMenu: { submenu: false},//开启行右键菜单的翻页功能，此属性可丰富配置，详情见 API 文档
				exportMenu:{submenu: false},
				toolbar:'#tb',
				frozenColumns: [[
					{ field: 'ck', checkbox: true },
					{ field: 'ID', title: 'ID', width: 80, sortable: true }
				]],
				columns: [[
					{ field: 'Code', title: '编号(Code)', width: 120, sortable: true },
					{ field: 'Name', title: '名称(Name)', width: 140, sortable: true },
					{ field: 'Age', title: '年龄(Age)', width: 120, sortable: true },
					{ field: 'Height', title: '身高(Height)', width: 140, sortable: true },
					{ field: 'Weight', title: '体重(Weight)', width: 140, sortable: true },
					{ field: 'CreateDate', title: '创建日期(CreateDate)', width: 180, sortable: true },
					{ field: 'undefined', title: '测试(不存在的字段)', width: 150 }
				]],
				headerContextMenu: [
					{ text: "测试菜单1", iconCls: "icon-hamburg-address", disabled: false, handler: function () { alert(1); } },
					{ text: "测试菜单2", iconCls: "icon-hamburg-busy", disabled: false, handler: function (e, field) { alert($.string.format("您点击了{0}", field)); } }
				],
				enableHeaderClickMenu: false,        //此属性开启表头列名称右侧那个箭头形状的鼠标左键点击菜单
				enableHeaderContextMenu: true     //此属性开启表头列名称右键点击菜单
			});
		});
	</script>
</head>
<body>
<div class="easyui-layout" data-options="fit: true">

	<div data-options="region: 'west', title: '组织架构', iconCls:'icon-berlin-bank', split: true,collapsible:false" style="width: 250px;">
		<ul id="menu_res"></ul>
	</div>
	<div data-options="region: 'center', split: true">
		<div class="easyui-layout" data-options="fit: true">
			<div data-options="region: 'center',title: '资源维护',collapsible:false" style="height:250%;overflow:hidden" >

				<div id="dlg-toolbar">
					<table cellpadding="5"  style="width:100%">
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
				<form style="padding:5px;">
					<table>
						<tr>
							<td style="width: 20%"><input class="easyui-textbox" label="上级部门：" labelWidth="65" labelPosition="before" labelAlign="right" style="width: 100%;"></td>
							<td style="width: 20%"><input class="easyui-combobox" label="部门编码：" labelWidth="65" labelPosition="before" labelAlign="right" style="width: 100%;"></td>
							<td style="width: 20%"><input class="easyui-textbox" label="部门名称：" labelWidth="65" labelPosition="before" labelAlign="right" style="width: 100%;"></td>
							<td style="width: 20%"><input class="easyui-textbox" label="部门简称：" labelWidth="65" labelPosition="before" labelAlign="right" style="width: 100%;"></td>
							<td style="width: 20%"><input class="easyui-textbox" label="部门简称：" labelWidth="65" labelPosition="before" labelAlign="right" style="width: 100%;"></td>
						</tr>
						<!--<tr style="text-align: right;">-->
							<!--<td style="width: 12%;">所在省：</td>-->
							<!--<td style="width: 12%"><input class="easyui-textbox" type="text" style="width: 100%;" data-options="iconWidth: 22,iconCls:'icon-add'"></input></td>-->
							<!--<td style="width: 12%">所在市：</td>-->
							<!--<td style="width: 12%"><input class="easyui-textbox" type="text" style="width: 100%;"/></td>-->
							<!--<td style="width: 12%">所在区/县：</td>-->
							<!--<td style="width: 12%"><input class="easyui-textbox" type="text" style="width: 100%;"/></td>-->
							<!--<td style="width: 12%">详细地址：</td>-->
							<!--<td style="width: 12%"><input class="easyui-textbox" type="text" style="width: 100%;"/></td>-->
						<!--</tr>-->

					</table>
				</form>
			</div>

		</div>
	</div>

</div>
</body>
</html>