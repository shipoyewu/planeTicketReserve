
$(function(){
    //获得旅行社的基本信息，写入form表单中
    var uid = document.cookie.split('=')[1];
    //alert(uid+"angencyinfo");
    $.ajax({
        url:'../REST/REST/Service/getAgencyInfoByAgencyid/'+uid,
        success:function(data){
            //alert(data);
            $('#agencyid').textbox('setValue',uid);
            $('#agencyname').textbox('setValue',data.name);
            $('#pwd').textbox('setValue',data.pwd);
            document.getElementById("content").value = data.contacts;
            $('#tel').textbox('setValue',data.phone);
            $('#address').textbox('setValue',data.address);
        }
    });

});


function submit(){
   
   alert("修改成功");
    $('#fpkg').form('submit', {           
        url:'../REST/REST/Service/updateAgencyInfo/',
        onSubmit: function(){
            var isValid = $(this).form('validate');
            return isValid; // 返回false终止表单提交
            },
        success: function(data){
                //$.messager.progress('close');   // 如果提交成功则隐藏进度条
                //alert("修改成功！");
                alert(data);
            }
        });
}

function reset(){
    //获得旅行社的基本信息，写入form表单中
    var uid = document.cookie.split('=')[1];
     $.ajax({
        url:'../REST/REST/Service/getAgencyInfoByAgencyid/'+uid,
        success:function(data){
            //alert(data);
            $('#agencyid').textbox('setValue',data.id.toString());
            $('#agencyname').textbox('setValue',data.name);
            $('#pwd').textbox('setValue',data.pwd);
            document.getElementById("content").value = data.contacts;
            $('#tel').textbox('setValue',data.phone);
            $('#address').textbox('setValue',data.address);
        }
    });

}