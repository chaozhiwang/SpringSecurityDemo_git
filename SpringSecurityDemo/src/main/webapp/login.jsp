<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>自定义登录控制</title>  
  
<link href="../common/bootstrap/css/bootstrap.min.css"       rel="stylesheet">  
<link href="../common/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">  
  
<script type="text/javascript"  
    src="../common/bootstrap/js/bootstrap.min.js"></script>  
<script type="text/javascript"   
    src="../common/jquery/jquery-2.1.1.min.js"></script>  
<body>  
    <div class="container">  
        <div id="container_demo">  
            <div id="wrapper">  
                <div id="login" class="animate form">  
                    <h1>示例二 自定义login方法</h1>  
                    <form id='loginForm' method="POST">  
                        <p>  
                            <label for="" class="uname" data-icon="u"> 用户名 </label>  
                            <input id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com">  
                        </p>  
                        <p>  
                            <label for="" class="youpasswd" data-icon="p"> 密码 </label>  
                            <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO">  
                        </p>  
                        <p class="login button">  
                            <input type="submit" id="submitId" value="登录">  
                        </p>  
                    </form>  
                </div>  
            </div>  
        </div>  
    </div>  
</body>  
  
<script type="text/javascript">  
    $(function(){  
      /////////////////登录提交////////////////////////////  
      $("#loginForm").submit(function() {  
        var username=$("#username").val();  
        var password=$("#password").val();  
        var data={username:username,password:password};   
        var url="/testSpringSecurity2/main/customLogin2.do";   
         $.ajax({  
            type: "POST",  
            url: url,  
            data: data,  
             // contentType: "application/json",  
            dataType: "json",  
            success:function (result) {  
              if(result.ok){  
                location.href="/testSpringSecurity2/main/admin.do";  
              } else  
              {  
                  alert(">>"+result.SPRING_SECURITY_LAST_EXCEPTION)  
                  $(".error").remove();  
                  $("#loginForm").prepend("<div class='error'><font color='red'>"+result.msg+"</font></div>");  
              }                
            },  
            error:function(XMLHttpRequest, textStatus, errorThrown){  
                alert('读取超时，请检查网络连接...');   
            }  
          });  
         return false;  
      });  
    });      
  </script>  
</html>  