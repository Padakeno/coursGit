
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ImprimerPapierCaisse implements Printable {

    /**
     * Constructeur par défaut de PrintRectangle
     */

    private ArrayList<ArrayList<Object>> maListe;
    private String resteVerser;
    private String argentClient;
    private BigDecimal prixRemise;

    public ImprimerPapierCaisse(ArrayList<ArrayList<Object>> maListe, String resteVerser, String argentClient, BigDecimal prixRemise) {
        this.maListe = maListe;
        this.resteVerser = resteVerser;
        this.argentClient = argentClient;
        this.prixRemise = prixRemise;
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        // Par défaut, retourne NO_SUCH_PAGE => la page n'existe pas
        int retValue = Printable.NO_SUCH_PAGE;
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        /* On définit une marge pour l'impression */
        int marge = 70;

        /* On récupère les coordonnées des bords de la page */
        int x = (int) pageFormat.getImageableX();
        int y = (int) pageFormat.getImageableY();
        int w = (int) pageFormat.getImageableWidth();
        int h = (int) pageFormat.getImageableHeight();

        /* Dessin d'un cadre gris clair*/
		//graphics.setColor(Color.LIGHT_GRAY);
        //graphics.fillRect(x+10, y+10, w-20, h-20);

        /* On écrit une ligne de titre en rouge, en gras de taille 18 */
		//graphics.setFont(new Font("Arial", Font.BOLD, 18));
        //graphics.setColor(Color.RED);
        //graphics.drawString("Rapport\n", x + marge, y+marge);

        /* On écrit une ligne en noir de taille 14 */
        graphics.setFont(new Font("Arial", Font.PLAIN, 10));
        graphics.setColor(Color.BLACK);
        graphics.drawString("SARL Reims Outillage", x + 30, y + 20);
        graphics.drawString("Magasin de bricolage", x + 30, y + 30);
        graphics.drawString("111, rue du Mont d'Arène, Reims", x + 30, y + 40);
        graphics.drawString("Tel : 03.26.32.45.65", x + 30, y + 50);

        int description = x + 30;
        int qte = x + 150;
        int prix = x + 240;
        int countArticle = 0;

        graphics.drawString("Description", description, y + 70);
        graphics.drawString("Qte", qte, y + 70);
        graphics.drawString("Prix", prix, y + 70);

        graphics.setFont(new Font("Arial", Font.PLAIN, 10));
        graphics.setColor(Color.BLACK);
        //System.out.println(maListe.get(0).get(4)+"");
        for (int i = 0; i < maListe.size(); i++) {
            graphics.drawString(maListe.get(i).get(2) + "", description, y + marge + 20);
            graphics.drawString(maListe.get(i).get(3) + "", qte, y + marge + 20);
            graphics.drawString(maListe.get(i).get(4) + "", prix, y + marge + 20);
            marge = marge + 20;
            countArticle = countArticle + Integer.parseInt(maListe.get(i).get(3) + "");
        }
        
        graphics.drawString("% de remise : "+this.prixRemise, description, y+marge+30);

        graphics.drawString(countArticle + " article(s)", description, y + marge + 40);
        graphics.drawString("Total à payer", x + 120, y + marge + 40);
        graphics.drawString(resteVerser, prix, y + marge + 40);

        graphics.drawString("ESPECES", description, y + marge + 70);
        graphics.drawString("EUR", x + 120, y + marge + 70);
        graphics.drawString(argentClient, prix, y + marge + 70);

        BigDecimal resteVerserB = new BigDecimal(resteVerser + "");
        BigDecimal argentClientB = new BigDecimal(argentClient + "");

        BigDecimal monnaie = argentClientB.subtract(resteVerserB);

        graphics.drawString("Votre monnaie :", description, y + marge + 90);
        graphics.drawString(monnaie + "", prix, y + marge + 90);

        Date aujourdhui = new Date();

        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        
        graphics.drawString(shortDateFormat.format(aujourdhui), qte, y + marge + 120);
        graphics.drawString("http://lamoria.reimsoutillage.fr", qte-50, y + marge + 130);
        
        System.setProperty("file.encoding", "UTF-8");
        return PAGE_EXISTS;

    }

}
