
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slam
 */
public class ProductTable extends javax.swing.JFrame {

    private int i = 1;
    private ArrayList<ArrayList<Object>> maListe = new ArrayList<ArrayList<Object>>();
    private BigDecimal prixRemise = new BigDecimal("0");
    private EncaisserLeFric elc;

    /**
     * Creates new form ProductTable
     */
    public ProductTable() {
        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet resultat = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
            connection = DriverManager.getConnection("jdbc:derby:magasin_0_6;create=true"); // chemin de la base, utilisateur, mot de passe
        } catch (ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("erreur SQL au moment de la connection");
            e.printStackTrace();
            System.exit(1);
        }
        
        try {
            requete = connection.prepareStatement("drop table produit");
            requete.execute();
        } catch (SQLException e) {
            if (e.getSQLState().compareTo("42Y55") != 0) {
                // le code d'erreur n'est pas 42Y55 : il y a un problème
                System.err.println("erreur lors de la destruction de la table \"listecode\"");
                System.err.println(e.getMessage());
                System.err.println(e.getErrorCode());
                System.err.println(e.getSQLState());
                System.exit(1);
            }
        }
        
        try {
            requete = connection.prepareStatement("create table produit(ref int not null,nom varchar(200),prix double,primary key(ref))");
            requete.execute();
        } catch (SQLException e) {
            System.err.println("erreur lors de la création de la table \"produit\"");
            System.err.println(e.getMessage());
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            System.exit(1);
        }
        
        ArrayList<Integer> ref = new ArrayList<>();
        ref.add(767029);ref.add(359731);ref.add(144241);ref.add(524497);ref.add(100738);ref.add(723906);ref.add(262316);ref.add(457879);ref.add(201023);ref.add(795057);ref.add(279884);ref.add(158195);
        
        ArrayList<String> nom = new ArrayList<>();
        nom.add("Micro alpha pro");nom.add("easy owl IV");nom.add("big fox IV");nom.add("small alpha IV");nom.add("super tango ");nom.add("super cobra");nom.add("easy bravo II");nom.add("easy alpha pro");nom.add("turbo moon 3000");nom.add("super star IV");nom.add("turbo cobra V");nom.add("nano bravo pro");
        
        ArrayList<Double> prix = new ArrayList<>();
        prix.add(8.72);prix.add(53.3);prix.add(1.54);prix.add(18.99);prix.add(176.62);prix.add(3.05);prix.add(8.71);prix.add(18.16);prix.add(127.62);prix.add(94.33);prix.add(94.33);prix.add(8.41);
        
        for (int i=0; i<12; i++) {
            try {
            requete = connection.prepareStatement("insert into produit(ref, nom, prix) values (?, ?, ?)");
            requete.setInt(1, ref.get(i));
            requete.setString(2, nom.get(i));
            requete.setDouble(3, prix.get(i));
            
            requete.executeUpdate();
            } catch(SQLException e) {
                e.printStackTrace();
                System.err.println("erreur lors de l'insertion");
                System.exit(1);	
            }
        }
        initComponents();
        this.elc = new EncaisserLeFric(this, true);
        /*BufferedImage image = null;
         try {
         image = ImageIO.read(getClass().getResource("/images/suppr.png"));
         } catch (IOException ex) {
         System.err.println("problème avec l'image");
         }
         ImageIcon icon = new ImageIcon(image);
         this.jButton11.setIcon(icon);*/
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        //model.addRow(new Object[]{1, "35416541", "Tournevis", 4, new BigDecimal("20.00")});
        //model.addRow(new Object[]{2, "45342114", "Clous", 4, new BigDecimal("3.00")});

        //model.getDataVector().removeAllElements(); //supprime toutes les ligne de la table 
    }

    public void rechercheBaseDonnee() {
        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet resultat = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
            connection = DriverManager.getConnection("jdbc:derby:magasin_0_6;create=true"); // chemin de la base, utilisateur, mot de passe
        } catch (ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("erreur SQL au moment de la connection");
            e.printStackTrace();
            System.exit(1);
        }

        int idProduit = Integer.parseInt(jTextField1.getText());
        try {

            requete = connection.prepareStatement("select * from produit where ref = ?");
            requete.setInt(1, idProduit);
            resultat = requete.executeQuery();
            while (resultat.next()) {
                String nomProduit = resultat.getString("nom");
                double prix = resultat.getDouble("prix");
                this.article.setText(nomProduit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("erreur lors de l'insertion");
            System.exit(1);
        }
    }
    
     public ArrayList<ArrayList<Object>> getProduit() {
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        ArrayList<ArrayList<Object>> maListe = new ArrayList<ArrayList<Object>>();
        for (int k = 0; k < tbProduct.getRowCount(); k++) {
            ArrayList<Object> liste = new ArrayList<Object>();
            for (int j = 0; j < tbProduct.getColumnCount(); j++) {
                Object selectedObject = tbProduct.getModel().getValueAt(k, j);
                liste.add(selectedObject);
            }
            maListe.add(liste);
        }
        return maListe;
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
        tbProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        article = new javax.swing.JTextField();
        paiement = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        quantite = new javax.swing.JTextField();
        supprimer = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        miseAttente = new javax.swing.JButton();
        finAttente = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        annuleVente = new javax.swing.JButton();
        encaisser = new javax.swing.JButton();
        ajout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        resteVerser = new javax.swing.JTextField();
        close = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caisse Enregistreuse Reims Outillage");
        setBackground(new java.awt.Color(255, 255, 255));

        tbProduct.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Code Barre", "Article", "Quantité", "Prix"
            }
        ));
        tbProduct.setFocusable(false);
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        jLabel1.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jLabel1.setText("Article");

        article.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        article.setFocusable(false);
        article.setMinimumSize(new java.awt.Dimension(20, 40));
        article.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleActionPerformed(evt);
            }
        });

        paiement.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        paiement.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CB", "Chèque", "Espèce" }));
        paiement.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jLabel3.setText("Quantité");

        quantite.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        quantite.setText("1");
        quantite.setFocusable(false);
        quantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantiteActionPerformed(evt);
            }
        });

        supprimer.setBackground(new java.awt.Color(255, 166, 166));
        supprimer.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.setFocusable(false);
        supprimer.setMaximumSize(new java.awt.Dimension(200, 25));
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jLabel4.setText("Reims Outillage : Caisse n°1");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("7");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton2.setText("8");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton3.setText("9");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton4.setText("4");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton5.setText("5");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(153, 255, 153));
        jButton6.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton6.setText("6");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 255, 153));
        jButton7.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton7.setText("1");
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(153, 255, 153));
        jButton8.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton8.setText("2");
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(153, 255, 153));
        jButton9.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton9.setText("3");
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(153, 255, 153));
        jButton10.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton10.setText("0");
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(153, 255, 153));
        jButton11.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton11.setText("CE");
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(153, 255, 153));
        jButton12.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton12.setText("C");
        jButton12.setFocusable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(153, 255, 153));
        jButton21.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton21.setText(",");
        jButton21.setFocusable(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton14.setBackground(new java.awt.Color(153, 255, 255));
        jButton14.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton14.setText("Suppr.");
        jButton14.setFocusable(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        miseAttente.setBackground(new java.awt.Color(255, 255, 255));
        miseAttente.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        miseAttente.setText("Mise en attente");
        miseAttente.setFocusable(false);
        miseAttente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miseAttenteActionPerformed(evt);
            }
        });

        finAttente.setBackground(new java.awt.Color(255, 255, 255));
        finAttente.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        finAttente.setForeground(new java.awt.Color(0, 0, 0));
        finAttente.setText("Fin attente");
        finAttente.setFocusable(false);
        finAttente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finAttenteActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(153, 255, 255));
        jButton17.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton17.setText("-");
        jButton17.setFocusable(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(153, 255, 255));
        jButton18.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton18.setText("+");
        jButton18.setFocusable(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        annuleVente.setBackground(new java.awt.Color(255, 166, 166));
        annuleVente.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        annuleVente.setText("Annuler la vente");
        annuleVente.setFocusable(false);
        annuleVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annuleVenteActionPerformed(evt);
            }
        });

        encaisser.setBackground(new java.awt.Color(255, 166, 166));
        encaisser.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        encaisser.setText("Encaisser");
        encaisser.setFocusable(false);
        encaisser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encaisserActionPerformed(evt);
            }
        });

        ajout.setBackground(new java.awt.Color(255, 166, 166));
        ajout.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        ajout.setText("Ajout");
        ajout.setFocusable(false);
        ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jLabel2.setText("Reste à verser :");

        resteVerser.setEditable(false);
        resteVerser.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        resteVerser.setText("0");
        resteVerser.setFocusable(false);

        close.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        close.setText("Fermer");
        close.setFocusable(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jButton13.setText("Remise");
        jButton13.setFocusable(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(article, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton17))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addGap(0, 179, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton14)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(resteVerser)
                                .addComponent(paiement, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finAttente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ajout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(annuleVente, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addComponent(encaisser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(miseAttente, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))))
                    .addComponent(close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(article, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(miseAttente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(finAttente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paiement, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resteVerser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ajout, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(annuleVente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encaisser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void articleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_articleActionPerformed

    private void ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutActionPerformed
        Connection connection = null;
        PreparedStatement requete = null;
        ResultSet resultat = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); // chargement du pilote (driver) permettant d'accéder au SGBDR
            connection = DriverManager.getConnection("jdbc:derby:magasin_0_6;create=true"); // chemin de la base, utilisateur, mot de passe
        } catch (ClassNotFoundException e) {
            System.err.println("erreur driver non trouvé");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("erreur SQL au moment de la connection");
            e.printStackTrace();
            System.exit(1);
        }

        int idProduit = Integer.parseInt(jTextField1.getText());
        int ref = 0;
        String nomProduit = "";
        BigDecimal prixTotal = new BigDecimal(this.resteVerser.getText());
        double prix = 0;

        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        if (!article.getText().trim().equals("")) {
            try {
                //JOptionPane.showMessageDialog(null, connection);
                requete = connection.prepareStatement("select * from produit where ref = ?");
                requete.setInt(1, idProduit);
                resultat = requete.executeQuery();
                while (resultat.next()) {
                    ref = resultat.getInt("ref");
                    prix = resultat.getDouble("prix");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("erreur lors de l'insertion");
                System.exit(1);
            }
            //model.addRow(new Object[]{2, "45342114", "Clous", 4, new BigDecimal("3.00")});
            model.addRow(new Object[]{i, ref, article.getText(), quantite.getText(), prix});
            prixTotal = prixTotal.add(new BigDecimal(Double.parseDouble(quantite.getText()) * prix + ""));
            this.resteVerser.setText(prixTotal + "");
            i++;
        } else {
            //iMessage.setText("Product Name should not be left blank");
        }
        this.jTextField1.setText("");
        //System.out.println(this.getProduit());

    }//GEN-LAST:event_ajoutActionPerformed

    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        article.setText(model.getValueAt(tbProduct.getSelectedRow(), 2).toString());
        quantite.setText(model.getValueAt(tbProduct.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tbProductMouseClicked

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        BigDecimal prixRestant = new BigDecimal("0");
        //JOptionPane.showMessageDialog(null,"supprimé");
        if (tbProduct.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null,"if");
            if (tbProduct.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,"table is empty");
            } else {
                JOptionPane.showMessageDialog(null,"You must select a product");
            }
        } else {
            BigDecimal prix = new BigDecimal(model.getValueAt(tbProduct.getSelectedRow(), 4).toString());
            BigDecimal quantite = new BigDecimal(model.getValueAt(tbProduct.getSelectedRow(), 3).toString());
            prixRestant = new BigDecimal(resteVerser.getText()).subtract(prix.multiply(quantite));
            model.removeRow(tbProduct.getSelectedRow());
        }
        
        resteVerser.setText(prixRestant + "");
    }//GEN-LAST:event_supprimerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "7");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "8");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "9");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "4");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "5");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "6");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "1");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "2");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "3");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.jTextField1.setText(this.jTextField1.getText() + "0");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.jTextField1.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (this.jTextField1.getText().length() > 0) {
            String test = this.jTextField1.getText();
            this.jTextField1.setText(this.jTextField1.getText().substring(0, test.length() - 1));
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        String test = this.jTextField1.getText();
        if (test.indexOf(",") == -1) {
            this.jTextField1.setText(this.jTextField1.getText() + ",");
        }
        //System.out.println(test.indexOf( "," ));
    }//GEN-LAST:event_jButton21ActionPerformed

    private void quantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantiteActionPerformed

    }//GEN-LAST:event_quantiteActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        int i = Integer.parseInt(this.quantite.getText());
        i++;
        this.quantite.setText(Integer.toString(i));
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        int i = Integer.parseInt(this.quantite.getText());
        if (i > 1) {
            i--;
            this.quantite.setText(Integer.toString(i));
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void miseAttenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miseAttenteActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        //ArrayList<ArrayList<Object>> maListe = new ArrayList<ArrayList<Object>>();
        maListe.clear();
        for (int k = 0; k < tbProduct.getRowCount(); k++) {
            ArrayList<Object> liste = new ArrayList<Object>();

            for (int j = 0; j < tbProduct.getColumnCount(); j++) {

                Object selectedObject = tbProduct.getModel().getValueAt(k, j);
                liste.add(selectedObject);
            }
            maListe.add(liste);

        }
        //System.out.println(liste.get(0));
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        
        this.resteVerser.setText("0");
        this.article.setText("");
        this.quantite.setText("1");
        
    }//GEN-LAST:event_miseAttenteActionPerformed

    private void finAttenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finAttenteActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        BigDecimal total = new BigDecimal("0.0");
        //System.out.println(maListe.size());
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
        for (int m = 0; m < maListe.size(); m++) {
            model.addRow(new Object[]{maListe.get(m).get(0), maListe.get(m).get(1), maListe.get(m).get(2), maListe.get(m).get(3), maListe.get(m).get(4)});
        }
        
        ArrayList<ArrayList<Object>> maListe = new ArrayList<ArrayList<Object>>();
        for (int k = 0; k < tbProduct.getRowCount(); k++) {
            ArrayList<Object> liste = new ArrayList<Object>();
            for (int j = 0; j < tbProduct.getColumnCount(); j++) {
                Object selectedObject = tbProduct.getModel().getValueAt(k, j);
                liste.add(selectedObject);
            }
            maListe.add(liste);
        }
        
        // Calcul prix Total
        for (int j = 0; j < tbProduct.getRowCount(); j++) {
            String quantite = tbProduct.getModel().getValueAt(j, 3).toString();
            String prix = tbProduct.getModel().getValueAt(j, 4).toString();
            String test = Double.parseDouble(quantite) * Double.parseDouble(prix) + "";
            total = total.add(new BigDecimal(test));
        }
        
        this.resteVerser.setText(total+"");
        
        maListe.clear();
    }//GEN-LAST:event_finAttenteActionPerformed

    private void annuleVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annuleVenteActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }
    }//GEN-LAST:event_annuleVenteActionPerformed

    private void encaisserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encaisserActionPerformed
        BigDecimal total = new BigDecimal("0.0");
        DefaultTableModel model = (DefaultTableModel) tbProduct.getModel();
        BigDecimal argentClient = new BigDecimal("0");
        
        // Initialisation de Tableau
        ArrayList<ArrayList<Object>> maListe = new ArrayList<ArrayList<Object>>();
        for (int k = 0; k < tbProduct.getRowCount(); k++) {
            ArrayList<Object> liste = new ArrayList<Object>();
            for (int j = 0; j < tbProduct.getColumnCount(); j++) {
                Object selectedObject = tbProduct.getModel().getValueAt(k, j);
                liste.add(selectedObject);
            }
            maListe.add(liste);
        }
        
        // Calcul prix Total
        for (int j = 0; j < tbProduct.getRowCount(); j++) {
            String quantite = tbProduct.getModel().getValueAt(j, 3).toString();
            String prix = tbProduct.getModel().getValueAt(j, 4).toString();
            String test = Double.parseDouble(quantite) * Double.parseDouble(prix) + "";
            total = total.add(new BigDecimal(test));
        }
        
        
        
        {
            //this.resteVerser.setText(total + "");

            if (paiement.getSelectedItem() == "Espèce") {
                if (new BigDecimal(jTextField1.getText()).compareTo(new BigDecimal(this.resteVerser.getText())) == 1) {
                    argentClient= new BigDecimal(this.jTextField1.getText());
                    elc.afficherPrixTotal(total, argentClient);
                    elc.renduMonnaie(total, argentClient);
                    elc.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Montant inferieur à la somme à payer !");
                }
            } else if (paiement.getSelectedItem() == "CB" || paiement.getSelectedItem() == "Chèque") {
                argentClient = total;
            }
            
            //Impression
            PrinterJob job = PrinterJob.getPrinterJob();
            // Définit son contenu à imprimer
            job.setPrintable(new ImprimerPapierCaisse(maListe, resteVerser.getText(), argentClient+"", this.prixRemise));

            // Affiche une boîte de choix d'imprimante
            if (true) {
                try {
                    // Effectue l'impression
                    job.print();

                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }

            this.resteVerser.setText("0");
            this.jTextField1.setText("");
            this.article.setText("");
            this.quantite.setText("1");

            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
        } 
    }//GEN-LAST:event_encaisserActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        this.article.setText("");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        JTextField liste = (JTextField) evt.getSource();
        if (evt.getMark() == 6) {
            //JOptionPane.showMessageDialog(null, "ca passe dans mwahahaha.... haaaa...");
            rechercheBaseDonnee();
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // lorsqu'on clique sur le bouton, une fenetre apparait indiquant le montant de la remise qui est déduit directement du prix
        /*Remise rem = new Remise(this, true, new BigDecimal(resteVerser.getText()));
        rem.setVisible(true);*/
        BigDecimal rv = new BigDecimal(resteVerser.getText());
        this.prixRemise = new BigDecimal("" + rv.subtract(rv.multiply(new BigDecimal(jTextField1.getText()).divide(new BigDecimal("100")))));
        this.resteVerser.setText(prixRemise+"");
        this.jTextField1.setText("");
        
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductTable frame = new ProductTable();
                Toolkit tk = Toolkit.getDefaultToolkit();
                int xSize = ((int) tk.getScreenSize().getWidth());
                int ySize = ((int) tk.getScreenSize().getHeight());
                frame.setSize(xSize, ySize);
                frame.setVisible(true);

                //frame.show();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajout;
    private javax.swing.JButton annuleVente;
    private javax.swing.JTextField article;
    private javax.swing.JButton close;
    private javax.swing.JButton encaisser;
    private javax.swing.JButton finAttente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton miseAttente;
    private javax.swing.JComboBox paiement;
    private javax.swing.JTextField quantite;
    private javax.swing.JTextField resteVerser;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable tbProduct;
    // End of variables declaration//GEN-END:variables
}
