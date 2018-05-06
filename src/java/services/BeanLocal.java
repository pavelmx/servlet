/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author павел
 */
@Local
public interface BeanLocal {
    
    String s();
    List PrintGrupp();
    void Delete(String shifr);
    
}
