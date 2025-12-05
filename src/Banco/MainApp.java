
package Banco;
import Banco.vista.*;

public class MainApp {
    public static void main(String []args){
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipalGUI().setVisible(true);
        });
    }
}
