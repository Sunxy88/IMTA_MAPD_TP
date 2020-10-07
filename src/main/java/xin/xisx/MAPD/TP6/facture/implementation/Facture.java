package xin.xisx.MAPD.TP6.facture.implementation;

import xin.xisx.MAPD.TP6.articles.interfaces.IStock;
import xin.xisx.MAPD.TP6.facture.interfaces.IFacture;

import java.util.*;

/**
 * For question 2.1
 * This is a bad-designed class with a heritage from Vector...
 */
public class Facture extends Vector<Map.Entry<String, Integer>> implements IFacture {

    private IStock stock;

    public Facture() {
    }

    public Facture(IStock bd) {
        this.stock = bd;
    }

    @Override
    public IStock getEntrepot() {
        return stock;
    }

    @Override
    public void setEntrepot(IStock stock) {
        this.stock = stock;
    }

    @Override
    public void add(String ref, int qt) {
        if (stock.enoughArticleQuantity(ref, qt)) {
            super.add(new AbstractMap.SimpleEntry<>(ref, qt));
            Map<String, Integer> qty = stock.getQuantities();
            qty.put(ref, qty.get(ref) - qt);
        }
    }

    @Override
    public void display() {
        System.out.println("Facture: ");
        Iterator<Map.Entry<String, Integer>> itr = super.iterator();
        Map.Entry<String, Integer> cur;
        while (itr.hasNext()) {
            cur = itr.next();
            System.out.println(cur.getKey() + ": " + cur.getValue());
        }
    }

    @Override
    public double compute() {
        Iterator<Map.Entry<String, Integer>> itr = super.iterator();
        double sum = 0.0;
        Map.Entry<String, Integer> cur;
        String ref;
        Integer qt;
        while (itr.hasNext()) {
            cur = itr.next();
            ref = cur.getKey();
            qt = cur.getValue();
            if (stock.getArticleQuantity(ref) > 10) {
                sum += qt * stock.getStock().get(ref).getPrix() * 0.9;
            } else {
                sum += qt * stock.getStock().get(ref).getPrix();
            }
        }
        return sum;
    }
}
