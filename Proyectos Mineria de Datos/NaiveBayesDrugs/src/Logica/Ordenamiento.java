/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Juan Carlos Narvaez
 */
public class Ordenamiento {
    
    public String[] datosOrdenados(ArrayList<Integer> edad, ArrayList<Double> Na, ArrayList<Double> K, int pos) {
        String[] linea = new String[9];
        linea[0] = edad.get(pos).toString();                                                              //asigacion del valor de la edad
        linea[1] = Integer.toString(edad.get(pos) - edad.get(pos-1));                                     //operacion para el delta de la edad
        linea[2] = Integer.toString(decisionEdad(edad.get(pos) - edad.get(pos-1)));                       //distic
        linea[3] = Double.toString(Na.get(pos));                                                          //asigacion del valor de Na
        linea[4] = Double.toString(Na.get(pos) - Na.get(pos-1));                                          //operacion para el delta de Na
        linea[5] = Integer.toString(decisionNaOK(Na.get(pos) - Na.get(pos-1)));                           //disctic
        linea[6] = Double.toString(K.get(pos));                                                           //asigacion del valor de K
        linea[7] = Double.toString(K.get(pos) - K.get(pos-1));                                            //operacion para el delta de K
        linea[8] = Integer.toString(decisionNaOK(K.get(pos) - K.get(pos-1)));                             //distic
        
        return linea;
    }

    public int decisionEdad(int valor) {
        if(valor > 0)
            return 1;
        else
            return 0;
    }
    
    public int decisionNaOK(double valor) {
        if(valor > 0)
            return 1;
        else
            return 0;
    }
    
    public int sumaDeltaEnteros(ArrayList<Integer> lista) {
        int resultado = 0;
        for (int i = 1; i < lista.size(); i++) {
            resultado = resultado + (lista.get(i) - lista.get(i-1));
        }
        return resultado;
    }
    
    public double sumaDeltaDouble(ArrayList<Double> lista) {
        double resultado = 0.0;
        for (int i = 1; i < lista.size(); i++) {
            resultado = resultado + (lista.get(i) - lista.get(i-1));
        }
        return resultado;
    }
    
    public int sumaDisticEntero(ArrayList<Integer> lista) {
        int resultado = 0;
        for (int i = 1; i < lista.size(); i++) {
            resultado = resultado + (decisionEdad(lista.get(i) - lista.get(i-1)));
        }
        return resultado;
    }
    
    public int sumaDisticDouble(ArrayList<Double> lista) {
        int resultado = 0;
        for (int i = 1; i < lista.size(); i++) {
            resultado = resultado + (decisionNaOK(lista.get(i) - lista.get(i-1)));
        }
        return resultado;
    }
    
    public String[] calculosOrdenamiento(ArrayList<Integer> edad, ArrayList<Double> Na, ArrayList<Double> K) {
        String[] calculos = new String[9];
        calculos[0] = Integer.toString(sumaDeltaEnteros(edad));
        calculos[1] = Integer.toString(sumaDisticEntero(edad));
        calculos[2] = Double.toString(sumaDeltaDouble(Na));
        calculos[3] = Double.toString(sumaDisticDouble(Na));
        calculos[4] = Double.toString(sumaDeltaDouble(K));
        calculos[5] = Double.toString(sumaDisticDouble(K));
        calculos[6] = Double.toString((double)sumaDeltaEnteros(edad)/(double)sumaDisticEntero(edad));
        calculos[7] = Double.toString(sumaDeltaDouble(Na)/sumaDisticDouble(Na));
        calculos[8] = Double.toString(sumaDeltaDouble(K)/sumaDisticDouble(K));
        
        return calculos;
    }
    
    public ArrayList<String> procesarListaEnteros(ArrayList<Integer> listaEdad, Double precision) {
        ArrayList<String> listaProcesada = new ArrayList<>();
        for (int i = 0; i < listaEdad.size(); i++) {
            listaProcesada.add(Double.toString((Math.round(listaEdad.get(i)/precision)) * precision));
        }
        return listaProcesada;
    }
    
    public ArrayList<String> procesarListaDecimales(ArrayList<Double> lista, Double precision) {
        ArrayList<String> listaProcesada = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            listaProcesada.add(Double.toString((Math.ceil(lista.get(i)/precision)) * precision));
        }
        return listaProcesada;
    }
    
}
