/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Juan Carlos Narvaez
 */
public class Validacion {
    
    //Metodo que valida si un dato leido como string es entero, decimal o cadena de texto
    public int verificarNumero(String datoLeido) {
        if(datoLeido.matches("[0-9]*"))         return 1; //si es entero
        if(datoLeido.matches("[0-9]+.[0-9]*"))  return 2; //si es decimal
                                                return 0; //si es cadena
    }
    
}
