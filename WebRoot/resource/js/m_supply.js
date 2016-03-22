$(document).ready(function(){
    /*日期输入*/
    $(".input-date-sp").datepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        startDate: new Date(),  //开始时间，在这时间之前都不可选
        autoclose: true,        //点击后消失
        todayBtn: 'linked'
    });
});