package xin.xisx.MAPD.TP6.facture.interfaces;

import xin.xisx.MAPD.TP6.articles.interfaces.IStock;

public interface IFacture {

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	IStock getEntrepot();

	/**
	 * Sets the stock.
	 *
	 * @param stock the new stock
	 */
	void setEntrepot(IStock stock);

	/**
	 * Add stupid should check the quantity available in stock.
	 *
	 * @param ref the ref
	 * @param qt the qt
	 */
	void add(String ref, int qt);

	/**
	 * Simple display.
	 */
	void display();

	/**
	 * Compute the total amount taking into account reductions.
	 *
	 * @return a double
	 */
	double compute();

}