
import java.math.BigDecimal;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author slam
 */
public class EncaisserLeFric extends javax.swing.JDialog {

    /**
     * Creates new form EncaisserLeFric
     */
    public EncaisserLeFric(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        prixTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        argentArendre = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Rendu Total :");

        prixTotal.setEditable(false);

        jLabel2.setText("Argent à rendre : ");

        argentArendre.setEditable(false);
        argentArendre.setColumns(20);
        argentArendre.setRows(5);
        jScrollPane1.setViewportView(argentArendre);

        jButton1.setText("Fermer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prixTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(prixTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void afficherPrixTotal(BigDecimal total, BigDecimal argentClient) {
       this.prixTotal.setText(argentClient.subtract(total)+"");
    }
    
    public void renduMonnaie(BigDecimal total, BigDecimal argentClient) {
        BigDecimal tableMonnaie [] = {
            new BigDecimal("200.00"), 
            new BigDecimal("100.00"), 
            new BigDecimal("50.00"), 
            new BigDecimal("20.00"), 
            new BigDecimal("10.00"), 
            new BigDecimal("5.00"), 
            new BigDecimal("2.00"), 
            new BigDecimal("1.00"), 
            new BigDecimal("0.50"), 
            new BigDecimal("0.20"), 
            new BigDecimal("0.10"), 
            new BigDecimal("0.05"), 
            new BigDecimal("0.02"), 
            new BigDecimal("0.01")
        };

        
        ArrayList<BigDecimal> maListe = new ArrayList<BigDecimal>();
        int listeMonnaie [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        BigDecimal argentArendre = argentClient.subtract(total);
        
        while(argentArendre.compareTo(BigDecimal.ZERO) != 0) {
            for (int i=0; i<tableMonnaie.length; i++) {
                BigDecimal test = argentArendre.subtract(tableMonnaie[i]);
                if (test.compareTo(BigDecimal.ZERO) >= 0) {
                    argentArendre = argentArendre.subtract(tableMonnaie[i]);
                    maListe.add(tableMonnaie[i]);
                    listeMonnaie[i]++;
                    i=14;
                }
            }
        }
        
        //this.argentArendre.setText(listeMonnaie.toString());
        String argent = "";
        for (int m = 0; m < listeMonnaie.length; m++) {
            if (listeMonnaie[m] != 0) {
                argent = argent + "x"+listeMonnaie[m]+" "+tableMonnaie[m]+"\n";
            }

        }
        
        this.argentArendre.setText(argent);
    }
    
    public void run() {
        EncaisserLeFric dialog = new EncaisserLeFric(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea argentArendre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prixTotal;
    // End of variables declaration//GEN-END:variables
}
