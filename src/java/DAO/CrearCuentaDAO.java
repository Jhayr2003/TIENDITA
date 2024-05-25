 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.CrearCuenta;


/**
 *
 * @author Andres
 */

public class CrearCuentaDAO {
    private Connection con;

    public CrearCuentaDAO() {
        ConectarBD conectarBD = new ConectarBD();
        this.con = conectarBD.getConnection();
        if (this.con == null) {
            throw new RuntimeException("Failed to establish database connection.");
        }
    }

    public boolean agregarCuenta(CrearCuenta cuenta) {
        if (this.con == null) {
            throw new IllegalStateException("Connection is not initialized.");
        }

        String sql = "INSERT INTO RegistroCuenta (Nombre, Apellido, Correo, Telefono, Contraseña) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cuenta.getNombre());
            ps.setString(2, cuenta.getApellido());
            ps.setString(3, cuenta.getCorreo());
            ps.setString(4, cuenta.getTelefono());
            ps.setString(5, cuenta.getContraseña());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void closeConnection() {
    if (this.con != null) {
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}

