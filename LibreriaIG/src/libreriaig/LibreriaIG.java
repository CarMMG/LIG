/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreriaig;


/**
 *
 * @author moyme
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LibreriaIG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Librería");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnVender = new JButton("Vender");
        JButton btnSalir = new JButton("Salir");

        frame.getContentPane().setLayout(null);
        btnAgregar.setBounds(30, 30, 100, 30);
        btnModificar.setBounds(150, 30, 100, 30);
        btnConsultar.setBounds(270, 30, 100, 30);
        btnVender.setBounds(90, 80, 100, 30);
        btnSalir.setBounds(210, 80, 100, 30);

        frame.getContentPane().add(btnAgregar);
        frame.getContentPane().add(btnModificar);
        frame.getContentPane().add(btnConsultar);
        frame.getContentPane().add(btnVender);
        frame.getContentPane().add(btnSalir);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame agregarFrame = new JFrame("Agregar");
                agregarFrame.setSize(300, 200);
                agregarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                agregarFrame.setVisible(true);
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame modificarFrame = new JFrame("Modificar");
                modificarFrame.setSize(300, 200);
                modificarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                modificarFrame.setVisible(true);
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame consultarFrame = new JFrame("Consultar");
                consultarFrame.setSize(300, 200);
                consultarFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                consultarFrame.setVisible(true);
            }
        });

        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame venderFrame = new JFrame("Vender");
                venderFrame.setSize(300, 200);
                venderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                venderFrame.setVisible(true);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
