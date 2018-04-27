package services;

import java.util.List;
import javax.ejb.Local;


@Local
public interface ServicesInterfaces {
    
     List Print();
     List PrintStud();
     List PrintGrupp();
     void Delete(String shifr);
         
}
