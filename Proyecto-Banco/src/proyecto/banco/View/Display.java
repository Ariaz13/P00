package proyecto.banco.View;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import proyecto.banco.Model.Conection;
import proyecto.banco.Model.Cuenta;
import proyecto.banco.Model.CuentaHabiente;
import proyecto.banco.Model.TDC;
import proyecto.banco.Model.TDD;
import proyecto.banco.Model.Validación;

public class Display {
    final String imgs = "src/proyecto/banco/View/imgs/";
    JFrame ventana;
    JPanel panel;
    JTextField cCuenta ;
    JLabel númeroC;
    JTextField cnip;
    JLabel np;
    JLabel ingresar;
    JLabel imagenFondo;
    JButton continuar;
    JButton cancelar;
    JButton atrás;
    JButton consultar;
    JButton transferir;
    JButton depositar;
    JButton retirar;
    int cantidad;
    JLabel nombre;
    JLabel saldo;
    JLabel imagen;
    JScrollPane movimientos;
    
    Conection cc = new Conection();
    Cuenta c = new Cuenta();
    TDD tdd = new TDD();
    TDC tdc = new TDC();
    Validación validar = new Validación();
    CuentaHabiente ch = new CuentaHabiente();
   
    
    public void show(){
        crear();
        configurar();
        lanzar();
    }

    void crear(){
        ventana = new JFrame();
        panel = new JPanel();
        cCuenta = new JTextField(c.getNumero());
        númeroC = new JLabel();
        cnip = new JTextField(ch.getNip());
        np = new JLabel();
        ingresar = new JLabel();
        imagenFondo = new JLabel();
        continuar = new JButton("Continuar");
        cancelar = new JButton("Cancelar");
        atrás = new JButton("Atrás");
        consultar = new JButton("Consultar");
        transferir = new JButton("Transferir");
        depositar = new JButton("Depositar");
        retirar = new JButton("Retirar");
        nombre = new JLabel();
        saldo = new JLabel();
        imagen = new JLabel();
        movimientos = new JScrollPane();
    }

    void configurar(){
        ventana.setSize(800, 600);
        ventana.setTitle("Proyecto banco - POO");
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        imagenFondo.setIcon(adaptar(imgs + "frente1.jpg"));
        imagenFondo.setBounds(0, 0, 800, 600);
        imagenFondo.setVisible(true);

        ingresar.setBounds(325, 200, 180, 30);
        ingresar.setText("Ingrese su número de cuenta");
        ingresar.setVisible(true);
        
        cCuenta.setBounds(320, 275, 180, 30);
        cCuenta.setVisible(true);
        
        np.setBounds(330, 350, 180, 30);
        np.setText("Ingrese el NIP de la tarjeta");
        np.setVisible(true);
        
        cnip.setBounds(320, 425, 180, 30);
        cnip.setVisible(true);

        continuar.setBounds(650, 370, 100, 40);
        continuar.addActionListener(new botónDerecho());
        continuar.setVisible(true);
        
        atrás.setBounds(650, 440, 100, 40);
        atrás.addActionListener(new botónDerecho());
        atrás.setVisible(false);
        
        cancelar.setBounds(650, 510, 100, 40);
        cancelar.addActionListener(new botónDerecho());
        cancelar.setVisible(true);

        consultar.setBounds(50, 300, 100, 40);
        consultar.addActionListener(new botónDerecho());
        consultar.setVisible(false);
        
        retirar.setBounds(50, 370, 100, 40);
        retirar.addActionListener(new botónDerecho());
        retirar.setVisible(false);
        
        depositar.setBounds(50, 440, 100, 40);
        depositar.addActionListener(new botónDerecho());
        depositar.setVisible(false);
        
        transferir.setBounds(50, 510, 100, 40);
        transferir.addActionListener(new botónDerecho());
        transferir.setVisible(false);
        
        nombre.setBounds(50, 50, 120, 30);
        nombre.setVisible(false);
        
        númeroC.setBounds(200, 50, 70, 30);
        númeroC.setVisible(false);
        
        saldo.setBounds(300, 50, 50, 30);
        saldo.setVisible(false);
        
        movimientos.setBounds(260, 130, 300, 420);
        movimientos.setVisible(false);
        
        panel.add(cCuenta);
        panel.add(númeroC);
        panel.add(continuar);
        panel.add(cancelar);
        panel.add(cnip);
        panel.add(np);
        panel.add(ingresar);
        panel.add(atrás);
        panel.add(consultar);
        panel.add(retirar);
        panel.add(depositar);
        panel.add(transferir);
        panel.add(nombre);
        panel.add(saldo);
        panel.add(imagen);
        panel.add(movimientos);
        panel.add(imagenFondo);
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
            if(e.getSource() == continuar){
                cc.conectar();
            
            }
        }
    
    }
    
    private ImageIcon adaptar(String archivo){
        Image i = new ImageIcon(archivo).getImage();
        ImageIcon ir = new ImageIcon(i.getScaledInstance(800, 600, Image.SCALE_SMOOTH));
        return ir;
    }
    
}
