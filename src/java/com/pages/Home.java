package com.pages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "home")
@SessionScoped
public class Home extends Login{
//---------------------------Değer Atama--------------------------------------//
    
    public String had, hsoyad, hePosta, htelefon, hkan, hsehir, hilce;

    public Home() {
    
        this.had=lad;
        this.hePosta =lePosta;
        this.hilce=lilce;
        this.hkan=lkan;
        this.hsehir=lsehir;
        this.hsoyad=lsoyad;
        this.htelefon=ltelefon;
        
    }

//-------------------------------Get-Set--------------------------------------//    

    public String getHad() {
        return had;
    }

    public void setHad(String had) {
        this.had = had;
    }

    public String getHsoyad() {
        return hsoyad;
    }

    public void setHsoyad(String hsoyad) {
        this.hsoyad = hsoyad;
    }

    public String getHePosta() {
        return hePosta;
    }

    public void setHePosta(String hePosta) {
        this.hePosta = hePosta;
    }

    public String getHtelefon() {
        return htelefon;
    }

    public void setHtelefon(String htelefon) {
        this.htelefon = htelefon;
    }

    public String getHkan() {
        return hkan;
    }

    public void setHkan(String hkan) {
        this.hkan = hkan;
    }

    public String getHsehir() {
        return hsehir;
    }

    public void setHsehir(String hsehir) {
        this.hsehir = hsehir;
    }

    public String getHilce() {
        return hilce;
    }

    public void setHilce(String hilce) {
        this.hilce = hilce;
    }
    
    
}
