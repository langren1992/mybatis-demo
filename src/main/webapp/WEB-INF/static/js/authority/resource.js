
$(function(){
	$("#menuRes").tree({
		url: "./resource/queryResByCon",
		loadFilter:function(rows){
			return convert(rows.dataList);
		},
		onDblClick:function(data){
			setFormEnable();
		},
		onClick:function(data){
			data.name = data.text;
			$("#resDetail").form("load",data);
			setFormDisable();
			$("#buttonDataGird").datagrid({
				url:"./resource/queryResByCon",
				queryParams:{
					"id" :data.id
				},
				loadFilter:function(data){
					data.rows = data.dataList;
					data.total = data.dataList.length;
					return data;
				}
			});
		}
	});
	$("#menuRes").addClass("treeClass");
	$("#buttonDataGird").datagrid({
		fit:true,
		method: "get",
		idField: 'id',
		rownumbers: true,
		pagination: true,
		singleSelect:true,
		enableRowContextMenu: true,         //此属性开启表头列名称右键点击菜单
		pagingMenu: { submenu: false},//开启行右键菜单的翻页功能，此属性可丰富配置，详情见 API 文档
		exportMenu:{submenu: false},
		toolbar:'#tb',
		frozenColumns: [[
			{ field: 'ck', checkbox: true },	
			{ field: 'id', title: '资源ID',hidden:true},
			{ field: 'parentId', title: '父资源ID',hidden:true}
		]],
		columns: [[
			{ field: 'name', title: '资源名称', sortable: true },
			{ field: 'code', title: '资源编码', sortable: true },
			{ field: 'parentName', title: '父资源编码', sortable: true },
			{ field: 'type', title: '类型', sortable: true,formatter:formatterType },
			{ field: 'permission', title: '权限项', sortable: true },
			{ field: 'href', title: '路径', sortable: true },
			{ field: 'iconCls', title: '图标', sortable: true },
			{ field: 'available', title: '可用状态', sortable: true,formatter:formatterAvailable},
			{ field: 'description', title: '描述', sortable: true },
			{ field: 'createTime', title: '创建时间', sortable: true,formatter: formatterData },
			{ field: 'createUserId', title: '创建者ID', hidden:true },
			{ field: 'createUser', title: '创建者', sortable: true },
			{ field: 'updateTime', title: '最近修改时间', sortable: true,formatter: formatterData },
			{ field: 'updateUserId', title: "最近修改者Id", hidden:true },
			{ field: 'updateUser', title: '最近修改者', sortable: true }
		]],
		onClickRow:function(rowIndex, rowData){
			rowData.text = rowData.name;
			$("#resDetail").form("load",rowData);
			setFormDisable();
		},
		onDblClickRow:function(rowIndex, rowData){
			rowData.text = rowData.name;
			$("#resDetail").form("load",rowData);
			setFormEnable();
		},
		enableHeaderClickMenu: false,        //此属性开启表头列名称右侧那个箭头形状的鼠标左键点击菜单
		enableHeaderContextMenu: true     //此属性开启表头列名称右键点击菜单
	});
	$("#type").combobox({
        //自适应数据高度属性
        panelHeight:"auto",
        //值
        valueField:'value',
        //名称
        textField: 'textName',
        data: [{
            textName: '目录',
            value: 'menu'
        },{
            textName: '按钮',
            value: 'button'
        }]
    });
	$("#available").combobox({
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
    //控件初始化
    $("#createUser").attr("disabled",true);
	$("#createTime").combo("disable");
	$("#updateUser").attr("disabled",true);
	$("#updateTime").combo("disable");
    
				
	$('#add').bind('click', function(){
		btnOperate("add");
	});
	$('#save').bind('click', function(){
		btnOperate("save");
	});
	$('#cancel').bind('click', function(){
		btnOperate("cancel");
	});
	$('#start').bind('click', function(){
		btnOperate("start");
	});
	$('#end').bind('click', function(){
		btnOperate("end");
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

function setFormDisable(){
	//控件设置 不可编辑
	$("#name").attr("disabled",true);
	$("#code").attr("disabled",true);
	$("#parentName").attr("disabled",true);
	$("#type").combo("disable");
	$("#permission").attr("disabled",true);
	$("#available").combo("disable");
	$("#iconCls").attr("disabled",true);
	$("#href").attr("disabled",true);
	$("#description").attr("disabled",true);
	
}

function setFormEnable(){
	//控件设置
	$("#name").attr("disabled",false);
	$("#code").attr("disabled",false);
	$("#permission").attr("disabled",false);
	$("#available").combo("enable");
	$("#iconCls").attr("disabled",false);
	$("#href").attr("disabled",false);
	$("#description").attr("disabled",false);
}



function btnOperate(value){
	if(value == "add"){
		$("#resDetail").form("clear");
		setFormEnable();
		var node = $("#menuRes").tree("getSelected");
		if(node != null){
			if(node.id != null){
				$("#parentId").val(node.id);
				$("#parentName").attr("disabled",true);
				$("#type").combo("enable");
				$("#parentName").val(node.text);
				$("#createUserId").val(node.createUserId);
				$("#createUser").val(node.createUser);
				$("#createTime").datebox("setValue",new Date(node.createTime));
				$("#updateUserId").val(node.updateUserId);
				$("#updateUser").val(node.updateUser);
				$("#updateTime").datebox("setValue",new Date(node.updateTime));
			}
		}
	}else if(value == "save"){
		//进度条
		$.messager.progress();
		var id = $("#id").val();
		var parentId = $("#parentId").val();
		var isValiName = $("#name").validatebox("isValid");
		if(isValiName){
			if(id == ""){
				//新增处理
				if(parentId == ""){
					var type = $("#type").combobox("getValue");
					if(type == "button"){
						$.messager.alert('新增提示',"按钮资源必须有父级！","error");
						$.messager.progress('close');
						$("#resDetail").form("clear");
						return;
					}
					$.messager.confirm("新增提醒", "确认新增无父级资源！", function (flag) {
						if(flag){
							$("#resDetail").form("submit",{
								url:"./resource/addResource",
								success:function(data){
									//关闭进度条
									$.messager.progress('close');
									//重置form
									$("#resDetail").form("clear");
									//重新加载树
									$("#menuRes").tree("reload");
									//表格重新加载
									$("#buttonDataGird").datagrid("reload");
									//提示消息
									$.messager.alert('新增提示',"新增成功！");
								},
								onSubmit:function(){
									$.messager.progress('close');
								}
							});
						}
					});
				}else{
					
					$("#resDetail").form("submit",{
						url:"./resource/addResource",
						success:function(data){
							//关闭进度条
							$.messager.progress('close');
							//重置form
							$("#resDetail").form("clear");
							//重新加载树
							$("#menuRes").tree("reload");
							//表格重新加载
							$("#buttonDataGird").datagrid("reload");
							//提示消息
							$.messager.alert('新增提示',"新增成功！");
						},
						onSubmit:function(){
							$.messager.progress('close');
						}
					});
				}
				
			}else{
				$("#resDetail").form("submit",{
					url:"./resource/updateResource",
					success:function(data){
						//关闭进度条
						$.messager.progress('close');
						//重置form
						$("#resDetail").form("clear");
						//重新加载树
						$("#menuRes").tree("reload");
						//表格重新加载
						$("#buttonDataGird").datagrid("reload");
						//提示消息
						$.messager.alert('修改提示',"修改成功！");
					},
					onSubmit:function(){
						$.messager.progress('close');
					}
				});
			}
		}else{
			$.messager.alert('新增提示',"请填好数据！！","error");
			$.messager.progress('close');
		}
	}else if(value == "cancel"){
		
	}else if(value == "start"){
		
	}else if(value == "end"){
		
	}
}