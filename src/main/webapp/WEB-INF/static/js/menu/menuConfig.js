/**
 * Created by ZengRui on 2015/12/15.
 */
$(function(){
    $('#tt').tree({
        onDblClick:function(node){
            loadMenuDetail(node);
        }
    });
    $('#td_menuId').hide();//隐藏
    $('#td_menuParentId').hide();//隐藏
    $('#td_menuId_dlg').hide();//隐藏
    $('#td_menuParentId_dlg').hide();//隐藏
    //$("#money1").show();//显示
    //按钮功能绑定-新增
    $('#addMenu_btn').bind('click', function(){
        $('#ff_dlg').form('clear');
        $('#dlg').dialog('open').dialog('setTitle','菜单新增');

    });
    //按钮功能绑定-修改
    $('#modifyMenu_btn').bind('click', function(){
        $("#menuId_dlg").textbox("setValue",$("#menuId").textbox("getValue"));
        $("#menuName_dlg").textbox("setValue",$("#menuName").textbox("getValue"));
        $("#menuParentName_dlg").textbox("setValue",$("#menuParentName").textbox("getValue"));
        $("#menuParentId_dlg").textbox("setValue",$("#menuParentId").textbox("getValue"));
        //$('#city').combobox('setValue', ‘北京’);
        if($("#menuUrl").textbox("getValue") == "是"){
            $("#menuIsLeaf_dlg").combobox("setValue","是");
        }else{
            $("#menuIsLeaf_dlg").combobox("setValue","否");
        }
        $("#menuUrl_dlg").textbox("setValue",$("#menuUrl").textbox("getValue"));
        $("#menuIconCls_dlg").textbox("setValue",$("#menuIconCls").textbox("getValue"));
        $("#menuPermission_dlg").textbox("setValue",$("#menuPermission").textbox("getValue"));
        $("#createUser_dlg").textbox("setValue",$("#createUser").textbox("getValue"));
        $("#createDate_dlg").textbox("setValue",$("#createDate").textbox("getValue"));
        $("#updateUser_dlg").textbox("setValue",$("#updateUser").textbox("getValue"));
        $("#updateDate_dlg").textbox("setValue",$("#updateDate").textbox("getValue"));
        $('#dlg').dialog('open').dialog('setTitle','菜单修改');
    });
    //按钮功能绑定-删除
    $('#deleteMenu_btn').bind('click', function(){
        alert('deleteMenu_btn');
    });

    $('#tt_grid').datagrid({
        url:'../../dataJson/tree6_data.json',
        rownumbers : true
    });

});

function loadMenuDetail(node){
    $("#menuId").textbox("setValue",node.id);
    $("#menuName").textbox("setValue",node.text);
    $("#menuParentName").textbox("setValue",node.text);
    $("#menuParentId").textbox("setValue",node.text);
    //$('#city').combobox('setValue', ‘北京’);
    if(node.isLeaf){
        $("#menuIsLeaf").combobox("setValue","是");
    }else{
        $("#menuIsLeaf").combobox("setValue","否");
    }
    $("#menuUrl").textbox("setValue",node.url);
    $("#menuIconCls").textbox("setValue",node.text);
    $("#menuPermission").textbox("setValue",node.text);
    $("#createUser").textbox("setValue",node.text);
    $("#createDate").textbox("setValue",node.text);
    $("#updateUser").textbox("setValue",node.text);
    $("#updateDate").textbox("setValue",node.text);
}