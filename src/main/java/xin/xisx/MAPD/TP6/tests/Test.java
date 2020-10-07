package xin.xisx.MAPD.TP6.tests;

import xin.xisx.MAPD.TP6.articles.interfaces.IArticle;
import xin.xisx.MAPD.TP6.articles.implementation.Article;
import xin.xisx.MAPD.TP6.articles.implementation.Stock;
import xin.xisx.MAPD.TP6.articles.interfaces.IStock;
import xin.xisx.MAPD.TP6.facture.interfaces.IFacture;
// Choisissez une implantation
//import facture.implementation.Facture;
//import xin.xisx.MAPD.TP6.facture.implementation.Facture;
import xin.xisx.MAPD.TP6.facture.implementation2.Facture;

/**
 * The Class Main.
 */
public class Test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public final static void main(String[] args) {
		// les articles
		IArticle s1 = new Article("stylo vert", "DUDU", 3.0);
		IArticle s2 = new Article("stylo bleu", "RIRI", 1.0);
		IArticle s3 = new Article("stylo rouge", "LULU", 2.0);
		IArticle s4 = new Article("stylo noir", "FIFI", 4.0);
		IArticle b1 = new Article("banane", "Martinique", 0.5);
		IArticle b2 = new Article("Banane", "Martinique", 1.0);
		IArticle b3 = new Article("BANANE", "Martinique", 2.0);

		// le stock
		IStock bd = new Stock();
		bd.add("stylo_vert", s1, 10);
		bd.add("stylo002", s2, 5);
		bd.add("stylo003", s3, 3);
		bd.add("stylo004", s4, 2);
		bd.add(b1.getDescriptif(), b1, 1);
		bd.add(b2.getMarque(), b2, 5);
		bd.add("b004", b3, 6);

		bd.display();

		bd.add("stylo_vert", s1, 5);
		bd.add("stylo004", s4, 2);

		bd.display();

		// une commande
		IFacture f = new Facture(bd);
		f.add("stylo002", 5);
		f.add("stylo_vert", 15);
		f.add("stylo002", 5);

		f.display();

		System.out.println("Montant avec la remise " + f.compute());

	}

}
