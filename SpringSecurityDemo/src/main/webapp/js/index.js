$(document).ready(
function() {
	$('.easyui-accordion li a').click(
			function() {
				var tabTitle = $(this).text();
				var url = $(this).attr("href");
				addTab(tabTitle, url);
				$('.easyui-accordion li div').removeClass(
						"selected");
				$(this).parent().addClass("selected");
			}).hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});

	
	function addTab(subtitle, url) {
		if (!$('#tabs').tabs('exists', subtitle)) {
			$('#tabs').tabs('add', {
				title : subtitle,
				content : createFrame(url),
				closable : true,
				width : $('#mainPanle').width() - 10,
				height : $('#mainPanle').height() - 26
			});
		} else {
			$('#tabs').tabs('select', subtitle);
		}
		tabClose();
	}

	function createFrame(url) {
		var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'
				+ url
				+ '" style="width:100%;height:100%;"></iframe>';
		return s;
	}

	function tabClose() {
		/*双击关闭TAB选项卡*/
		$(".tabs-inner").dblclick(function() {
			var subtitle = $(this).children("span").text();
			$('#tabs').tabs('close', subtitle);
		})

		$(".tabs-inner").bind('contextmenu', function(e) {
			$('#mm').menu('show', {
				left : e.pageX,
				top : e.pageY,
			});
			var subtitle = $(this).children("span").text();
			$('#mm').data("currtab", subtitle);
			return false;
		});
	}

	//绑定右键菜单事件
	function tabCloseEven() {
		//关闭当前
		$('#mm-tabclose').click(function() {
			var currtab_title = $('#mm').data("currtab");
			$('#tabs').tabs('close', currtab_title);
		})
		//全部关闭
		$('#mm-tabcloseall').click(function() {
			$('.tabs-inner span').each(function(i, n) {
				var t = $(n).text();
				$('#tabs').tabs('close', t);
			});
		});

		//关闭除当前之外的TAB
		$('#mm-tabcloseother').click(function() {
			var currtab_title = $('#mm').data("currtab");
			$('.tabs-inner span').each(function(i, n) {
				var t = $(n).text();
				if (t != currtab_title)
					$('#tabs').tabs('close', t);
			});
		});
		//关闭当前右侧的TAB
		$('#mm-tabcloseright').click(function() {
			var nextall = $('.tabs-selected').nextAll();
			if (nextall.length == 0) {
				//msgShow('系统提示','后边没有啦~~','error');
				alert('后边没有啦~~');
				return false;
			}
			nextall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				$('#tabs').tabs('close', t);
			});
			return false;
		});
		//关闭当前左侧的TAB
		$('#mm-tabcloseleft').click(function() {
			var prevall = $('.tabs-selected').prevAll();
			if (prevall.length == 0) {
				alert('到头了，前边没有啦~~');
				return false;
			}
			prevall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				$('#tabs').tabs('close', t);
			});
			return false;
		});

		//退出
		$("#mm-exit").click(function() {
			$('#mm').menu('hide');

		})
	}
						
	$('#title2tree').tree({  
    	url: '/user2/mylist.do',  
    	loadFilter: function(data){     
        	return data;        
    },
    onClick: function(node){
    	if (node.url) { // 如果是链接
			//node.isLeaf()
			openTab(node,'<%=path%>'+ node.url);
			} 
		}
	});	
	
	
	$('#title1tree').tree({  
    url: '',
    loadFilter: function(data){     
        return data.returnObject;        
    },
    
    onClick: function(node){
    	if (node.url) { // 如果是链接
				//node.isLeaf()
				openTab(node, node.url);
													} 
												}
											});										
			openTab = function(node, url) {
						var id = node.id;
						try {
							title = (node.text.split('>')[1])
									.split('<')[0];
						} catch (e) {
							title = node.text;
						}
						if ($('#tabs').tabs('exists', title)) {
							$('#tabs').tabs('select', title);
						} else {
							var content = "<iframe scrolling='auto' frameborder='0'  src='"
									+ url
									+ "' style='width:100%;height:100%;'></iframe>";
							$('#tabs').tabs('add', {
								title : title,
								content : content,
								closable : true
							});
						}
					};												
	});


