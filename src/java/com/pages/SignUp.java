package com.pages;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.query.DataQuery;
import connect.Connect;
import java.io.Serializable;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@ManagedBean(name = "signup")
@SessionScoped
public class SignUp implements Serializable{
    
    private final DataQuery query = new DataQuery();    
    private String dizi[]= new String[10];
    private String skullaniciAdi;
    private String ssifre;
    private String sid, sad, ssoyad, sePosta, stelefon, skan, ssehir, silce;
    
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

//------------------------Girilen Verilerin Kontrolü--------------------------//
    
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
       
        if(skullaniciAdi.length()<6 || skullaniciAdi.length()>15){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Kullanıcı Adı en az 6, en fazla 15 karakter olabilir!");
            hatalimi=true;
        }

        if(ssifre.length()<8){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Parola en az 8 karakter olabilir!");
            hatalimi=true;
        }       

        if(query.signUp(skullaniciAdi)==true){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Bu kullanıcı adı daha önce alınmış!"); 
            hatalimi=true;
        }
        
         
        if(stelefon.length()!=10 || isNumeric(stelefon)==false){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Yanlış Telefon no. girdiniz!");
            hatalimi=true;
        }
        
        if(!sePosta.matches("(.*)@(.*).")){
            Mesaj(FacesMessage.SEVERITY_ERROR,"Hata", "Yanlış e-posta adresi girdiniz!");
            hatalimi=true;
        }

        return hatalimi;
    }

//---------------------------------Atama--------------------------------------//    
    
    public void Atama(){
        
            dizi[0]=1000 +"";
            dizi[1]=skullaniciAdi;
            dizi[2]=ssifre;
            dizi[3]=sad;
            dizi[4]=ssoyad;
            dizi[5] = skan;
            dizi[6]= stelefon;       
            dizi[7] = sePosta;
            dizi[8] =ssehir;
            dizi[9] =silce;
    }

//------------------------Verilerin Tablolara Yazılması-----------------------//    
    
    public void UyeOl() throws SQLException{
    int x;

        Atama();
        if(DegerKontrol()==false){
        
            try {
                st = Baglan();
                rs = st.executeQuery("SELECT * FROM Uyeler");
                
                if(rs.next()){
                    rs.last();
                    x= Integer.parseInt(rs.getString(1))+1;
                    dizi[0]= x +"";

                    st.executeUpdate("INSERT INTO Uyeler "
                    + "VALUES('"+dizi[0]+"','"+dizi[1]+"','"+dizi[2]+"','"+dizi[3]+"','"+dizi[4]+"','"+dizi[5]+"','"+dizi[6]+"','"+dizi[7]+"','"+dizi[8]+"','"+dizi[9]+"')");

                    Mesaj(FacesMessage.SEVERITY_INFO,"", "İşlem Tamamlandı");
                }
                else{
                    st.executeUpdate("INSERT INTO Uyeler "
                    + "VALUES('"+"1000"+"','"+dizi[1]+"','"+dizi[2]+"','"+dizi[3]+"','"+dizi[4]+"','"+dizi[5]+"','"+dizi[6]+"','"+dizi[7]+"','"+dizi[8]+"','"+dizi[9]+"')");

                    Mesaj(FacesMessage.SEVERITY_INFO,"", "İşlem Tamamlandı");
                }

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

    public String getSkullaniciAdi() {
        return skullaniciAdi;
    }

    public void setSkullaniciAdi(String skullaniciAdi) {
        this.skullaniciAdi = skullaniciAdi;
    }

    public String getSsifre() {
        return ssifre;
    }

    public void setSsifre(String ssifre) {
        this.ssifre = ssifre;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSad() {
        return sad;
    }

    public void setSad(String sad) {
        this.sad = sad;
    }

    public String getSsoyad() {
        return ssoyad;
    }

    public void setSsoyad(String ssoyad) {
        this.ssoyad = ssoyad;
    }

    public String getSePosta() {
        return sePosta;
    }

    public void setSePosta(String sePosta) {
        this.sePosta = sePosta;
    }

    public String getStelefon() {
        return stelefon;
    }

    public void setStelefon(String stelefon) {
        this.stelefon = stelefon;
    }

    public String getSkan() {
        return skan;
    }

    public void setSkan(String skan) {
        this.skan = skan;
    }

    public String getSsehir() {
        return ssehir;
    }

    public void setSsehir(String ssehir) {
        this.ssehir = ssehir;
    }

    public String getSilce() {
        return silce;
    }

    public void setSilce(String silce) {
        this.silce = silce;
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