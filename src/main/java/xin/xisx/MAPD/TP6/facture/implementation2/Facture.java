package xin.xisx.MAPD.TP6.facture.implementation2;

import xin.xisx.MAPD.TP6.articles.interfaces.IStock;
import xin.xisx.MAPD.TP6.facture.interfaces.IFacture;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Facture implements IFacture {

    private IStock stock;
    private List<Map.Entry<String, Integer>> commands;

    public Facture(IStock stock) {
        this.stock = stock;
        this.commands = new ArrayList<>();
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
            commands.add(new AbstractMap.SimpleEntry<>(ref, qt));
            Map<String, Integer> qty = stock.getQuantities();
            qty.put(ref, qty.get(ref) - qt);
        }
    }

    @Override
    public void display() {
        for (Map.Entry<String, Integer> entry : commands) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public double compute() {
        double sum = 0;
        for (Map.Entry<String, Integer> entry : commands) {
            String ref = entry.getKey();
            int qt = entry.getValue();
            if (stock.getArticleQuantity(ref) > 10) {
                sum += qt * stock.getStock().get(ref).getPrix() * 0.9;
            } else {
                sum += qt * stock.getStock().get(ref).getPrix();
            }
        }
        return sum;
    }
}
