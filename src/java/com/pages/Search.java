package com.pages;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.query.DataQuery;
import connect.Connect;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@ManagedBean(name = "search")
@SessionScoped
public class Search implements Serializable{

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
    
//----------------------------Tablo Oluşturma---------------------------------//    
    
    public  String araKan;
    public  String araAd, araSoyad, araEPosta, araTelefon, araSehir, araIlce;
    public final DataQuery query = new DataQuery();
    

    public String Search(){
            
        Searching();
        return "search.xhtml?faces-redirect=true";
            
    }

    public List<Search> Searching(){
        List<Search> list = new ArrayList<Search>();
        
        try{
            st = Baglan();
            rs = st.executeQuery("SELECT * FROM Uyeler WHERE kanGrubu='"+araKan+"'");
            
        
        while(rs.next()){
            Search s =new Search();
            s.setAraAd(rs.getString("adi"));
            s.setAraSoyad(rs.getString("soyadi"));
            s.setAraSehir(rs.getString("sehir"));
            s.setAraIlce(rs.getString("ilce"));
            s.setAraKan(rs.getString("kanGrubu"));
            s.setAraTelefon(rs.getString("telNo"));
            s.setAraEPosta(rs.getString("ePosta"));
            list.add(s);
            
            }
        return list;
        }catch(Exception e){
        
        }
        return null;
    }     
 
//-------------------------------Get-Set--------------------------------------// 
    
    public String getAraSehir() {
        return araSehir;
    }

    public void setAraSehir(String araSehir) {
        this.araSehir = araSehir;
    }

    public String getAraAd() {
        return araAd;
    }

    public void setAraAd(String araAd) {
        this.araAd = araAd;
    }

    public String getAraSoyad() {
        return araSoyad;
    }

    public void setAraSoyad(String araSoyad) {
        this.araSoyad = araSoyad;
    }

    public String getAraEPosta() {
        return araEPosta;
    }

    public void setAraEPosta(String araEPosta) {
        this.araEPosta = araEPosta;
    }

    public String getAraTelefon() {
        return araTelefon;
    }

    public void setAraTelefon(String araTelefon) {
        this.araTelefon = araTelefon;
    }

    public String getAraKan() {
        return araKan;
    }

    public void setAraKan(String araKan) {
        this.araKan = araKan;
    }

    public String getAraIlce() {
        return araIlce;
    }

    public void setAraIlce(String araIlce) {
        this.araIlce = araIlce;
    }

   
//---------------------------------Mesaj--------------------------------------//
    
    public void Mesaj(FacesMessage.Severity tip,String baslik,String hata){
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(tip,baslik ,hata));
        
    }    
}
