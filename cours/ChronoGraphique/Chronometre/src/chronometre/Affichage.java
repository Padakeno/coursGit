/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chronometre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author slam
 */
public class Affichage implements ActionListener{
    private JTextField champ;
    private int compteur;
    
    public Affichage(JTextField champ) {
        this.champ = champ;
        this.compteur = 0;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	this.champ.setText("" + this.compteur++);
    }
}
