var flight = new Array();
var ticket="";
var orderids=new Array();
	function doSearch(value) {
		$('#printForm').form(
				'submit',
				{
					type : "GET",
					async : false,
					url : "../REST/REST/Service/printTicket/" + value,
					onSubmit : function() {
						if (!isNaN(value) && !value.length == 0) {
							return true;
						} else {
							$("#searchcontent").focus();
							return false;
						}
						return $("#printForm").form('validate');
					},
					success : function(data) {
						var obj = eval(data);
						for (var i = 0; i < obj.length; i++) {
							flight[i] = obj[i].flight;
							orderids[i]=obj[i].orderid;
							ticket+= ""+obj[i].orderid +"*"+ obj[i].name + "*" + obj[i].idcard
									+ "*" + obj[i].flight + "*"
									+ obj[i].startPoint + "*" + obj[i].endPoint
									+ "*" + obj[i].startTime + "*"
									+ obj[i].endTime + "*" + obj[i].ticketTime
									+ "*" + obj[i].seat + "*" + obj[i].space+"*"+obj[i].teamName+"*"+obj[i].agencyName;
						}
						$("#searchDiv").css("display", "none");
						$('#dg').datagrid({
							async : false,
							data : eval(data),
							columns : [ [ {
								field : 'orderid',
								title : '订单号',
								width : 70,
								align : 'center'
							},{
								field : 'name',
								title : '姓名',
								width : 81,
								align : 'center'
							}, {
								field : 'idcard',
								title : '身份证号',
								width : 160,
								align : 'center'
							}, {
								field : 'flight',
								title : '航班号',
								width : 70,
								align : 'center'
							}, {
								field : 'startPoint',
								title : '出发地',
								width : 70,
								align : 'center'
							}, {
								field : 'endPoint',
								title : '目的地',
								width : 70,
								align : 'center'
							}, {
								field : 'startTime',
								title : '出起飞时间',
								width : 160,
								align : 'center'
							}, {
								field : 'endTime',
								title : '抵达时间',
								width : 160,
								align : 'center'
							}, {
								field : 'ticketTime',
								title : '取票时间',
								width : 160,
								align : 'center'
							}, {
								field : 'seat',
								title : '座位号',
								width : 70,
								align : 'center'
							}, {
								field : 'space',
								title : '仓号',
								width : 70,
								align : 'center'
							},{
								field : 'teamName',
								title : '团队名字',
								width : 70,
								align : 'center'
							},{
								field : 'agencyName',
								title : '旅行社',
								width : 70,
								align : 'center'
							} ] ]
						});
						$("#printBt").css("display", "inline");
					}
				});
	}

	function printBut() {
		var rows = $('#dg').datagrid('getSelections');
		if (rows.length == 0) {
			$.messager.alert("提示", "请选择要打印的预订单!");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			$.ajax({
				type : "GET",
				async : false,
				url : "../REST/REST/Service/reviseTicketStatus/" + orderids[i],
				success : function(data) {
					/*alert(ticket);*/
					window.parent.location = encodeURI("../html/printTable.html?ticket="+ticket);
				}
			});
		}

		/* $.messager.progress({
			title : "正在打印，请稍后...",
			interval : 500
		});
		setTimeout(function() {
			$.messager.progress('close');
			window.location.reload();
		}, 5000); */
	}