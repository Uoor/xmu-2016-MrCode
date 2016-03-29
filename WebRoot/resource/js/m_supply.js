$(document).ready(function(){
    /*日期输入*/
	 var dt=new Date();
	    $(".input-date-sp").datepicker({

	        language: 'zh-CN',
	        format: 'yyyy-mm-dd',
	        startDate: dt,  //开始时间，在这时间之前都不可选
	        endDate: '+6d',  //开始时间，在这时间之前都不可选
	        autoclose: true,        //点击后消失
	        todayBtn: 'linked',
	        showButtonPanel: true
	    });
});