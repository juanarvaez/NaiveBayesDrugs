/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Archivo;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 *
 * @author Juan Carlos Narvaez
 */
public class TablasEntrenamiento extends javax.swing.JFrame {
    
    DefaultTableModel t1, t2, t3, t4, t5, t6, t7, t8, t9;
    ArrayList<String[]> datosEntrenamiento = new ArrayList<>();
    String[] datosNuevoRegistro = new String[7];
    String[] datosNuevosNormalizados;
    String[][] probabilidades = new String[9][5];
    Archivo archivo = new Archivo();

    /**
     * Creates new form TablasEntrenamiento
     */
    public TablasEntrenamiento() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        jPanel1.setBackground(Color.white);
        this.setLocationRelativeTo(null);
        prepararTablas();
        datosEntrenamiento = archivo.leerDatosEntrenamiento();
        llenarTablas();
    }
    
    public final void prepararTablas() {
        t1 = new DefaultTableModel();    t2 = new DefaultTableModel();    t3 = new DefaultTableModel();
        t4 = new DefaultTableModel();    t5 = new DefaultTableModel();    t6 = new DefaultTableModel();
        t7 = new DefaultTableModel();    t8 = new DefaultTableModel();    t9 = new DefaultTableModel();
        
        t1.addColumn("drugA");      t2.addColumn("drugA");      t6.addColumn("drugA");      t9.addColumn("drugA");
        t1.addColumn("drugB");      t2.addColumn("drugB");      t6.addColumn("drugB");      t9.addColumn("drugB");
        t1.addColumn("drugC");      t2.addColumn("drugC");      t6.addColumn("drugC");      t9.addColumn("drugC");
        t1.addColumn("drugX");      t2.addColumn("drugX");      t6.addColumn("drugD");      t9.addColumn("drugX");
        t1.addColumn("drugY");      t2.addColumn("drugY");      t6.addColumn("drugX");      t9.addColumn("drugY");
        t1.addColumn("Total");      t2.addColumn("Total");      t6.addColumn("Total");      t9.addColumn("Total");
        
        t3.addColumn("drugA");      t4.addColumn("drugA");      t5.addColumn("drugA");      t7.addColumn("drugA");
        t3.addColumn("drugB");      t4.addColumn("drugB");      t5.addColumn("drugB");      t7.addColumn("drugB");
        t3.addColumn("drugC");      t4.addColumn("drugC");      t5.addColumn("drugC");      t7.addColumn("drugC");
        t3.addColumn("drugX");      t4.addColumn("drugX");      t5.addColumn("drugX");      t7.addColumn("drugX");
        t3.addColumn("drugY");      t4.addColumn("drugY");      t5.addColumn("drugY");      t7.addColumn("drugY");
        
        t8.addColumn("Edad");
        t8.addColumn("Sexo");
        t8.addColumn("BP");
        t8.addColumn("Colesterol");
        t8.addColumn("Na");
        t8.addColumn("K");
        t8.addColumn("Droga");
        
        
        this.tablaBP.setModel(t1);
        this.tablaColesterol.setModel(t2);
        this.tablaNa.setModel(t3);
        this.tablaK.setModel(t4);
        this.tablaEdad.setModel(t5);
        this.tablaSexo.setModel(t6);
        this.tablaProbabilidadesGenerales.setModel(t7);
        this.tablaDatosInicialesNormalizados.setModel(t8);
        this.tablaTotales.setModel(t9);
    }
    
    public final void llenarTablas() {
        t9.addRow(datosEntrenamiento.get(0));
        
        for (int i = 1; i < 5; i++) t5.addRow(datosEntrenamiento.get(i));
        for (int i = 5; i < 8; i++) t6.addRow(datosEntrenamiento.get(i));
        for (int i = 8; i < 12; i++) t1.addRow(datosEntrenamiento.get(i));
        for (int i = 12; i < 16; i++) t2.addRow(datosEntrenamiento.get(i));
        for (int i = 16; i < 20; i++) t3.addRow(datosEntrenamiento.get(i));
        for (int i = 20; i < 24; i++) t4.addRow(datosEntrenamiento.get(i));
    }
    
    public void obtenerDatosEntrada() {
        datosNuevoRegistro[0] = "49";//txtEdad.getText();
        datosNuevoRegistro[1] = "F";//txtSexo.getText();
        datosNuevoRegistro[2] = "NORMAL";//txtBP.getText();
        datosNuevoRegistro[3] = "HIGH";//txtColesterol.getText();
        datosNuevoRegistro[4] = "0.789637";//txtNa.getText();
        datosNuevoRegistro[5] = "0.048518";//txtK.getText();
        datosNuevoRegistro[6] = "drugY";//txtDrogaEntrada.getText();
    }
    
    public void normalizarDatosEntrada() {
        datosNuevosNormalizados = datosNuevoRegistro;
        datosNuevosNormalizados[0] = Double.toString((Math.round(Integer.parseInt(datosNuevoRegistro[0])/Double.parseDouble(datosEntrenamiento.get(4)[0]))) * Double.parseDouble(datosEntrenamiento.get(4)[0]));
        datosNuevosNormalizados[4] = Double.toString((Math.round(Double.parseDouble(datosNuevoRegistro[4])/Double.parseDouble(datosEntrenamiento.get(19)[0]))) * Double.parseDouble(datosEntrenamiento.get(19)[0]));
        datosNuevosNormalizados[5] = Double.toString((Math.round(Double.parseDouble(datosNuevoRegistro[5])/Double.parseDouble(datosEntrenamiento.get(23)[0]))) * Double.parseDouble(datosEntrenamiento.get(23)[0]));
    }
    
    public void llenarTablaProbabilidades() {
        PApriori();
        PAge();
        PSex();
        PBP();
        PCholesterol();
        PNa();
        PK();
    }
    
    public void PApriori() {
        String[] linea = new String[5];
        for (int i = 0; i < datosEntrenamiento.get(0).length - 1; i++) {
            probabilidades[0][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(0)[i])/Double.parseDouble(datosEntrenamiento.get(0)[5]));
            linea[i] = probabilidades[0][i];
        }
        t7.addRow(linea);
    }
    
    public void PAge() {
        String[] linea = new String[5];
        
        for (int i = 0; i < datosEntrenamiento.get(1).length; i++) {
            NormalDistribution normal = new NormalDistribution(Double.parseDouble(datosEntrenamiento.get(1)[i]), Double.parseDouble(datosEntrenamiento.get(2)[i]));
            probabilidades[1][i] = Double.toString(normal.density(Double.parseDouble(datosNuevosNormalizados[0])));
            linea[i] = probabilidades[1][i];
        }
        t7.addRow(linea);
    }
    
    public void PSex() {
        String[] linea = new String[5];
        if(datosNuevoRegistro[1].equals("F")) {
            for (int i = 0; i < datosEntrenamiento.get(5).length - 1; i++) {
                probabilidades[2][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(5)[i])/Double.parseDouble(datosEntrenamiento.get(7)[i]));
                linea[i] = probabilidades[2][i];
            }
        }
        else {
            for (int i = 0; i < datosEntrenamiento.get(6).length - 1; i++) {
                probabilidades[2][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(6)[i])/Double.parseDouble(datosEntrenamiento.get(7)[i]));
                linea[i] = probabilidades[2][i];
            }
        }
        t7.addRow(linea);        
    }
    
    public void PBP() {
        String[] linea = new String[5];
        if(datosNuevoRegistro[2].equals("HIGH")) {
            for (int i = 0; i < datosEntrenamiento.get(8).length - 1; i++) {
                probabilidades[3][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(8)[i])/Double.parseDouble(datosEntrenamiento.get(11)[i]));
                linea[i] = probabilidades[3][i];
            }
        }
        else {
            if(datosNuevoRegistro[2].equals("NORMAL")) {
                for (int i = 0; i < datosEntrenamiento.get(9).length - 1; i++) {
                    probabilidades[3][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(9)[i])/Double.parseDouble(datosEntrenamiento.get(11)[i]));
                    linea[i] = probabilidades[3][i];
                }
            }
            else {
                for (int i = 0; i < datosEntrenamiento.get(10).length - 1; i++) {
                    probabilidades[3][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(10)[i])/Double.parseDouble(datosEntrenamiento.get(11)[i]));
                    linea[i] = probabilidades[3][i];
                }
            }
        }
        t7.addRow(linea);        
    }
    
    public void PCholesterol() {
        String[] linea = new String[5];
        if(datosNuevoRegistro[3].equals("HIGH")) {
            for (int i = 0; i < datosEntrenamiento.get(12).length - 1; i++) {
                probabilidades[4][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(12)[i])/Double.parseDouble(datosEntrenamiento.get(15)[i]));
                linea[i] = probabilidades[4][i];
            }
        }
        else {
            if(datosNuevoRegistro[2].equals("NORMAL")) {
                for (int i = 0; i < datosEntrenamiento.get(13).length - 1; i++) {
                    probabilidades[4][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(13)[i])/Double.parseDouble(datosEntrenamiento.get(15)[i]));
                    linea[i] = probabilidades[4][i];
                }
            }
            else {
                for (int i = 0; i < datosEntrenamiento.get(14).length - 1; i++) {
                    probabilidades[4][i] = Double.toString(Double.parseDouble(datosEntrenamiento.get(14)[i])/Double.parseDouble(datosEntrenamiento.get(15)[i]));
                    linea[i] = probabilidades[4][i];
                }
            }
        }
        t7.addRow(linea);        
    }
    
    public void PNa() {
        String[] linea = new String[5];
        
        for (int i = 0; i < datosEntrenamiento.get(16).length; i++) {
            NormalDistribution normal = new NormalDistribution(Double.parseDouble(datosEntrenamiento.get(16)[i]), Double.parseDouble(datosEntrenamiento.get(17)[i]));
            probabilidades[5][i] = Double.toString(normal.density(Double.parseDouble(datosNuevosNormalizados[4])));
            linea[i] = probabilidades[5][i];
        }
        t7.addRow(linea);
    }
    
    public void PK() {
        String[] linea = new String[5];
        
        for (int i = 0; i < datosEntrenamiento.get(20).length; i++) {
            NormalDistribution normal = new NormalDistribution(Double.parseDouble(datosEntrenamiento.get(20)[i]), Double.parseDouble(datosEntrenamiento.get(21)[i]));
            probabilidades[6][i] = Double.toString(normal.density(Double.parseDouble(datosNuevosNormalizados[5])));
            linea[i] = probabilidades[6][i];
        }
        t7.addRow(linea);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBP = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEdad = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaColesterol = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaSexo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaK = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaNa = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaProbabilidadesGenerales = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaDatosInicialesNormalizados = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtEdad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtColesterol = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtK = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDrogaEntrada = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtProbabilidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDrogaResultado = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaTotales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaBP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaBP);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 432, 92));

        tablaEdad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaEdad);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 432, 92));

        tablaColesterol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaColesterol);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 29, 510, 92));

        jLabel1.setText("Tabla 1: BP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 64, -1));

        jLabel2.setText("Tabla 2: Colesterol");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 11, 107, -1));

        jLabel3.setText("Tabla 3: Na");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 71, -1));

        jLabel4.setText("Tabla 5: Edad");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 85, -1));

        tablaSexo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablaSexo);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 270, 510, 76));

        jLabel5.setText("Tabla 6: Sexo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 250, 107, -1));

        tablaK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tablaK);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 147, 510, 92));

        jLabel6.setText("Tabla 4: K");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 127, 108, -1));

        tablaNa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tablaNa);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 147, 432, 92));

        tablaProbabilidadesGenerales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaProbabilidadesGenerales);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 393, 432, 172));

        tablaDatosInicialesNormalizados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tablaDatosInicialesNormalizados);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 393, 510, 59));

        jLabel7.setText("Tabla 7: Probabilidades generales");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 373, 215, -1));

        jLabel8.setText("Tabla 8: Datos entrada/normalizados");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 373, 210, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo registro"));

        jLabel9.setText("Colesterol:");

        jLabel10.setText("Sexo:");

        jLabel11.setText("BP:");

        jLabel12.setText("Edad:");

        jLabel16.setText("    Na:");

        jLabel17.setText("  K:");

        jLabel18.setText("Droga:");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSexo)
                            .addComponent(txtNa, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBP)
                            .addComponent(txtK, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDrogaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColesterol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addComponent(txtNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtDrogaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 510, -1));

        jLabel13.setText("Probabilidad:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, 20));
        getContentPane().add(txtProbabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 470, 68, -1));

        jLabel14.setText("Porcentaje:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 473, -1, -1));
        getContentPane().add(txtPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 68, -1));

        jLabel15.setText("Droga:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, -1, 20));
        getContentPane().add(txtDrogaResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 470, 68, -1));

        jLabel19.setText("Tabla 9: Totales de cada droga");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 576, 207, -1));

        tablaTotales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tablaTotales);

        getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 601, 432, 44));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        obtenerDatosEntrada();
        t8.addRow(datosNuevoRegistro);
        normalizarDatosEntrada();
        t8.addRow(datosNuevosNormalizados);
        llenarTablaProbabilidades();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TablasEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablasEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablasEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablasEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablasEntrenamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable tablaBP;
    private javax.swing.JTable tablaColesterol;
    private javax.swing.JTable tablaDatosInicialesNormalizados;
    private javax.swing.JTable tablaEdad;
    private javax.swing.JTable tablaK;
    private javax.swing.JTable tablaNa;
    private javax.swing.JTable tablaProbabilidadesGenerales;
    private javax.swing.JTable tablaSexo;
    private javax.swing.JTable tablaTotales;
    private javax.swing.JTextField txtBP;
    private javax.swing.JTextField txtColesterol;
    private javax.swing.JTextField txtDrogaEntrada;
    private javax.swing.JTextField txtDrogaResultado;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtK;
    private javax.swing.JTextField txtNa;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtProbabilidad;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables

    
}
