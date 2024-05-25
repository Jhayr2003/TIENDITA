/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import DAO.CrearCuentaDAO;

import modelo.CrearCuenta;


/**
 *
 * @author Andres
 */


public class CrearCuentaCRUD {
    private CrearCuentaDAO cuentaDAO;

    public CrearCuentaCRUD() {
        this.cuentaDAO = new CrearCuentaDAO();
    }

    public void agregarCuenta(String nombre, String Apellido, String Correo,String Telefono, String Contraseña) {
        CrearCuenta cuenta = new CrearCuenta();
        cuenta.setNombre(nombre);
        cuenta.setApellido(Apellido);
        cuenta.setCorreo(Correo);
        cuenta.setTelefono(Telefono);
        cuenta.setContraseña(Contraseña);
        if (cuentaDAO.agregarCuenta(cuenta)) {
            System.out.println("Cuenta agregada.");
        } else {
            System.out.println("Error al agregar cuenta.");
        }
    }

    

}
