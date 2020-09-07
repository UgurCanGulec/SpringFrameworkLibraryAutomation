<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE HTML>
<html>

<head>
    <script type="text/javascript">
        if ((${hataDurum})) {
            window.alert("Yanlış kullanıcı adı ya parola..");
        }
    </script>
    <title>Giriş</title>
    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Tool Sign In Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta-Tags -->
    <!-- Stylesheets -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
    <!--// Stylesheets -->
    <!--fonts-->
    <link href="//fonts.googleapis.com/css?family=Poiret+One&amp;subset=cyrillic,latin-ext" rel="stylesheet">
    <!--//fonts-->

</head>
<body>
<h1>Giriş</h1>
<div class="w3ls-login box box--big">
    <!-- form starts here -->
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="agile-field-txt">
            <label> Kullanıcı Adı</label>
            <input type="text" onkeypress="return event.charCode>=48&&event.charCode<=57" name="kullaniciID"  placeholder="Kullanıcı adınızı giriniz." required="" />
        </div>
        <div class="agile-field-txt">
            <label> Parola</label>
            <input type="password" name="kullaniciParola" placeholder="Parolanızı giriniz." required="" id="myInput" />
            <div class="agile_label">
                <input id="check3" name="check3" type="checkbox" value="show password" onclick="myFunction()">
                <label class="check" for="check3">Parolamı göster</label>
            </div>
            <div class="agile-right">
                <a href="${pageContext.request.contextPath}/register">Kaydol</a>
            </div>
        </div>
        <!-- script for show password -->
        <script>
            function myFunction() {
                var x = document.getElementById("myInput");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>
        <!-- //end script -->
        <div class="w3ls-bot">
            <div class="switch-agileits">
            </div>
        </div>
        <input type="submit"  value="Giriş Yap">
    </form>

</div>

<!-- //form ends here -->
<!--copyright-->
<div class="copy-wthree">
</div>
<!--//copyright-->
</body>
</html>