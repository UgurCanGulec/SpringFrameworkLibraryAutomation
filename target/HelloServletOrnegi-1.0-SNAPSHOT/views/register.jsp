<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Kaydol</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords"
          content="Invent Signup Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta tag Keywords -->
    <!--/Style-CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style2.css" type="text/css" media="all" />
    <!--//Style-CSS -->
</head>

<body>
<!-- /login-section -->
<section class="w3l-login-6">
    <div class="login-hny">
        <div class="form-content">
            <div class="form-right">
                <div class="overlay">
                    <div class="grid-info-form">
                        <h3>Hesabınızı Oluşturun</h3>
                        <a href="${pageContext.request.contextPath}/home" class="read-more-1 btn">HADİ BAŞLAYALIM</a>
                    </div>

                </div>
            </div>
            <div class="form-left">
                <div class="middle">
                    <h4>Bize Katılın</h4>
                </div>
                <form action="${pageContext.request.contextPath}/register" method="post" class="signin-form">
                    <div class="form-input">
                        <label>İsim-Soyisim</label>
                        <input type="text" name="kullaniciIsimSoyisim" placeholder="İsminiz-Soyisminiz" required="" />
                    </div>
                    <div class="form-input">
                        <label>Email</label>
                        <input type="email" name="kullaniciEmail" placeholder="Email adresiniz" required=""/>
                    </div>
                    <div class="form-input">
                        <label>Parola</label>
                        <input type="password" name="kullaniciParola" placeholder="Parolanız" required="" />
                    </div>
                    <div class="form-input">
                        <label>Telefon</label>
                        <input type="text" name="kullaniciTelefon" placeholder="Telefon numaranız" required="" />
                    </div>

                    <label class="container">Bilgilerimin doğruluğunu kabul ediyorum.
                        <input type="checkbox">
                        <span class="checkmark"></span>
                    </label>
                    <button type="submit" class="btn">Hesap Oluştur</button>
                </form>
                <div class="copy-right text-center">
                </div>
            </div>

        </div>

    </div>
</section>
<!-- //login-section -->
</body>

</html>