/**
 * Created by Programmer on 2016/2/22.
 */
$(document).ready(function(){
    $("#tabs").tabs();
    $("input[type=button]").button();
    /*打开页面时，ajax向后台提交请求个人资料信息*/
    $.ajax({
    	'type':'post',
    	'url':'getUserAllInfoAction',
    	'dataType':'json',
    	'success':function(data){
    		$(".name").val(data.username);
    		$(".age").val(data.age);
    		if(data.gender=="男"){
    			$(".gender[value=male]").attr("checked",true);
    		}else{			
    			$(".gender[value=female]").attr("checked",true);
    		}
    		$(".email").val(data.email);
    		$(".address").val(data.address);
    		$(".school").val(data.school);
    		var picUrl = data.picture;
    		var index = picUrl.lastIndexOf("\\");
    		var src = picUrl.substring(index+1);
    		$(".picture").attr('src',"upload/images/"+src);
    	}
    });
    /*点击提交时，通过ajax向后台提交数据*/
    $(".infoUpdate").click(function(){
    	$.ajax({
        	'type':'post',
        	'url':'updateUserInfoAction',
        	'data':{
        		'username':$(".name").val(),
        		'age':$(".age").val(),
        		'gender':$(".gender").val(),
        		'address':$(".address").val(),
        		'school':$(".school").val(),
        		'email':$(".email").val()
        	},
        	'success':function(data){
        		if(data=="success"){
        			$(".infohint").css({
            			'width':200,
            			'height':25,
            			'color':'white',
            			'text-align':'center'
            		}).empty().append("<b>修改成功！</b>")
            		  .fadeIn(2000)
            		  .fadeOut(3000);
        		}else{
        			$(".infohint").css({
            			'width':200,
            			'height':25,
            			'color':'white',
            			'text-align':'center'
            		}).empty().append("<b>修改失败！</b>")
            		  .fadeIn(2000)
            		  .fadeOut(3000);
        		}
        	}
        });
    });
    /*使得页面中不可用的输入框变得可用*/
    $(".isUpdate").click(function(){
    	$(".name").removeAttr("disabled");
		$(".age").removeAttr("disabled");
		$(".gender").removeAttr("disabled");
		$(".address").removeAttr("disabled");
		$(".school").removeAttr("disabled");
    });
    /*清空输入框的数据*/
    $(".infoClear").click(function(){
    	$(".name").val("");
		$(".age").val("");
		$("option").val("");
		$(".address").val("");
		$(".school").val("");
    });
    /*后台请求检验原始密码是否正确*/
    $(".originalPass").blur(function(){
    	$.ajax({
    		'type':'post',
    		'url':'checkPasswordAction',
    		'data':{
    			'password':$(".originalPass").val()
    		},
    		'success':function(data){
    			if(data=="error"){
    				$(".warnning1").css({
    					'color':'red',
    					'font-size':'smaller'
    				}).empty().append("<b>原始密码错误！</b>");
    				$(".passwordUpdate").attr("disabled","disabled");
    			}else{
    				$(".warnning1").css({
    					'color':'deepskyblue',
    					'font-size':'smaller'
    				}).empty().append("<b>原始密码正确！</b>");
    				$(".passwordUpdate").removeAttr("disabled");
    			}
    		}
    	});
    });
    /*检查新提交的密码是否一致*/
    $(".confirmNewPass").blur(function(){
    	if($(".newPass").val()==$(".confirmNewPass").val()&$(".newPass").val()!=""&$(".confirmNewPass").val()!=""){
    		$(".warnning3").css({
				'color':'deepskyblue',
				'font-size':'smaller'
			}).empty().append("<b>密码输入一致！</b>");
    		$(".passwordUpdate").removeAttr("disabled");
    	}else{
    		$(".warnning3").css({
				'color':'red',
				'font-size':'smaller'
			}).empty().append("<b>密码输入不一致！</b>");
    		$(".passwordUpdate").attr("disabled","disabled");
    	}
    });
    /*点击提交按钮，ajax后台提交新密码给数据库*/
    $(".passwordUpdate").click(function(){
    	$.ajax({
    		'type':'post',
    		'url':'updatePasswordAction',
    		'data':{
    			'password':$(".confirmNewPass").val()
    		},
    		'success':function(data){
    			if(data=="success"){
    				$(".hintDialog").empty()
    								.append("<h3>密码修改成功！请退出重新登录</h3>")
    								.dialog({
    									'buttons':{
    										"确定":function(){
    											$(".hintDialog").dialog("close");
    										}
    									}
    								});
    			}else{
    				$(".hintDialog").empty()
					.append("<h3>密码修改失败！</h3>")
					.dialog({
						'buttons':{
							"确定":function(){
								$(".hintDialog").dialog("close");
							}
						}
					});
    			}
    		}
    	});
    });
    /*检查图片以外的格式，非图片不可以传入数据库*/
    $(".pic").change(function(){
        var picName = $(".pic").val();
        var start = picName.lastIndexOf(".")+1;
        var picName = picName.substring(start);
            if(picName=="PNG"|picName=="JPG"|picName=="JPEG"|picName=="png"|picName=="jpg"|picName=="jpeg"){
                $(".picSubmit").removeAttr("disabled");
            }else {
                $(".picSubmit").attr("disabled", "disabled");
                $(".tab5Hint").css({
                    'width': 250,
                    'height': 30,
                    'color': 'white'
                }).empty().append("<b>上传的图片只支持png,jpg,jpeg</b>").fadeIn(3000).fadeOut(3000);

            }
    });
    /*点击tab，载入自己发过的帖子*/
    $("a[href='#tab4']").click(function(){
    	$("tr").nextAll().remove();
    	$.ajax({
    		'type':'post',
    		'dataType':'json',
    		'url':'getSelfPostAction',
    		'success':function(data){
    			for( i = 0;i < data.length;i ++) {
    		        $("table").append("<tr class='table" + i + "'></tr>");
    		    }
    		    for( i = 0;i < data.length;i ++){
    		        $(".table"+i+"").append("<td>"+data[i].title+"</td>")
    		        $(".table"+i+"").append("<td>"+data[i].content+"</td>")
    		        $(".table"+i+"").append("<td><a class='postEdit' onclick='postEdit()' name='"+data[i].id+"'>编辑</a></td>")
    		        $(".table"+i+"").append("<td><a class='postDel' onclick='postDel()' name='"+data[i].id+"'>删除</a></td>")
    		    }
    		}
    	});  	
    });
    /*点击tab，载入自己发过的商品*/
    $("a[href='#tab3']").click(function(){
    	$("tr").nextAll().remove();
    	$.ajax({
    		'type':'post',
    		'dataType':'json',
    		'url':'getSelfProductAction',
    		'success':function(data){
    			for( i = 0;i < data.length;i ++) {
    		        $("table").append("<tr class='table" + i + "'></tr>");
    		    }
    		    for( i = 0;i < data.length;i ++){
    		        $(".table"+i+"").append("<td>"+data[i].name+"</td>")
    		        $(".table"+i+"").append("<td>"+data[i].title+"</td>")
    		        $(".table"+i+"").append("<td>"+data[i].detail+"</td>")
    		        $(".table"+i+"").append("<td>"+data[i].budgetTime+"</td>")
    		        $(".table"+i+"").append("<td>"+data[i].budgetPrice+"</td>")
    		        $(".table"+i+"").append("<td>"+data[i].category+"</td>")
    		        $(".table"+i+"").append("<td><a class='productEdit' onclick='productEdit()' name='"+data[i].id+"'>编辑</a></td>")
    		        $(".table"+i+"").append("<td><a class='productDel' onclick='productDel()' name='"+data[i].id+"'>删除</a></td>")
    		    }
    		}
    	});  	
    });
});
/*删除帖子*/
function postDel(){
	var id = $(".postDel").attr('name');
	//alert(id);
	$.ajax({
		'type':'post',
		'data':{
			'id':id
		},
		'url':'delSelfPostAction',
		'success':function(data){
			if(data=="success"){
				alert("删除成功！");
			}
		}
	});
}
/*编辑帖子*/
function postEdit(){
	var id = $(".postEdit").attr('name');
	$(".postEditDialog").dialog({
		'modal':true,
		'buttons':{
			'保存':function(){
				$.ajax({
					'type':'post',
					'data':{
						'id':id,
						'title':$(".postTitle").val(),
						'content':$(".postContent").val()
					},
					'url':'saveSelfPostAction'
				});
				alert("编辑成功！");
				$(".postEditDialog").dialog('close');
			},
			'取消':function(){
				$(".postEditDialog").dialog('close');
			}
		}
	});
}