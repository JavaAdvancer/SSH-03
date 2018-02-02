/**
 * Created by Programmer on 2016/3/11.
 */
$(document).ready(function(){
	$.ajax({
		'type':'post',
		'url':'showAllProductAction',
		'dataType':'json',
		'success':function(data){
			for(var i = 0;i < data.length;i ++){
				$(".background").append("<div class='category"+i+"'></div>");
		        $(".category"+i+"").css({
		            'float':'left',
		            'height':300,
		            'margin-left':60,
		            'margin-top':30,
		            'background':'white'
		        });
		        $(".category"+i+"").append("<img class='picture picture"+i+"' src='' width='200px' height='200px' name='' onclick='getProductInfoAction(this.name)'>");
		        $(".picture"+i+"").css({
		            'cursor':'pointer'
		        });
		        $(".picture"+i+"").after("<h6 class='title"+i+"'></h6>");
		        $(".title"+i+"").after("<p class='content"+i+"' name=''></p>")
		        $(".content"+i+"").after("<a class='sellerInfo sellerInfo"+i+"' name='' onclick='getSellerInfoAction()'>卖家信息</a>")
		        $(".sellerInfo"+i+"").css({
		            'display':'block',
		            'cursor':'pointer'
		        });
			}
			for(var i = 0;i < data.length;i ++){
				$(".category"+i+"").attr({
					'name':data[i].id
				});
				var picUrl = data[i].picture;
	    		var index = picUrl.lastIndexOf("\\");
	    		var src = picUrl.substring(index+1);
	    		//$(".picture"+i+"").attr('src',"upload/images/"+src);
	    		$(".picture"+i+"").attr({
	    			'name':data[i].id,
	    			'src':"upload/images/"+src
	    		});
	    		$(".title"+i+"").text(data[i].title);
	    		$(".content"+i+"").text(data[i].context);
	    		$(".sellerInfo"+i+"").attr({
	    			'name':data[i].uId
	    		})
			}
		}
	});
});
function getSellerInfoAction(){
	$.ajax({
    	'type':'post',
    	'url':'getSellerInfoAction',
    	'data':{
    		id:$(".sellerInfo").attr("name")
    	},
    	'dataType':'json',
    	'success':function(data){
    		$(".sellerName").val(data.username);
    		$(".age").val(data.age);
    		if(data.gender=="男"){
    			$(".gender[value=male]").attr("checked",true);
    		}else{			
    			$(".gender[value=female]").attr("checked",true);
    		}
    		$(".school").val(data.school);
    		$(".email").val(data.email);
    	}
    });
	
	$(".sellerInfoDia").dialog({
		modal:true,
		buttons:{
			确定:function(){
				$(".sellerInfoDia").dialog("close");
			}
		}
	});
}
function getProductInfoAction(name){
	$.ajax({
    	'type':'post',
    	'url':'getProductInfoAction',
    	'data':{
    		id:name
    	},
    	'dataType':'json',
    	'success':function(data){
    		$(".productName").empty().text(data.name);
    		$(".title").empty().text(data.title);
    		$(".detail").empty().text(data.detail);
    		$(".budgetTime").empty().text(data.budgetTime);
    		$(".price").empty().text(data.budgetPrice);
    	}
    });
	$(".productInfoDia").dialog({
		width:400,
		height:400,
		modal:true,
		draggable:false,
        resizable:false,
		buttons:{
			确定:function(){
				$(".productInfoDia").dialog("close");
			}
		}
	});
}