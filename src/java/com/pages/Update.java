package com.pages;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.util.Date;

import connect.Connect;
import java.io.Serializable;
import java.sql.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;



@ManagedBean(name = "update")
@SessionScoped
public class Update extends Login implements Serializable{
    
    
           
    private String dizi[]= new String[10];
    private String ukullaniciAdi;
    private String usifre;
    private String uid, uad, usoyad, uePosta, utelefon, ukan, usehir, uilce;
    
//------------------------SQL Bağlantısı--------------------------------------//        
    public Connect c;
    private static String USERNAME;
    private static  String PASSWORD;
    private static  String CONN_STRING;
    private static  String JDBC_DRIVER; 
        
 
public Statement Baglan() throws SQLException{
    c = new Connect();
    
    USERNAME=c.username;
    PASSWORD=c.password;
    CONN_STRING=c.conn_string;
    JDBC_DRIVER=c.jdbc_driver;
    
    Connection conn = null;
    conn = (Connection) DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD); 
    return (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
}

    Statement st;
    ResultSet rs;  

//---------------------------Hata Kontol--------------------------------------//    
    
    boolean hatalimi;
    public boolean DegerKontrol(){
        
        hatalimi=false;
        int sayac=0;
        for(int i=0; i<=9; i++){
            if("".equals(dizi[i])){
                sayac++;

            }         
        }
        if(sayac==8){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Boş Alanları Doldurun!");    
            hatalimi=true;
            return hatalimi;
        }
       
        if(ukullaniciAdi.length()<6 || ukullaniciAdi.length()>15){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Kullanıcı Adı en az 6, en fazla 15 karakter olabilir!");
            hatalimi=true;
        }
    
        if(query.Update(ukullaniciAdi)){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Bu kullanıcı adı daha önce alınmış!"); 
            hatalimi=true;
        }
        
        if(usifre.length()<8){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Parola en az 8 karakter olabilir!");
            hatalimi=true;
        }       

         
        if(utelefon.length()!=10 || isNumeric(utelefon)==false){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Yanlış Telefon no. girdiniz!");
            hatalimi=true;
        }
        
        if(!uePosta.matches("(.*)@(.*).")){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Yanlış e-posta adresi girdiniz!");
            hatalimi=true;
        }

        return hatalimi;
    }
//---------------------------------Atamalar-----------------------------------//     
    public void Atama(){
        
            dizi[0]=uid;
            dizi[1]=ukullaniciAdi;
            dizi[2]=usifre;
            dizi[3]=uad;
            dizi[4]=usoyad;
            dizi[5] = ukan;
            dizi[6]= utelefon;       
            dizi[7] = uePosta;
            dizi[8] =usehir;
            dizi[9] =uilce;
    }
        
    public void Atama2(){
      
            lkullaniciAdi=dizi[1];
            lsifre=dizi[2];
            lad=dizi[3];
            lsoyad=dizi[4];
            lkan=dizi[5];
            ltelefon=dizi[6];       
            lePosta=dizi[7];
            lsehir=dizi[8];
            lilce=dizi[9];
    }
    
//---------------------------Tablolara Deger Atama----------------------------//
    
    public void Guncelle() throws SQLException{
        int x=0;
        Atama();
        if(DegerKontrol()==false){
            
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();    

                try {
                    st = Baglan();
                    rs = st.executeQuery("SELECT * FROM GuncellenmisUye");
                    rs.last();
                    
                    st.executeUpdate("INSERT INTO GuncellenmisUye "
                    + "VALUES('"+lid+"','"+df.format(dateobj)+"','"+lkullaniciAdi+"','"+lsifre+"','"+lad+"','"
                    +lsoyad+"','"+lkan+"','"+ltelefon+"','"+lePosta+"','"
                    +lsehir+"','"+lilce+"')");

                } catch (SQLException ex) {     
                    Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                    Mesaj(FacesMessage.SEVERITY_FATAL,"","SQL Hatası 1: "+ex.getMessage());
                }

 
            try {
                st = Baglan();
                rs = st.executeQuery("SELECT * FROM Uyeler WHERE id='"+lid+"'");

                    st.executeUpdate("UPDATE Uyeler SET "
                    +"kullaniciAdi='"+dizi[1]+"',"+"sifre='"+dizi[2]+"',"+"adi='"+dizi[3]+"',"+"soyadi='"+dizi[4]+"',"+"kanGrubu='"+dizi[5]+"',"+"telNo='"+dizi[6]+"',"+"ePosta='"+dizi[7]+"',"+"sehir='"+dizi[8]+"',"+"ilce='"+dizi[9]+"' WHERE id='"+lid+"'");
 
                    Mesaj(FacesMessage.SEVERITY_INFO,"", "İşlem Tamamlandı");


            } catch (SQLException ex) {     
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);

                Mesaj(FacesMessage.SEVERITY_FATAL,"","SQL Hatası: "+ex.getMessage());
            }   
        }    
    }

//--------------------------------Get-Set-------------------------------------//    
    public String[] getDizi() {
        return dizi;
    }

    public void setDizi(String[] dizi) {
        this.dizi = dizi;
    }

    public String getUkullaniciAdi() {
        return ukullaniciAdi;
    }

    public void setUkullaniciAdi(String ukullaniciAdi) {
        this.ukullaniciAdi = ukullaniciAdi;
    }

    public String getUsifre() {
        return usifre;
    }

    public void setUsifre(String usifre) {
        this.usifre = usifre;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUad() {
        return uad;
    }

    public void setUad(String uad) {
        this.uad = uad;
    }

    public String getUsoyad() {
        return usoyad;
    }

    public void setUsoyad(String usoyad) {
        this.usoyad = usoyad;
    }

    public String getUePosta() {
        return uePosta;
    }

    public void setUePosta(String uePosta) {
        this.uePosta = uePosta;
    }

    public String getUtelefon() {
        return utelefon;
    }

    public void setUtelefon(String utelefon) {
        this.utelefon = utelefon;
    }

    public String getUkan() {
        return ukan;
    }

    public void setUkan(String ukan) {
        this.ukan = ukan;
    }

    public String getUsehir() {
        return usehir;
    }

    public void setUsehir(String usehir) {
        this.usehir = usehir;
    }

    public String getUilce() {
        return uilce;
    }

    public void setUilce(String uilce) {
        this.uilce = uilce;
    }

//---------------------------------Mesaj--------------------------------------//

    public void Mesaj(FacesMessage.Severity tip,String baslik,String hata){
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(tip,baslik ,hata));
        
    }
    
//------------------------Telefon Kontrolü İçin-------------------------------//    
    
    public static boolean isNumeric(String str){  
        try  
        {  
          double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
          return false;  
        }  
    return true;  
    }
    
    
}