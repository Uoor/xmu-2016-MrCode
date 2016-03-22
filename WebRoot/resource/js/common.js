/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var browser = {
    versions: function() {
        var u = navigator.userAgent, app = navigator.appVersion;
        return {//移动终端浏览器版本信息
            trident: u.indexOf('Trident') > -1, //IE内核
            presto: u.indexOf('Presto') > -1, //opera内核
            webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
            //mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
            mobile: u.indexOf('Mobile') > -1,
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器
            iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
            iPad: u.indexOf('iPad') > -1, //是否iPad
            webApp: u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
            weixinApp: u.indexOf('Version') > -1 //微信安卓客户端
        };
    }(),
    language: (navigator.browserLanguage || navigator.language).toLowerCase()
};

function getQueryStringByName(name) {
    var result = location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
    if (result == null || result.length < 1) {
        return "";
    }
    return result[1];
}

$(function() {
    /*判断手机浏览器,是否开通一键拨号*/
    $("a[href^='tel']").click(function() {
        if (browser.versions.mobile) {
            if (browser.versions.weixinApp) {
                var tel = $(this).attr('href').substring(4);
                //alert('请手动拨打电话：' + tel);
                //return false;
            }
        } else { // if (browser.versions.webApp)
            alert('请使用手机访问！');
            return false;
        }
    });

    /*右侧弹出列表*/
    $(".header a.links").toggle(function() {
        $(".sidebar").stop(true).css({"display": "block", "z-index": "99999"});
        $(".sidebar").stop(true).animate({"right": "0%"});
        function show() {
            $(".bj").stop(true).css({"z-index": "2", "display": "block"});
            $(".bj").stop(true).animate({"opacity": "0.6"});
        }
        setTimeout(show, 300);
    }, function() {
        $(".sidebar").stop(true).animate({"right": "-50%"});
        function show() {
            $(".bj").stop(true).animate({"opacity": "0"});
            $(".sidebar").stop(true).css({"display": "none"});
            $(".sidebar").stop(true).css({"z-index": "999"});
        }
        setTimeout(show, 300);
        $(".bj").stop(true).css({"display": "none"});
    }
    );

    /*联系方式弹出列表*/
    $(".header a.contect").toggle(function() {
        $(".touch").stop(true).show(300);
        function show() {
            $(".bj").stop(true).css({"z-index": "8", "display": "block"});
            $(".bj").stop(true, false).animate({"opacity": "0.6"});
            $(".touch").stop(true).css({"opacity": "1"});
        }
        setTimeout(show, 300);

    }, function() {
        $(".touch").stop(true).hide(300);
        function show() {
            $(".bj").stop(true, false).animate({"opacity": "0"});
        }
        setTimeout(show, 300);
        $(".bj").stop(true).css({"display": "none"});
    });

    $(".bj").click(function() {
        if ($(".touch").is(":visible")) {
            $(".touch").stop(true).hide(300);
            function show() {
                $(".bj").stop(true, false).animate({"opacity": "0"});

            }
            setTimeout(show, 300);
            $(".bj").stop(true).css({"display": "none"});
        }
        else if ($(".sidebar").is(":visible")) {
            $(".sidebar").stop(true).animate({"right": "-50%"});
            function a() {
                $(".bj").stop(true).animate({"opacity": "0"});
                $(".bj").stop(true).css({"display": "none"});
            }
            setTimeout(a, 300);
            $(".bj").stop(true).css({"display": "none"});
        }
    });

    $("a.back").click(function() {
        if (window.history.length <= 1) {
            window.location.href = 'index.php@g=Wap&m=Index&a=index&token=' + getQueryStringByName("token");
        } else {
            window.history.back();
        }
    });
});