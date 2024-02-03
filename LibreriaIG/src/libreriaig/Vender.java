/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreriaig;

/**
 *
 * @author moyme
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Vender {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Vender Libro");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel idLabel = new JLabel("ID del Libro:");
        idLabel.setBounds(10, 20, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 20, 165, 25);
        panel.add(idText);

        JLabel cantidadLabel = new JLabel("Cantidad a Vender:");
        cantidadLabel.setBounds(10, 50, 150, 25);
        panel.add(cantidadLabel);

        JTextField cantidadText = new JTextField(20);
        cantidadText.setBounds(160, 50, 105, 25);
        panel.add(cantidadText);

        JButton venderButton = new JButton("Vender");
        venderButton.setBounds(10, 80, 80, 25);
        panel.add(venderButton);

        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int libroId = Integer.parseInt(idText.getText());
                    int cantidad = Integer.parseInt(cantidadText.getText());
                    venderLibro(libroId, cantidad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos para el ID y la cantidad.");
                }
            }
        });
    }

    public static void venderLibro(int libroId, int cantidad) {
        // Conectar a la base de datos
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_libros", "root", "")) {
            // Verificar si hay suficientes libros en stock
            if (verificarStockSuficiente(libroId, cantidad, con)) {
                // Actualizar la cantidad en tbl_ope_libro
                actualizarCantidad(libroId, cantidad, con);
                
                // Registrar la venta en tbl_hist_ventas
                registrarVenta(libroId, cantidad, con);

                JOptionPane.showMessageDialog(null, "Venta realizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficientes libros en stock");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al realizar la venta");
        }
    }

    private static boolean verificarStockSuficiente(int libroId, int cantidad, Connection con) throws SQLException {
        String query = "SELECT Libro_Cantidad FROM tbl_ope_libro WHERE LibroId = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, libroId);
            try (var rs = pst.executeQuery()) {
                if (rs.next()) {
                    int stockActual = rs.getInt("Libro_Cantidad");
                    return stockActual >= cantidad;
                }
            }
        }
        return false;
    }

    private static void actualizarCantidad(int libroId, int cantidad, Connection con) throws SQLException {
        String query = "UPDATE tbl_ope_libro SET Libro_Cantidad = Libro_Cantidad - ? WHERE LibroId = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, cantidad);
            pst.setInt(2, libroId);
            pst.executeUpdate();
        }
    }

    private static void registrarVenta(int libroId, int cantidad, Connection con) throws SQLException {
        String query = "INSERT INTO tbl_hist_ventas (Ventas_LibroId, Ventas_Vendido) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, libroId);
            pst.setInt(2, cantidad);
            pst.executeUpdate();
        }
    }
}
