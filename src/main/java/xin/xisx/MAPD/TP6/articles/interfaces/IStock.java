package xin.xisx.MAPD.TP6.articles.interfaces;

import java.util.HashMap;

import xin.xisx.MAPD.TP6.articles.interfaces.IArticle;

public interface IStock {

	HashMap<String, IArticle> getStock();

	void setStock(HashMap<String, IArticle> stock);

	/**
	 * Gets the quantity.
	 *
	 * @return the quantities
	 */
	HashMap<String, Integer> getQuantities();
	
	/**
	 * Gets the quantity of a specific reference.
	 *
	 * @return the quantity
	 */
	Integer getArticleQuantity(String ref);
	
	/**
	 * Returns if there is enough quantity of an article.
	 *
	 * @return true if the quantity is greater or equal to required
	 */
	boolean enoughArticleQuantity(String ref, int required);

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the quantity
	 */
	void setQuantity(HashMap<String, Integer> quantity);

	/**
	 * add multiple times is allowed.
	 *
	 * @param ref the ref
	 * @param s1 the art
	 * @param qt  the qt
	 */
	void add(String ref, IArticle s1, int qt);

	/**
	 * display the contents.
	 */
	void display();

}