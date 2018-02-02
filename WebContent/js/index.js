/**
 * Created by Programmer on 2016/2/12.
 */
$(document).ready(function() {
	$("#accordion").accordion();
    $("h3").click(function(){
        $.ajax({
        	'type':'post',
        	'datatype':'json',
        	'url':'getAllProductsByType',
        	'data':{
        		'type':$(this).text()
        	},
        	'success':function(data){
        		var div = $(this).next("div");
        		var data = eval("("+data+")");
        		for(var i = 0;i < 5;i ++){
        			div.text(data[i].name)
        		}
        	}
        });
    });
	$("#search").click(function(){
		window.location.href = "searchResult.jsp?keyWord="+$('#keyWord').val()+""
	});
	$(".category").click(function(){
		window.location = "searchResult.jsp?category="+$(this).text()+"";
	});
	$(".notice").click(function(){
		window.location.href = "notice.jsp";
	});
	$(".index").click(function(){
		window.location.reload();
	});
	$(".personalCenter").click(function(){
		$.ajax({
			'type':'post',
			'url':'checkIsLoginAction',
			'success':function(data){
				if(data=="success"){
					
					location.href = "personInfo.jsp";
					
				}else{
					$(".hint").css({
						'width':200,
						'height':25,
						'background':'deepskyblue',
						'color':'white',
						'text-align':'center'
					}).empty().append("<b>您还没有登录，请先登录！</b>")
					.fadeIn(3000)
					.fadeOut(3000);
				}
			}
		});
	});
	$(".sell").click(function(){
		$.ajax({
			'type':'post',
			'url':'checkIsLoginAction',
			'success':function(data){
				if(data=="success"){
					
					location.href = "sellProduct.jsp";
					
				}else{
					$(".hint").css({
						'width':200,
						'height':25,
						'background':'deepskyblue',
						'color':'white',
						'text-align':'center'
					}).empty().append("<b>您还没有登录，请先登录！</b>")
					.fadeIn(3000)
					.fadeOut(3000);
				}
			}
		});
	});
	$(".need").click(function(){
		$.ajax({
			'type':'post',
			'url':'checkIsLoginAction',
			'success':function(data){
				if(data=="success"){
					
					location.href = "needProduct.jsp";
					
				}else{
					$(".hint").css({
						'width':200,
						'height':25,
						'background':'deepskyblue',
						'color':'white',
						'text-align':'center'
					}).empty().append("<b>您还没有登录，请先登录！</b>")
					.fadeIn(3000)
					.fadeOut(3000);
				}
			}
		});
	});
    $(".login").click(function(){
        $(".loginDialog").dialog({
            modal:true,
            width:450,
            height:300,
            title:"用户登录",
            buttons:{
                '登录':function(){
                	userLogin();
                },
                '清空':function(){
                    $(":text").val("");
                    $(":password").val("");
                },
                '取消':function(){
                    $(".loginDialog").dialog("close");
                }
            },
            draggable:false,
            resizable:false
        });
    });
    $(".register").click(function(){
        $(".registerDialog").dialog({
            modal:true,
            width:450,
            height:400,
            'title':"用户注册",
            buttons:{
                '注册':function(){
                    userRegister();
                },
                '清空':function(){
                    $(":text").val("");
                    $(":password").val("");
                },
                '取消':function(){
                    $(".registerDialog").dialog("close");
                }
            },
            draggable:false,
            resizable:false
        });
    });
    $(".repassword").blur(function(){
        if(verifyPassword()=="false"){
            $("button:contains('注册')").attr("disabled","disabled");
        }
    });
    $(".email").blur(function(){
    	
    	if(isEmail()=="false"){
			$(".email-true-icon").hide();
            $(".email-error-icon").fadeIn();
            $("button:contains('注册')").attr("disabled","disabled");
		}else{
	         isEmailUsed();
		}
    	
    });
    $(".username,.loginPassword").blur(function(){
        loginCheck();
    });
    $(".logout").click(function(){
            $(".logoutDialog").empty().append('<h5>你确定要注销退出吗？</h5>')
                .dialog({
                    title:"注销退出",
                    modal:true,
                    buttons:{
                        '确定':function(){
                        	$.ajax({
                        		'type':'post',
                        		'url':'logoutAction',
                        		'success':function(data){
                        			$(".logoutDialog").dialog("close");
                        			window.location.reload();
                        		}
                        	});
                        },
                        '取消':function(){
                            $(".logoutDialog").empty();
                            $(".logoutDialog").dialog("close");
                        }
                    }
                });
    });
});
/*注册时检查密码是否一致并且密码不能为空*/
function verifyPassword(){
    if($(".repassword").val()==$(".password").val()&$(".repassword").val()!=""&$(".password").val()!=""){
        $(".password-error-icon").hide();
        $(".password-true-icon").fadeIn();
        return "true";
    }else{
        $(".password-true-icon").hide();
        $(".password-error-icon").fadeIn();
        return "false";
    }
}
/*检查邮箱是否符合格式*/
function isEmail(){
	if($(".email").val().indexOf("@")<0){
		
		return "false";
	}else{
		return "success";
	}
}
/*检查邮箱是否已经被注册*/
function isEmailUsed(){
	$.ajax({
		'type':'post',
		'url':'emailCheckAction',
		'data':{
			'emailName':$(".email").val()
		},
		'success':function(data){
//			alert(data);
			if(data=="error"){
				$(".hint").css({
        			'width':200,
        			'height':25,
        			'background':'deepskyblue',
        			'color':'white',
        			'text-align':'center'
        		}).empty().append("<b>该邮箱被注册了！</b>")
        		  .fadeIn(3000)
        		  .fadeOut(5000);
				$("button:contains('注册')").attr("disabled","disabled");
				$(".email-true-icon").hide();
	            $(".email-error-icon").fadeIn();
			}else{
				$(".email-error-icon").hide();
		        $(".email-true-icon").fadeIn();
				$("button:contains('注册')").removeAttr("disabled");
			}
		}
	});
}
/*登录检查用户名和密码不能为空*/
function loginCheck(){
    if($(".username").val()==""|$(".loginPassword").val()==""){
        $("button:contains('登录')").attr("disabled","disabled");
    }else{
        $("button:contains('登录')").removeAttr("disabled");
    }
}
/*用户注册*/
function userRegister(){
	$.ajax({
        'type':'post',
        'url':'registerAction',
        'data':{
            'email':$(".email").val(),
            'password':$(".password").val()
        },
        'dataType':'json',
        success:function(data){
        	if(data.email!=null){
        		$(".hint").css({
        			'width':200,
        			'height':25,
        			'background':'deepskyblue',
        			'color':'white',
        			'text-align':'center'
        		}).empty().append("<b>注册成功！</b>")
        		  .fadeIn(3000)
        		  .fadeOut(5000);
        		
        		$(".registerDialog").dialog("close");
        	}
        }
    });
}
/*用户登录*/
function userLogin(){
	$.ajax({
		'type':'post',
		'data':{
			'email':$(".loginEmail").val(),
			'password':$(".loginPassword").val()
		},
		'url':'loginAction',
		'dataType':'json',
		'success':function(data){
			if(data.id!=0){
				$(".hint").css({
        			'width':200,
        			'height':25,
        			'background':'deepskyblue',
        			'color':'white',
        			'text-align':'center'
        		}).empty().append("<b>登录成功！</b>")
        		  .fadeIn(2000)
        		  .fadeOut(3000);
				$(".loginDialog").dialog("close");
				window.location.reload();
			}else{
				$(".hint").css({
        			'width':200,
        			'height':25,
        			'background':'deepskyblue',
        			'color':'white',
        			'text-align':'center'
        		}).empty().append("<b>登录失败！</b>")
        		  .fadeIn(2000)
        		  .fadeOut(3000);
			}
		}
	});
}