/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Fenetre.java
 *
 * Created on 12 févr. 2011, 19:48:21
 */

package demo_son;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.WindowConstants;

/**
 *
 * @author arno
 */
public class Fenetre extends javax.swing.JFrame {

    /** Creates new form Fenetre */
    public Fenetre() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSon1 = new JButton();
        btnSon2 = new JButton();
        btnSon3 = new JButton();
        btnSon4 = new JButton();
        btnSon5 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Démo son");

        btnSon1.setMnemonic('1');
        btnSon1.setText("Son 1");
        btnSon1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSon1ActionPerformed(evt);
            }
        });

        btnSon2.setMnemonic('2');
        btnSon2.setText("Son 2");
        btnSon2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSon2ActionPerformed(evt);
            }
        });

        btnSon3.setMnemonic('3');
        btnSon3.setText("Son 3");
        btnSon3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSon3ActionPerformed(evt);
            }
        });

        btnSon4.setMnemonic('4');
        btnSon4.setText("Son 4");
        btnSon4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSon4ActionPerformed(evt);
            }
        });

        btnSon5.setMnemonic('5');
        btnSon5.setText("Son 5");
        btnSon5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSon5ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSon1)
                .addGap(18, 18, 18)
                .addComponent(btnSon2)
                .addGap(18, 18, 18)
                .addComponent(btnSon3)
                .addGap(18, 18, 18)
                .addComponent(btnSon4)
                .addGap(18, 18, 18)
                .addComponent(btnSon5)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(btnSon1)
                    .addComponent(btnSon2)
                    .addComponent(btnSon3)
                    .addComponent(btnSon4)
                    .addComponent(btnSon5))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSon1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSon1ActionPerformed
        Son son = new Son("/ressources/BERNARD_C_39_EST_QUI_LE_PATRON_.wav");
        son.start();
    }//GEN-LAST:event_btnSon1ActionPerformed

    private void btnSon2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSon2ActionPerformed
        Son son = new Son("/ressources/Grand_Chariot_Transformation.wav");
        son.start();
    }//GEN-LAST:event_btnSon2ActionPerformed

    private void btnSon3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSon3ActionPerformed
        Son son = new Son("/ressources/J_39_aime_les_licornes_featuring_Orelsan_.wav");
        son.start();
    }//GEN-LAST:event_btnSon3ActionPerformed

    private void btnSon4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSon4ActionPerformed
        Son son = new Son("/ressources/SSJ_Goku_39_s_Kamehameha_Vs_LSSJ_Broly_1080p_HD_.wav");
        son.start();
    }//GEN-LAST:event_btnSon4ActionPerformed

    private void btnSon5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSon5ActionPerformed
        Son son = new Son("/ressources/Doumbek-Tek.wav");
        son.start();
    }//GEN-LAST:event_btnSon5ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fenetre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnSon1;
    private JButton btnSon2;
    private JButton btnSon3;
    private JButton btnSon4;
    private JButton btnSon5;
    // End of variables declaration//GEN-END:variables

}
