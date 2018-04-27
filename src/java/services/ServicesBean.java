package services;




import services.ServicesInterfaces;
import services.HibernateUtil;
import entity.Gruppyi;
import entity.Studentyi;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author павел
 */
@Stateless
public class ServicesBean implements ServicesInterfaces {
       
      Session s;
      Transaction t;

    public ServicesBean() {
        SessionFactory sf= HibernateUtil.getSessionFactory(); 
      Session s = sf.openSession();
       t= s.beginTransaction();
    }
      
               

    
    @Override
    public List PrintStud(){
        org.hibernate.Query query = s.createQuery("from Studentyi u");
        List<Gruppyi> ups = (List<Gruppyi>)query.list();
       return ups;
    }
    
     @Override
    public List PrintGrupp(){
        org.hibernate.Query query = s.createQuery("from Gruppyi u");
        List<Gruppyi> ups = (List<Gruppyi>)query.list();
       return ups;
    }
    
    @Override
    public void Delete(String shifr){
        org.hibernate.Query query = s.createQuery("DELETE from Gruppyi u WHERE shifr = :shifr");
    query.setParameter("shifr", shifr);
    query.executeUpdate();
        
    }
    
    @Override
    public List Print(){
    //Transaction t = this.s.beginTransaction(); 
org.hibernate.Query query = this.s.createQuery("from Gruppyi u"); 
List ups = (List)query.list(); 
//t.commit(); 
System.out.println("go"); 
return ups;
    }
    
}
