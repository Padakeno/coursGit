package caisseenregistreuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JList;

/**
 *
 * @author slam
 */
public class AffichageCaisse extends javax.swing.JFrame {
    private ArrayList<Produit> produits;
    private ListeProduit lp;
    private int numeroProduit;
    
    Connection connection = null;
    PreparedStatement requete = null;
    ResultSet resultat = null;
    
    public AffichageCaisse(ArrayList<Produit> produits) {
        this.produits = produits;
        this.lp = new ListeProduit(produits);
        initComponents();
        
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
            connection = DriverManager.getConnection("jdbc:derby:db_produit;create=true"); // chemin de la base, utilisateur, mot de passe
	} catch(ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé dans AffichageCaisse");
            System.exit(1);
        } catch(SQLException e) {
            System.err.println("erreur SQL au moment de la connection dans AffichageMain");
            System.exit(1);
        }
    }
    
    public void envoyer(String s) {
        numeroProduit = Integer.parseInt(affichageCalculette.getText());
        affichageCalculette.setText("");
        
        try {
            requete = connection.prepareStatement("select * from produit where id = ?");
            requete.setInt(1, numeroProduit);
            resultat = requete.executeQuery();
            while (resultat.next()) {
                String nomProduit = resultat.getString("nomProduit");
                double prix = resultat.getDouble("prix");
                produits.add(new Produit(numeroProduit, nomProduit, prix));
            }

        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println("erreur lors de l'insertion");
            System.exit(1);	
        }
    }
    
    
    /**
     *  NE PAS OUBLIER !! Lorsque l'on tape un produit avec les numéros, ces produits sont stokés dans ListeProduit, et cette même liste de produit est stocké dans Client
     * qui est lui même stoké dans listClient 
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeProduit = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        affichagePrixTotal = new javax.swing.JTextField();
        typePayement1 = new javax.swing.JRadioButton();
        typePayement2 = new javax.swing.JRadioButton();
        typePayement3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        num1 = new javax.swing.JButton();
        num2 = new javax.swing.JButton();
        num3 = new javax.swing.JButton();
        num4 = new javax.swing.JButton();
        num5 = new javax.swing.JButton();
        num6 = new javax.swing.JButton();
        num7 = new javax.swing.JButton();
        num8 = new javax.swing.JButton();
        num9 = new javax.swing.JButton();
        num0 = new javax.swing.JButton();
        num00 = new javax.swing.JButton();
        numPoint = new javax.swing.JButton();
        numX = new javax.swing.JButton();
        suppressionLigneProduit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeClientAttente = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        boutonSuivant = new javax.swing.JButton();
        boutonEntrer = new javax.swing.JButton();
        affichageCalculette = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Programme caisse enregistreuse");

        listeProduit.setModel(lp);
        listeProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeProduitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeProduit);

        affichagePrixTotal.setEditable(false);
        affichagePrixTotal.setFont(new java.awt.Font("DialogInput", 1, 48)); // NOI18N
        affichagePrixTotal.setText("15000000000.54");
        affichagePrixTotal.setToolTipText("");

        typePayement1.setText("Chèque");

        typePayement2.setText("Espèce");

        typePayement3.setText("Ticket cadeau");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setText("€");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typePayement1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(typePayement2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typePayement3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(affichagePrixTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(affichagePrixTotal)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typePayement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typePayement2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typePayement3)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        num1.setText("1");
        num1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num1MouseClicked(evt);
            }
        });

        num2.setText("2");
        num2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num2MouseClicked(evt);
            }
        });

        num3.setText("3");
        num3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num3MouseClicked(evt);
            }
        });

        num4.setText("4");
        num4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num4MouseClicked(evt);
            }
        });

        num5.setText("5");
        num5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num5MouseClicked(evt);
            }
        });

        num6.setText("6");
        num6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num6MouseClicked(evt);
            }
        });

        num7.setText("7");
        num7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num7MouseClicked(evt);
            }
        });

        num8.setText("8");
        num8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num8MouseClicked(evt);
            }
        });

        num9.setText("9");
        num9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num9MouseClicked(evt);
            }
        });

        num0.setText("0");
        num0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num0MouseClicked(evt);
            }
        });

        num00.setText("00");
        num00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                num00MouseClicked(evt);
            }
        });

        numPoint.setText(".");
        numPoint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numPointMouseClicked(evt);
            }
        });

        numX.setText("X");
        numX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numXMouseClicked(evt);
            }
        });

        suppressionLigneProduit.setText("Supprimer la ligne");

        jLabel2.setText("Type de payement");

        listeClientAttente.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listeClientAttente);

        jLabel3.setText("liste de clients en attente");

        boutonSuivant.setText("Suivant");

        boutonEntrer.setText("Entrer");
        boutonEntrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boutonEntrerMouseClicked(evt);
            }
        });

        affichageCalculette.setEditable(false);
        affichageCalculette.setAutoscrolls(false);
        affichageCalculette.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(num5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(num9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(numX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(num2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(num4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(num6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(num7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(num8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(num0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(num00, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(numPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(boutonEntrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(boutonSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(affichageCalculette, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(suppressionLigneProduit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(num1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(num2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(num3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(num4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(num5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(num6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(num7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(num8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(num9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(num0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(num00, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(numX, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(boutonEntrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(affichageCalculette, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suppressionLigneProduit)
                    .addComponent(boutonSuivant, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // bouton numerique
    private void num1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num1MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"1");
    }//GEN-LAST:event_num1MouseClicked

    private void num2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num2MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"2");
    }//GEN-LAST:event_num2MouseClicked

    private void num3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num3MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"3");
    }//GEN-LAST:event_num3MouseClicked

    private void num4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num4MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"4");
    }//GEN-LAST:event_num4MouseClicked

    private void num5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num5MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"5");
    }//GEN-LAST:event_num5MouseClicked

    private void num6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num6MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"6");
    }//GEN-LAST:event_num6MouseClicked

    private void num7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num7MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"7");
    }//GEN-LAST:event_num7MouseClicked

    private void num8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num8MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"8");
    }//GEN-LAST:event_num8MouseClicked

    private void num9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num9MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"9");
    }//GEN-LAST:event_num9MouseClicked

    private void num0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num0MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"0");
    }//GEN-LAST:event_num0MouseClicked

    private void num00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_num00MouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+"00");
    }//GEN-LAST:event_num00MouseClicked

    private void numPointMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numPointMouseClicked
        String text = affichageCalculette.getText();
        affichageCalculette.setText(text+".");
    }//GEN-LAST:event_numPointMouseClicked

    private void numXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numXMouseClicked
        affichageCalculette.setText("");
    }//GEN-LAST:event_numXMouseClicked

    private void boutonEntrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boutonEntrerMouseClicked
        envoyer(affichageCalculette.getText());
    }//GEN-LAST:event_boutonEntrerMouseClicked

    private void listeProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeProduitMouseClicked
        JList liste = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            int index = liste.locationToIndex(evt.getPoint());
            this.affichageCalculette.setText("hello");            
        }
    }//GEN-LAST:event_listeProduitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField affichageCalculette;
    private javax.swing.JTextField affichagePrixTotal;
    private javax.swing.JButton boutonEntrer;
    private javax.swing.JButton boutonSuivant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listeClientAttente;
    private javax.swing.JList listeProduit;
    private javax.swing.JButton num0;
    private javax.swing.JButton num00;
    private javax.swing.JButton num1;
    private javax.swing.JButton num2;
    private javax.swing.JButton num3;
    private javax.swing.JButton num4;
    private javax.swing.JButton num5;
    private javax.swing.JButton num6;
    private javax.swing.JButton num7;
    private javax.swing.JButton num8;
    private javax.swing.JButton num9;
    private javax.swing.JButton numPoint;
    private javax.swing.JButton numX;
    private javax.swing.JButton suppressionLigneProduit;
    private javax.swing.JRadioButton typePayement1;
    private javax.swing.JRadioButton typePayement2;
    private javax.swing.JRadioButton typePayement3;
    // End of variables declaration//GEN-END:variables
}
