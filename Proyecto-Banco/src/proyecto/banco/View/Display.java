
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
import proyecto.banco.Model.TDC;
import proyecto.banco.Model.TDD;
import proyecto.banco.Model.Validación;

public class Display {
    final String imgs = "src/proyecto/banco/View/imgs/";
    JFrame ventana;
    JPanel panel;
    JTextField nCuenta;
    JLabel númeroC;
    JTextField nip;
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

        imagenFondo.setIcon(new ImageIcon(imgs + "frente1.jpg"));
        imagenFondo.setBounds(0, 0, 800, 600);
        imagenFondo.setVisible(true);

        ingresar.setBounds(325, 200, 180, 30);
        ingresar.setText("Ingrese su número de cuenta");
        ingresar.setVisible(true);
        
        nCuenta.setBounds(320, 275, 180, 30);
        nCuenta.setVisible(true);
        
        np.setBounds(330, 350, 180, 30);
        np.setText("Ingrese el NIP de la tarjeta");
        np.setVisible(true);
        
        nip.setBounds(320, 425, 180, 30);
        nip.setVisible(true);

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
        
        panel.add(imagenFondo);
        panel.add(nCuenta);
        panel.add(númeroC);
        panel.add(continuar);
        panel.add(cancelar);
        panel.add(nip);
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
            if(validar.verifyAccount(nCuenta, nip) == true){
                cc.conectar();
                consultar.setVisible(true);
                retirar.setVisible(true);
                depositar.setVisible(true);
                transferir.setVisible(true);
                nombre.setVisible(true);
                nombre.setText("");
                númeroC.setVisible(true);
                númeroC.setText(nCuenta.getText());
                saldo.setVisible(true);
                saldo.setText("");
                
                if(e.getSource() == consultar){
                // - Consulta el saldo actual de la tarjeta
                // - A su vez despliega la lista de movimientos que se han registrado
                    movimientos.setVisible(true);
                    tdd.consultar(nCuenta);
                    tdc.consultar(nCuenta);
                } else if(e.getSource() == retirar){
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto", "Retirar"));
                    tdd.retirar(cantidad, nCuenta);
                    tdc.retirar(cantidad, nCuenta);
                } else if(e.getSource() == depositar){
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto", "Depositar"));
                    tdd.depositar(cantidad, nCuenta);
                    
                } else if(e.getSource() == transferir){
                    JOptionPane.showMessageDialog(null, "Operación no disponible",
                        "Transferencia de saldos", JOptionPane.ERROR_MESSAGE);
                } else if(e.getSource() == continuar){
                    validar.verifyAccount(nCuenta, nip);
                    cc.conectar();
                } else if(e.getSource() == cancelar){
                    cc.desconectar();
                    ventana.setDefaultCloseOperation(JFrame.ERROR);
                } else if(e.getSource() == atrás){
                    
                }
            }
        }
        
    }
    
    private ImageIcon adaptar(String archivo){
        Image i = new ImageIcon(archivo).getImage();
        ImageIcon ir = new ImageIcon(i.getScaledInstance(800, 600, Image.SCALE_SMOOTH));
        return ir;
    }
    
    // - Esto no va aquí -
    public static void main(String[] args) {
        Display run = new Display();
        
        run.show();
    }

}
