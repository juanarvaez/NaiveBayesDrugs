/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logica.Archivo;
import Logica.Ordenamiento;
import Logica.Probabilidad;
import java.util.ArrayList;

/**
 *
 * @author Juan Carlos Narvaez
 */
public class Controlador {
    
    Archivo objArchivo;
    Ordenamiento ordenamiento = new Ordenamiento();
    String[] tabla1;
    String[][] tabla2, tabla3, tabla4, tabla5, tabla6, tabla7;
    
    
    
    public ArrayList<String[]> leerDatosArchivo(String rutaArchivo) {
        objArchivo = new Archivo();
        return objArchivo.obtenerListaParametros(rutaArchivo);
    }
    
    public String[] datosOrdenados(ArrayList<Integer> edad, ArrayList<Double> Na, ArrayList<Double> K, int pos) {
        return ordenamiento.datosOrdenados(edad, Na, K, pos);
    }
    
    public String[] calculosOrdenamiento(ArrayList<Integer> edad, ArrayList<Double> Na, ArrayList<Double> K) {
        return ordenamiento.calculosOrdenamiento(edad, Na, K);
    }
    
    public ArrayList<String> procesarDatosEntero(ArrayList<Integer> listaEdad, Double precision) {
        return ordenamiento.procesarListaEnteros(listaEdad, precision);
    }
    
    public ArrayList<String> procesarDatosDecimales(ArrayList<Double> lista, Double precision) {
        return ordenamiento.procesarListaDecimales(lista, precision);
    }
    
    //metodos para las tablas de probabilidad
    public void obtenerTablasProbabilidad(String[][] datosProcesados, String[] calculosOrdenamiento) {
        datosTabla1(datosProcesados);
        datosTabla2(datosProcesados, Double.parseDouble(calculosOrdenamiento[6]));
        datosTabla3(datosProcesados);
        datosTabla4(datosProcesados);
        datosTabla5(datosProcesados);
        datosTabla6(datosProcesados, Double.parseDouble(calculosOrdenamiento[7]));
        datosTabla7(datosProcesados, Double.parseDouble(calculosOrdenamiento[8]));
        
        
        almacenarTablasProbabilidad();
    }
    
    public void almacenarTablasProbabilidad() {
        
    }
    
    
    public void datosTabla1(String[][] datosProcesados) {
        Probabilidad pr = new Probabilidad();
        tabla1 = pr.tabla1(datosProcesados);
    }
    
    public void datosTabla2(String[][] datosProcesados, Double precisionEdad) {
        Probabilidad pr = new Probabilidad();
        tabla2 = pr.tabla2(datosProcesados, precisionEdad);
    }
    
    public void datosTabla3(String[][] datosProcesados) {
        Probabilidad pr = new Probabilidad();
        tabla3 = pr.tabla3(datosProcesados);
    }
    
    public void datosTabla4(String[][] datosProcesados) {
        Probabilidad pr = new Probabilidad();
        tabla4 = pr.tabla4(datosProcesados);
    }
    
    public void datosTabla5(String[][] datosProcesados) {
        Probabilidad pr = new Probabilidad();
        tabla5 = pr.tabla5(datosProcesados);
    }
    
    public void datosTabla6(String[][] datosProcesados, Double precisionNa) {
        Probabilidad pr = new Probabilidad();
        tabla6 = pr.tabla6(datosProcesados, precisionNa);
    }
    
    public void datosTabla7(String[][] datosProcesados, Double precisionK) {
        Probabilidad pr = new Probabilidad();
        tabla7 = pr.tabla7(datosProcesados, precisionK);
    }
    
}
