<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>用户登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/theme/metro-standard/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/theme/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
    <style>
        body{ text-align:center}
        .panel{ margin:0 auto}
    </style>
    <script type="text/javascript">
        document.onkeydown = function(e){
            var event = e || window.event;
            var code = event.keyCode || event.which || event.charCode;
            if (code == 13) {
                login();
            }
        }
        $(function(){
            $("input[name='login']").focus();
        });
        function cleardata(){
            $('#loginForm').form('clear');
        }
        function login(){
            if($("input[name='login']").val()=="" || $("input[name='password']").val()==""){
                $("#showMsg").html("用户名或密码为空，请输入");
                $("input[name='login']").focus();
            }else{
            	$('#loginForm').submit();
            }
        }
    </script>
</head>
<body style="background-color:#76D17F;text-align:center;padding-top: 100px;background-image: url('${pageContext.request.contextPath}/static/easyui/logo/easyui-zhuzi.png');-moz-background-size:cover;-webkit-background-size: cover;-o-background-size: cover;background-size: cover;"  >
    <div id="p" class="easyui-panel"
         style="width:434px;height:270px;background:#fafafa;margin:0 auto;">
        <div class="easyui-layout" fit="true">
            <div region="north" border="false" id = "title" style="text-align:center;height:128px;">
                <img src="${pageContext.request.contextPath}/static/logo/easyui-logo.png">
                <div id = "showMsg" style="padding:5px 0;text-align: center;color: blue;height:15px;">${error}</div>
            </div>
            <div region="center" border="false" style="text-align:center;border-bottom:1px solid #ccc;border-top:1px solid #ccc;">
                <form id="loginForm" method="post">
                    <div style="padding:5px 0;">
                        <label for="login"style="font-family: '微软雅黑';font-size: 12pt;font-weight: 900">用 户 名 :</label>
                        <input type="text" name="username" value="<shiro:principal/>" style="width:200px;"/>
                        <a iconCls="icon-redo" href="javascript:void(0)" style="font-family: '微软雅黑';font-weight: 900">注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册</a>
                    </div>
                    <div style="padding:5px 0;">
                        <label for="password" style="font-family: '微软雅黑';font-size: 12pt;font-weight: 900">&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 :</label>
                        <input type="password" name="password" style="width:200px;"/>
                        <a iconCls="icon-help" href="javascript:void(0)"  style="font-family: '微软雅黑';font-weight: 900">修改密码</a>
                    </div>
                    <div style="padding:5px 0;" style="height:29px;line-height:29px;">
                        <input type="checkbox" name="rememberMe" value="true"/>
                        <label for="rememberMe" style="font-family: '微软雅黑';font-size: 11pt;font-weight: 900">记住密码</label>
                        <input type="checkbox" name="autoLoad" style="margin-left: 35px;"/>
                        <label for="autoLogin" style="font-family: '微软雅黑';font-size: 11pt;font-weight: 900">自动登陆</label>
                    </div>
                </form>
            </div>
            <div region="south" border="false" style="text-align:center;padding:5px 0;">
                <a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="login()" style="font-family: '微软雅黑';font-weight: 900"> 登 录 </a>
                <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="cleardata()" style="margin-left: 130px;font-family: '微软雅黑';font-weight: 900;"> 重 置 </a>
            </div>
        </div>
    </div>
</body>

<%-- <head>
    <title>登录</title>
    <% %>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
    密码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form>

</body> --%>
</html>