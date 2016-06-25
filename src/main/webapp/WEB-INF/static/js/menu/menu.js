/**
 * Created by gaoyi on 2015/12/4.
 */

function doSearch(value){
    alert('You input: ' + value);
}


$(function(){
    $('#tt').tree({
        onDblClick:function(node){
//            if(node.isLeaf){
                Open(node.text,node.url);
//            }
        }
    });
    //在tabs上可以右键
    $(".tabs-header").bind('contextmenu',function(e){
        e.preventDefault();
        $('#rcmenu').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
    });

    //关闭当前标签页
    $("#closecur").bind("click",function(){
        var tab = $('#tabs').tabs('getSelected');
        var index = $('#tabs').tabs('getTabIndex',tab);
        if(index!=0){
            $('#tabs').tabs('close',index);
        }

    });
    //关闭所有标签页
    $("#closeall").bind("click",function(){
        var tablist = $('#tabs').tabs('tabs');
        for(var i=tablist.length-1;i>=0;i--){
            if(i!=0){
                $('#tabs').tabs('close',i);
            }
        }
    });
    //关闭非当前标签页（先关闭右侧，再关闭左侧）
    $("#closeother").bind("click",function(){
        var tablist = $('#tabs').tabs('tabs');
        var tab = $('#tabs').tabs('getSelected');
        var index = $('#tabs').tabs('getTabIndex',tab);
        for(var i=tablist.length-1;i>index;i--){
            if(i!=0){
                $('#tabs').tabs('close',i);
            }
        }
        var num = index-1;
        for(var i=num;i>0;i--){
            if(i!=0){
                $('#tabs').tabs('close',1);
            }
        }
    });
    //关闭当前标签页右侧标签页
    $("#closeright").bind("click",function(){
        var tablist = $('#tabs').tabs('tabs');
        var tab = $('#tabs').tabs('getSelected');
        var index = $('#tabs').tabs('getTabIndex',tab);
        for(var i=tablist.length-1;i>index;i--){
            if(i!=0){
                $('#tabs').tabs('close',i);
            }
        }
    });
    //关闭当前标签页左侧标签页
    $("#closeleft").bind("click",function(){
        var tab = $('#tabs').tabs('getSelected');
        var index = $('#tabs').tabs('getTabIndex',tab);
        var num = index-1;
        for(var i=0;i<num;i++){
            if(i!=0){
                $('#tabs').tabs('close',i);
            }
        }
    });

});
//在右边center区域打开菜单，新增tab
function Open(text, url) {
    if ($("#tabs").tabs('exists', text)) {
        $('#tabs').tabs('select', text);
    } else {
        $('#tabs').tabs('add', {
            title : text,
            closable : true,
            content : '<iframe frameborder="0"  src="./'+url+'" style="width:100%;height:99%;"></iframe>'
        });
    }
}
