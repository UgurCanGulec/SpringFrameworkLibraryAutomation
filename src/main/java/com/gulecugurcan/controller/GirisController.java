package com.gulecugurcan.controller;

import com.gulecugurcan.model.Kitap;
import com.gulecugurcan.model.Kullanici;
import com.gulecugurcan.model.Yayinevi;
import com.gulecugurcan.service.KitapService;
import com.gulecugurcan.service.KullaniciService;
import com.gulecugurcan.service.YayineviService;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import org.apache.log4j.Logger;

@Controller
public class GirisController {
    private final static Logger log = Logger.getLogger(GirisController.class);
    private  static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(GirisController.class);
    private Kullanici kullanici = null; //Oturum açan kullanıcı bilgileri bu nesnede tutulur.//Bu nesne login işleminde doldurulur.
    private List<Yayinevi> yayineviList = null;
    private List<Kitap> kitapList=null;

    @Autowired
    ServletContext servletContext; //Dosya yolunu elde edebilmek için bağladık.

    @Autowired
    private YayineviService yayineviService;

    @Autowired
    private KullaniciService kullaniciService;

    @Autowired
    KitapService kitapService;

    @RequestMapping(value = "/info_book/{kitapISBN}",method = RequestMethod.GET)
    public void KitapDetayBilgileri(@PathVariable("kitapISBN") Long kitapISBN,ModelMap modelMap,HttpServletResponse response) throws IOException {
        Kitap kitap= (Kitap) kitapService.kitapGetirId(kitapISBN);
        response.setContentType("image/jpeg");
        modelMap.addAttribute("kitapBilgi",kitap);
        InputStream inputStream=new ByteArrayInputStream(kitap.getKapakSayfasi());
        IOUtils.copy(inputStream,response.getOutputStream());

    }


    @RequestMapping(value = "/update_book/{kitapISBN}",method = RequestMethod.GET)
    public String KitapGuncelleVeriGetir(@PathVariable("kitapISBN") Long kitapISBN,ModelMap modelMap){
        Kitap kitap=(Kitap) kitapService.kitapGetirId(kitapISBN);
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info(kitap.getKitapAdi()+" isimli kitap güncellendi.");
        modelMap.addAttribute("adminBilgi", this.kullanici);
        modelMap.addAttribute("kitapBilgi",kitap);
        this.yayineviList = yayineviService.yayineviListele();
        modelMap.addAttribute("yayineviList", yayineviList);
        return "views/update_book";



    }


    @RequestMapping(value = "/delete_book/{kitapISBN}",method = RequestMethod.GET)
    public String KitapSil(@PathVariable("kitapISBN") Long kitapISBN,ModelMap modelMap,HttpServletRequest request){
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        kitapService.kitapSil(kitapISBN);
        log.info(kitapISBN+" numaralı kitap silindi.");
        this.yayineviList = yayineviService.yayineviListele();
        this.kitapList=kitapService.kitapListele();
        modelMap.addAttribute("kitapList",kitapList);
        modelMap.addAttribute("adminBilgi", this.kullanici);
        modelMap.addAttribute("yayineviList", yayineviList);

        return "views/admin";
    }



    @PostMapping(value = "/register_book")
    public String KitapEkle(@RequestParam Long kitapISBN,
                            @RequestParam String kitapAdi,
                            @RequestParam String kitapYazari,
                            @RequestParam int kitapSayfa,
                            @RequestParam String kitapTuru,
                            @RequestParam Long kitapYayineviID,
                            @RequestParam MultipartFile kapakResmi,
                            ModelMap modelMap) throws IOException {

        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");


        if (kapakResmi!=null||!kapakResmi.isEmpty()){

         String filename= servletContext.getRealPath("/")+"resources\\images\\"+kapakResmi.getOriginalFilename();
         kapakResmi.transferTo(new File(filename));

     }

        kitapService.kitapEkleGuncelle(kitapISBN,kitapAdi,kitapYazari,kitapSayfa,kitapTuru,kitapYayineviID,kapakResmi);
        this.yayineviList = yayineviService.yayineviListele();
        this.kitapList=kitapService.kitapListele();
        modelMap.addAttribute("kitapList",kitapList);
        modelMap.addAttribute("adminBilgi", this.kullanici);
        modelMap.addAttribute("yayineviList", yayineviList);
        log.info(kitapAdi+" isimli kitap eklendi.");

        return "views/admin";
    }


    @RequestMapping(value = "/update_publisher/{yayineviID}", method = RequestMethod.GET)
    public String YayinEviGuncelleVeriGetir(@PathVariable("yayineviID") Long yayineviID, ModelMap modelMap) {
        Yayinevi yayinevi = (Yayinevi) yayineviService.yayineviGetirId(yayineviID); //Jspden alınan id ile geri kalan parametrelere erişildi.
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info("Yayin Evi Güncelleme Islemi yapılıyor");
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Yayınevi Guncelleme Islemi Yapılıyor SLF4J");
        }


        LOGGER.info("Yayin Evi Güncelleme SLF4J ile yapılıyor");
        modelMap.addAttribute("yayineviBilgi", yayinevi);
        this.yayineviList = yayineviService.yayineviListele();
        modelMap.addAttribute("adminBilgi", this.kullanici);
        modelMap.addAttribute("yayineviList", yayineviList);
        return "views/update";

    }

    @RequestMapping(value = "/delete_publisher/{yayineviID}", method = RequestMethod.GET)
    public String YayinEviSil(@PathVariable("yayineviID") Long yayineviID, ModelMap modelMap) {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info("Yayin Evi Silme Islemi yapılıyor");
        yayineviService.yayineviSil(yayineviID);
        this.yayineviList = yayineviService.yayineviListele();
        this.kitapList=kitapService.kitapListele();
        modelMap.addAttribute("kitapList",kitapList);
        modelMap.addAttribute("adminBilgi", this.kullanici);
        modelMap.addAttribute("yayineviList", yayineviList);
        return "views/admin";
    }


    @PostMapping(value = "/register_publisher")
    public String YayinEviEkle(@RequestParam Long yayineviID, @RequestParam String yayineviAdi,
                               @RequestParam String yayineviSehri,
                               @RequestParam String yayineviMail,
                               @RequestParam String yayineviTelefon, ModelMap modelMap) {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info("Yayin Ev ekleme islemi yapılıyor");
        yayineviService.yayineviEkleGuncelle(yayineviID, yayineviAdi, yayineviSehri, yayineviMail, yayineviTelefon);
        this.yayineviList = yayineviService.yayineviListele();
        this.kitapList=kitapService.kitapListele();
        modelMap.addAttribute("kitapList",kitapList);
        modelMap.addAttribute("adminBilgi", this.kullanici);
        modelMap.addAttribute("yayineviList", yayineviList);


        return "views/admin";
    }

    @GetMapping(value = "/home")
    public String AnaEkran() {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info("Home sayfası Acılıyor");
        return "views/home";
    }


    @GetMapping(value = "/register")
    public String KayitEkrani() {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info("Kayıt Ekranı Açılıyor.");
        return "views/register";
    }


    @PostMapping(value = "/login")
    public ModelAndView GirisIslemiYap(HttpServletRequest request, ModelMap modelMap) {
        boolean hataDurum;
        ModelAndView modelAndView = new ModelAndView("views/admin");
        ModelAndView modelAndView1 = new ModelAndView("views/home");
        String kulllaniciIDString = request.getParameter("kullaniciID").toString();
        String kullaniciParola = request.getParameter("kullaniciParola").toString();
        Long kullaniciID = Long.valueOf(kulllaniciIDString);
        this.kullanici = (Kullanici) kullaniciService.KullaniciGetir(kullaniciID);
        log.info("Giris Yapiliyor.....");
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");

        if (kullanici != null) {
            if (kullanici.getKullaniciID() == kullaniciID && kullanici.getKullaniciParola().equals(kullaniciParola)) {
                log.info(kullanici.getKulllaniciIsimSoyisim()+" isimli kullanıcı oturum açtı.");
                modelMap.addAttribute("adminBilgi", kullanici);
                this.yayineviList = yayineviService.yayineviListele();
                this.kitapList=kitapService.kitapListele();
                modelMap.addAttribute("kitapList",kitapList);
                modelMap.addAttribute("yayineviList", yayineviList);
                return modelAndView;
            } else {
                hataDurum = true;
                log.error("Hata olustu");
                modelMap.addAttribute("hataDurum", hataDurum);
                return modelAndView1;

            }

        } else {
            hataDurum = true;
            modelMap.addAttribute("hataDurum", hataDurum);

            return modelAndView1;
        }


    }


    @PostMapping(value = "/register")
    public ModelAndView KayitIslemiYap(HttpServletRequest request) {
        String kullaniciIsimSoyisim = request.getParameter("kullaniciIsimSoyisim").toString();
        String kullaniciEmail = request.getParameter("kullaniciEmail").toString();
        String kulllaniciParola = request.getParameter("kullaniciParola").toString();
        String kullaniciTelefon = request.getParameter("kullaniciTelefon").toString();

        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");

        kullaniciService.kullaniciEkleGuncelle(kullaniciIsimSoyisim, kullaniciEmail, kulllaniciParola, kullaniciTelefon);
        log.info(kullaniciIsimSoyisim+" isimli kullanıcı sisteme kayıt edildi.");
        Long kullaniciID = kullaniciService.IDGetir();

        ModelAndView modelAndView = new ModelAndView("views/welcomescreen");
        modelAndView.addObject("kullaniciID", kullaniciID);
        modelAndView.addObject("kullaniciAd", kullaniciIsimSoyisim);

        return modelAndView;

    }


}
