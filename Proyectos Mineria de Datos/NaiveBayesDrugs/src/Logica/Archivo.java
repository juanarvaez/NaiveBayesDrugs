/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Juan Carlos Narvaez
 */
public class Archivo {
    
    ArrayList<String> contenido = new ArrayList<>();
    ArrayList<String[]> parametros = new ArrayList<>();
    ArrayList<Integer> edad = new ArrayList<>();
    ArrayList<Double> Na = new ArrayList<>();
    ArrayList<Double> K = new ArrayList<>();
    
    //metodo para leer el contenido del archivo y guardarlo en una lista
    public void leerArchivo(String archivo) {
        try {
            String cadena;
            FileReader f = new FileReader(archivo);
            try (BufferedReader b = new BufferedReader(f)) {
                while((cadena = b.readLine()) != null) {
                    contenido.add(cadena); 
                }
            }
        }
        catch(Exception e) { System.err.println("No se ha podido leer el archivo"); }
    }
    
    public void escribirArchivo(ArrayList<String[]> datosEntrenamiento) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("D:\\datosEntrenamiento.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < datosEntrenamiento.size(); i++) {
//                for (int j = 0; j < datosEntrenamiento.get(i).length; j++) {
                    pw.println(prepararLinea(datosEntrenamiento.get(i)));
//                }
            }
            fichero.close();
        } catch (Exception e) { e.printStackTrace(); }

    }
    
    public String prepararLinea(String[] datos) {
        String linea = "";
        for (int i = 0; i < datos.length; i++) {
            if (i != (datos.length - 1)) linea = linea + datos[i] + ",";
            else linea = linea + datos[i];
        }
        return linea;
    }
    
    public boolean existeArchivo(String ruta) {
        File fichero = new File(ruta);
        return fichero.exists();
    }
    
    //Metodo que muestra el valor de los parametros de los atributos
    public void mostrarContenido() {
        for (String[] parametro : parametros) {
            //System.out.print((i+1) + ") ");
            for (String get : parametro) {
                System.out.print(get + "    ");
            }
            System.out.println("\n");
        }
        
//        for (int i = 0; i < parametros.size(); i++) {
//            //System.out.print((i+1) + ") ");
//            for (String get : parametros.get(i)) {
//                System.out.print(get + "    ");
//            }
//            System.out.println("\n");
//        }
    }
    
    //Metodo que lee los parametros de cada atributo, los organiza en un vector y los almacena en una lista
    public void obtenerParametros() {
        for (int i = 11; i < contenido.size(); i++) {
            parametros.add(contenido.get(i).split(","));
        }
        
        for (int i = 0; i < parametros.size(); i++) {
            edad.add(Integer.parseInt(parametros.get(i)[0]));
            Na.add(Double.parseDouble(parametros.get(i)[4]));
            K.add(Double.parseDouble(parametros.get(i)[5]));
        }
        
        Collections.sort(edad);
        Collections.sort(Na);
        Collections.sort(K);
    }
    
    public ArrayList<String[]> obtenerListaParametros(String rutaArchivo) {
        leerArchivo(rutaArchivo);
        obtenerParametros();
        return parametros;
    }
    
    public ArrayList<Integer> obtenerListaEdadOrdenada() {
        return edad;
    }
    
    public ArrayList<Double> obtenerListaNaOrdenada() {
        return Na;
    }
    
    public ArrayList<Double> obtenerListaKOrdenada() {
        return K;
    }
    
    public ArrayList<String[]> leerDatosEntrenamiento() {
        ArrayList<String[]> datos = new ArrayList<>();
        
        try {
            String cadena;
            FileReader f = new FileReader("D:\\datosEntrenamiento.txt");
            try (BufferedReader b = new BufferedReader(f)) {
                while((cadena = b.readLine()) != null) {
                    datos.add(cadena.split(","));
                }
            }
            return datos;
        }
        catch(Exception e) { System.err.println("No se ha podido leer el archivo"); return null;}
    }
     
}
