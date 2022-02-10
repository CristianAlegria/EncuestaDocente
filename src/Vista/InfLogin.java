/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Ventana que permite al usuario loguearse en el sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
public class InfLogin extends javax.swing.JInternalFrame {

   /**
    * Inicializa los componentes que conforman el logueo de un usuario. 
    * @since SIGED 1.0.0
    */
    public InfLogin() {
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
        lblIngresoSistema = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        lblContrasenia = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblNombreUsuario = new javax.swing.JLabel();
        pwdContrasenia = new javax.swing.JPasswordField();
        lblMensajeNombreUsuario = new javax.swing.JLabel();
        lblMensajeLogueo = new javax.swing.JLabel();
        lblMensajeContrasenia = new javax.swing.JLabel();

        setClosable(true);

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedor.setPreferredSize(new java.awt.Dimension(700, 400));

        lblIngresoSistema.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblIngresoSistema.setForeground(new java.awt.Color(255, 51, 51));
        lblIngresoSistema.setText("    Ingreso al Sistema");

        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblContrasenia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContrasenia.setText("Contraseña");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreUsuario.setText("Nombre de Usuario");

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(lblMensajeLogueo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(btnEntrar))
                            .addGroup(pnlContenedorLayout.createSequentialGroup()
                                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreUsuario)
                                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pwdContrasenia)
                                    .addComponent(lblIngresoSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMensajeNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(lblMensajeContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblIngresoSistema)
                .addGap(18, 18, 18)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMensajeNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwdContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblMensajeContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajeLogueo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

    }//GEN-LAST:event_btnEntrarActionPerformed

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public void setBtnEntrar(JButton btnEntrar) {
        this.btnEntrar = btnEntrar;
    }

    public JLabel getLblContrasenia() {
        return lblContrasenia;
    }

    public void setLblContrasenia(JLabel lblContrasenia) {
        this.lblContrasenia = lblContrasenia;
    }

    public JLabel getLblIngresoSistema() {
        return lblIngresoSistema;
    }

    public void setLblIngresoSistema(JLabel lblIngresoSistema) {
        this.lblIngresoSistema = lblIngresoSistema;
    }

    public JLabel getLblMensajeContrasenia() {
        return lblMensajeContrasenia;
    }

    public void setLblMensajeContrasenia(JLabel lblMensajeContrasenia) {
        this.lblMensajeContrasenia = lblMensajeContrasenia;
    }

    public JLabel getLblMensajeLogueo() {
        return lblMensajeLogueo;
    }

    public void setLblMensajeLogueo(JLabel lblMensajeLogueo) {
        this.lblMensajeLogueo = lblMensajeLogueo;
    }

    public JLabel getLblMensajeNombreUsuario() {
        return lblMensajeNombreUsuario;
    }

    public void setLblMensajeNombreUsuario(JLabel lblMensajeNombreUsuario) {
        this.lblMensajeNombreUsuario = lblMensajeNombreUsuario;
    }

    public JLabel getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(JLabel lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public JPanel getPnlContenedor() {
        return pnlContenedor;
    }

    public void setPnlContenedor(JPanel pnlContenedor) {
        this.pnlContenedor = pnlContenedor;
    }

    public JPasswordField getPwdContrasenia() {
        return pwdContrasenia;
    }

    public void setPwdContrasenia(JPasswordField pwdContrasenia) {
        this.pwdContrasenia = pwdContrasenia;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
        this.txtNombreUsuario = txtNombreUsuario;
    }
    
    
    /**
    *Metodo  encargado de limpiar mensajes que se le han dado al usuario.
    * Verificar que el campo Nombre de Usuario sea de tipo numerico y que el campo contraseña no sea vacio
    * y  si no cumple aquellas condiciones, dar un mensaje indicandole al usuario la forma adecuada de hacerlo y retornar el valor booleano de dicha verificacion.
     *@return Dato Booleano: true si el usuario ingreso un dato de tipo numerico al campo "Nombre de Usuario" y diligencio el campo "Contraseña", false si fue lo contrario.
    *@since SIGED 1.0.0
    */
    public  boolean validarcamposLogin(){
          limpiarMensajes();
          boolean blValidacion =true;
            if(!validarCampoVacio(getTxtNombreUsuario().getText())){
               if(!validarCampoNumerico(getTxtNombreUsuario().getText())){                
               
                  getLblMensajeNombreUsuario().setText("Nombre De Usuario Debe Ser Numerico");
                  blValidacion =false;
                }
            }else{
                getLblMensajeNombreUsuario().setText("Ingrese Nombre De Usuario");
                blValidacion =false;
            }
            
            if(validarCampoVacio(getPwdContrasenia().getText())){
            
                getLblMensajeContrasenia().setText("Ingrese Contraseña");
                blValidacion =false;
            }    
     
       return blValidacion;
    }     
   
    /**
    *Metodo encargado de verificar que el campo suministrado es vacio.
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
    *Metodo encargado de verificar que el campo suministrado sea numerico.
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
    

    /**
    * Metodo encargado de limpiar los mensajes de advertecia que se le dan al usuario
    *@since SIGED 1.0.0
    */
    public void limpiarMensajes(){
        getLblMensajeContrasenia().setText("");
        getLblMensajeLogueo().setText("");
        getLblMensajeNombreUsuario().setText("");  
    }
    
    /**
    * Metodo encargado de limpiar los campos que ha diligenciado el usuario
    *@since SIGED 1.0.0
    */
    
    public void limpiarCamposTxt(){
         getTxtNombreUsuario().setText("");
         getPwdContrasenia().setText("");
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblIngresoSistema;
    private javax.swing.JLabel lblMensajeContrasenia;
    private javax.swing.JLabel lblMensajeLogueo;
    private javax.swing.JLabel lblMensajeNombreUsuario;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPasswordField pwdContrasenia;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
