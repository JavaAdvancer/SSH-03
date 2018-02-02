/**
 * Created by Programmer on 2016/4/28.
 */
$(document).ready(function(){
    $(".sellerInfo").click(function(){
    	$.ajax({
    		'type':'post',
    		'dataType':'json',
    		'data':{
    			id:$(this).attr("href")
    		},
    		'url':'getSellerInfoAction',
    		'success':function(data){
    			$(".sellerName").empty().text(data.username);
    			$(".gender").empty().text(data.gender);
    			$(".age").empty().text(data.age);
    			$(".schoolName").empty().text(data.school);
    			$(".emailName").empty().text(data.email);
    			$(".sellerInfoDia").dialog({
    				buttons:{
    					'确定':function(){
    						$(".sellerInfoDia").dialog("close");
    					}
    				}
    			});
    		}
    	});
    	return false;
    });
});
function getSellerInfoAction(){
	
    
    return false;
};