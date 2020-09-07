<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
    <title>Update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/css/style3.css" rel='stylesheet' type='text/css' />
    <!-- Graph CSS -->
    <link href="${pageContext.request.contextPath}/css/lines.css" rel='stylesheet' type='text/css' />
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!----webfonts--->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
    <!---//webfonts--->
    <!-- Nav CSS -->
    <link href="${pageContext.request.contextPath}/css/custom.css" rel="stylesheet">
    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/custom.js"></script>
</head>
<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Kütüphane</a>
        </div>
        <!-- /.navbar-header -->
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="${pageContext.request.contextPath}/images/logo.png" alt=""><span class="badge"></span></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-menu-header text-center">
                        <strong>${adminBilgi.kulllaniciIsimSoyisim}</strong>
                    </li>
                    <li class="dropdown-menu-header text-center">
                        <strong>Hesap</strong>
                    </li>

                    <li class="m_2"><a href="#" data-toggle="modal" data-target="#Modal1"><i class="fa fa-user"></i> Profil</a></li>
                    <li class="m_2"><a href="#"><i class="fa fa-wrench"></i> Ayarlar</a></li>
                    <li class="divider"></li>
                    <li class="m_2"><a href="${pageContext.request.contextPath}/home" onclick="return confirm('Çıkış işlemini onaylıyor musunuz ?')"><i class="fa fa-lock"></i>  Çıkış</a></li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-right">
            <input type="text" class="form-control" value="Ara..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}">
        </form>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">

                    <li>
                        <a href="#"><i class="fa fa-laptop nav_icon"></i>Ana Sayfa<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#" onclick="goBack()" data-toggle="modal" data-target="#Modal2">Ana Sayfaya Git</a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>

                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <div class="graphs">
            <div class="xs">
                <h3 style="margin-left:75px">Yayınevi Güncelle</h3>
                <div class="tab-content">
                    <div class="tab-pane active" id="horizontal-form">
                        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/register_publisher">
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Yayınevi ID</label>
                                <div class="col-sm-8">
                                    <input type="number" name="yayineviID" value="${yayineviBilgi.yayineviID}" aria-disabled="false" class="form-control1">
                                </div>
                                <div class="col-sm-2">
                                    <p class="help-block">Bu alanı güncellemek önerilmez!</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Yayınevi Adı</label>
                                <div class="col-sm-8">
                                    <input type="text" name="yayineviAdi"  value="${yayineviBilgi.yayineviAdi}"  class="form-control1" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Yayınevi Şehri</label>
                                <div class="col-sm-8">
                                    <input type="text" name="yayineviSehri" value="${yayineviBilgi.yayineviSehri}"  class="form-control1"  >
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Yayınevi Mail Adresi</label>
                                <div class="col-sm-8">
                                    <input type="email" name="yayineviMail" value="${yayineviBilgi.yayineviMail}" class="form-control1"  >
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">Yayınevi Telefon Numarası</label>
                                <div class="col-sm-8">
                                    <input type="text" name="yayineviTelefon" value="${yayineviBilgi.yayineviTelefon}" class="form-control1" >
                                </div>
                            </div>
                            <button style="margin-left: 183px" type="submit" onclick="return confirm('Güncelleme işlemini onaylayın ?')"
                                    class="btn btn-primary">Güncelle</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
