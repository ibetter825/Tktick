!(function(){
	//初始化标签
	//初始化标签
    var artTags = $('#article_tags');
    artTags.tagEditor({
        placeholder: '添加标签...',
        onChange: function(field, editor, tags) {
        	if(tags.length > 5){
        		layer.msg('不能超过5个标签!', {time:800})
            	artTags.tagEditor('removeTag', tags[5]);
            }
        }
    });
	
	//添加自定义菜单
	// 获取 wangEditor 构造函数和 jquery
    var E = window.wangEditor;

    // 用 createMenu 方法创建菜单
    E.createMenu(function (check) {
        // 定义菜单id，不要和其他菜单id重复。编辑器自带的所有菜单id，可通过『参数配置-自定义菜单』一节查看
        var menuId = 'save';
        // check将检查菜单配置（『参数配置-自定义菜单』一节描述）中是否该菜单id，如果没有，则忽略下面的代码。
        if (!check(menuId))
            return;

        // this 指向 editor 对象自身
        var editor = this;

        // 创建 menu 对象
        var menu = new E.Menu({
            editor: editor,  // 编辑器对象
            id: menuId,  // 菜单id
            title: '保存', // 菜单标题

            // 正常状态和选中装下的dom对象，样式需要自定义
            $domNormal: $('<a href="#" tabindex="-1" id="save-btn" style="color:#FFF;">保存</a>'),
            $domSelected: $('<a href="#" tabindex="-1" class="selected">保存中</i></a>')
        });

        // 菜单正常状态下，点击将触发该事件
        menu.clickEvent = function (e) {
        	location.href = '/art/save.json';
        };
        // 增加到editor对象中
        editor.menus[menuId] = menu;
    });

	var editor = new wangEditor('editor_01');
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
    	'fullscreen',
    	'|',
    	'save'
     ];
	 editor.create();
	 //编辑器保存菜单的位置修改，靠右
	$('.menu-group:last').css({'float':'right','borderRight':0,'padding':0,'background':'#FF766C'}).find('.menu-item').width('60px');
})();