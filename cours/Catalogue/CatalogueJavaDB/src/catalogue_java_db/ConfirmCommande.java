/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogue_java_db;

/**
 *
 * @author slam
 */
public class ConfirmCommande extends javax.swing.JDialog {
    private boolean valider;
    private String message;
    /**
     * Creates new form ConfirmCommande
     */
    public ConfirmCommande(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setAfficher(String message) {
        affichageConfirm.setText(message);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boutonOK = new javax.swing.JButton();
        affichageConfirm = new javax.swing.JLabel();

        boutonOK.setText("Ok");
        boutonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonOKActionPerformed(evt);
            }
        });

        affichageConfirm.setText("gqsfd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(affichageConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(boutonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(affichageConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutonOK)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_boutonOKActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel affichageConfirm;
    private javax.swing.JButton boutonOK;
    // End of variables declaration//GEN-END:variables
}
