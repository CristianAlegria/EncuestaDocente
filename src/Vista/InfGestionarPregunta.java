/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class InfGestionarPregunta extends javax.swing.JInternalFrame {

    /**
     * Creates new form GestionarPregunta
     */
    private DefaultTableModel defaultTableModel;
    public InfGestionarPregunta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaPregunta = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPregunta = new javax.swing.JTable();
        btnRegistrarPregunta = new javax.swing.JButton();
        btnListarPregunta = new javax.swing.JButton();
        btnModificarPregunta = new javax.swing.JButton();
        lblCaracteristicaPregunta = new javax.swing.JLabel();
        cbxCaracteristicaPregunta = new javax.swing.JComboBox();
        lblMensajeTipoPregunta = new javax.swing.JLabel();
        lblMensajePregunta = new javax.swing.JLabel();
        lblMensajeCaracteristicaPregunta = new javax.swing.JLabel();
        lblMensajeAceptar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo.setText("Gestionar  Preguntas");

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipo.setText("Tipo:");

        lblPregunta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPregunta.setText("Formular Pegunta:");

        txaPregunta.setColumns(20);
        txaPregunta.setRows(5);
        jScrollPane1.setViewportView(txaPregunta);

        tblPregunta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pregunta", "Tipo", "Caracteristica"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPregunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPreguntaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPregunta);

        btnRegistrarPregunta.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarPregunta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegistrarPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoRegistrar.png"))); // NOI18N
        btnRegistrarPregunta.setText("CREAR");
        btnRegistrarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPreguntaActionPerformed(evt);
            }
        });

        btnListarPregunta.setBackground(new java.awt.Color(255, 255, 255));
        btnListarPregunta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnListarPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoMostrarInformacion.png"))); // NOI18N
        btnListarPregunta.setText("LISTAR PREGUNTAS");
        btnListarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPreguntaActionPerformed(evt);
            }
        });

        btnModificarPregunta.setBackground(new java.awt.Color(255, 255, 255));
        btnModificarPregunta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificarPregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoModificar.png"))); // NOI18N
        btnModificarPregunta.setText("MODIFICAR");
        btnModificarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPreguntaActionPerformed(evt);
            }
        });

        lblCaracteristicaPregunta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCaracteristicaPregunta.setText("Caracteristica de la Pregunta");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setText("ACEPTAR");

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPregunta)
                            .addComponent(lblTipo))
                        .addGap(41, 41, 41)
                        .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblMensajeTipoPregunta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                                .addGap(314, 314, 314)
                                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                                        .addComponent(lblCaracteristicaPregunta)
                                        .addGap(47, 47, 47)
                                        .addComponent(cbxCaracteristicaPregunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblMensajeCaracteristicaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65))))
                            .addComponent(jScrollPane1)
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addComponent(lblMensajePregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                                .addComponent(btnModificarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnListarPregunta)))))
                .addContainerGap())
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblMensajeAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(399, 399, 399))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(396, 396, 396))))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarPregunta)
                    .addComponent(btnRegistrarPregunta)
                    .addComponent(btnModificarPregunta))
                .addGap(37, 37, 37)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaracteristicaPregunta)
                    .addComponent(cbxCaracteristicaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblMensajeTipoPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblPregunta))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblMensajeCaracteristicaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblMensajePregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensajeAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPreguntaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPreguntaMouseClicked

    }//GEN-LAST:event_tblPreguntaMouseClicked

    private void btnRegistrarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPreguntaActionPerformed

        
    }//GEN-LAST:event_btnRegistrarPreguntaActionPerformed

    private void btnListarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPreguntaActionPerformed

       
    }//GEN-LAST:event_btnListarPreguntaActionPerformed

    private void btnModificarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPreguntaActionPerformed

    }//GEN-LAST:event_btnModificarPreguntaActionPerformed

    public JButton getBtnListarPregunta() {
        return btnListarPregunta;
    }

    public void setBtnListarPregunta(JButton btnListarPregunta) {
        this.btnListarPregunta = btnListarPregunta;
    }

    public JButton getBtnModificarPregunta() {
        return btnModificarPregunta;
    }

    public void setBtnModificarPregunta(JButton btnModificarPregunta) {
        this.btnModificarPregunta = btnModificarPregunta;
    }

    public JButton getBtnRegistrarPregunta() {
        return btnRegistrarPregunta;
    }

    public void setBtnRegistrarPregunta(JButton btnRegistrarPregunta) {
        this.btnRegistrarPregunta = btnRegistrarPregunta;
    }

    public JComboBox getCbxCaracteristicaPregunta() {
        return cbxCaracteristicaPregunta;
    }

    public void setCbxCaracteristicaPregunta(JComboBox cbxCaracteristicaPregunta) {
        this.cbxCaracteristicaPregunta = cbxCaracteristicaPregunta;
    }

    public JTable getTblPregunta() {
        return tblPregunta;
    }

    public void setTblPregunta(JTable tblPregunta) {
        this.tblPregunta = tblPregunta;
    }

    public JTextArea getTxaPregunta() {
        return txaPregunta;
    }

    public void setTxaPregunta(JTextArea txaPregunta) {
        this.txaPregunta = txaPregunta;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JLabel getLblMensajePregunta() {
        return lblMensajePregunta;
    }

    public void setLblMensajePregunta(JLabel lblMensajePregunta) {
        this.lblMensajePregunta = lblMensajePregunta;
    }

    public JLabel getLblMensajeTipoPregunta() {
        return lblMensajeTipoPregunta;
    }

    public void setLblMensajeTipoPregunta(JLabel lblMensajeTipoPregunta) {
        this.lblMensajeTipoPregunta = lblMensajeTipoPregunta;
    }

    public JLabel getLblMensajeCaracteristicaPregunta() {
        return lblMensajeCaracteristicaPregunta;
    }

    public void setLblMensajeCaracteristicaPregunta(JLabel lblMensajeCaracteristicaPregunta) {
        this.lblMensajeCaracteristicaPregunta = lblMensajeCaracteristicaPregunta;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JLabel getLblMensajeAceptar() {
        return lblMensajeAceptar;
    }

    public void setLblMensajeAceptar(JLabel lblMensajeAceptar) {
        this.lblMensajeAceptar = lblMensajeAceptar;
    }

   

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

  
    
    
    public  boolean validarCamposGestionarPregunta(){
          boolean blValidacion =true;
            if(validarCampoVacio(getTxtTipo().getText())){
               getLblMensajeTipoPregunta().setText("Ingrese Tipo Pregunta.");
               blValidacion =false;
            }
            
            if(validarCampoVacio(getTxaPregunta().getText())){
            
                getLblMensajePregunta().setText("Ingrese la Formulación De La Pregunta.");
                blValidacion =false;
            }          
       return blValidacion;
     }
    
    
    
    private  boolean validarCampoVacio(String stCampo){
        boolean blValidacion =false;
            if(stCampo.equals("")){
               blValidacion = true;
            }       
        return blValidacion;
     }
    
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnListarPregunta;
    private javax.swing.JButton btnModificarPregunta;
    private javax.swing.JButton btnRegistrarPregunta;
    private javax.swing.JComboBox cbxCaracteristicaPregunta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCaracteristicaPregunta;
    private javax.swing.JLabel lblMensajeAceptar;
    private javax.swing.JLabel lblMensajeCaracteristicaPregunta;
    private javax.swing.JLabel lblMensajePregunta;
    private javax.swing.JLabel lblMensajeTipoPregunta;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JTable tblPregunta;
    private javax.swing.JTextArea txaPregunta;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}