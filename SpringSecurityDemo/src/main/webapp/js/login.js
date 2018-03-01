$(document).ready(function(){
	/*if(new RegExp('firefox','i').test(navigator.userAgent)){
		$('.top_button').width(340); 
	}*/ 
	
	listAcntType();
	
})
	
function listAcntType (){
	$.ajax({
		url: 'dic/listAcntType.do', 
		type: 'POST',
		async: false,
		data:{}, 
		dataType: 'json', 
		timeout: 10000, 
		error: function(){
			showTips('请求失败,请稍后重试');
		}, 
		success: function(result){
			if(result.resultCode==1000){
				var obj = result.returnObject;
				var objStr = "";
				$.each(obj, function(i) {						
					objStr += "<option value=\"" + obj[i].code + "\" >" + obj[i].name + "</option>"; 
				});	
				$("#acntList").html(objStr);
			}else{
				
			}
		} 
	});
}
function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	var userType = $("#acntList").val();
//	console.log(username+"---"+password+"--"+userType);
	$.ajax({
		type: "post",  
        url: 'login.do', 
        data: {username:username,password:password,userType:userType},
        dataType: "html",
		error: function(XMLHttpRequest, textStatus, errorThrown){
//			location.href = data.responseText;
//			console.log(textStatus);
//			console.log(XMLHttpRequest.status); 
//			console.log(XMLHttpRequest.readyState);
//			console.log("data="+XMLHttpRequest.responseText);
			var errorMsg=XMLHttpRequest.responseText; //取得整个地址栏
			$("#errorMsg").html(errorMsg);
			showTips('请求失败,请稍后重试');
		}, 
		success: function(result,name){
//			$("#errorMsg").html(result);
//			if(result.resultCode==1000){
//				location.href ="goIndex.do";
//			}else{
//				$(".error_clew").html(result.returnObject).show();
//				$("#randimg").click();
//			}
			console.log(result.indexOf("DOCTYPE"));
			if(result.indexOf("DOCTYPE")>=0) {
				window.location.href="index.html";
			}else {
				$("#errorMsg").html(result);
			}
		} 
		}); 
}
function goIndex(){
	window.top.location.href ="goIndex.do";
}