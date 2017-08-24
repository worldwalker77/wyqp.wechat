<!DOCTYPE html>
<!-- saved from url=(0028)http://mcdown.xixiqipai.com/ -->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>万友游戏</title>
    <script src="${contextPath}/resources/js/jquery/jquery.min.js"></script>
    <script>
        // 是否是安卓
        function isAndroid() {
            var u = navigator.userAgent;
            if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) { //安卓手机
                return true;
            }
            return false;
        }

        function isIOS() {
            var u = navigator.userAgent;
            var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
            return isiOS;
        }
        function isRunOnWeChat() {
            var ua = navigator.userAgent.toLowerCase();
            if (ua.match(/MicroMessenger/i) == "micromessenger") {
                return true;
            } else {
                return false;
            }
        }
        $(document).ready(function () {
            initialize();
            function initialize() {
                if (true == isIOS()) {
                    $('#download-tip').removeClass("common-hide");
                    $('.common-ios').removeClass('common-hide');
                } else if (true == isAndroid()) {
                    $('.common-android').removeClass('common-hide');
                } else {
                    $('.common-pc').removeClass('common-hide');
                }
                // 如果在微信中打开，直接弹遮罩
                if (true == isRunOnWeChat()) {
                }
            }
            $('#download-ios').on('click', function (e) {
                if (true == isRunOnWeChat()) {
                    e.preventDefault();
                    $('#mask').removeClass("common-hide");
                }
            });
            $('#download-pc').on('click', function () {
                alert("在手机中浏览器中打开点击“立即下载”，将会自动下载安装包。");
            });
            $('#mask').on('click', function () {
                //$('#mask').addClass("common-hide");
            });
        });
    </script>
    <style>
        * { margin: 0; padding: 0; }
        *, :before, :after { -webkit-box-sizing: border-box; box-sizing: border-box; }
        html, body { background: rgb(255, 240, 189); font-family: "Microsoft YaHei" !important; text-align: center; }
        a { background-color: transparent; }
        a:focus { outline: none; }
        a:active, a:hover { outline: none; }
        a, button, input { -webkit-tap-highlight-color: rgba(255,0,0,0); }
        img { -webkit-box-sizing: border-box; box-sizing: border-box; vertical-align: middle; border: 0; }
        .wimg{width:100%;display:block;}
        .hp { }
        .fr{float:right;}
        .common-center {  }
        .hp-head { position: relative; text-align: center; background: #fff; background: url(img/xixi_topdh.png) no-repeat center top; margin: 0 auto; width: 100%px; min-height: 60px; _height: 60px; }
        .hp-head img { width: 258px; height: 60px; }
        .hp-desc { padding-top: 24px; padding-bottom: 24px; text-align: center; }
        .hp-desc-title { color: #ff0000; font-size: 20px; padding-top: 5px; margin-bottom: 10px; font-weight: bold; }
        .hp-desc-detail { font-size: 13px; color: #5a5a5a; margin-bottom: 1px; }
        .hp-desc-logo { }
        .hp-desc-logo1 { }
        .hp-download { }
        .hp-download-btn { }
        .hp-mask { }
        .hp-mask-background { position: fixed; top: 0; left: 0; right: 0; bottom: 0; background: #000; opacity: 0.6; }
        .hp-mask-instruction { position: fixed; top: 6px; right: 8px; width: 200px; height: 137px; }
        .hp-guid { }
        .hp-guid img { max-width: 300px; display: block; margin-top: 16px; }
        .hp-guid-title { margin-top: 10px; color: #ffa323; font-size: 15px; margin-top: 10px; margin-bottom: 10px; }
        .btn_op{position:relative;text-align:left;}
        .btn_download_box{position:absolute;width:100%;left:0; top:50%; transform: translateY(-50%); -moz-transform: translateY(-50%); -ms-transform: translateY(-50%); -webkit-transform: translateY(-50%); }
        .hp-download-download{display:inline-block;width:40%;margin-left:6.4%;float:left;}
        .hp-download-download img{width:100%;}
        .common-hide { display: none; }
    </style>
</head>
<body>
    <div><img src="/resources/img/ga_01.jpg" class="wimg" /></div>
    <div><img src="/resources/img/ga_02.jpg" class="wimg" /></div>
    <div class="btn_op">
        <img src="/resources/img/ga_03.jpg" class="wimg" />
        <div class="btn_download_box">
            <!-- android下载链接 -->
            <a class="common-android hp-download-download common-hide" href="http://fir.im/3z1x">
                <img id="download-android" class="common-center hp-download-btn" src="/resources/img/anzhuo_down.png">
            </a>
            <a class="common-android hp-download-download common-hide" href="http://fir.im/rzba">
                <img id="download-ios" class="common-center hp-download-btn" src="/resources/img/ios_down1.png">
            </a>
            <!-- ios下载链接 -->
            <a class="common-ios hp-download-download common-hide" href="http://fir.im/rzba">
                <img id="download-ios" class="common-center hp-download-btn" src="/resources/img/ios_down.png">
            </a>
            <a class="common-ios hp-download-download common-hide" href="http://fir.im/rzba">
                <img id="download-android" class="common-center hp-download-btn" src="/resources/img/anzhuo_down1.png">
            </a>
            <!-- pc下载链接  sdfsd -->
            <a class="hp-download-download" href="http://fir.im/3z1x">
                <img id="download-pc" class="common-center common-pc hp-download-btn" src="/resources/img/anzhuo_down.png">
            </a>
            <a class="hp-download-download" href="http://fir.im/rzba">
                <img id="download-pc" class="common-center common-pc hp-download-btn" src="/resources/img/ios_down.png">
            </a>
        </div>
    </div>
    <div><img src="/resources/img/ga_04.jpg" class="wimg" /></div>
    <div><img src="/resources/img/ga_05.jpg" class="wimg" /></div>
    <section id="mask" class="common-hide hp-mask">
        <div class="hp-mask-background"></div>
        <img class="hp-mask-instruction" src="/resources/img/instruction.png">
    </section>
    <div align="center"><!--<a href="http://www.cnzz.com/stat/website.php?web_id=2688391" target="_blank" title="站长统计">站长统计</a>--></div>
    <div id="cli_dialog_div"></div>
</body>
</html>