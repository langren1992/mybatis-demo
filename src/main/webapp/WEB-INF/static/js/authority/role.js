//将表单数据转为json
function form2Json(id) {
    var arr = $("#" + id).serializeArray()
    var jsonStr = "";
    jsonStr += '{';
    for (var i = 0; i < arr.length; i++) {
        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
    }
    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
    jsonStr += '}'
    var json = JSON.parse(jsonStr)
    return json
}

$(function(){
	
	$("#available_condi").combobox({
        //自适应数据高度属性
        panelHeight:"auto",
        //值
        valueField:'value',
        //名称
        textField: 'textName',
        data: [{
            textName: '可用',
            value: "1"
        },{
            textName: '停用',
            value: "0"
        }]
    });
	
	$("#roleList").datagrid({
		fit:true,
		method: "get",
		url: "./role/queryRoleByCon",
		idField: 'ID',
		rownumbers: true,
		pagination: true,
		enableRowContextMenu: true,         //此属性开启表头列名称右键点击菜单
		pagingMenu: { submenu: false},//开启行右键菜单的翻页功能，此属性可丰富配置，详情见 API 文档
		exportMenu:{submenu: false},
		toolbar:'#roleListTool',
		singleSelect:true,
		sortName:"createTime",
		sortOrder:"DESC",
		method:"POST",
		queryParams:{
			"condition":form2Json("role_condi"),
			"orderby":"createTime desc"
		},
		frozenColumns: [[
			{ field: 'ck', checkbox: true },
			{ field: 'ID', title: '角色ID',hidden:true },
			{ field: 'alias', title: '名称', sortable: true },
			{ field: 'name', title: '角色', sortable: true },
			{ field: 'code', title: '角色编码', sortable: true }
		]],
		columns: [[
			{ field: 'available', title: '可用状态', sortable: true,formatter:formatterAvailable },
			{ field: 'ownDeptName', title: '所属部门'},
			{ field: 'ownDeptId', title: '所属部门ID'},
			{ field: 'createUser', title: '创建人'},
			{ field: 'createUser', title: '创建人'},
			{ field: 'createUserId', title: '创建人ID'},
			{ field: 'createTime', title: '创建时间',formatter: formatterData },
			{ field: 'updateUser', title: '最近修改人'},
			{ field: 'updateUserId', title: '最近修改人ID'},
			{ field: 'updateTime', title: '最近修改时间',formatter: formatterData }
		]],
		pageSize:40,
		pageList:[40,80,120],
		loadFilter:function(data){
//			data.rows = data.dataList;
//			data.total = data.dataList.length;
			return data.data;
		},
		onDblClickRow:function(rowIndex, rowData){
			if(parent.$("#menuContent").tabs("exists","角色明细")){
				parent.$('#menuContent').tabs('select', "角色明细");
			}else{
				parent.$("#menuContent").tabs("insert", {
						title: "角色明细",
						href: "./role/roleDetail?id="+rowData.id,
						closable: true,
						iniframe:true
				});
			}
		},
		enableHeaderClickMenu: false,        //此属性开启表头列名称右侧那个箭头形状的鼠标左键点击菜单
		enableHeaderContextMenu: true     //此属性开启表头列名称右键点击菜单
	});	
	$('#btnReset').bind('click', function(){
		btnOperate("btnReset");
	});
	$('#btnSearch').bind('click', function(){
		btnOperate("btnSearch");
	});
	$('#btnAddRole').bind('click', function(){
		btnOperate("btnAddRole");
	});
	
	
});

function formatterType(value){
	if(value == "button"){
		return "按钮";
	}else if(value == "menu"){
		return "目录";
	}
}

function formatterAvailable(value){
	if(value == true){
		return "可用";
	}else{
		return "停用";
	}
}

function formatterData(value){
	return (new Date(value)).pattern("M/d/yyyy");
}



function btnOperate(value){
	if(value == "btnAddRole"){
		//window.parent.frames.location.href="./role/roleDetail";
		if(parent.$("#menuContent").tabs("exists","角色明细")){
			parent.$('#menuContent').tabs('select', "角色明细");
		}else{
			parent.$("#menuContent").tabs("insert", {
				title: "角色明细",
				href: "./role/roleDetail",
				closable: true,
				iniframe:true
				
			});
		}
	}else if(value =="btnReset"){
		$("#role_condi").form("reset");
	}else if(value =="btnSearch"){
		$("#roleList").datagrid("load",{
			"condition":form2Json("role_condi"),
			"orderby":"createTime desc"
		});
	}

}