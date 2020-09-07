<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>

    <script>
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
    <script type="text/javascript">
        var alerted = localStorage.getItem('alerted') || '';
        if (alerted != 'yes') {
            alert("Hoşgeldiniz ${adminBilgi.kulllaniciIsimSoyisim}");
            localStorage.setItem('alerted','yes');
        }
    </script>
    <title>Admin</title>
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
                        <a href="#"><i class="fa fa-laptop nav_icon"></i>İşlemler<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#Modal4" data-toggle="modal">Kitap Kaydı Oluştur</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="modal" data-target="#Modal2">Yayınevi Kaydı Oluştur</a>

                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>

                    <li>
                        <a href="#"><i class="fa fa-table nav_icon"></i>Tablolar<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#Modal5" data-toggle="modal">Kitap Kayıtları</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="modal" data-target="#Modal3">Yayınevi Kayıtları</a>
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
            <div class="col_3">
                <div class="clearfix"> </div>
            </div>
            <div class="col_1">
                <div class="col-md-4 span_7">
                    <div class="cal1 cal_2"><div class="clndr"><div class="clndr-controls"><div class="clndr-control-button"><p class="clndr-previous-button">previous</p></div><div class="month">July 2015</div><div class="clndr-control-button rightalign"><p class="clndr-next-button">next</p></div></div><table class="clndr-table" border="0" cellspacing="0" cellpadding="0"><thead><tr class="header-days"><td class="header-day">S</td><td class="header-day">M</td><td class="header-day">T</td><td class="header-day">W</td><td class="header-day">T</td><td class="header-day">F</td><td class="header-day">S</td></tr></thead><tbody><tr><td class="day adjacent-month last-month calendar-day-2015-06-28"><div class="day-contents">28</div></td><td class="day adjacent-month last-month calendar-day-2015-06-29"><div class="day-contents">29</div></td><td class="day adjacent-month last-month calendar-day-2015-06-30"><div class="day-contents">30</div></td><td class="day calendar-day-2015-07-01"><div class="day-contents">1</div></td><td class="day calendar-day-2015-07-02"><div class="day-contents">2</div></td><td class="day calendar-day-2015-07-03"><div class="day-contents">3</div></td><td class="day calendar-day-2015-07-04"><div class="day-contents">4</div></td></tr><tr><td class="day calendar-day-2015-07-05"><div class="day-contents">5</div></td><td class="day calendar-day-2015-07-06"><div class="day-contents">6</div></td><td class="day calendar-day-2015-07-07"><div class="day-contents">7</div></td><td class="day calendar-day-2015-07-08"><div class="day-contents">8</div></td><td class="day calendar-day-2015-07-09"><div class="day-contents">9</div></td><td class="day calendar-day-2015-07-10"><div class="day-contents">10</div></td><td class="day calendar-day-2015-07-11"><div class="day-contents">11</div></td></tr><tr><td class="day calendar-day-2015-07-12"><div class="day-contents">12</div></td><td class="day calendar-day-2015-07-13"><div class="day-contents">13</div></td><td class="day calendar-day-2015-07-14"><div class="day-contents">14</div></td><td class="day calendar-day-2015-07-15"><div class="day-contents">15</div></td><td class="day calendar-day-2015-07-16"><div class="day-contents">16</div></td><td class="day calendar-day-2015-07-17"><div class="day-contents">17</div></td><td class="day calendar-day-2015-07-18"><div class="day-contents">18</div></td></tr><tr><td class="day calendar-day-2015-07-19"><div class="day-contents">19</div></td><td class="day calendar-day-2015-07-20"><div class="day-contents">20</div></td><td class="day calendar-day-2015-07-21"><div class="day-contents">21</div></td><td class="day calendar-day-2015-07-22"><div class="day-contents">22</div></td><td class="day calendar-day-2015-07-23"><div class="day-contents">23</div></td><td class="day calendar-day-2015-07-24"><div class="day-contents">24</div></td><td class="day calendar-day-2015-07-25"><div class="day-contents">25</div></td></tr><tr><td class="day calendar-day-2015-07-26"><div class="day-contents">26</div></td><td class="day calendar-day-2015-07-27"><div class="day-contents">27</div></td><td class="day calendar-day-2015-07-28"><div class="day-contents">28</div></td><td class="day calendar-day-2015-07-29"><div class="day-contents">29</div></td><td class="day calendar-day-2015-07-30"><div class="day-contents">30</div></td><td class="day calendar-day-2015-07-31"><div class="day-contents">31</div></td><td class="day adjacent-month next-month calendar-day-2015-08-01"><div class="day-contents">1</div></td></tr></tbody></table></div></div>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="span_11">
                <div class="col-md-6 col_4">
                    <!----Calender -------->
                    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/clndr.css" type="text/css" />
                    <script src="${pageContext.request.contextPath}/js/underscore-min.js" type="text/javascript"></script>
                    <script src= "${pageContext.request.contextPath}/js/moment-2.2.1.js" type="text/javascript"></script>
                    <script src="${pageContext.request.contextPath}/js/clndr.js" type="text/javascript"></script>
                    <script src="${pageContext.request.contextPath}/js/site.js" type="text/javascript"></script>
                    <!----End Calender -------->
                </div>
            </div>
            <div class="modal" id="Modal5">
                <div class="modal-dialog" style="width:1250px">
                    <div class="modal-content">
                        <div class="modal-header">
                            <strong class="modal-title">Kitap Kayıtları</strong>
                        </div>
                        <div class="modal-body">
                            <table class="table table-bordered">
                                <tr>
                                    <th>ISBN Numarası</th>
                                    <th>Kitap Adı</th>
                                    <th>Yazarı</th>
                                    <th>Sayfa Sayısı</th>
                                    <th>Tür</th>
                                    <th>Yayınevi</th>
                                    <th>Sil</th>
                                    <th>Güncelle</th>
                                    <th>Detay</th>
                                </tr>
                                <c:forEach items="${kitapList}" var="kitap">
                                <tr>
                                    <td><c:out value="${kitap.kitapISBN}" /></td>
                                    <td><c:out value="${kitap.kitapAdi}" /></td>
                                    <td><c:out value="${kitap.kitapYazari}" /></td>
                                    <td><c:out value="${kitap.kitapSayfa}" /></td>
                                    <td><c:out value="${kitap.kitapTuru}" /></td>
                                    <td><c:out value="${kitap.yayinevi.yayineviAdi}" /></td>
                                    <td><a href="<c:url value="/delete_book/${kitap.kitapISBN}"/>"
                                           class="btn btn-danger" type="submit" onclick="return confirm('Silmek istiyor musunuz ?')">Sil</a></td>
                                    <td><a href="<c:url value="/update_book/${kitap.kitapISBN}"/>" class="btn btn-info">Güncelle</a></td>
                                    <td><a href="<c:url value="/info_book/${kitap.kitapISBN}"/>" class="btn btn-primary">Detay</a></td>
                                </tr>
                                </c:forEach>
                            </table>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Kapat</button>
                        </div>

                    </div>
                </div>

            </div>
            <!-- YayınEvi Tablolarını Görüntüleyen Modal-->

            <div class="modal" id="Modal3">
                <div class="modal-dialog" style="width:1250px">
                    <div class="modal-content">
                        <div class="modal-header">
                            <strong class="modal-title">Yayın Evleri</strong>
                        </div>
                        <div class="modal-body">
                            <table class="table table-bordered">
                                <tr>
                                    <th>Yayınevi ID</th>
                                    <th>Yayınevi Adı</th>
                                    <th>Yayınevi Şehri</th>
                                    <th>Yayınevi Mail Adresi</th>
                                    <th>Yayınevi Telefon Numarası</th>
                                    <th>Sil</th>
                                    <th>Güncelle</th>
                                </tr>
                                <c:forEach items="${yayineviList}" var="yayinevi">
                                    <tr>
                                        <td><c:out value="${yayinevi.yayineviID}" /></td>
                                        <td><c:out value="${yayinevi.yayineviAdi}" /></td>
                                        <td><c:out value="${yayinevi.yayineviSehri}" /></td>
                                        <td><c:out value="${yayinevi.yayineviMail}" /></td>
                                        <td><c:out value="${yayinevi.yayineviTelefon}" /></td>
                                        <td><a href="<c:url value="/delete_publisher/${yayinevi.yayineviID}"/>"
                                               class="btn btn-danger" type="submit" onclick="return confirm('Silmek istiyor musunuz ?')">Sil</a></td>
                                        <td><a href="<c:url value="/update_publisher/${yayinevi.yayineviID}"/>" class="btn btn-info">Güncelle</a></td>
                                    </tr>
                                </c:forEach>

                            </table>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Kapat</button>
                        </div>

                    </div>
                </div>
            </div>
            <!-- YayınEvi Tablolarını Görüntüleyen Modal-->

            <!-- Kitap Kaydı Ekleyen Modal-->
            <div class="modal" id="Modal4">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <strong class="modal-title">Kitap Kaydı Oluştur</strong>
                        </div>
                        <form action="${pageContext.request.contextPath}/register_book" method="post" enctype="multipart/form-data">
                            <div class="modal-body">
                                <label>
                                    Kitap ISBN Numarası:
                                </label>
                                <input type="number" required="" name="kitapISBN" class="form-control1"/>
                                <br/>
                                <label>
                                    Kitap Adı:
                                </label>
                                <input type="text" required="" name="kitapAdi" class="form-control1"/>
                                <br/>
                                <label>
                                    Kitap Yazarı:
                                </label>
                                <input type="text" required="" name="kitapYazari" class="form-control1"/>
                                <br/>
                                <label>
                                    Kitap Sayfa Sayısı:
                                </label>
                                <input type="number" required="" name="kitapSayfa" class="form-control1"/>
                                <br/>
                                <label>
                                    Kitap Türü:
                                </label>
                                <input type="text" required="" name="kitapTuru" class="form-control1"/>
                                <br/>
                                <br/>
                                <label>
                                    Kitap Yayınevi:
                                </label>
                                <br/>
                                <select name="kitapYayineviID" class="form-control1">
                                    <c:forEach items="${yayineviList}" var="kitapYayinevi">
                                        <option value="${kitapYayinevi.yayineviID}">${kitapYayinevi.yayineviAdi}</option>
                                    </c:forEach>
                                </select>
                                <br/>
                                <br/>

                                <label>
                                    Kapak Resmi:
                                </label>
                                <input class="form-control1" type="file" name="kapakResmi"/>

                                <br/>
                                <br/>
                                <button type="submit" class="btn btn-info">Kitap Ekle</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Kapat</button>
                            </div>

                        </form>

                    </div>
                </div>
            </div>

            <!-- Kitap Kaydı Ekleyen Modal-->




            <!-- YayınEvi Eklemeyi Görüntüleyen Modal-->
            <div class="modal" id="Modal2">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-header">
                            <strong class="modal-title">Yayınevi Kaydı Oluştur</strong>
                        </div>
                        <form action="${pageContext.request.contextPath}/register_publisher" method="post">
                            <div class="modal-body">
                                <label>
                                    Yayınevi ID:
                                </label>
                                <input type="number" required="" name="yayineviID" class="form-control1">
                                <br/>
                                <label>
                                    Yayınevi Adı:
                                </label>
                                <input type="text" required="" name="yayineviAdi" class="form-control1">
                                <br/>
                                <label>
                                    Yayınevi Şehri:
                                </label>
                                <input type="text" required="" name="yayineviSehri" class="form-control1">
                                <br/>
                                <label>
                                    Yayınevi Mail Adresi:
                                </label>
                                <input type="email" required="" name="yayineviMail" class="form-control1">
                                <br/>
                                <label>
                                    Yayınevi Telefon Numarası:
                                </label>
                                <input type="text" required="" name="yayineviTelefon" class="form-control1">
                                <br/>
                                <br/>
                                <button type="submit" class="btn btn-info">Yayınevi Ekle</button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Kapat</button>
                            </div>
                        </form>

                    </div>

                </div>

            </div>
            <!-- YayınEvi Eklemeyi Görüntüleyen Modal-->
            <div class="modal" id="Modal1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <strong class="modal-title">Kullanıcı Bilgileri</strong>
                        </div>
                        <form>
                            <div class="modal-body">
                                <label>
                                    Kullanıcı ID
                                </label>
                                <input type="number" value="${adminBilgi.kullaniciID}" class="form-control" disabled="disabled">
                                <br/>
                                <label>
                                    Kullanıcı İsmi Soyisimi
                                </label>
                                <input type="text" value="${adminBilgi.kulllaniciIsimSoyisim}" class="form-control" disabled="disabled">
                                <br/>
                                <label>
                                    Kullanıcı Email Adresi
                                </label>
                                <input type="email" value="${adminBilgi.kullaniciEmail}" class="form-control" disabled="disabled">
                                <br/>
                                <label>
                                    Kullanıcı Parola
                                </label>
                                <input type="text" value="${adminBilgi.kullaniciParola}" class="form-control" disabled="disabled">
                                <br/>
                                <label>
                                    Kullanıcı Telefon
                                </label>
                                <input type="number" value="${adminBilgi.kullaniciTelefon}" class="form-control" disabled="disabled">
                                <br/>
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Kapat</button>
                            </div>
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
