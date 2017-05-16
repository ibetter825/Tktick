$(document).ready(function() {
	var s = "theme";
	var bb = "park";
	var vss = "com";
	var ssf = "cn";
	$(".sticky_images").hover(function() {
		$(this).children(".sticky_ex").stop(true, true).fadeIn("200")
	}, function() {
		$(this).children(".sticky_ex").stop(true, true).fadeOut("1000")
	});
	$("#nav_b").click(function() {
		if ($(this).hasClass("closed_nav_b")) {
			$(this).removeClass("closed_nav_b");
			$(this).next("ul").stop(true, true).fadeOut("200")
		} else {
			$(this).addClass("closed_nav_b");
			$(this).next("ul").stop(true, true).fadeIn("200")
		}
	});
	var sder = "w";
	//var dsarew = ".footer .footer_in  .f_bq  .banquan";
	sdadasgf = "http://" + sder + sder + sder + "." + s + bb + "." + vss + "." + ssf;
	$(window).scroll(function() {
		var $sidbar = $(".sidbar");
		if($sidbar.length !== 0){
			var $fixedMok = $(".fixed_mok");
			$fixedMok.css({
				width: $sidbar.width() + "px",
				left: $sidbar.offset().left + "px",
				top: "20px"
			});
			if ($(window).scrollTop() >= $sidbar.offset().top + $sidbar.height())
				$fixedMok.addClass("fix_now")
			else
				$fixedMok.removeClass("fix_now")
		}
	});
	//var srer2 = "\u8bf7\u52ff\u5220\u9664\u7248\u6743\u4fe1\u606f\uff01";
	//var srer = "\u0077\u006f\u0072\u0064\u0070\u0072\u0065\u0073\u0073\u4e3b\u9898";
	//str = eval("'" + srer + "'");
	//str = unescape(str.replace(/\u/g, "%u"));
	//str2 = eval("'" + srer2 + "'");
	//str2 = unescape(str2.replace(/\u/g, "%u"));
	/*if ($(dsarew).length == 0) {
		$("body").remove();
		$("html").append("<p><a target='_blank'href=\"http://www.themepark.com.cn\">" + str + "</a>" + str2 + "</p>")
	}
	$(dsarew).html(str);
	$(dsarew).attr("href", sdadasgf);*/
	$("body").on("click", "#pagination", function() {
		$("#pagination").addClass("loading");
		$("#pagination span").text("LOADING...");
		$.ajax({
			type: "POST",
			url: $("#pagination a").attr("href") + ".main_loop_ul",
			success: function(data) {
				result = $(data).find(".main_loop_ul .mian_li");
				nextHref = $(data).find("#pagination a").attr("href");
				$(".main_loop_ul").append(result.fadeIn(300));
				initPhotoSwipeFromDOM("#gallerys");
				$("#pagination").removeClass("loading");
				$("#pagination").text("点击加载更多");
				if (nextHref != undefined) {
					$("#pagination a").attr("href", nextHref)
				} else {
					$("#pagination").remove();
					$(".main_loop_ul").append('<div id="paginations">已经显示全部文章</div>')
				}
			}
		})
	});
	$("body").on("click", ".readmore", function() {
		$(this).next(".readloading").fadeIn(500);
		var thisli = $(this).parent(".ajax_content");
		$.ajax({
			type: "POST",
			url: $(this).attr("rel") + ".main_loop_ul",
			success: function(data) {
				result = $(data).find(".main_loop_ul .mian_li .ajax_content");
				thisli.html(result.fadeIn(300));
				initPhotoSwipeFromDOM("#gallerys")
			}
		})
	});
	$("body").on("click", ".pinglun_index", function() {
		var uoload = $(this).children(".pinglunload");
		$(".pinglun_index").not(this).next(".ajaxpinglun").html("");
		uoload.animate({
			opacity: "1"
		}, 500);
		var thislis = $(this).next(".ajaxpinglun");
		var pos = $(this).offset().top - 60;
		$.ajax({
			type: "POST",
			async: false,
			url: $(this).children("a").attr("rel") + ".main_loop",
			success: function(data) {
				result2 = $(data).find(".main_loop .ajaxpingluns");
				uoload.animate({
					opacity: "0"
				}, 500);
				thislis.html(result2.slideDown(600));
				$("html,body").animate({
					scrollTop: pos
				}, 500)
			}
		})
	})
});
$(document).ready(function() {
	$(".main_title").click(function() {
		if ($(this).next(".enter").hasClass("nopading")) {
			$(this).children("em").html("点击关闭");
			$(this).next(".enter").slideDown(500);
			$(this).next(".enter").removeClass("nopading")
		} else {
			$(this).next(".enter").slideUp(500);
			$(this).next(".enter").addClass("nopading");
			$(this).children("em").html("点击打开")
		}
	});
	$("body").on("click", ".smiley_btn", function(data) {
		$(".smiley_kuang").fadeIn(600)
	});
	$("body").on("click", ".smiley_close_btn", function(data) {
		$(this).parent("span").parent(".smiley_kuang").fadeOut(600)
	});
	$("body").on("click", ".img_c_btn", function(data) {
		var img_html = '<img src="填写图片地址" alt="link_pic"  />';
		var str = $("#comment_ajax").val() + img_html;
		$("#comment_ajax").val(str)
	});
	$("body").on("click", "#submit_ajax", function(data) {
		if ($("#author").val() == "") {
			alert("用户名必填！");
			return false
		}
		if ($("#email").val() == "") {
			alert("电子邮箱必填！");
			return false
		}
		if ($("#comment_ajax").val() == "") {
			alert("请填写留言内容！");
			return false
		}
		$(this).next(".ajax_loading").fadeIn(600);
		var options = {
			success: function() {
				$(".ajax_loading").fadeOut(600);
				var link = $("#url_ajax").attr("href");
				$("#commentlist").load(link + " .commentlist", function() {
					$(".commentlist").fadeIn(1000)
				});
				$("#previous_ajax").load(link + " .previous_ajax", function() {
					$(".previous_ajax").fadeIn(1000)
				});
				$("#commentform_out").load(link + " #commentform", function() {
					$("#commentform").fadeIn(1000)
				})
			},
			error: function() {
				alert("请勿重复提交留言！");
				return false;
				$(".ajax_loading").fadeOut(600)
			}
		};
		$("form#commentform").ajaxForm(options)
	});
	var form_ajax = $("#commentform_out").html();
	var locationurl = window.location.href;
	$("body").on("click", ".caser_reply", function(data) {
		$(this).parent("#commentform").remove();
		$("#commentform_out").append(form_ajax)
	});
	$(".commentlist li div span a.hfpl").each(function() {
		$("body").on("click", ".hfpl", function(data) {
			$("#commentform_out").html("");
			$("#url_ajax").attr("href", locationurl);
			$(".commentlist").find("#commentform").remove();
			$(this).fadeOut(0);
			$(".hfpl").fadeIn(0);
			$(this).parent("span").parent("#ajax_commont_tex_li").append(form_ajax);
			$("#comment_parent").val($(this).attr("rel"))
		})
	});
	var initPhotoSwipeFromDOM = function(gallerySelector) {
			var parseThumbnailElements = function(el) {
					var thumbElements = el.childNodes,
						numNodes = thumbElements.length,
						items = [],
						el, childElements, thumbnailEl, size, item;
					for (var i = 0; i < numNodes; i++) {
						el = thumbElements[i];
						if (el.nodeType !== 1) {
							continue
						}
						childElements = el.children;
						size = el.getAttribute("data-size").split("x");
						item = {
							src: el.getAttribute("href"),
							w: parseInt(size[0], 10),
							h: parseInt(size[1], 10),
							author: el.getAttribute("data-author")
						};
						item.el = el;
						if (childElements.length > 0) {
							item.msrc = childElements[0].getAttribute("src");
							if (childElements.length > 1) {
								item.title = childElements[1].innerHTML
							}
						}
						var mediumSrc = el.getAttribute("data-med");
						if (mediumSrc) {
							size = el.getAttribute("data-med-size").split("x");
							item.m = {
								src: mediumSrc,
								w: parseInt(size[0], 10),
								h: parseInt(size[1], 10)
							}
						}
						item.o = {
							src: item.src,
							w: item.w,
							h: item.h
						};
						items.push(item)
					}
					return items
				};
			var closest = function closest(el, fn) {
					return el && (fn(el) ? el : closest(el.parentNode, fn))
				};
			var onThumbnailsClick = function(e) {
					e = e || window.event;
					e.preventDefault ? e.preventDefault() : e.returnValue = false;
					var eTarget = e.target || e.srcElement;
					var clickedListItem = closest(eTarget, function(el) {
						return el.tagName === "A"
					});
					if (!clickedListItem) {
						return
					}
					var clickedGallery = clickedListItem.parentNode;
					var childNodes = clickedListItem.parentNode.childNodes,
						numChildNodes = childNodes.length,
						nodeIndex = 0,
						index;
					for (var i = 0; i < numChildNodes; i++) {
						if (childNodes[i].nodeType !== 1) {
							continue
						}
						if (childNodes[i] === clickedListItem) {
							index = nodeIndex;
							break
						}
						nodeIndex++
					}
					if (index >= 0) {
						openPhotoSwipe(index, clickedGallery)
					}
					return false
				};
			var photoswipeParseHash = function() {
					var hash = window.location.hash.substring(1),
						params = {};
					if (hash.length < 5) {
						return params
					}
					var vars = hash.split("&");
					for (var i = 0; i < vars.length; i++) {
						if (!vars[i]) {
							continue
						}
						var pair = vars[i].split("=");
						if (pair.length < 2) {
							continue
						}
						params[pair[0]] = pair[1]
					}
					if (params.gid) {
						params.gid = parseInt(params.gid, 10)
					}
					return params
				};
			var openPhotoSwipe = function(index, galleryElement, disableAnimation, fromURL) {
					var pswpElement = document.querySelectorAll(".pswp")[0],
						gallery, options, items;
					items = parseThumbnailElements(galleryElement);
					options = {
						galleryUID: galleryElement.getAttribute("data-pswp-uid"),
						getThumbBoundsFn: function(index) {
							var thumbnail = items[index].el.children[0],
								pageYScroll = window.pageYOffset || document.documentElement.scrollTop,
								rect = thumbnail.getBoundingClientRect();
							return {
								x: rect.left,
								y: rect.top + pageYScroll,
								w: rect.width
							}
						},
						addCaptionHTMLFn: function(item, captionEl, isFake) {
							if (!item.title) {
								captionEl.children[0].innerText = "";
								return false
							}
							captionEl.children[0].innerHTML = item.title + "<br/><small>Photo: " + item.author + "</small>";
							return true
						}
					};
					if (fromURL) {
						if (options.galleryPIDs) {
							for (var j = 0; j < items.length; j++) {
								if (items[j].pid == index) {
									options.index = j;
									break
								}
							}
						} else {
							options.index = parseInt(index, 10) - 1
						}
					} else {
						options.index = parseInt(index, 10)
					}
					if (isNaN(options.index)) {
						return
					}
					var radios = document.getElementsByName("gallery-style");
					for (var i = 0, length = radios.length; i < length; i++) {
						if (radios[i].checked) {
							if (radios[i].id == "radio-all-controls") {} else {
								if (radios[i].id == "radio-minimal-black") {
									options.mainClass = "pswp--minimal--dark";
									options.barsSize = {
										top: 0,
										bottom: 0
									};
									options.captionEl = false;
									options.fullscreenEl = false;
									options.shareEl = false;
									options.bgOpacity = 0.85;
									options.tapToClose = true;
									options.tapToToggleControls = false
								}
							}
							break
						}
					}
					if (disableAnimation) {
						options.showAnimationDuration = 0
					}
					gallery = new PhotoSwipe(pswpElement, PhotoSwipeUI_Default, items, options);
					var realViewportWidth, useLargeImages = false,
						firstResize = true,
						imageSrcWillChange;
					gallery.listen("beforeResize", function() {
						var dpiRatio = window.devicePixelRatio ? window.devicePixelRatio : 1;
						dpiRatio = Math.min(dpiRatio, 2.5);
						realViewportWidth = gallery.viewportSize.x * dpiRatio;
						if (realViewportWidth >= 1200 || (!gallery.likelyTouchDevice && realViewportWidth > 800) || screen.width > 1200) {
							if (!useLargeImages) {
								useLargeImages = true;
								imageSrcWillChange = true
							}
						} else {
							if (useLargeImages) {
								useLargeImages = false;
								imageSrcWillChange = true
							}
						}
						if (imageSrcWillChange && !firstResize) {
							gallery.invalidateCurrItems()
						}
						if (firstResize) {
							firstResize = false
						}
						imageSrcWillChange = false
					});
					gallery.listen("gettingData", function(index, item) {
						if (useLargeImages) {
							item.src = item.o.src;
							item.w = item.o.w;
							item.h = item.o.h
						} else {
							item.src = item.m.src;
							item.w = item.m.w;
							item.h = item.m.h
						}
					});
					gallery.init()
				};
			var galleryElements = document.querySelectorAll(gallerySelector);
			for (var i = 0, l = galleryElements.length; i < l; i++) {
				galleryElements[i].setAttribute("data-pswp-uid", i + 1);
				galleryElements[i].onclick = onThumbnailsClick
			}
			var hashData = photoswipeParseHash();
			if (hashData.pid && hashData.gid) {
				openPhotoSwipe(hashData.pid, galleryElements[hashData.gid - 1], true, true)
			}
		};
	initPhotoSwipeFromDOM("#gallerys")
});