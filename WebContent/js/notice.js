/**
 * Created by Programmer on 2016/4/27.
 */
$(document).ready(function(){
    $("a").click(function(){
        //alert($(this).attr("href"));
    	$.ajax({
    		'type':'post',
    		'datatype':'json',
    		'url':'getNoticeAction',
    		'data':{
    			'id':$(this).attr("href")
    		},
    		'success':function(data){
    			var objectData = eval("("+data+")");
    			$("p").empty().append("<h3>"+objectData.content+"</h3>").slideToggle("slow");
    		}
    	});
        return false;
    });
});
