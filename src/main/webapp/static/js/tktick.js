var tktick = {};
!(function(app){
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
})(tktick);