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
public class Probabilidad {
    
    public String[] tabla1(String[][] datosProcesados) {
        //int[] conteo = new int[6];
        int t1 = 0; int t2 = 0; int t3 = 0; int t4 = 0; int t5 = 0;
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA")) { t1++; }
            if (datosProcesados[i][6].equals("drugB")) { t2++; }
            if (datosProcesados[i][6].equals("drugC")) { t3++; }
            if (datosProcesados[i][6].equals("drugX")) { t4++; }
            if (datosProcesados[i][6].equals("drugY")) { t5++; }
        }
        String[] conteo = {Integer.toString(t1), Integer.toString(t2), Integer.toString(t3), Integer.toString(t4), Integer.toString(t5), Integer.toString((t1+t2+t3+t4+t5))};
        
        for (int i = 0; i < 6; i++) {
            System.out.print("  " + conteo[i]);
        }
        System.out.println("\n");
        
        return conteo;
    }
    
    public String[][] tabla2(String[][] datosProcesados, Double precisionEdad) {
        String[][] datosT2 = new String[4][5];
        int c1 = 0; int c2 = 0; int c3 = 0; int c4 = 0; int c5 = 0;
        double d1, d2, d3, d4, d5;
        double s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0;
        double a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;
        double m1, m2, m3, m4, m5;
        for (int i = 0; i < 200; i++) {
            if(datosProcesados[i][6].equals("drugA")) {
                a1 = a1 + Double.parseDouble(datosProcesados[i][0]);
                c1++;
            }
            if(datosProcesados[i][6].equals("drugB")) {
                a2 = a2 + Double.parseDouble(datosProcesados[i][0]);
                c2++;
            }
            if(datosProcesados[i][6].equals("drugC")) {
                a3 = a3 + Double.parseDouble(datosProcesados[i][0]);
                c3++;
            }
            if(datosProcesados[i][6].equals("drugX")) {
                a4 = a4 + Double.parseDouble(datosProcesados[i][0]);
                c4++;
            }
            if(datosProcesados[i][6].equals("drugY")) {
                a5 = a5 + Double.parseDouble(datosProcesados[i][0]);
                c5++;
            }
        }
        m1 = a1/c1; m2 = a2/c2; m3 = a3/c3; m4 = a4/c4; m5 = a5/c5;
        
        datosT2[0][0] = Double.toString(m1); datosT2[0][1] = Double.toString(m2); datosT2[0][2] = Double.toString(m3); datosT2[0][3] = Double.toString(m4); datosT2[0][4] = Double.toString(m5);
        
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugA")) s1 = s1 + (double) Math.pow(Double.parseDouble(datosProcesados[i][0]), 2); } s1 = s1/c1;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugB")) s2 = s2 + (double) Math.pow(Double.parseDouble(datosProcesados[i][0]), 2); } s2 = s2/c2;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugC")) s3 = s3 + (double) Math.pow(Double.parseDouble(datosProcesados[i][0]), 2); } s3 = s3/c3;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugX")) s4 = s4 + (double) Math.pow(Double.parseDouble(datosProcesados[i][0]), 2); } s4 = s4/c4;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugY")) s5 = s5 + (double) Math.pow(Double.parseDouble(datosProcesados[i][0]), 2); } s5 = s5/c5;
        
        d1 = Math.sqrt(s1 - Math.pow(m1, 2));
        d2 = Math.sqrt(s2 - Math.pow(m2, 2));
        d3 = Math.sqrt(s3 - Math.pow(m3, 2));
        d4 = Math.sqrt(s4 - Math.pow(m4, 2));
        d5 = Math.sqrt(s5 - Math.pow(m5, 2));
        
        datosT2[1][0] = Double.toString(d1); datosT2[1][1] = Double.toString(d2); datosT2[1][2] = Double.toString(d3); datosT2[1][3] = Double.toString(d4); datosT2[1][4] = Double.toString(d5);
        
        datosT2[2][0] = tabla1(datosProcesados)[0]; datosT2[2][1] = tabla1(datosProcesados)[1]; datosT2[2][2] = tabla1(datosProcesados)[2]; datosT2[2][3] = tabla1(datosProcesados)[3]; datosT2[2][4] = tabla1(datosProcesados)[4];
        
        datosT2[3][0] = Double.toString(precisionEdad); datosT2[3][1] = Double.toString(precisionEdad); datosT2[3][2] = Double.toString(precisionEdad); datosT2[3][3] = Double.toString(precisionEdad); datosT2[3][4] = Double.toString(precisionEdad);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("  " + datosT2[i][j]);
            }
            System.out.println("\n");
        }
        
        return datosT2;
    }
    
    public String[][] tabla3(String[][] datosProcesados) {
        String[][] datosT3 = new String[3][6];
        int tF1 = 1; int tF2 = 1; int tF3 = 1; int tF4 = 1; int tF5 = 1;
        int tM1 = 1; int tM2 = 1; int tM3 = 1; int tM4 = 1; int tM5 = 1;
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][1].equals("F")) { tF1++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][1].equals("F")) { tF2++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][1].equals("F")) { tF3++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][1].equals("F")) { tF4++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][1].equals("F")) { tF5++; }
        }
        
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][1].equals("M")) { tM1++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][1].equals("M")) { tM2++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][1].equals("M")) { tM3++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][1].equals("M")) { tM4++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][1].equals("M")) { tM5++; }
        }
        
        datosT3[0][0] = Integer.toString(tF1); datosT3[0][1] = Integer.toString(tF2); datosT3[0][2] = Integer.toString(tF3); datosT3[0][3] = Integer.toString(tF4); datosT3[0][4] = Integer.toString(tF5); datosT3[0][5] = Integer.toString(tF1+tF2+tF3+tF4+tF5);
        datosT3[1][0] = Integer.toString(tM1); datosT3[1][1] = Integer.toString(tM2); datosT3[1][2] = Integer.toString(tM3); datosT3[1][3] = Integer.toString(tM4); datosT3[1][4] = Integer.toString(tM5); datosT3[1][5] = Integer.toString(tM1+tM2+tM3+tM4+tM5);
        
        datosT3[2][0] = Integer.toString(Integer.parseInt(datosT3[0][0]) + Integer.parseInt(datosT3[1][0]));
        datosT3[2][1] = Integer.toString(Integer.parseInt(datosT3[0][1]) + Integer.parseInt(datosT3[1][1]));
        datosT3[2][2] = Integer.toString(Integer.parseInt(datosT3[0][2]) + Integer.parseInt(datosT3[1][2]));
        datosT3[2][3] = Integer.toString(Integer.parseInt(datosT3[0][3]) + Integer.parseInt(datosT3[1][3]));
        datosT3[2][4] = Integer.toString(Integer.parseInt(datosT3[0][4]) + Integer.parseInt(datosT3[1][4]));
        datosT3[2][5] = Integer.toString(Integer.parseInt(datosT3[0][5]) + Integer.parseInt(datosT3[1][5]));
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("  " + datosT3[i][j]);
            }
            System.out.println("\n");
        }
        
        return datosT3;
    }
    
    public String[][] tabla4(String[][] datosProcesados) {
        String[][] datosT4 = new String[4][6];
        int tHA = 1; int tHB = 1; int tHC = 1; int tHX = 1; int tHY = 1;
        int tNA = 1; int tNB = 1; int tNC = 1; int tNX = 1; int tNY = 1;
        int tLA = 1; int tLB = 1; int tLC = 1; int tLX = 1; int tLY = 1;
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][2].equals("HIGH")) { tHA++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][2].equals("HIGH")) { tHB++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][2].equals("HIGH")) { tHC++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][2].equals("HIGH")) { tHX++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][2].equals("HIGH")) { tHY++; }
        }
        
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][2].equals("NORMAL")) { tNA++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][2].equals("NORMAL")) { tNB++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][2].equals("NORMAL")) { tNC++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][2].equals("NORMAL")) { tNX++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][2].equals("NORMAL")) { tNY++; }
        }
        
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][2].equals("LOW")) { tLA++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][2].equals("LOW")) { tLB++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][2].equals("LOW")) { tLC++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][2].equals("LOW")) { tLX++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][2].equals("LOW")) { tLY++; }
        }
        
        datosT4[0][0] = Integer.toString(tHA); datosT4[0][1] = Integer.toString(tHB); datosT4[0][2] = Integer.toString(tHC); datosT4[0][3] = Integer.toString(tHX); datosT4[0][4] = Integer.toString(tHY); datosT4[0][5] = Integer.toString(tHA+tHB+tHC+tHX+tHY);
        datosT4[1][0] = Integer.toString(tNA); datosT4[1][1] = Integer.toString(tNB); datosT4[1][2] = Integer.toString(tNC); datosT4[1][3] = Integer.toString(tNX); datosT4[1][4] = Integer.toString(tNY); datosT4[1][5] = Integer.toString(tNA+tNB+tNC+tNX+tNY);
        datosT4[2][0] = Integer.toString(tLA); datosT4[2][1] = Integer.toString(tLB); datosT4[2][2] = Integer.toString(tLC); datosT4[2][3] = Integer.toString(tLX); datosT4[2][4] = Integer.toString(tLY); datosT4[2][5] = Integer.toString(tLA+tLB+tLC+tLX+tLY);
        
        datosT4[3][0] = Integer.toString(Integer.parseInt(datosT4[0][0]) + Integer.parseInt(datosT4[1][0]) + Integer.parseInt(datosT4[2][0]));
        datosT4[3][1] = Integer.toString(Integer.parseInt(datosT4[0][1]) + Integer.parseInt(datosT4[1][1]) + Integer.parseInt(datosT4[2][1]));
        datosT4[3][2] = Integer.toString(Integer.parseInt(datosT4[0][2]) + Integer.parseInt(datosT4[1][2]) + Integer.parseInt(datosT4[2][2]));
        datosT4[3][3] = Integer.toString(Integer.parseInt(datosT4[0][3]) + Integer.parseInt(datosT4[1][3]) + Integer.parseInt(datosT4[2][3]));
        datosT4[3][4] = Integer.toString(Integer.parseInt(datosT4[0][4]) + Integer.parseInt(datosT4[1][4]) + Integer.parseInt(datosT4[2][4]));
        datosT4[3][5] = Integer.toString(Integer.parseInt(datosT4[0][5]) + Integer.parseInt(datosT4[1][5]) + Integer.parseInt(datosT4[2][5]));
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("  " + datosT4[i][j]);
            }
            System.out.println("\n");
        }
        
        return datosT4;
    }
    
    public String[][] tabla5(String[][] datosProcesados) {
        String[][] datosT5 = new String[4][6];
        int tHA = 1; int tHB = 1; int tHC = 1; int tHX = 1; int tHY = 1;
        int tNA = 1; int tNB = 1; int tNC = 1; int tNX = 1; int tNY = 1;
        int tLA = 1; int tLB = 1; int tLC = 1; int tLX = 1; int tLY = 1;
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][3].equals("HIGH")) { tHA++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][3].equals("HIGH")) { tHB++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][3].equals("HIGH")) { tHC++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][3].equals("HIGH")) { tHX++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][3].equals("HIGH")) { tHY++; }
        }
        
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][3].equals("NORMAL")) { tNA++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][3].equals("NORMAL")) { tNB++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][3].equals("NORMAL")) { tNC++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][3].equals("NORMAL")) { tNX++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][3].equals("NORMAL")) { tNY++; }
        }
        
        for (int i = 0; i < 200; i++) {
            if (datosProcesados[i][6].equals("drugA") && datosProcesados[i][3].equals("LOW")) { tLA++; }
            if (datosProcesados[i][6].equals("drugB") && datosProcesados[i][3].equals("LOW")) { tLB++; }
            if (datosProcesados[i][6].equals("drugC") && datosProcesados[i][3].equals("LOW")) { tLC++; }
            if (datosProcesados[i][6].equals("drugX") && datosProcesados[i][3].equals("LOW")) { tLX++; }
            if (datosProcesados[i][6].equals("drugY") && datosProcesados[i][3].equals("LOW")) { tLY++; }
        }
        
        datosT5[0][0] = Integer.toString(tHA); datosT5[0][1] = Integer.toString(tHB); datosT5[0][2] = Integer.toString(tHC); datosT5[0][3] = Integer.toString(tHX); datosT5[0][4] = Integer.toString(tHY); datosT5[0][5] = Integer.toString(tHA+tHB+tHC+tHX+tHY);
        datosT5[1][0] = Integer.toString(tNA); datosT5[1][1] = Integer.toString(tNB); datosT5[1][2] = Integer.toString(tNC); datosT5[1][3] = Integer.toString(tNX); datosT5[1][4] = Integer.toString(tNY); datosT5[1][5] = Integer.toString(tNA+tNB+tNC+tNX+tNY);
        datosT5[2][0] = Integer.toString(tLA); datosT5[2][1] = Integer.toString(tLB); datosT5[2][2] = Integer.toString(tLC); datosT5[2][3] = Integer.toString(tLX); datosT5[2][4] = Integer.toString(tLY); datosT5[2][5] = Integer.toString(tLA+tLB+tLC+tLX+tLY);
        
        datosT5[3][0] = Integer.toString(Integer.parseInt(datosT5[0][0]) + Integer.parseInt(datosT5[1][0]) + Integer.parseInt(datosT5[2][0]));
        datosT5[3][1] = Integer.toString(Integer.parseInt(datosT5[0][1]) + Integer.parseInt(datosT5[1][1]) + Integer.parseInt(datosT5[2][1]));
        datosT5[3][2] = Integer.toString(Integer.parseInt(datosT5[0][2]) + Integer.parseInt(datosT5[1][2]) + Integer.parseInt(datosT5[2][2]));
        datosT5[3][3] = Integer.toString(Integer.parseInt(datosT5[0][3]) + Integer.parseInt(datosT5[1][3]) + Integer.parseInt(datosT5[2][3]));
        datosT5[3][4] = Integer.toString(Integer.parseInt(datosT5[0][4]) + Integer.parseInt(datosT5[1][4]) + Integer.parseInt(datosT5[2][4]));
        datosT5[3][5] = Integer.toString(Integer.parseInt(datosT5[0][5]) + Integer.parseInt(datosT5[1][5]) + Integer.parseInt(datosT5[2][5]));
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("  " + datosT5[i][j]);
            }
            System.out.println("\n");
        }
        
        return datosT5;
    }
    
    public String[][] tabla6(String[][] datosProcesados, Double precisionNa) {
        String[][] datosT6 = new String[4][5];
        int c1 = 0; int c2 = 0; int c3 = 0; int c4 = 0; int c5 = 0;
        double d1, d2, d3, d4, d5;
        double s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0;
        double a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;
        double m1, m2, m3, m4, m5;
        for (int i = 0; i < 200; i++) {
            if(datosProcesados[i][6].equals("drugA")) {
                a1 = a1 + Double.parseDouble(datosProcesados[i][4]);
                c1++;
            }
            if(datosProcesados[i][6].equals("drugB")) {
                a2 = a2 + Double.parseDouble(datosProcesados[i][4]);
                c2++;
            }
            if(datosProcesados[i][6].equals("drugC")) {
                a3 = a3 + Double.parseDouble(datosProcesados[i][4]);
                c3++;
            }
            if(datosProcesados[i][6].equals("drugX")) {
                a4 = a4 + Double.parseDouble(datosProcesados[i][4]);
                c4++;
            }
            if(datosProcesados[i][6].equals("drugY")) {
                a5 = a5 + Double.parseDouble(datosProcesados[i][4]);
                c5++;
            }
        }
        m1 = a1/c1; m2 = a2/c2; m3 = a3/c3; m4 = a4/c4; m5 = a5/c5;
        
        datosT6[0][0] = Double.toString(m1); datosT6[0][1] = Double.toString(m2); datosT6[0][2] = Double.toString(m3); datosT6[0][3] = Double.toString(m4); datosT6[0][4] = Double.toString(m5);
        
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugA")) s1 = s1 + (double) Math.pow(Double.parseDouble(datosProcesados[i][4]), 2); } s1 = s1/c1;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugB")) s2 = s2 + (double) Math.pow(Double.parseDouble(datosProcesados[i][4]), 2); } s2 = s2/c2;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugC")) s3 = s3 + (double) Math.pow(Double.parseDouble(datosProcesados[i][4]), 2); } s3 = s3/c3;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugX")) s4 = s4 + (double) Math.pow(Double.parseDouble(datosProcesados[i][4]), 2); } s4 = s4/c4;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugY")) s5 = s5 + (double) Math.pow(Double.parseDouble(datosProcesados[i][4]), 2); } s5 = s5/c5;
        
        d1 = Math.sqrt(s1 - Math.pow(m1, 2));
        d2 = Math.sqrt(s2 - Math.pow(m2, 2));
        d3 = Math.sqrt(s3 - Math.pow(m3, 2));
        d4 = Math.sqrt(s4 - Math.pow(m4, 2));
        d5 = Math.sqrt(s5 - Math.pow(m5, 2));
        
        datosT6[1][0] = Double.toString(d1); datosT6[1][1] = Double.toString(d2); datosT6[1][2] = Double.toString(d3); datosT6[1][3] = Double.toString(d4); datosT6[1][4] = Double.toString(d5);
        
        datosT6[2][0] = tabla1(datosProcesados)[0]; datosT6[2][1] = tabla1(datosProcesados)[1]; datosT6[2][2] = tabla1(datosProcesados)[2]; datosT6[2][3] = tabla1(datosProcesados)[3]; datosT6[2][4] = tabla1(datosProcesados)[4];
        
        datosT6[3][0] = Double.toString(precisionNa); datosT6[3][1] = Double.toString(precisionNa); datosT6[3][2] = Double.toString(precisionNa); datosT6[3][3] = Double.toString(precisionNa); datosT6[3][4] = Double.toString(precisionNa);
        
        System.out.println("\n");
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("  " + datosT6[i][j]);
            }
            System.out.println("\n");
        }
        
        return datosT6;
    }
    
    
    public String[][] tabla7(String[][] datosProcesados, Double precisionK) {
        String[][] datosT7 = new String[4][5];
        int c1 = 0; int c2 = 0; int c3 = 0; int c4 = 0; int c5 = 0;
        double d1, d2, d3, d4, d5;
        double s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0;
        double a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;
        double m1, m2, m3, m4, m5;
        for (int i = 0; i < 200; i++) {
            if(datosProcesados[i][6].equals("drugA")) {
                a1 = a1 + Double.parseDouble(datosProcesados[i][5]);
                c1++;
            }
            if(datosProcesados[i][6].equals("drugB")) {
                a2 = a2 + Double.parseDouble(datosProcesados[i][5]);
                c2++;
            }
            if(datosProcesados[i][6].equals("drugC")) {
                a3 = a3 + Double.parseDouble(datosProcesados[i][5]);
                c3++;
            }
            if(datosProcesados[i][6].equals("drugX")) {
                a4 = a4 + Double.parseDouble(datosProcesados[i][5]);
                c4++;
            }
            if(datosProcesados[i][6].equals("drugY")) {
                a5 = a5 + Double.parseDouble(datosProcesados[i][5]);
                c5++;
            }
        }
        m1 = a1/c1; m2 = a2/c2; m3 = a3/c3; m4 = a4/c4; m5 = a5/c5;
        
        datosT7[0][0] = Double.toString(m1); datosT7[0][1] = Double.toString(m2); datosT7[0][2] = Double.toString(m3); datosT7[0][3] = Double.toString(m4); datosT7[0][4] = Double.toString(m5);
        
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugA")) s1 = s1 + (double) Math.pow(Double.parseDouble(datosProcesados[i][5]), 2); } s1 = s1/c1;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugB")) s2 = s2 + (double) Math.pow(Double.parseDouble(datosProcesados[i][5]), 2); } s2 = s2/c2;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugC")) s3 = s3 + (double) Math.pow(Double.parseDouble(datosProcesados[i][5]), 2); } s3 = s3/c3;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugX")) s4 = s4 + (double) Math.pow(Double.parseDouble(datosProcesados[i][5]), 2); } s4 = s4/c4;
        for (int i = 0; i < 200; i++) { if (datosProcesados[i][6].equals("drugY")) s5 = s5 + (double) Math.pow(Double.parseDouble(datosProcesados[i][5]), 2); } s5 = s5/c5;
        
        d1 = Math.sqrt(s1 - Math.pow(m1, 2));
        d2 = Math.sqrt(s2 - Math.pow(m2, 2));
        d3 = Math.sqrt(s3 - Math.pow(m3, 2));
        d4 = Math.sqrt(s4 - Math.pow(m4, 2));
        d5 = Math.sqrt(s5 - Math.pow(m5, 2));
        
        datosT7[1][0] = Double.toString(d1); datosT7[1][1] = Double.toString(d2); datosT7[1][2] = Double.toString(d3); datosT7[1][3] = Double.toString(d4); datosT7[1][4] = Double.toString(d5);
        
        datosT7[2][0] = tabla1(datosProcesados)[0]; datosT7[2][1] = tabla1(datosProcesados)[1]; datosT7[2][2] = tabla1(datosProcesados)[2]; datosT7[2][3] = tabla1(datosProcesados)[3]; datosT7[2][4] = tabla1(datosProcesados)[4];
        
        datosT7[3][0] = Double.toString(precisionK); datosT7[3][1] = Double.toString(precisionK); datosT7[3][2] = Double.toString(precisionK); datosT7[3][3] = Double.toString(precisionK); datosT7[3][4] = Double.toString(precisionK);
        
        System.out.println("\n");
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("  " + datosT7[i][j]);
            }
            System.out.println("\n");
        }
        
        return datosT7;
    }
    
    
    
        
    
}
