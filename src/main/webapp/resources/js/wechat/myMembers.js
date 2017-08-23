﻿$(function() {
	/*bootstrap table*/
	$('.table.table-striped:eq(0)').bootstrapTable({
		method : 'post',
	    url:"/game/proxy/getMyMembers",//请求数据url
	    queryParams: function (params) {
	        return {
	            offset: params.offset,  //页码
	            limit: params.limit,   //页面大小
//	            order : params.order, //排序
//	            ordername : params.sort, //排序
	            startDate : $('#startDate').val(), //开始时间
	            endDate : $('#endDate').val() //结束时间
	        };
	    },
	    responseHandler : function(res){
	    	if (res.code == 0) {
	    		return res.data;
			}else{
				return [];
			}
	    	
	    },
	    showHeader : true,
//	    showColumns : true,
//	    showRefresh : true,
	    pagination: true,//分页
	    sidePagination : 'server',//服务器端分页
	    pageNumber : 1,
	    pageList: [5, 10, 20, 50],//分页步进值
	    //表格的列
	    columns : [{
			field:'createTime',
			title: '绑定时间'
        },{
			field : 'playerId',
			title : '玩家游戏ID'
		}, {
			field : 'nickName',
			title : '玩家昵称'
		}]
	});
	
	// 查询按钮点击事件,refresh方法存在bug，无法从第一页开始
	$('#searchBtn').click(function() {
		var res = $('#myMembersListTable').bootstrapTable('getData').length;
		if (res > 0) {
			$('#myMembersListTable').bootstrapTable('selectPage', 1);
		} else {
			$('#myMembersListTable').bootstrapTable('refresh');
		}
	});
	
	/*清空按钮事件*/
	$('#resetBtn').click(function(){
		$('#startDate').val('');
		$('#endDate').val('');
	});
	
	$("#startDate").datetimepicker({
        format: 'yyyy-mm-dd',
        minView:'month',
        language: 'zh-CN',
        autoclose:true
//        startDate:new Date()
    }).on("click",function(){
        $("#startDate").datetimepicker("setEndDate",$("#endDate").val());
    });
    $("#endDate").datetimepicker({
        format: 'yyyy-mm-dd',
        minView:'month',
        language: 'zh-CN',
        autoclose:true
//        startDate:new Date()
    }).on("click",function(){
        $("#endDate").datetimepicker("setStartDate",$("#startDate").val());
    });

	
});

