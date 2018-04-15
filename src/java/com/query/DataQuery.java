package com.query;

import com.entitiy.Uyeler;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DataQuery {
    
    EntityManagerFactory emf;
    EntityManager em;

    public DataQuery() {
        emf = Persistence.createEntityManagerFactory("KanBagisiPU");
        em= emf.createEntityManager();
        em.getTransaction().begin();
        
    }
        
    public static String id, kullaniciAdi, sifre, ad, soyad, ePosta, telefon, kan, sehir, ilce;
    public boolean loginControl(String usr, String pas){
        try{
            
        Uyeler u = em.createNamedQuery
        ("Uyeler.control", Uyeler.class).setParameter("kullaniciAdi", usr)
                .setParameter("sifre", pas).getSingleResult();

        
        if(u != null){
            id=u.getId();
            kullaniciAdi=u.getKullaniciAdi();
            sifre=u.getSifre();
            ad=u.getAdi();
            soyad=u.getSoyadi();
            ePosta = u.getEPosta();
            telefon = u.getTelNo();
            kan = u.getKanGrubu();
            sehir= u.getSehir();
            ilce = u.getIlce();
            return true;
        }    
        return false;    
        }catch (Exception e){
            return false; 
        }        
    }
    
       public boolean signUp(String dgr){
              
        try{
            
        Uyeler u = em.createNamedQuery
        ("Uyeler.findByKullaniciAdi", Uyeler.class).setParameter("kullaniciAdi", dgr).getSingleResult();
        
        if(u!=null){
            return true;
        }
           
        }catch (Exception e){
            return false; 
        } 
        
        
        return false;

    } 
       
   public boolean Update(String up){
              
        try{
            
        Uyeler u = em.createNamedQuery
        ("Uyeler.findByKullaniciAdi", Uyeler.class).setParameter("kullaniciAdi", up).getSingleResult();
        
        if(u!=null){
           if(!u.getId().equals(id)) return true;
        }
           
        }catch (Exception e){
            return false; 
        } 
        
        
        return false;

    } 
   
       public boolean Search(String araSehir){
        try{
            
        Uyeler u = em.createNamedQuery
        ("Uyeler.findBySehir", Uyeler.class).setParameter("sehir", araSehir).getSingleResult();

        
        if(u != null){
            
            return true;
        }    
        return false;    
        }catch (Exception e){
            return false; 
        }        
    }
}
