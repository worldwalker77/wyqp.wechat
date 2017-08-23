//页面表格对象
var withDrawalRecordListTable = $('#withDrawalRecordListTable');
// 加载表格数据
$(function() {
	withDrawalRecordListUtil.init();
});

var default_table_settings = {
//		striped : true,
	pagination : true,
	sidePagination : 'server',
	pageSize : 20,
	pageList : [10,20,100,200],
	method : 'post',
	clickToSelect : false,
	checkboxHeader : true,
	maintainSelected : true,
	searchOnEnterKey : true,
	undefinedText:'\\',
	showLoading:true,
	queryParamsType : '',
};

//域账号管理

var withDrawalRecordListUtil = {
		/**
		 * 初始化
		 */
		init : function(){
			/*域账号列表初始化*/
			withDrawalRecordListUtil.loadTable();

			// 查询按钮点击事件,refresh方法存在bug，无法从第一页开始
			$('#searchBtn').click(function() {
				withDrawalRecordListUtil.search();
			});
			
			/*清空按钮事件*/
			$('#resetBtn').click(function(){
				$('#addedTimeFrom').val($("#addedTimeFromh").val());
				$('#addedTimeTo').val($("#addedTimeToh").val());
			});
			
		},
			
		// 查询
		search : function() {
			var res = withDrawalRecordListTable.bootstrapTable('getData').length;
			if (res > 0) {
				withDrawalRecordListUtil.selectPage();
			} else {
				withDrawalRecordListUtil.refresh();
			}
		},
		// 查询起始页归1
		selectPage : function() {
			withDrawalRecordListTable.bootstrapTable('selectPage', 1);
		},
		// 刷新表格数据
		refresh : function() {
			withDrawalRecordListTable.bootstrapTable('refresh');
		},
		
		// 加载表格
		loadTable : function() {
			withDrawalRecordListTable.bootstrapTable(
					$.extend({}, default_table_settings,
					{
					method : 'post',
					url :'/game/proxy/getWithDrawalRecord',
					idField : 'id',
					height : 500,
					queryParams : withDrawalRecordListUtil.queryParams,
					responseHandler : withDrawalRecordListUtil.responseHandler,
					onLoadSuccess : withDrawalRecordListUtil.onLoadSuccess,
					columns : [  {
						field : 'rowNum',
						title : '序号'
						
					},{
						field:'createTime',
						title: '提现时间'
		            },{
						field : 'beforeWithdrawalAmount',
						title : '提现前金额'
					}, {
						field : 'withdrawalAmount',
						title : '提现金额'
					}]
				}));
			
		},
		
		
		// 查询请求参数
		queryParams : function(params) {
	
			var queryModel = {
		            startTime: $.trim($("#startTime").val()),
		            endTime: $.trim($("#endTime").val())
			};
			if(params){
				queryModel.rows = params.pageSize;
				queryModel.page = params.pageNumber;
			}
			return queryModel;
		},
		
		responseHandler:function(res){
			  if(res.code==0){
				 var data = res.result;
			     return data;
			  }else{
				layer.msg(res.message, {time: 0,btn: ['确定'],title: "提示",icon: 2,yes: function(index){
				    layer.close(index);
				  }
				});
			    return [];
			  }
		  },
		  
		  onLoadSuccess:function(){
		  }
		
		
}