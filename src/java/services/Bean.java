/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Gruppyi;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author павел
 */
@Stateless
public class Bean implements BeanLocal {

    @Override
    public String s() {
    
        return "hpotr";
    }

     @Override
    public List PrintGrupp(){
         SessionFactory sf= HibernateUtil.getSessionFactory(); 
      Session s = sf.openSession();
        org.hibernate.Query query = s.createQuery("from Gruppyi u");
        List<Gruppyi> ups = (List<Gruppyi>)query.list();
         System.out.println(ups);
       return ups;
    }
    
    @Override
    public void Delete(String shifr){
        SessionFactory sf= HibernateUtil.getSessionFactory(); 
      Session s = sf.openSession();
        org.hibernate.Query query = s.createQuery("DELETE from Gruppyi u WHERE u.shifr = :shifr");
    query.setParameter("shifr", shifr);
    query.executeUpdate();
        
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
