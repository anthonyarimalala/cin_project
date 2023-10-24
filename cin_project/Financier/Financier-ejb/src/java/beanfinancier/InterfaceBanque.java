
package beanfinancier;

import java.sql.Connection;
import java.sql.SQLException;
import javax.ejb.Remote;

@Remote
public interface InterfaceBanque {
    String getMessage();
    String showMessage(String message);
    String getget() throws SQLException; 
}
