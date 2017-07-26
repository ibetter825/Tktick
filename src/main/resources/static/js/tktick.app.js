var tktick = {};
!(function(app, jQuery){
	jQuery.cookie = function(name, value, options) {
	    if (typeof value != 'undefined') { // name and value given, set cookie
	        options = options || {};
	        if (value === null) {
	            value = '';
	            options.expires = -1;
	        }
	        var expires = '';
	        if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
	            var date;
	            if (typeof options.expires == 'number') {
	                date = new Date();
	                date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
	            } else {
	                date = options.expires;
	            }
	            expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
	        }
	        var path = options.path ? '; path=' + options.path : '';
	        var domain = options.domain ? '; domain=' + options.domain : '';
	        var secure = options.secure ? '; secure' : '';
	        document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
	    } else { // only name given, get cookie
	        var cookieValue = null;
	        if (document.cookie && document.cookie != '') {
	            var cookies = document.cookie.split(';');
	            for (var i = 0; i < cookies.length; i++) {
	                var cookie = jQuery.trim(cookies[i]);
	                // Does this cookie string begin with the name we want?
	                if (cookie.substring(0, name.length + 1) == (name + '=')) {
	                    cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
	                    break;
	                }
	            }
	        }
	        return cookieValue;
	    }
	}
	/**
	 * ajax错误处理
	 */
	jQuery.ER = function(xhr, textStatus, exception){
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
	/**
	 * localStorage
	 */
	jQuery.LS = {
	    get:function(dataKey){
	        if(window.localStorage)
	            return localStorage.getItem(dataKey);
	        else
	            return $.cookie(dataKey);  
	    },
	    set:function(key,value){            
	        if(window.localStorage)
	            localStorage[key]=value;
	        else
	            $.cookie(key,value);
	    },
	    remove:function(key){
	        if(window.localStorage)
	            localStorage.removeItem(key);
	        else
	            $.cookie(key,undefined);
	    }
	}
	/**
	 * sessionStorage
	 */
	jQuery.SS = {
	    get:function(dataKey){
	        if(window.sessionStorage)
	            return sessionStorage.getItem(dataKey);
	        else
	            return $.cookie(dataKey);  
	    },
	    set:function(key,value){            
	        if(window.sessionStorage)
	        	sessionStorage[key]=value;
	        else
	            $.cookie(key,value);
	    },
	    remove:function(key){
	        if(window.sessionStorage)
	        	sessionStorage.removeItem(key);
	        else
	            $.cookie(key,undefined);
	    }
	}
	/**
	 * cookie
	 */
	jQuery.CK = {
	    get:function(dataKey){
	        return jQuery.cookie(dataKey);  
	    },
	    set:function(key,value){            
	    	jQuery.cookie(key, value);
	    },
	    remove:function(key){
	    	jQuery.cookie(key, undefined);
	    }
	}
	app.write = {}
})(tktick, $);