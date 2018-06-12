var ue;
$(function() {
	ue = UE.getEditor('content');
	$("#savenews").click(function() {
		var content = ue.getContent();
		
		
		if (content == "") {
			parent.$.messager.alert('系统提示', '请输入评论内容', 'warning');
			return;
		}

		$.ajax({
			url : base+"comment/addComment",
			//只封装和传输指定的数据
			data : {
				"userId" : title,
				"newsId" : cruser,
		
				"content" : content
			},
			type : "POST",
			success : function(res) {
				if (res.ok) {
					parent.$.messager.alert('系统提示', '评论成功', 'info');
				} else {
					parent.$.messager.alert('系统提示', res, 'warning');
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
