package xin.xisx.MAPD.TP6.articles.implementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import xin.xisx.MAPD.TP6.articles.interfaces.IArticle;
import xin.xisx.MAPD.TP6.articles.interfaces.IStock;

/**
 * The Class Stock. 
 * 
 */
public class Stock implements IStock  {

	/** the contents */
	private HashMap<String, IArticle> stock;

	/** The quantity. */
	private HashMap<String, Integer> quantity;

	/**
	 * Default constructor.
	 */
	public Stock() {
		this.stock = new HashMap<String, IArticle>();
		this.quantity = new HashMap<String, Integer>();
	}

	@Override
	public HashMap<String, IArticle> getStock() {
		return stock;
	}

	@Override
	public void setStock(HashMap<String, IArticle> stock) {
		this.stock = stock;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	@Override
	public HashMap<String, Integer> getQuantities() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the quantity
	 */
	@Override
	public void setQuantity(HashMap<String, Integer> quantity) {
		this.quantity = quantity;
	}
	

	@Override
	public Integer getArticleQuantity(String ref) {
		return this.quantity.get(ref);
	}

	@Override
	public boolean enoughArticleQuantity(String ref, int required) {
		return required <= getArticleQuantity(ref);
	}

	/**
	 * add multiple times is allowed.
	 *
	 * @param ref the ref
	 * @param art the art
	 * @param qt  the qt
	 */
	@Override
	public void add(String ref, IArticle art, int qt) {
		if (this.stock.containsKey(ref)) {
			this.quantity.put(ref, this.quantity.get(ref) + qt);
		} else {
			this.stock.put(ref, art);
			this.quantity.put(ref, qt);
		}
	}

	/**
	 * display the contents.
	 */
	@Override
	public void display() {
		System.out.println("Stock contents :");
		Iterator<Entry<String, IArticle>> it = this.stock.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, IArticle> art = it.next();
			System.out.println(art.toString() + " quantité = " + this.quantity.get(art.getKey()));
		}
	}
	
	public static void main(String [] a) {
		// les articles
		IArticle s1 = new Article("stylo vert", "DUDU", 3.0);
		IArticle s2 = new Article("stylo bleu", "RIRI", 1.0);
		IArticle s3 = new Article("stylo rouge", "LULU", 2.0);
		IArticle s4 = new Article("stylo noir", "FIFI", 4.0);
		IArticle b1 = new Article("botte", "Paris", 10.5);
		IArticle b2 = new Article("chaussette", "Ulan Bâtor", 2.0);
		IArticle b3 = new Article("lacet", "Madrid", 1.0);

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
		
		System.out.println("Expected quantity for stylo_vert is 15 : actual is "+bd.getArticleQuantity("stylo_vert"));
		System.out.println("There is enough for 15 : " +bd.enoughArticleQuantity("stylo_vert",15));
		System.out.println("There is enough for 16 : " +bd.enoughArticleQuantity("stylo_vert",16));
	}
	
}

