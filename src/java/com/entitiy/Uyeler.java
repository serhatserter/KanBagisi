package com.entitiy;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Uyeler")
@XmlRootElement
@NamedQueries({
    
        @NamedQuery(name = "Uyeler.control", query = "SELECT u FROM Uyeler u WHERE u.kullaniciAdi = :kullaniciAdi AND u.sifre= :sifre")

    , @NamedQuery(name = "Uyeler.findAll", query = "SELECT u FROM Uyeler u")
    , @NamedQuery(name = "Uyeler.findById", query = "SELECT u FROM Uyeler u WHERE u.id = :id")
    , @NamedQuery(name = "Uyeler.findByKullaniciAdi", query = "SELECT u FROM Uyeler u WHERE u.kullaniciAdi = :kullaniciAdi")
    , @NamedQuery(name = "Uyeler.findBySifre", query = "SELECT u FROM Uyeler u WHERE u.sifre = :sifre")
    , @NamedQuery(name = "Uyeler.findByAdi", query = "SELECT u FROM Uyeler u WHERE u.adi = :adi")
    , @NamedQuery(name = "Uyeler.findBySoyadi", query = "SELECT u FROM Uyeler u WHERE u.soyadi = :soyadi")
    , @NamedQuery(name = "Uyeler.findByKanGrubu", query = "SELECT u FROM Uyeler u WHERE u.kanGrubu = :kanGrubu")
    , @NamedQuery(name = "Uyeler.findByTelNo", query = "SELECT u FROM Uyeler u WHERE u.telNo = :telNo")
    , @NamedQuery(name = "Uyeler.findByEPosta", query = "SELECT u FROM Uyeler u WHERE u.ePosta = :ePosta")
    , @NamedQuery(name = "Uyeler.findBySehir", query = "SELECT u FROM Uyeler u WHERE u.sehir = :sehir")
    , @NamedQuery(name = "Uyeler.findByIlce", query = "SELECT u FROM Uyeler u WHERE u.ilce = :ilce")})
public class Uyeler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "kullaniciAdi")
    private String kullaniciAdi;
    @Column(name = "sifre")
    private String sifre;
    @Column(name = "adi")
    private String adi;
    @Column(name = "soyadi")
    private String soyadi;
    @Column(name = "kanGrubu")
    private String kanGrubu;
    @Column(name = "telNo")
    private String telNo;
    @Column(name = "ePosta")
    private String ePosta;
    @Column(name = "sehir")
    private String sehir;
    @Column(name = "ilce")
    private String ilce;

    public Uyeler() {
    }

    public Uyeler(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEPosta() {
        return ePosta;
    }

    public void setEPosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uyeler)) {
            return false;
        }
        Uyeler other = (Uyeler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitiy.Uyeler[ id=" + id + " ]";
    }
    
}
