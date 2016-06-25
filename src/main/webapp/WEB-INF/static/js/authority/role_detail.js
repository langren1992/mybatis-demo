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
	
	$("#allResWin").window({
		title:"分配资源",
		height:450,
		width:600,
		closed:true,
		closable:true,
		inline:true,
		modal:true,
		resizable:false,
		draggable:false,
		minimizable:false,
		collapsible:false,
		center:true
	});
	
	$("#allResTable").tree({
		fit:true,
        checkbox:true
    });
    $("#ownResTable").treegrid({
    	fit:true,
        idField: 'id',
        treeField: 'name',
        url: "./queryRoleRes",
        toolbar:"#tb",
        frozenColumns: [[
   			{ field: 'id', title: '资源ID',hidden:true},
   			{ field: 'name', title: '资源名称' },
   			{ field: 'code', title: '资源编码' },
   			{ field: 'parentId', title: '父资源ID',hidden:true}
   		]],
   		columns: [[
   			{ field: 'type', title: '类型',formatter:formatterType },
   			{ field: 'permission', title: '权限项'},
   			{ field: 'href', title: '路径'},
   			{ field: 'iconCls', title: '图标'},
   			{ field: 'available', title: '可用状态',formatter:formatterAvailable,hidden:true},
   			{ field: 'description', title: '描述',hidden:true},
   			{ field: 'createTime', title: '创建时间', sortable: true,formatter: formatterData,hidden:true },
   			{ field: 'createUserId', title: '创建者ID', hidden:true,hidden:true },
   			{ field: 'createUser', title: '创建者', sortable: true,hidden:true },
   			{ field: 'updateTime', title: '最近修改时间', sortable: true,formatter: formatterData,hidden:true },
   			{ field: 'updateUserId', title: "最近修改者Id", hidden:true,hidden:true },
   			{ field: 'updateUser', title: '最近修改者', sortable: true,hidden:true }
   		]],
   		loadFilter:function(data){
			data.rows = convert(data.dataList);
			data.total = data.dataList.length;
			return data;
		}
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
    $.ajax({
    	url:'./queryRole',
    	method:'post',
    	success:function(data){
    		$('#roleDetail').form('load',(data.dataList)[0]);
    		if((data.dataList)[0] != null){
    			if((data.dataList)[0].available == 1){
	    			//控件设置 不可编辑
					$("#name").attr("disabled",true);
					$("#code").attr("disabled",true);
					$("#alias").attr("disabled",true);
					$("#available").combo("disable");
					$('#btnEdit').linkbutton('disable');
    			}else{
    				//控件设置 不可编辑
					$("#name").attr("disabled",true);
					$("#code").attr("disabled",true);
					$("#alias").attr("disabled",true);
					
    			}
    		}
    		else{
    			$.ajax({
			    	url:'./genCode',
			    	method:'get',
			    	success:function(data){
			    		$("#code").val(data.data);
			    		$("#available").combo("disable");
			    		$("#available").combobox("setValue","1");
			    	}
		    	});
    		}
    	}
    });
    
    //修改
    $('#btnEdit').bind('click', function(){
		btnOperate("btnEdit");
	});
	//保存
	$('#btnSave').bind('click', function(){
		btnOperate("btnSave");
	});
	//分配资源
	$('#btnAddRes').bind('click', function(){
		btnOperate("btnAddRes");
	});
	$('#btnSaveRes').bind('click', function(){
		btnOperate("btnSaveRes");
	});
	$('#btnCancelRes').bind('click', function(){
		btnOperate("btnCancelRes");
	});
});
function btnOperate(value){
	//修改角色
	if(value == "btnEdit"){
		//控件设置 不可编辑
		$("#name").attr("disabled",false);
		$("#code").attr("disabled",false);
		$("#alias").attr("disabled",false);
		$("#available").combo("enable");
	//保存角色
	}else if(value == "btnSave"){
		//进度条
		$.messager.progress();
		var id = $("#id").val();
		if(id == ""){
			if($('#roleDetail').form('validate')){
				$('#roleDetail').form('submit', {
					url:'./addRoleRes',
				    onSubmit: function(param){
				    	var table = $("#ownResTable").treegrid("getChildren");
				    	for(var i=0;i<table.length;i++)
						{
				    		delete table[i].children;
						}
						param.roleResStr=JSON.stringify(table);
				    },
				    success:function(data){
				    	//关闭进度条
						$.messager.progress('close');
						//关闭当前tab
						parent.$('#menuContent').tabs('close', "角色明细");
						//刷新角色管理页面
						parent.$('#menuContent').tabs('refresh', "角色管理");
						if(data.success){
							//提示消息
							$.messager.alert('新增提示',"新增成功！");
						}else{
							//提示消息
							$.messager.alert('新增提示',"新增失败！","error");
						}
				    },
				    onLoadError:function(){
				    	//关闭进度条
						$.messager.progress('close');
						//提示消息
						$.messager.alert('新增提示',"问题很严重请联系管理员！","error");
				    }
				});
			}else{
				//进度条
				$.messager.progress('close');
				//提示消息
				$.messager.alert('新增提示',"新增失败！","error");
			}
		}else{
			$('#roleDetail').form('submit', {
				url:'./updateRoleRes',
			    onSubmit: function(param){
			    	var table = $("#ownResTable").treegrid("getChildren");
			    	for(var i=0;i<table.length;i++)
					{
			    		delete table[i].children;
					}
					param.code=$("#code").val();
					param.alias=$("#alias").val();
					param.name=$("#name").val();
					param.available=$("#available").combobox("getValue");
					param.roleResStr=JSON.stringify(table);
			    },
			    success:function(data){
			    	//关闭进度条
					$.messager.progress('close');
					//关闭当前tab
					parent.$('#menuContent').tabs('close', "角色明细");
					//刷新角色管理页面
					parent.$('#menuContent').tabs('refresh', "角色管理");
					if(data.success){
						//提示消息
						$.messager.alert('新增提示',"新增成功！");
					}else{
						//提示消息
						$.messager.alert('新增提示',"新增失败！","error");
					}
			    },
			    onLoadError:function(){
			    	//关闭进度条
					$.messager.progress('close');
					//提示消息
					$.messager.alert('新增提示',"问题很严重请联系管理员！","error");
			    }
			});
			
		}
	//分配权限
	}else if(value == "btnAddRes"){
		$("#allResWin").window("open");
		$("#allResTable").tree({
	        url: "./queryAllRes",
	   		loadFilter:function(data){
				return convert(data.dataList);
			},
			onLoadSuccess:function(row, data){
	   			var ownRes = $("#ownResTable").treegrid("getChildren");
	   			var res = "";
	   			if(ownRes != null){
		   			for (var i = 0; i < ownRes.length; i++) {
		   				if(ownRes[i].children == null){
			   				res = $("#allResTable").tree("find",ownRes[i].id);
			   				if(res != null){
			   					$("#allResTable").tree("check",res.target);
			   				}
		   				}
		   			}
	   			}
			}
			
	    });
	//窗口保存
	}else if(value == "btnSaveRes"){
		var ownRes = {dataList:[]};
		var i = 0;
		var nodes = $('#allResTable').tree('getChecked',['checked','indeterminate']);
		for (var index = 0; index < nodes.length; index++) {
			if(nodes[index].children != null){
				nodes[index].children = "";
			}
//			if(nodes[index].parentName == null ){
				(ownRes.dataList)[i]=nodes[index];
				i++;
//			}
		}
		$("#ownResTable").treegrid("loadData",ownRes);
		$('#allResWin').window('close');
	//窗口取消
	}else if(value == "btnCancelRes"){
		$('#allResWin').window('close');
	}

}

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

