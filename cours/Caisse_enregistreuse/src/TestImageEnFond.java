import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
 
public class TestImageEnFond extends JButton { // !!! on doit étendre le composant dans lequel on veut insérer une image de fond
     
    private Image img;
    private String imageName;
     
    //Un constructeur pour choisir plus simplement l'image
    public TestImageEnFond(String imageName) {
        img = new ImageIcon(getClass().getResource(imageName)).getImage();
    }
     
    //On doit redéfinir la méthode paintComponent() pour les composant swing !!! et paint() pour awt
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img == null) return;
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this); //ici on adapte l'image à la taille du composant(getWidth(), getHeight())...
//cf : la documentation java à http://javasearch.developpez.com/j2se/1.6.0/docs/api/java/awt/Graphics.html#drawImage(java.awt.Image,%20int,%20int,%20int,%20int,%20java.awt.image.ImageObserver)
     
    }
 
    public static void main(String[] args) {
         
        //Mise en place d'une JFrame de test
       JFrame f = new JFrame("test");
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setLocationRelativeTo(null);
       f.setSize(100,100);
        
       //Creation du JButton avec une image en fond
       TestImageEnFond butTest =  new TestImageEnFond("/images/suppr.png");
        
       f.getContentPane().add(butTest);  //on attache le composant au panel par default
        
        
       f.setVisible(true);
    }
 
}