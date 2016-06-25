<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@page import="com.zengrui.common.authority.shared.entity.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>  
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="${pageContext.request.contextPath}/static/theme/gray/easyui.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/static/theme/icon.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/static/icons/icon-all.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" type="text/css" />
	
	<script src="${pageContext.request.contextPath}/static/jquery/jquery-2.1.1.min.js"></script>

	<script src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/static/release/jquery.jdirk.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/release/jeasyui.extensions.all.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/release/jeasyui.icons.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/common/common.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/index.js"></script>
    
    <style type="text/css">
		.treeClass li div{
			font-family: 微软雅黑;
			height: 20px;
			margin: 0 auto;
		}
		.tree-title{
			font-size: 12pt;
		}
		.top-bar { position: absolute; width: 100%; height: 52px; top: 0; left: 0; }
		.top-bar-left { position: absolute; width: 500px; height: 52px; }
		.top-bar-right { position: absolute; width: 400px; height: 52px; right: 0; }
		.top-bar-right #timerSpan { position: absolute; padding-top: 5px; right: 10px; }
		.top-bar-right #themeSpan { position: absolute; width: 350px; top: 24px; right: 5px; text-align: right; }
		
		.top-toolbar { position: absolute; font-weight: normal; padding: 0; width: 100%; height: 28px; top: 51px; left: 0; border-top-width: 1px; border-bottom-width: 0; z-index: 100; }
		.top-toolbar-topmost { top: 0px; height: 27px; border-top-width: 0px; border-bottom-width: 1px; }
		.top-toolbar #infobar { position: absolute; height: 26px; line-height: 26px; left: 50px; }
		.top-toolbar #searchbar { position: absolute; height: 26px; left: 600px; padding-top: 1px; }
		.top-toolbar #buttonbar { position: absolute; height: 26px; right: 5px; padding-top: 1px; text-align: right; }
		
	</style>


</head>
<body>
	<div id="maskContainer">
		<div class="datagrid-mask" style="display: block;"></div>
		<div class="datagrid-mask-msg" style="display: block; left: 50%; margin-left: -52.5px;">
			正在加载...
		</div>
	</div>
	<div id="mainLayout" class="easyui-layout" data-options="fit: true">

		<div data-options="region: 'north', split: true" style="height: 86px;overflow: hidden;">
			<div id="topbar" class="top-bar">
                <div class="top-bar-left">
                    <h1 style="margin-left: 10px; margin-top: 10px;">jEasyUI</h1>
                </div>
                <div class="top-bar-right">
                    <div id="timerSpan"></div>
                    <div id="themeSpan">
                        <a id="btnHideNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-up'"></a>
                    </div>
                </div>
            </div>
            <div id="toolbar" class="panel-header panel-header-noborder top-toolbar">
                <div id="infobar">
                    <span class="icon-hamburg-user" style="padding-left: 18px; background-position: left center;">
                        	用户：<shiro:principal/>
                    </span>
                    &nbsp;&nbsp;&nbsp;
                    <span class="icon-standard-house-go" style="padding-left: 18px; background-position: left center;">
                        	所属部门：<shiro:principal/>
                    </span>
                </div>
                <div id="searchbar">
                    <input id="topSearchbox" name="topSearchbox" class="easyui-searchbox" data-options="width: 350, height: 26, prompt: '请输入您要查找的内容关键词', menu: '#topSearchboxMenu'" />
                    <div id="topSearchboxMenu" style="width: 85px;">
                        <div data-options="name:'mame', iconCls: 'icon-standard-book-addresses'">目录名称</div>
                        <div data-options="name:'code', iconCls: 'icon-standard-calculator-add'">目录编码</div>
                    </div>
                </div>
                <div id="buttonbar">
                	<a id="btnChangeOrg" class="easyui-linkbutton" data-options="plain: true, iconCls: 'icon-standard-chart-organisation-add'">组织切换</a>
                    <a id="btnNews" class="easyui-linkbutton" data-options="plain: true, iconCls: 'icon-hamburg-contact', tooltip: '邮件'">消息<span id="newNum">(0)</span></a>
                    <a id="btnMaximize" class="easyui-linkbutton" data-options="plain: true, iconCls: 'icon-metro-expand2'">最大化</a>
                    <a id="btnFullScreen" class="easyui-linkbutton" data-options="plain: true, iconCls: 'icon-standard-arrow-inout'">全屏切换</a>
                    <a id="btnExit" class="easyui-linkbutton" data-options="plain: true, iconCls: 'icon-hamburg-sign-out'">退出系统</a>
                    <a id="btnShowNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-down'" style="display: none;"></a>
                </div>
            </div>
		</div>
		<div data-options="region: 'west', title: '菜单导航栏', iconCls: 'icon-standard-map', split: true, minWidth: 250, maxWidth: 500" style="width: 200px;">
			<ul id="menuTreeNav"></ul>
		</div>
		<div data-options="region: 'center', split: true">
			<div id="menuContent" class="easyui-tabs" data-options="fit: true, border: true, showOption: true, enableNewTabMenu: true, enableJumpTabMenu: true, onSelect: function (title, index) { updateHash(index); }">
				<div data-options="title: '首页', href: './welcome', refreshable: true,iconCls: 'icon-hamburg-home'"></div>
			</div>
		</div>
		<!-- <div data-options="region: 'south', split: true" style="height: 30px;"></div> -->
	</div>

</body>
</html>