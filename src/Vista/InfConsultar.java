/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Ventana que permite visualizar y consultar un estudiante o un docente en el sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class InfConsultar extends javax.swing.JInternalFrame {

   
    /**
    * Inicializa los componentes que conforman la visualizacion y consulta a estudiante o docente. 
    * @since SIGED 1.0.0
    */
    public InfConsultar() {
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
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscarEstudiante = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInformacion = new javax.swing.JTable();
        btnBuscarDocente = new javax.swing.JButton();
        LblMensajeId = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(866, 450));

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo.setText("Consultar Docente/Estudiante");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblId.setText("Codigo Estudiante o Cedula Docente:");

        btnBuscarEstudiante.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarEstudiante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoBuscar.png"))); // NOI18N
        btnBuscarEstudiante.setText("Buscar Estudiante");

        tblInformacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Plan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInformacion);

        btnBuscarDocente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarDocente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoBuscar.png"))); // NOI18N
        btnBuscarDocente.setText("Buscar Docente");

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addGap(543, 543, 543)
                                .addComponent(btnBuscarEstudiante))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblMensajeId, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(btnBuscarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(49, 49, 49)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEstudiante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblMensajeId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDocente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
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

    public JLabel getLblMensajeId() {
        return LblMensajeId;
    }

    public void setLblMensajeId(JLabel LblMensajeId) {
        this.LblMensajeId = LblMensajeId;
    }

    public JButton getBtnBuscarDocente() {
        return btnBuscarDocente;
    }

    public void setBtnBuscarDocente(JButton btnBuscarDocente) {
        this.btnBuscarDocente = btnBuscarDocente;
    }

    public JButton getBtnBuscarEstudiante() {
        return btnBuscarEstudiante;
    }

    public void setBtnBuscarEstudiante(JButton btnBuscarEstudiante) {
        this.btnBuscarEstudiante = btnBuscarEstudiante;
    }

    public JTable getTblInformacion() {
        return tblInformacion;
    }

    public void setTblInformacion(JTable tblInformacion) {
        this.tblInformacion = tblInformacion;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JPanel getPnlContenedor() {
        return pnlContenedor;
    }

    public void setPnlContenedor(JPanel pnlContenedor) {
        this.pnlContenedor = pnlContenedor;
    }

    
    /**
    *Metodo  encargado de limpiar mensajes que se le han dado al usuario.
    * Verificar que el codigo o cedula que ingresa el usuario sea de tipo numerico,
    * y  si no lo es, dar un mensaje indicandole la forma adecuada de hacerlo y retornar el valor booleano de dicha verificacion.
    *@param  stTipoId String : Contiene la descripcion del dato que  ingreso el usuario (Cedula o Codigo).
    *@return Dato Booleano: true si el usuario ingreso un dato de tipo numerico al campo, false si fue lo contrario.
    *@since SIGED 1.0.0
    */
    public  boolean validarcampoConsultar(String stTipoId){
          limpiarMensajes();
          boolean blValidacion =true;
            if(!validarCampoVacio(getTxtId().getText())){
               if(!validarCampoNumerico(getTxtId().getText())){                
               
                  getLblMensajeId().setText(stTipoId+" Debe Ser Numerico");
                  blValidacion =false;
                }
            }else{
                getLblMensajeId().setText("Ingrese Su "+stTipoId);
                blValidacion =false;
            }   
       return blValidacion;
     }
   
    /**
    *Metodo encargado de verificar que el campo  cedula o codigo no sea vacio.
    *@param stCampo String: Campo a validar.
    *@return Dato booleano:true si el campo esta vacio, false si no lo esta.
    *@since SIGED 1.0.0
    */
    
    private  boolean validarCampoVacio(String stCampo){
        boolean blValidacion =false;
            if(stCampo.equals("")){
               blValidacion = true;
            }       
        return blValidacion;
     }
       
   /**
    *Metodo encargado de verificar que el campo  cedula o codigo sea numerico.
    *@param stCampo String: Campo a validar.
    *@return Dato booleano:true si el campo es numerico, false si no lo es.
    *@since SIGED 1.0.0
    */
    private  boolean validarCampoNumerico(String stCampo){
             boolean blValidacion=true;
             try {
                 Integer.parseInt(stCampo);
             } catch (NumberFormatException nfe) {
                 blValidacion = false;                 
             }         
        return blValidacion;
     }
    
      public void limpiarMensajes(){
        getLblMensajeId().setText("");
         
    }
    
     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblMensajeId;
    private javax.swing.JButton btnBuscarDocente;
    private javax.swing.JButton btnBuscarEstudiante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JTable tblInformacion;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
