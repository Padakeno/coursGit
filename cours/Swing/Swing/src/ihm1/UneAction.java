package ihm1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
*
* @author slam
*/

public class UneAction implements ActionListener {
    private JTextField champ;
    private int compteur;
    
    public UneAction(JTextField champ) {
        this.champ = champ;
        this.compteur = 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	this.champ.setText("" + this.compteur++);
    }
}