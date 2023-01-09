import gui.MainWindow;

import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Luis Andres Valido Fajardo luis.valido1989@gmail.com
 */
public class Main {

    /**
     * Método encargado de iniciar la aplicación
     * @param args 
     * @author Luis Andrés Valido Fajardo +53 53694742 luis.valido1989@gmail.com
     */
    public static void main(String[] args) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               MainWindow gui= new MainWindow();
               Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
               gui.setLocation(dim.width/2-gui.getSize().width/2, dim.height/2-gui.getSize().height/2);
               gui.setVisible(true);
            }
        });
    }
    
}
