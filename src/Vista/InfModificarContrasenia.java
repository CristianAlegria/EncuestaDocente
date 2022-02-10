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
 * Ventana que permite modificar la contraseña a un usuario del sistema SIGED.
 * @author Cristian Alexis Alegria C.
 * @version 1.0.0
 * @since SIGED 1.0.0
 */
    
public class InfModificarContrasenia extends javax.swing.JInternalFrame {

 
    /**
    * Inicializa los componentes que conforman la modificacion de la contraseña a un usuario. 
    * @since SIGED 1.0.0
    */
    public InfModificarContrasenia() {
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
        lblModificarContrasenia = new javax.swing.JLabel();
        lblContraseniaActual = new javax.swing.JLabel();
        lblContraseniaNueva = new javax.swing.JLabel();
        pwdContraseniaActual = new javax.swing.JPasswordField();
        btnGuardarCambios = new javax.swing.JButton();
        lblConfirmaContraseniaNueva = new javax.swing.JLabel();
        pwdConfirmaContraseniaNueva = new javax.swing.JPasswordField();
        pwdContraseniaNueva = new javax.swing.JPasswordField();
        lblMensajeContraseniaActual = new javax.swing.JLabel();
        lblMensajeContraseniaNueva = new javax.swing.JLabel();
        lblMensajeConfirmaContraseniaNueva = new javax.swing.JLabel();
        lblMensajeModificarContrasenia = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(866, 450));

        pnlContenedor.setBackground(new java.awt.Color(255, 255, 255));

        lblModificarContrasenia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblModificarContrasenia.setForeground(new java.awt.Color(255, 51, 51));
        lblModificarContrasenia.setText("Modificar Contraseña");

        lblContraseniaActual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContraseniaActual.setText("Contraseña Actual");

        lblContraseniaNueva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContraseniaNueva.setText("Contraseña Nueva");

        btnGuardarCambios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        lblConfirmaContraseniaNueva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblConfirmaContraseniaNueva.setText("Confirmar Contraseña Nueva");

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pwdConfirmaContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblModificarContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addComponent(lblContraseniaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwdContraseniaActual)
                        .addComponent(lblContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblConfirmaContraseniaNueva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdContraseniaNueva, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMensajeConfirmaContraseniaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(lblMensajeContraseniaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMensajeContraseniaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(lblMensajeModificarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(btnGuardarCambios)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblModificarContrasenia)
                .addGap(30, 30, 30)
                .addComponent(lblContraseniaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pwdContraseniaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensajeContraseniaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pwdContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblMensajeContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(lblConfirmaContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pwdConfirmaContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensajeConfirmaContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensajeModificarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed

    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    public JButton getBtnGuardarCambios() {
        return btnGuardarCambios;
    }

    public void setBtnGuardarCambios(JButton btnGuardarCambios) {
        this.btnGuardarCambios = btnGuardarCambios;
    }

    public JLabel getJblContraseniaActual() {
        return lblContraseniaActual;
    }

    public void setJblContraseniaActual(JLabel jblContraseniaActual) {
        this.lblContraseniaActual = jblContraseniaActual;
    }

    public JLabel getLblConfirmaContraseniaNueva() {
        return lblConfirmaContraseniaNueva;
    }

    public void setLblConfirmaContraseniaNueva(JLabel lblConfirmaContraseniaNueva) {
        this.lblConfirmaContraseniaNueva = lblConfirmaContraseniaNueva;
    }

    public JLabel getLblModificarContrasenia() {
        return lblModificarContrasenia;
    }

    public void setLblModificarContrasenia(JLabel lblModificarContrasenia) {
        this.lblModificarContrasenia = lblModificarContrasenia;
    }

    public JPasswordField getPwdConfirmaContraseniaNueva() {
        return pwdConfirmaContraseniaNueva;
    }

    public void setPwdConfirmaContraseniaNueva(JPasswordField pwdConfirmaContraseniaNueva) {
        this.pwdConfirmaContraseniaNueva = pwdConfirmaContraseniaNueva;
    }

    public JPasswordField getPwdContraseniaNueva() {
        return pwdContraseniaNueva;
    }

    public void setPwdContraseniaNueva(JPasswordField pwdContraseniaNueva) {
        this.pwdContraseniaActual = pwdContraseniaNueva;
    }

    public JPasswordField getPwdContraseniaActual() {
        return pwdContraseniaActual;
    }

    public void setPwdContraseniaActual(JPasswordField pwdContraseniaActual) {
        this.pwdContraseniaActual = pwdContraseniaActual;
    }

    public JLabel getLblMensajeConfirmaContraseniaNueva() {
        return lblMensajeConfirmaContraseniaNueva;
    }

    public void setLblMensajeConfirmaContraseniaNueva(JLabel lblMensajeConfirmaContraseniaNueva) {
        this.lblMensajeConfirmaContraseniaNueva = lblMensajeConfirmaContraseniaNueva;
    }

    public JLabel getLblMensajeContraseniaActual() {
        return lblMensajeContraseniaActual;
    }

    public void setLblMensajeContraseniaActual(JLabel lblMensajeContraseniaActual) {
        this.lblMensajeContraseniaActual = lblMensajeContraseniaActual;
    }

    public JLabel getLblMensajeContraseniaNueva() {
        return lblMensajeContraseniaNueva;
    }

    public void setLblMensajeContraseniaNueva(JLabel lblMensajeContraseniaNueva) {
        this.lblMensajeContraseniaNueva = lblMensajeContraseniaNueva;
    }

    public JLabel getLblMensajeModificarContrasenia() {
        return lblMensajeModificarContrasenia;
    }

    public void setLblMensajeModificarContrasenia(JLabel lblMensajeModificarContrasenia) {
        this.lblMensajeModificarContrasenia = lblMensajeModificarContrasenia;
    }

    public JLabel getLblContraseniaActual() {
        return lblContraseniaActual;
    }

    public void setLblContraseniaActual(JLabel lblContraseniaActual) {
        this.lblContraseniaActual = lblContraseniaActual;
    }

    public JLabel getLblContraseniaNueva() {
        return lblContraseniaNueva;
    }

    public void setLblContraseniaNueva(JLabel lblContraseniaNueva) {
        this.lblContraseniaNueva = lblContraseniaNueva;
    }

    public JPanel getPnlContenedor() {
        return pnlContenedor;
    }

    public void setPnlContenedor(JPanel pnlContenedor) {
        this.pnlContenedor = pnlContenedor;
    }
    
     /**
    *Metodo  encargado de verificar que los campos "Contraseña Actual","Contraseña Nueva","Confirmar Contraseña Nueva" no se han vacios y
    *confirmar Contraseña Nueva sea diferente a Contraseña Actual.Retornar el valor booleano de dicha verificacion
    *@return Dato Booleano: true si el usuario diligencio los campos y "Contraseña Nueva" sea diferente a "Contraseña Actual", false si fue lo contrario.
    *@since SIGED 1.0.0
    */   
    
    public  boolean validarcamposModificarContrasenia(){
          boolean blValidacion =true;
            if(validarCampoVacio(getPwdContraseniaActual().getText())){
               getLblMensajeContraseniaActual().setText("Ingrese La Contraseña Actual");
               blValidacion =false;
            }
            
            if(validarCampoVacio(getPwdContraseniaNueva().getText())){
            
                getLblMensajeContraseniaNueva().setText("Ingrese Contraseña Nueva");
                blValidacion =false;
            }
            
            if(!validarCampoVacio(getPwdConfirmaContraseniaNueva().getText())){
                if(!getPwdConfirmaContraseniaNueva().getText().equals(getPwdContraseniaNueva().getText())){
                   
                   getLblMensajeConfirmaContraseniaNueva().setText("Confirmacion De Contraseña Invalida");
                   blValidacion =false;
                }               
            }else{
                getLblMensajeConfirmaContraseniaNueva().setText("Comfirme Contraseña");
                blValidacion =false;
            }
            
            if (getPwdConfirmaContraseniaNueva().getText().equals(getPwdContraseniaActual().getText())){
                   getLblMensajeConfirmaContraseniaNueva().setText("Debe Ser Una Contraseña Diferente a La Actual");
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
    *Metodo encargado de verificar que el campo  suministrado sea numerico.
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
    * Metodo encargado de limpiar los mensajes de advertecia que se le dan al usuario.
    *@since SIGED 1.0.0
    */    
     public void limpiarMensajes(){
        getLblMensajeContraseniaActual().setText("");
        getLblMensajeContraseniaNueva().setText("");
        getLblMensajeConfirmaContraseniaNueva().setText(""); 
        getLblMensajeModificarContrasenia().setText(""); 
        
    }
    
    /**
    * Metodo encargado de limpiar los campos que ha diligenciado el usuario.
    *@since SIGED 1.0.0
    */
    public void limpiarCamposTxt(){
         getPwdContraseniaActual().setText("");
         getPwdContraseniaNueva().setText("");
         getPwdConfirmaContraseniaNueva().setText("");
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardarCambios;
    private javax.swing.JLabel lblConfirmaContraseniaNueva;
    private javax.swing.JLabel lblContraseniaActual;
    private javax.swing.JLabel lblContraseniaNueva;
    private javax.swing.JLabel lblMensajeConfirmaContraseniaNueva;
    private javax.swing.JLabel lblMensajeContraseniaActual;
    private javax.swing.JLabel lblMensajeContraseniaNueva;
    private javax.swing.JLabel lblMensajeModificarContrasenia;
    private javax.swing.JLabel lblModificarContrasenia;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPasswordField pwdConfirmaContraseniaNueva;
    private javax.swing.JPasswordField pwdContraseniaActual;
    private javax.swing.JPasswordField pwdContraseniaNueva;
    // End of variables declaration//GEN-END:variables
}