<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
<title>新闻阅读</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="<%=basePath%>include/img/ico.jpg">
<link rel="stylesheet" href="<%=basePath%>include/css/themes/icon.css">
<link rel="stylesheet" href="<%=basePath%>include/css/themes/default/easyui.css">

<link rel="stylesheet" href="<%=basePath%>include/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script>var base="<%=basePath%>";</script>

<script src="<%=basePath%>include/js/jquery.min.js"></script>
<script src="<%=basePath%>include/js/bootstrap.min.js"></script>
<script  src="<%=basePath%>include/js/jquery.easyui.min.js"></script>
<script  src="<%=basePath%>include/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="<%=basePath%>include/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath%>include/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="<%=basePath%>include/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>


<body style="background-color: #eee;">
<nav class="navbar navbar-default navbar-fixed-top">
	<div
		style="background:#bce8f1;padding:0 10px 0 10px;vertical-align: middle;">
		<img src="<%=basePath%>include/img/ico.jpg" width="50" height="50" />
		<div
			style="float:right;line-height:50px;margin-right:10px;font-size: 9pt;">
			<span> 【 </span><a style="color:blue;"
				href="javascript:window.opener=null;window.open('','_self');window.close(); " ><span>
					关 闭 窗 口 </span></a><span>】 </span>
		</div>
	</div>
	</nav>
	<div class="container" style="margin-top:80px;background-color: #fff; border: 1px;border-radius: 10px; ">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
			<div class="ndetail">
				<div class="ntitle">
					<h1 class="text-center">${news.title}</h1>
				</div>
				<div class="nauthor">
					<h4 class="text-center">
						<div>
							来源: &nbsp;<strong>${news.cruser}</strong> &nbsp;&nbsp; 发 布 时 间
							:&nbsp; <strong><fmt:formatDate value="${news.tjdate}" pattern="yyyy-MM-dd"/></strong>&nbsp;&nbsp;
							访 问 量 :&nbsp; <strong>[<span>${news.hitnum}</span>]
							</strong>
						</div>
						</h1>
						<hr />
				</div>
				<div class="nbody">
					<div id="vsb_content">${news.content}</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
</div>
<br>
<br>
	<div class="container">
		<div class="row">
		<!-- <div id="sss">aaa</div> -->
		
				<div class="panel panel-info">
					<div class="panel-heading">新闻评论</div>
					<div class="panel-body">
						
						<%-- <c:forEach items="${comments}" var="comment">
							
							${comment.getNickname()}:
						<div class="col-md-2 col-md-offset-10"> --%>
							<%-- 	<a
									href="CommentServlet?type=favour&id=${comment.getId()}&favour=${comment.getFavour()+1}">
									<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"><span
										class="badge" style="background:#0B7EE2">${comment.getFavour()}</span></span>
								</a> <a
									href="CommentServlet?type=disfavour&id=${comment.getId()}&disfavour=${comment.getDisfavour()+1}">
									<span class="glyphicon glyphicon-thumbs-down"
									aria-hidden="true"><span class="badge"
										style="background:#E22B0B">${comment.getDisfavour()}</span></span>
								</a> --%>
							<%-- </div> 
							<br>
								${comment.getContent()}<br>
								<fmt:formatDate value="${comment.getCommentTime()}" pattern="yyyy-MM-dd hh:mm:dd"/>
								
						<hr>
						</c:forEach> --%>
						<div id="approve"></div>
						
						<div id="comment"></div>
				<div id="pp" style="background:#efefef; display: block;"></div>
						<hr>
						<c:choose>
							<c:when test="${not empty me}">

									
										<br><br>
										<div class="form-group">
											<label>评论:</label>
											<!--给表单域添加form-control样式，能够美化文本框-->
											<script id="content" type="text/plain" rows="4"></script>
									
									<br>
										<div class="col-md-offset-4">
											<button id="save" style="width:90px" class="btn  btn-warning">发表</button>
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href="<%=basePath%>user/goIndex"
												style="width:90px" class="btn  btn-info">首页</a>
												</div>
							
							</c:when>
							<c:otherwise>
							<br>
							<div class="col-md-offset-4">
								<h5>
									使用评论功能请先<a href="<%=basePath%>user/goLogin">登录</a>
								</h5>
								<a href="<%=basePath%>user/toIndex" style="width:90px" class="btn  btn-info">首页</a>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		
	</div>




	<style>
#backtotop {
	width: 24px;
	color: white;
	padding: 12px 0px 12px 5px;
	display: none;
	position: fixed;
	cursor: pointer;
	text-align: center;
	z-index: 20;
	background-color: rgba(0, 188, 212, 0.65);
	border-radius: 12px 0px 0px 12px;
}
</style>
	<div id="backtotop" style="right: 0px; display: none;">回到顶部</div>
	<script>
		
		

		$(function() {
		/* $("#sss").click(function() {
		 document.getElementById("sss").innerHTML = "内容2";
		$("#sss").t("想写什么就什么，html代码也可以");
		}); */
		
		/* 	  $(document).on("click","#disfavour52",function(){
        	  	$("#disfavour52").hide;
     		 });  */
			
 	
		/* 	var ue;
			ue = UE.getEditor('content'); */
			var ue = UE.getEditor('content', {
   			 toolbars: [
       	 ['fullscreen', 'source', '|', 'undo', 'redo', '|',
            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
            'directionalityltr', 'directionalityrtl', 'indent', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
            'link', 'unlink','|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
            'simpleupload', 'insertimage', 'emotion', 'scrawl', 'insertvideo', 'music', 'attachment', 'map', 'gmap', 'insertframe', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
            'horizontal']
   		 	],
   		 autoHeightEnabled: true,
  		  autoFloatEnabled: true
		}); 
			$("#save").click(function() {
				var content = ue.getContent();
				var userId="${me.uid}";
				var nickName="${me.xm}";
				var newsId="${news.id}";
				
				if (content == "") {
					parent.$.messager.alert('系统提示', '请输入评论内容', 'warning');
					return;
				}

				$.ajax({
					url : base + "comment/addComment",
					//只封装和传输指定的数据
					data : {
						"userId" : userId,
						"newsId" : newsId,
						"nickname": nickName,
						"content" : content
					},
					type : "POST",
					success : function(res) {
						if (res.ok) {
						var f=parseInt(res.floor);
						/* $('#pp').pageNumber=(parseInt(f/10+1));  */
						listComments(parseInt(f/10+1),10);  
						$('#pp').pagination('refresh',{pageNumber:parseInt(f/10+1)}); 
						 $.messager.alert({
						title:'系统提示', 
						msg:'评论成功', 
						icon:'info',
						top:$(window).height()*0.6
						});  
						} else {
							$.messager.alert('系统提示', res, 'warning');
						}
						return false;
					},

					error : function(res) {
						parent.$.messager.alert('系统错误', '请核实错误', 'warning');
						return false;
					}
				});
			});
		})
		
		
var pageN=1,pageTotal=100,newsId="${news.id}";
$(function(){
    $.ajax({
    
        url:base+"comment/getCount?newsId="+newsId,
        type:"get",
        success: function(res){
            var c=parseInt(res.commentcount);
            pageTotal=c;            
            listComments(1,10);loadPager();         
        },
        error:function(res){
            $.messager.alert('系统提示','系统错误!','error');
        }
    }); 
});


function listComments(pageNumber,pageSize){
    $.ajax({
        url:base+"comment/listComment",
        data:{"newsId":newsId,"page":pageNumber,"rows":pageSize},
        type:"post",
        success: function(res){
           $(".icomment").remove(); 
            if(res.total<=0){
                var tr="<div class='t'>暂无相关评论</div>";
                $("#comment").before(tr);
            }
            else {
            pageN=pageNumber;
            pageTotal=res.total;
            var rows=res.rows;
                for(var i=0;i<rows.length;i++){ 
                    var row=rows[i];
      
                    var tr="<div  class='icomment'><div class=\"col-md-2\" style=\"font-weight:bold;\">"+row.nickname+"：</div>";
                    	tr+="<div class=\"col-md-2 col-md-offset-8\">"; 
                    	tr+="<a class=\"addApprove\" onclick='approve("+row.id+","+row.favour+")'><span  class=\"glyphicon glyphicon-thumbs-up\" aria-hidden=\"true\"></span><span id=\"favour"+row.id+"\" class=\"badge\" style=\"background:#0B7EE2\">"+row.favour+"</span></a>&nbsp;&nbsp;"
                    	tr+="<a class=\"addDisApprove\" onclick='disapprove("+row.id+","+row.disfavour+")'><span class=\"glyphicon glyphicon-thumbs-down\" aria-hidden=\"true\"></span><span  class=\"badge\" style=\"background:#ff0505\"> <div id=\"disfavour"+row.id+"\">"+row.disfavour+"</div></span></a>"		
                        tr+="</div><br><div class=\"col-md-12\">"+row.content+"</div>";
                        //日期格式的处理方法，在下文提供。
                        tr+="<div class=\"col-md-10\">"+(new Date(row.commentTime).Format("yyyy-MM-dd hh:mm:ss"))+"</div><div class=\"col-md-2\">"+row.floor+"楼</div>&nbsp;<hr></div>";
                    $("#comment").before(tr);
                   
                    }
                }
            },
        error:function(res){
            $.messager.alert('系统提示','系统错误!','error');
        }
    })
   }

function approve(id,favour){
 	   $.ajax({
    
        url:base+"comment/approve",
        type:"post",
        data:{"id":id,"favour":favour},
        success: function(res){
     
             $("#favour"+id).text(favour+1); 
        },
        error:function(res){
            $.messager.alert('系统提示','系统错误!','error');
        }
    });  
}
function disapprove(id,disfavour){
	   	 $.ajax({
    
        url:base+"comment/disapprove",
        type:"post",
        data:{"id":id,"disfavour":disfavour},
        success: function(res){
              $("#disfavour"+id).text(disfavour+1);   
        },
        error:function(res){
            $.messager.alert('系统提示','系统错误!','error');
        }
    });    
 
   
}  

function loadPager(){
    $('#pp').pagination({
        total:pageTotal,
        pageSize:10,
        pageNumber:pageN,
        layout:['list','sep','first','prev','links','next','last'],
        links:5,
        displayMsg:'{from}/{to} 共{total}条',
        onSelectPage:function(pageNumber, pageSize){
            listComments(pageNumber,pageSize);
        }
    });
}	
	
	

		
	</script>
</body>
<script src="<%=basePath%>include/js/backtop.js"></script>
<script src="<%=basePath%>include/js/jquery.min.js"></script>
<script src="<%=basePath%>include/js/jquery.easyui.min.js"></script>
<script src="<%=basePath%>include/js/easyui-lang-zh_CN.js"></script>
<script src="<%=basePath%>include/js/canvas.js"></script>
</html>
