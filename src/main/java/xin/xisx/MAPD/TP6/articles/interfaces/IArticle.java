package xin.xisx.MAPD.TP6.articles.interfaces;

public interface IArticle {

	/**
	 * Sets the marque.
	 *
	 * @param marque the new marque
	 */
	public String getMarque();

	/**
	 * Sets the marque.
	 *
	 * @param marque the new marque
	 */
	public void setMarque(String marque);

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	public double getPrix();

	/**
	 * Sets the prix.
	 *
	 * @param pu the new prix
	 */
	public void setPrix(double pu);

	/**
	 * Sets the descriptif.
	 *
	 * @param descriptif the new descriptif
	 */
	public void setDescriptif(String descriptif);

	/**
	 * Gets the descriptif.
	 *
	 * @return the descriptif
	 */
	public String getDescriptif();

}
