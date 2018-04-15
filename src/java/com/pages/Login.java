package com.pages;

import com.query.DataQuery;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@ManagedBean(name = "login")
@SessionScoped
 public class Login implements Serializable {

//---------------------------Değer Atama--------------------------------------//    
    public static String lid,lkullaniciAdi;
    public static String lsifre;

    public static String lad, lsoyad, lePosta, ltelefon, lkan, lsehir, lilce;
    public final DataQuery query = new DataQuery();

    public void Atama(){
        lid=query.id;
        lad=query.ad;
        lsoyad=query.soyad;
        lePosta=query.ePosta;
        ltelefon= query.telefon;
        lkan = query.kan;
        lePosta = query.ePosta;
        lsehir =query.sehir;
        lilce =query.ilce;
    }

//------------------------Giriş Kontrolü--------------------------------------//
    
    public String LoginControl(){
        
        if(query.loginControl(lkullaniciAdi, lsifre)){
            Atama();
            
            return "home.xhtml?faces-redirect=true";
        }
        Mesaj(FacesMessage.SEVERITY_ERROR,"Error" ,"Kullanıcı Adı veya Şifre Hatalı!" );
        return "";
        
    }
    
//-------------------------------Get-Set--------------------------------------//
    
    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getLkullaniciAdi() {
        return lkullaniciAdi;
    }

    public void setLkullaniciAdi(String lkullaniciAdi) {
        this.lkullaniciAdi = lkullaniciAdi;
    }

    public String getLsifre() {
        return lsifre;
    }

    public void setLsifre(String lsifre) {
        this.lsifre = lsifre;
    }

    public String getLad() {
        return lad;
    }

    public void setLad(String lad) {
        this.lad = lad;
    }

    public String getLsoyad() {
        return lsoyad;
    }

    public void setLsoyad(String lsoyad) {
        this.lsoyad = lsoyad;
    }

    public String getLePosta() {
        return lePosta;
    }

    public void setLePosta(String lePosta) {
        this.lePosta = lePosta;
    }

    public String getLtelefon() {
        return ltelefon;
    }

    public void setLtelefon(String ltelefon) {
        this.ltelefon = ltelefon;
    }

    public String getLkan() {
        return lkan;
    }

    public void setLkan(String lkan) {
        this.lkan = lkan;
    }

    public String getLsehir() {
        return lsehir;
    }

    public void setLsehir(String lsehir) {
        this.lsehir = lsehir;
    }

    public String getLilce() {
        return lilce;
    }

    public void setLilce(String lilce) {
        this.lilce = lilce;
    }

//---------------------------------Mesaj--------------------------------------//
    
    public void Mesaj(FacesMessage.Severity tip,String baslik,String hata){
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(tip,baslik ,hata));
        
    }
}
