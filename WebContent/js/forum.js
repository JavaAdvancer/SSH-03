/**
 * Created by Programmer on 2016/3/12.
 */
$(document).ready(function(){
	$.ajax({
		'type':'post',
		'url':'getAllPostAction',
		'success':function(data){
			var objectData = eval("("+data+")");
			for(var i = 0;i < objectData.length;i ++){
				$(".background").append("<div class='post"+i+"'></div>");
		        $(".post"+i+"").css({
		            'position': 'relative',
		            'margin-top': 20,
		            'margin-left': 140,
		            'width': '80%',
		            'height': '150',
		            'background': 'honeydew'
		        });
		        $(".post"+i+"").append("<img class='img"+i+"' name='' width='100px' height='100px' src=''>");
		        $(".img"+i+"").css({
		            'float':'left',
		            'margin-left':20,
		            'margin-top':30
		        });
		        $(".img"+i+"").after("<h2 class='title"+i+"'></h2>");
		        $(".title"+i+"").after("<hr class='hr"+i+"'>");
		        $(".hr"+i+"").after("<P class='content"+i+"'></P>")
			}
			for(var i = 0;i < objectData.length;i ++){
				var picUrl = objectData[i].uPic
				var index = picUrl.lastIndexOf("\\");
	    		var src = picUrl.substring(index+1);
				$(".img"+i+"").attr({
					'src':"upload/images/"+src,
					'name':objectData[i].uId
				});
				$(".title"+i+"").text(objectData[i].title);
				$(".content"+i+"").text(objectData[i].content)
			}
		}
	});
});