	function pagePlugin(pluginName,totalPages,page,totalNum,pageMethod){
		var aim = $('#'+pluginName);
		var moz = 0;
		var minPage = page - 2;
		if(minPage <= 0){
			moz = minPage - 1;
			minPage = 1;
		}
		var maxPage = page + 2 - moz;
		if(maxPage > totalPages){
			maxPage = totalPages;
		}
		if(page != 1){
			aim.append('<li><a href="javascript:void(-1)" onclick="jumpPage('+ 1 +')"><i class="fa fa-angle-double-left"></i></a></li>');
			aim.append('<li><a href="javascript:void(-1)" onclick="jumpPage('+ (page-1) +')"><i class="fa fa-angle-left"></i></a></li>');
		}
		for(var i = minPage ;i <= maxPage;i++){
			if(i != page){
				aim.append('<li><a href="javascript:void(-1)" onclick="jumpPage('+ i +')">'+ i +'</a></li>');
			}else{
				aim.append('<li><a href="javascript:void(-1)" style="color:#D3D3D3">'+ i +'</a></li>');				
			}
		}
		
		if(page != totalPages){
			aim.append('<li><a href="javascript:void(-1)" onclick="jumpPage('+ (page+1) +')"><i class="fa fa-angle-right"></i></a></li>');
			aim.append('<li><a href="javascript:void(-1)" onclick="jumpPage('+ totalPages +')"><i class="fa fa-angle-double-right"></i></a></li>');
		}
		$('<label>').html('跳转至<input type="text" class="targetPage" style="width:28px;height:21px;color:black;margin:0px 7px 0px 7px;"/>页,')
		.css("color","#428bca").css("padding-left","12px").appendTo($('<li>')).appendTo(aim);		
		
		$('<label>').html('共<font style="color:red;padding:0 7px 0 7px;">'+totalNum+'</font>条数据')
		.css("color","#428bca").css("padding","6px 12px 12px 0px").appendTo($('<li>')).appendTo(aim);
		$('.targetPage').bind('keydown',function(event){
			if (event.which == 13){
				var tpVal = $(this).val();
				if(isNaN(tpVal)){
					$(this).val('');
				}else{
					if(parseInt(tpVal) > totalPages){
						pageMethod(totalPages);
					}else{
						pageMethod(tpVal);
					}
				}
            } 
		});
	}