
package View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display {
    final String imgs = "src/View/imgs/";
    JFrame ventana;
    JPanel panel;
    JTextField nCuenta;
    JLabel númeroC;
    JTextField nip;
    JLabel ingresar;
    JLabel imagenFondo;
    JButton continuar;
    JButton cancelar;
    JButton atrás;
    JButton consultar;
    JButton transferir;
    JButton depositar;
    JButton retirar;
    JLabel nombre;
    JLabel saldo;
    JLabel imagen;
    JButton movimientos;

    public void show(){
        crear();
        configurar();
        lanzar();
    }

    void crear(){
        ventana = new JFrame();
        panel = new JPanel();
        nCuenta = new JTextField(16);
        númeroC = new JLabel();
        nip = new JTextField(4);
        ingresar = new JLabel();
        imagenFondo = new JLabel();
        continuar = new JButton("Continuar");
        cancelar = new JButton("Cancelar");
        atrás = new JButton("Atrás");
        consultar = new JButton("Consultar saldo");
        transferir = new JButton("Transferir saldo");
        depositar = new JButton("Depositar");
        retirar = new JButton("Retirar");
        nombre = new JLabel();
        saldo = new JLabel();
        imagen = new JLabel();
        movimientos = new JButton();
    }

    void configurar(){
        ventana.setSize(800, 600);
        ventana.setTitle("Proyecto banco - POO");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        imagenFondo.setIcon(new ImageIcon(imgs + "frente1.jpg"));
        imagenFondo.setBounds(0, 0, 800, 600);
        imagenFondo.setVisible(false);

        ingresar.setBounds(325, 200, 180, 30);
        ingresar.setText("Ingrese su número de cuenta");
        ingresar.setVisible(true);
        
        nCuenta.setBounds(320, 275, 180, 30);
        nCuenta.setVisible(true);
        
        nip.setBounds(335, 275, 100, 30);
        nip.setText("Ingrese el nip de la tarjeta");
        nip.setVisible(true);

        continuar.setBounds(650, 370, 100, 40);
        continuar.addActionListener(new botónDerecho());
        continuar.setVisible(true);
        
        atrás.setBounds(650, 440, 100, 40);
        atrás.addActionListener(new botónDerecho());
        atrás.setVisible(true);
        
        cancelar.setBounds(650, 510, 100, 40);
        cancelar.addActionListener(new botónDerecho());
        cancelar.setVisible(true);

        consultar.setBounds(50, 300, 100, 40);
        consultar.addActionListener(new botónDerecho());
        consultar.setVisible(true);
        
        retirar.setBounds(50, 370, 100, 40);
        retirar.addActionListener(new botónDerecho());
        retirar.setVisible(true);
        
        depositar.setBounds(50, 440, 100, 40);
        depositar.addActionListener(new botónDerecho());
        depositar.setVisible(true);
        
        transferir.setBounds(50, 510, 100, 40);
        transferir.addActionListener(new botónDerecho());
        transferir.setVisible(true);
        
        nombre.setBounds(50, 50, 120, 40);
        nombre.setText("");
        nombre.setVisible(true);
        
        númeroC.setBounds(200, 50, 70, 40);
        númeroC.setText(nCuenta.getText());
        númeroC.setVisible(true);
        
        panel.add(imagenFondo);
        panel.add(nCuenta);
        panel.add(númeroC);
        panel.add(continuar);
        panel.add(cancelar);
        panel.add(nip);
        panel.add(ingresar);
        panel.add(atrás);
        panel.add(consultar);
        panel.add(retirar);
        panel.add(depositar);
        panel.add(transferir);
        panel.add(movimientos);
        panel.add(nombre);
        panel.add(saldo);
        panel.add(imagen);
        panel.setLayout(null);
    }

    void lanzar(){
        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class botónDerecho implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == consultar){
                nCuenta.setVisible(false);
                ingresar.setVisible(false);
                
            }
            
        }
    }
    
    private ImageIcon adaptar(String archivo){
        Image i = new ImageIcon(archivo).getImage();
        ImageIcon ir = new ImageIcon(i.getScaledInstance(800, 600, Image.SCALE_SMOOTH));
        return ir;
    }

}
