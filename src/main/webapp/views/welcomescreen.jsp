<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>Hoşgeldiniz</title>
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
                        <h5>Merhaba ${kullaniciAd}</h5>
                        <h3>Hesabınız Oluşturuldu.</h3>
                        <p>Hoşgeldiniz ${kullaniciAd}...
                        Giriş yaparken kullanacağınız Kullanıcı Adınız : ${kullaniciID}</p>
                        <a href="${pageContext.request.contextPath}/home" class="read-more-1 btn">HADİ BAŞLAYALIM</a>
                    </div>

                </div>
            </div>
            <div class="form-left">
                <div class="middle">
                    <h4>Aramıza Hoşgeldiniz...</h4>
                </div>
                <form action="${pageContext.request.contextPath}/register" method="get" class="signin-form">
                    <div class="form-input">
                        <label>İsim-Soyisim</label>
                        <input type="text" name="kullaniciIsimSoyisim" disabled="disabled" placeholder="İsminiz-Soyisminiz" required="" />
                    </div>
                    <div class="form-input">
                        <label>Email</label>
                        <input type="email" name="kullaniciEmail" disabled="disabled" placeholder="Email adresiniz" required=""/>
                    </div>
                    <div class="form-input">
                        <label>Parola</label>
                        <input type="password" name="kullaniciParola" disabled="disabled" placeholder="Parolanız" required="" />
                    </div>
                    <div class="form-input">
                        <label>Telefon</label>
                        <input type="text" name="kullaniciTelefon" disabled="disabled" placeholder="Telefon numaranız" required="" />
                    </div>
                    <button type="submit" class="btn">Sayfaya Git</button>
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