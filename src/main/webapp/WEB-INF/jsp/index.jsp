<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>主页第二版</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/themes/icon.css">
	<link href="${pageContext.request.contextPath}/static/icons/icon-all.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>

	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jquery.jdirk.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.menu.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.tabs.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/jeasyui-extensions/jeasyui.extensions.panel.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/common.js" type="text/javascript"></script>

	<style type="text/css">
		.msg {
			font-weight:bold; font-family:微软雅黑; font-size:22pt; color:red;
		}
		.tabs-tool table { border-width: 0; border-collapse: collapse; border-spacing: 0; }
		.tabs-tool table td { padding: 0; }
	</style>

	<script type="text/javascript">
		(function ($, undefined) {

			Date.prototype.Format = function(fmt){
				var o = {
					"M+" : this.getMonth()+1,                 //月份
					"d+" : this.getDate(),                    //日
					"h+" : this.getHours(),                   //小时
					"m+" : this.getMinutes(),                 //分
					"s+" : this.getSeconds(),                 //秒
					"q+" : Math.floor((this.getMonth()+3)/3), //季度
					"S"  : this.getMilliseconds()             //毫秒
				};
				if(/(y+)/.test(fmt))
					fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
				for(var k in o)
					if(new RegExp("("+ k +")").test(fmt))
						fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
				return fmt;
			};

			var UserInfo = function(target, opt){
				this.target = target;

				this.defaults = {
					userNo :"000000",
					userName:"admin",
					userDept:"信息技术中心",
					userCompany:"中骅国际物流有限公司",
					userMsgNum :"0"
				};

				this.options = $.extend({}, this.defaults, opt);

			};
			UserInfo.prototype = {
				addInfo : function(){
					var userBtn = $("<a>").linkbutton({
						text:this.options.userName,
						iconCls:'icon-berlin-customers'
					});
					var userNoBtn = $("<a>").linkbutton({
						text:this.options.userNo,
						iconCls:'icon-berlin-customers'
					});
					var userDeptBtn = $("<a>").linkbutton({
						text:this.options.userDept,
						iconCls:'icon-berlin-customers'
					});
					var userCompanyBtn = $("<a>").linkbutton({
						text:this.options.userCompany,
						iconCls:'icon-berlin-bank'
					});
					var msgBtn = $("<a>").linkbutton({
						id:"btn_msg",
						text:this.options.userMsgNum,
						iconCls:'icon-hamburg-contact'
					});
					var fullSreenBtn = $("<a>").linkbutton({
						iconCls: 'icon-standard-arrow-inout',
						text: '全屏'
					});
					var exitBtn = $('<a>').linkbutton({
						iconCls: 'icon-hamburg-sign-out',
						text: '退出'
					});
					return this.target.append("<span id='showTimer'>"+(new Date()).Format("yyyy-MM-dd hh:mm:ss")+"</span>").append("&nbsp;")
							.append("欢迎：").append(userBtn).append("&nbsp;")
							.append("工号：").append(userNoBtn).append("&nbsp;")
							.append("部门：").append(userDeptBtn).append("&nbsp;")
							.append("所属组织：").append(userCompanyBtn).append("&nbsp;")
							.append(msgBtn).append("&nbsp;")
							.append(fullSreenBtn).append("&nbsp;")
							.append(exitBtn).append("&nbsp;");
				}
			};


			updateCurrentTab = function(index){
				var mainTabs = $("#mainTabs");
				var currenTab = mainTabs.tabs("getTab", index);
				var opts = mainTabs.tabs("getTab", index).panel("options");
				currenTab.panel('refresh');
				window.location.hash = opts.href ? opts.href : "";
			};

			$.fn.TabTools = function(){
				return this.append("<a href=\"javascript:void(0)\" class=\"icon-mini-refresh\" onclick=\"updatTab(this)\"></a>");
			};

			//在插件中使用Beautifier对象
			$.fn.addInfo = function(options) {
				//创建Beautifier的实体
				var userInfo = new UserInfo(this, options);
				//调用其方法
				return userInfo.addInfo();
			};

			showMsgNum = function(){
				var num = 1;
				setInterval(function(){
					$("#btn_msg").linkbutton({text:num++});
				}, 1000);
			};


			function showTimer(){
				setInterval(function(){
					$("#showTimer").text(new Date().Format("yyyy-MM-dd hh:mm:ss"));
				},1000);
			};

			function initComponent(){
				$("#tree_menu").tree({
					animate: true,
					lines: false,
					toggleOnClick: true,
					selectOnContextMenu: true,
					showOption: true,
					method: "get",
					url: "./menu",
					enableContextMenu: true,
					onClick:function(node){
						if(node.isLeaf){
							openContent(node);
						}
					},
					loadFilter:function(rows){
						 return convert(rows.data);
					}
				});
			};

			function openContent(node){
				var mainTabs = $("#mainTabs");
				if(mainTabs.tabs("exists",node.text)){
					mainTabs.tabs('select', node.text);
				}else{
					mainTabs.tabs("insert", {
						title: node.text,
						href: node.resUrl,
						iniframe:true,
						closable: true
					});
				}
			};

			$(function(){
				$("#user").addInfo({
					userName:"曾睿",
					userNo:"000003",
					userDept:"研发部",
					userCompany:"中骅国际物流有限公司",
					userMsgNum :"100"
				});
				showMsgNum();
				showTimer();
				initComponent();
			});


		})(jQuery);

	</script>
</head>
<body id="index_layout" class="easyui-layout">
	<div region="north" fit="false" split="false" style="height: 46px;padding-top: 5px;">
		<div id="header-before" style="float: left;padding-left: 40px;"><img src="#" style="height: 26px"></div>
		<div id="header-after" style="float: right;;width: 70%">
			<div id="loginInfo">
				<div id="user" style="float: right;padding-right: 5px;line-height: 26px"></div>
			</div>
		</div>
	</div>
	<div data-options="region: 'west', title: '菜单导航栏', iconCls: 'icon-standard-map', split: true" title="West" style="width:256px;">
		<ul id="tree_menu"></ul>
	</div>
	<div data-options="region:'center',split: true" style="padding: 1px;">
		<div id="mainTabs_tools" class="tabs-tool" style="line-height: 30px;">
			<table>
				<tr >
					<td><a id="mainTabs_jumpHome" class="easyui-linkbutton easyui-tooltip" title="跳转至主页选项卡" data-options="plain: true, iconCls: 'icon-hamburg-home'"></a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td><a id="mainTabs_closeAll" class="easyui-linkbutton easyui-tooltip" title="关闭所有选项卡" data-options="plain: true, iconCls: 'icon-standard-cross'"></a></td>
				</tr>
			</table>
		</div>
		<div id="mainTabs" class="easyui-tabs" data-options="fit: true, border: false, showOption: true, enableNewTabMenu: true, tools: '#mainTabs_tools', enableJumpTabMenu: true, onSelect: function (title, index) { updateCurrentTab(index) }">
			<div data-options="title: '首页', href: './main', refreshable: true,iniframe:true"></div>
		</div>
	</div>
</body>
</html>