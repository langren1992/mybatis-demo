var start = new Date();

$(function(){
	/**控制浏览器后退事件**/
	if (window.history && window.history.pushState) {
		$(window).on('popstate', function () {
			window.history.pushState('forward', null, '#');
			window.history.forward(1);
		});
	}
	window.history.forward(1);
	
	/**重新刷新**/
	window.onbeforeunload = function () { return "您确定退出本页面吗？"; };
	
	$("#menuTreeNav").addClass("treeClass");
	
	
	$("#menuTreeNav").tree({
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
	$("#menuContent").tabs({
		enableConextMenu: true,
		enableNewTabMenu: true
	});
	$.util.exec(function(){
		var stop = new Date();
		$.easyui.messager.show({ msg: "当前页面加载耗时(毫秒)：" + $.date.diff(start, "ms", stop), position: "bottomRight"});
	});
	
	$('#btnChangeOrg').bind('click', function(){
		btnOperate("btnChangeOrg");
	});
	$('#btnNews').bind('click', function(){
		btnOperate("btnNews");
	});
	$('#btnMaximize').bind('click', function(){
		btnOperate("btnMaximize");
	});
	$('#btnFullScreen').bind('click', function(){
		btnOperate("btnFullScreen");
	});
	$('#btnExit').bind('click', function(){
		btnOperate("btnExit");
	});
	$('#btnHideNorth').bind('click', function(){
		btnOperate("btnHideNorth");
	});
	var btnShow = $('#btnShowNorth').bind('click', function(){
		btnOperate("btnShowNorth");
	});
	/**
	 * 绑定最大化、还原的功能实现
	 * */
	var l = $("#mainLayout"), north = l.layout("panel", "north"), panel = north.panel("panel"),
            toolbar = $("#toolbar"), topbar = $("#topbar");
    opts = north.panel("options"), onCollapse = opts.onCollapse, onExpand = opts.onExpand;
    opts.onCollapse = function () {
        if ($.isFunction(onCollapse)) { onCollapse.apply(this, arguments); }
        btnShow.show();
        $('#btnMaximize').linkbutton({
        	text:"还原",
        	iconCls:"icon-metro-contract2"
        });
        toolbar.insertBefore(panel).addClass("top-toolbar-topmost");
    };
    opts.onExpand = function () {
        if ($.isFunction(onExpand)) { onExpand.apply(this, arguments); }
        btnShow.hide();
        $('#btnMaximize').linkbutton({
        	text:"最大化",
        	iconCls:"icon-metro-expand2"
        });
        toolbar.insertAfter(topbar).removeClass("top-toolbar-topmost");
    };
});
//由于前期easyui westPanel eastPanel 收缩中间的centerPanel样式不能完成展开，可以用页面重定向来解决（重定向到用户原有界面）
function updateHash(index){
	var opts = $("#menuContent").tabs("getTab", index).panel("options");
	//window.location.hash 用户重定向路径
	window.location.hash = opts.href ? opts.href : "";
}
function openContent(node){
	$("#mainLayout").layout("toggleAll", "collapse");
	if($("#menuContent").tabs("exists",node.text)){
		$('#menuContent').tabs('select', node.text);
	}else{
		$("#menuContent").tabs("insert", {
			title: node.text,
			href: node.resUrl,
			closable: true,
			iniframe:true
		});
	}
}
function btnOperate(value){
	if(value == "btnChangeOrg"){
		
	}else if(value == "btnNews"){
		
	}else if(value == "btnMaximize"){
		/**
		 * 最大化
		 * */
		$("#mainLayout").layout("toggleAll", "collapse");
	}else if(value == "btnFullScreen"){
		/**
		 * 全屏
		 * */
		//支持全屏的功能
		if ($.util.supportsFullScreen) {
            if ($.util.isFullScreen()) {
                $.util.cancelFullScreen();
            } else {
                $.util.requestFullScreen();
            }
        } else {
            $.easyui.messager.show("当前浏览器不支持全屏 API，请更换至最新的 Chrome/Firefox/Safari 浏览器或通过 F11 快捷键进行操作。");
        }
	}else if(value == "btnExit"){
		/**本地跳转到登陆页面**/
		location.href = "./logout";
	}else if(value == "btnHideNorth"){
		/**
		 * 隐藏北面板
		 * */
		$("#mainLayout").layout("collapse", "north");
	}else if(value == "btnShowNorth"){
		$("#mainLayout").layout("expand", "north");
	}
}



