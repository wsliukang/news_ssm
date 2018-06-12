var bver,role="5",base="./";
var pageN=1,pageTotal=100;

$(document).ready(function () {
    $('#login_form input').keydown(function (e) {
        if (e.keyCode == 13)
        {
            checkUserName();//$('#login_submit').click();
        }
    }); 
    $("#login_submit").click(checkUserName); 
   /* bver=(CKobject.Platform()+' '+CKobject.browser()['B']+' v'+CKobject.browser()['V']);
    if(bver.indexOf("IE v7.0")>0) $("#bver").html("您现在使用的浏览器是IE v7.0内核，版本太低，建议切换到极速模式或更换浏览器。");
    else $("#bver").html("");*/

});
function checkUserName()//登录前，校验用户信息
{    
      var a=$('#uid').val();
      var b=$('#pwd').val();
      if(a==""){$.messager.alert('系统提示',"请输入用户名",'warning');return;      }
      var re=/^\d{4}$|^\d{8}$|^\d{11}$/;
      if(!re.test(a)){$.messager.alert('系统提示',"用户名格式错误",'warning');return;     }
      if(b==""||b==undefined){$.messager.alert('系统提示',"请输入登录密码",'warning');return;}

      $.ajax({
            url : "./doLogin",
            data :{"uid":a,"pwd":b},
            type:"POST",
            success : function (res) {
              if (res.ok) {
                    window.location.href=base+res.msg;
              }else {             
                  $.messager.alert('系统提示',res.msg,'error');
              }
              return false;
            },
            error : function(res) {$.messager.alert('系统提示','系统错误!','error');      }
      });
}