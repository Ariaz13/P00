
package U.ProyectoBanco.View;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {
    final String imgs = "src/U/ProyectoBanco/imgs/";
    JFrame ventana;
    JPanel panel;
    JLabel imagenFondo;
    JButton aceptar;
    DefaultComboBoxModel actividades;
    JComboBox combo;
    
    void show(){
        crear();
        configurar();
        lanzar();
    }
    
    void crear(){
        ventana = new JFrame();
        panel = new JPanel();
        imagenFondo = new JLabel();
        aceptar = new JButton();
        actividades = new DefaultComboBoxModel();
    }
    
    void configurar(){
        ventana.setSize(800, 600);
        ventana.setTitle("ATM");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        
        combo = new JComboBox();
        combo.setBounds(650, 70, 70, 80);
        
        panel.setLayout(null);
        
        panel.add(imagenFondo);
        panel.add(aceptar);
        panel.add(combo);
    }
    
    void lanzar(){
        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
