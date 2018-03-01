;(function($) {
	var mainObj = {}, para = {
		ww : "",
		wh : "",
		muh : "",
		muh1 : "",
		muh2 : "",
		sr1 : "",
		sr2 : "",
		sr3 : "",
		i : "",
		ml : "",
		proph : "",
		vn1 : "",
		vn2 : "",
		vn3 : ""
	};
	mainObj.init = function() {
		mainObj.events();
	}

	mainObj.events = function() {
		$(".nav_left").each(
				function(index, element) {
					/* 左侧一级导航切换 */
					$(this).bind("click", function() {
						para.vn1 = $(this).find("img").attr("src");
						para.vn2 = para.vn1.substr(12, 1); // 获取src中数字
							para.vn3 = parseFloat(para.vn2); // string->number
							para.ml = $(".menu_first").children("a").length;
							para.sr1 = "images/menu_" + (para.vn3) + "_on.png";
							for (para.i = 0; para.i < para.ml; para.i++) {
								para.sr2 = $(".nav_left").eq(para.i)
										.find("img").attr("src");
								para.sr3 = para.sr2.substr(0, 13) + ".png";
								$(".nav_left").eq(para.i).find("img").attr(
										"src", para.sr3);
							}
							$(this).siblings().removeClass("nav_left_on");
							$(this).addClass("nav_left_on");
							$(this).find("img").attr("src", para.sr1);
							$(".list_a").removeClass("list_a_on");
							$(".ul_menu").eq(index).show().siblings("ul")
									.hide();
						})
				});
		$(".list_a").each(
				function(index, element) {
					/* 二级菜单切换 */
					$(this).click(
							function() {
								$(this).addClass("list_a_on").parent("li")
										.siblings().find("a").removeClass(
												"list_a_on");
							})
				});
		$(".close_icon,.cancel_btn").click(function() {
			/* 弹框关闭按钮 */
			$(this).parent().parent().hide();
			$(".opacity_div").hide();
		});

		$(".right_content").delegate(".cancel_btn,.close_infobtn", "click",
				function() {
					/* 取消创建角色 */
					$(this).parents(".right_content").hide();
					$(".search_div").show().siblings(".turn_page").show();
				});
		$(".right_content").delegate(".sure_btn", "click", function() {
			/* 确定创建角色 */
			$(".opacity_div").show();
			$(".small_prop").show();
		});
		$(".small_prop").delegate(".btn_pop", "click", function() {
			/* 小弹框点击确定后弹框消失 */
			$(".opacity_div").hide();
			$(".small_prop").hide();
		});
		$(".drop_frame i").each(function(){
			$(this).attr("title",$(this).text());
		});
		// 点击选择状态，显示下拉框
		$(".drop_frame").click(function() {
			/*$(this).addClass('selected');
			$(".choose_ul").hide();
			// alert($(this).find(".choose_a").);
				$(this).children(".choose_ul").show();*/
			if($(this).children(".choose_ul").is(':visible')){
				$(this).children(".choose_ul").hide();
				$(this).removeClass('selected');
			}else{
				$(this).children(".choose_ul").show();
				$(this).removeClass('selected');
			}	
			$(".choose_ul").not($(this).children(".choose_ul")[0]).hide();
			$(".drop_frame").not(this).removeClass('selected');
		});
		
		
		/* 点击页面其他地方隐藏下拉框 */
		$(document)
				.bind(
						"click",
						function(e) {
							var target = $(e.target);
							if (target.closest(".drop_frame").length == 0
									|| e.target.className == "choose_a") {
								$(".choose_ul").hide().parent().removeClass(
										'selected');
							}
						});
		/* 点击下拉列表中某一项，对应改变下拉框的内容 */
		$('body').delegate(
				'.choose_a',
				'click',
				function() {
					$(this).parents(".drop_frame").children(".text_i").text(
							$(this).text());
					$(this).parents(".drop_frame").children(".text_i").attr("title",$(this).text());
					var status = $(this).attr("data-status");
					$(this).parents(".drop_frame").children(".text_i").attr(
							"data-status", status);
				});

		$(".first_check").change(
				function() {
					/* 复选框全选和取消全选 */
					$(".check_td").children('input[name="subBox"]').attr(
							"checked", this.checked);

				});
		var $subBox = $("input[name='subBox']");
		$subBox
				.click(function() {
					/* 所有复选框都选中时，全选框也同时勾上 */
					$(".first_check")
							.attr(
									"checked",
									$subBox.length == $("input[name='subBox']:checked").length ? true
											: false);
				});
		$(".user_taocanbtn").click(function() {
			/* 提交后显示办理套餐内容 */
			$(".hide_div").show();
			$(this).parents("div.border_div").removeClass("border_div");
		});
		$(".taocan_tree").click(function() {
			$(".opacity_div").show();
			$(".small_prop").show();
		});
		$(".calendar_a").each(function(index, element) {
			/* 点击日期图标同样出发输入框的日期控件 */
			$(this).click(function() {
				$("#datepicker" + (index + 1)).focus();
			})
		});
		$(".taocan_look").click(
				function() {
					/* 工单查询-明细查看 */
					$(this).parents(".search_div").hide().siblings(
							".right_content").show();
					$(this).parents(".search_div").siblings(".turn_page")
							.hide();
				});
		$("#search_detail").click(
				function() {
					$(this).parents(".search_div").removeClass("border_div");
					$(this).parents(".search_div").children(".table_list")
							.removeClass("hide_div");
				})
	}
	mainObj.init();
})(jQuery)

function showTips(tipText, time) {
	var tipsDiv = '<div class="tip_dialog hide"><div class="tipDialog_box"><p>'+tipText+'</p></div></div>';
	$('body').append(tipsDiv);
	var elem = $(".tip_dialog"),t = time || 2000,len;
	elem.find('p')
	.html(""+tipText);
	elem.fadeIn();
	setTimeout(function(){elem.fadeOut();},t);
	setTimeout(function(){elem.remove();},t);
}
function format(timeStamp){
	if(timeStamp==undefined){
		return "";
	}
	//timeStamp是整数，否则要parseInt转换
	var time = new Date(timeStamp);
	var y = time.getFullYear();
	var m = time.getMonth()+1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
	return y+'-'+(m<10?'0'+m:m)+'-'+(d<10?'0'+d:d)+' '+(h<10?'0'+h:h)+':'+(mm<10?'0'+mm:mm)+':'+(s<10?'0'+s:s);
}
function repalceNull(obj){
	if(obj==null||obj==""||obj=="undifine"){
		return "";
	}else{
		return obj;
	}
}

function isNull(obj){
	if(obj==null||obj==""||obj=="undifine"){
		return true;
	}else{
		return false;
	}
}
//判断流量包状态
function flowStatus(obj){
	if(obj==1){
		return '正常';
	}else if(obj==2){
		return '下架';
	}else {
		return '其他'
	}
}


//用户状态
function userStatus(obj){
	if(obj==1){
		return '<font color="green">正常</font>';
	}else if(obj==2){
		return '<font color="red">删除</font>';
	}else {
		return '其他'
	}
}

//用户产品折扣状态
function userDiscountStatus(obj){
	if(obj=='n'){
		return '<font color="green">正常</font>';
	}else if(obj=='y'){
		return '<font color="red">删除</font>';
	}else {
		return '其他'
	}
}

//判断运营商
function operatorStr(obj){
	if(obj==1){
		return '移动';
	}else if(obj==2){
		return '联通';
	}else if(obj==3) {
		return '电信'
	}else {
		return '其他';
	}
}
//类型：1：话费，2：流量
function orderTypeStr(obj){
	if(obj==1){
		return '话费';
	}else if(obj==2){
		return '流量';
	}else {
		return '其他';
	}
}

function orderStatus(obj){
	if(obj==1){
		return '待充值';
	}else if(obj==2){
		return '充值中';
	}else if(obj==3){
		return '成功';
	}else if(obj==4){
		return '失败';
	}else if(obj==5){
		return '缓存';
	}else{
		return '其他';
	}
}


function flowMoney(obj){
	if(obj==1){
		return ' 元';
	}else if(obj==2){
		return ' M';
	}
}
