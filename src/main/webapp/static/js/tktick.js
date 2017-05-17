var tktick = {};
!(function(app, $){
	$.ER = function(xhr, textStatus, exception){
    	var status = xhr.status; 
    	if(status){
    		switch (status) {
    		case 403:
    			layer.msg("访问被拒绝", {icon:5});
    			break;
    		case 404:
    			layer.msg("访问地址不存在或已删除", {icon:5});
    			break;
    		case 500:
    			layer.msg("操作出错", {icon:5});
    			break;
    		case 504:
    			layer.msg("请求超时", {icon:5});
    			break;
    		case 0:
    			layer.msg("网络异常", {icon:5});
    			break;
    		default:
    			layer.msg("错误代码["+status+"]", {icon:5});
    			break;
    		}
    	}
    }
	app.write = {
		/**
		 * 添加控件
		 */
		etadd: function(dom, tp){
			switch (tp) {
				case 0:
					//添加文字
					var $editors = $('.write_editor');
					var id = 'editor_' + ($editors.length + 1);
					$(dom).parent().before('<div class="write_editor" id="'+ id +'" style="height: 150px;"></div>');
					createEditor(id);
					function createEditor(id){
						var editor = new wangEditor(id);
						 // 关闭菜单栏fixed
				    	editor.config.menuFixed = false;
						// 上传图片
				    	editor.config.uploadImgUrl = '/upload/editor?upload_type=image';
				    	editor.config.uploadImgFileName = 'upload';
						// 普通的自定义菜单
					    editor.config.menus = [
					        'bold',
					        'underline',
					        'italic',
					        'strikethrough',
					        'head',
					        'quote',
					        'fontfamily',
					        'link',
				        	'unlink',
					        '|',
					        'img',
					        'video',
					        '|',
					        'undo',
				        	'redo',
				        	'|',
				        	'fullscreen'
					     ];
				    	 editor.create();
					}
					break;
				default:
					break;
			}
		}
	}
})(tktick, $);