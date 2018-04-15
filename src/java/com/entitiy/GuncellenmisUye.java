/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entitiy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author serhat
 */
@Entity
@Table(name = "GuncellenmisUye")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuncellenmisUye.findAll", query = "SELECT g FROM GuncellenmisUye g")
    , @NamedQuery(name = "GuncellenmisUye.findById", query = "SELECT g FROM GuncellenmisUye g WHERE g.id = :id")
    , @NamedQuery(name = "GuncellenmisUye.findByGuncellemeTarihi", query = "SELECT g FROM GuncellenmisUye g WHERE g.guncellemeTarihi = :guncellemeTarihi")
    , @NamedQuery(name = "GuncellenmisUye.findByKullaniciAdi", query = "SELECT g FROM GuncellenmisUye g WHERE g.kullaniciAdi = :kullaniciAdi")
    , @NamedQuery(name = "GuncellenmisUye.findBySifre", query = "SELECT g FROM GuncellenmisUye g WHERE g.sifre = :sifre")
    , @NamedQuery(name = "GuncellenmisUye.findByAdi", query = "SELECT g FROM GuncellenmisUye g WHERE g.adi = :adi")
    , @NamedQuery(name = "GuncellenmisUye.findBySoyadi", query = "SELECT g FROM GuncellenmisUye g WHERE g.soyadi = :soyadi")
    , @NamedQuery(name = "GuncellenmisUye.findByKanGrubu", query = "SELECT g FROM GuncellenmisUye g WHERE g.kanGrubu = :kanGrubu")
    , @NamedQuery(name = "GuncellenmisUye.findByTelNo", query = "SELECT g FROM GuncellenmisUye g WHERE g.telNo = :telNo")
    , @NamedQuery(name = "GuncellenmisUye.findByEPosta", query = "SELECT g FROM GuncellenmisUye g WHERE g.ePosta = :ePosta")})
public class GuncellenmisUye implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "guncellemeTarihi")
    @Temporal(TemporalType.DATE)
    private Date guncellemeTarihi;
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
    private Integer telNo;
    @Column(name = "ePosta")
    private String ePosta;

    public GuncellenmisUye() {
    }

    public GuncellenmisUye(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(Date guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
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

    public Integer getTelNo() {
        return telNo;
    }

    public void setTelNo(Integer telNo) {
        this.telNo = telNo;
    }

    public String getEPosta() {
        return ePosta;
    }

    public void setEPosta(String ePosta) {
        this.ePosta = ePosta;
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
        if (!(object instanceof GuncellenmisUye)) {
            return false;
        }
        GuncellenmisUye other = (GuncellenmisUye) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entitiy.GuncellenmisUye[ id=" + id + " ]";
    }
    
}
