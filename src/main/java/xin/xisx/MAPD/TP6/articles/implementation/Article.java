package xin.xisx.MAPD.TP6.articles.implementation;

import xin.xisx.MAPD.TP6.articles.interfaces.IArticle;

/**
 * Articles unitaires.
 */
public class Article implements IArticle {

	/** The marque. */
	private String marque;

	/** The prix. */
	private double prix;

	/** The descriptif. */
	private String descriptif;

	/**
	 * Instantiates a new article.
	 *
	 * @param descriptif the descriptif
	 * @param marque     the marque
	 * @param pu         the pu
	 */
	public Article(String descriptif, String marque, double pu) {
		this.marque = marque;
		this.prix = pu;
		this.descriptif = descriptif;
	}

	/**
	 * Gets the marque.
	 *
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Sets the marque.
	 *
	 * @param marque the new marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Sets the prix.
	 *
	 * @param pu the new prix
	 */
	public void setPrix(double pu) {
		this.prix = pu;
	}

	/**
	 * Sets the descriptif.
	 *
	 * @param descriptif the new descriptif
	 */
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	/**
	 * Gets the descriptif.
	 *
	 * @return the descriptif
	 */
	public String getDescriptif() {
		return descriptif;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return this.getDescriptif() + " : " + this.getMarque() + " au prix de " + this.getPrix();
	}
	
	public static void main(String [] a) {
		IArticle s1 = new Article("stylo vert", "DUDU", 3.0);
		IArticle s2 = new Article("stylo bleu", "RIRI", 1.0);
		
		System.out.println(s1);
		System.out.println(s2);
		s1.setDescriptif("Stylo Vert");
		System.out.println(s1);
		s1.setPrix(6.0);
		System.out.println(s1);
		s1.setMarque("DuDu");
		System.out.println(s1);
	}

}
