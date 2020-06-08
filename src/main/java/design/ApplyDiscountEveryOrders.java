package design;

import java.util.HashMap;

public class ApplyDiscountEveryOrders {
    public static void main(String[] args) {
        Cashier cashier = new Cashier(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        System.out.println("500.0 => " + cashier.getBill(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println("4000.0 => " + cashier.getBill(new int[]{3, 7}, new int[]{10, 10}));
        System.out.println("800.0 => " + cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println("4000.0 => " + cashier.getBill(new int[]{4}, new int[]{10}));
        System.out.println("4000.0 => " + cashier.getBill(new int[]{7, 3}, new int[]{10, 10}));
        System.out.println("7350.0 => " + cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}));
        System.out.println("2500.0 => " + cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2}));
    }
}

class Cashier {

    private int number;
    private int happyMan;
    private int discount;
    private int[] products;
    private int[] prices;

    int [] pricesMap = new int[1000];

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.happyMan = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;

        for (int i = 0; i < products.length; i++) {
            pricesMap[products[i]] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount) {
        if (++number % happyMan == 0) {
            return makeDiscount(product, amount);
        } else return getTotalPrice(product, amount);
    }

    private double makeDiscount(int[] product, int[] amount) {
        double res = 0;
        for (int i = 0; i < product.length; i++) {
            res+=amount[i] * pricesMap[product[i]];
        }
        return res - ((res * discount) / 100);
    }

    private double getTotalPrice(int[] product, int[] amount) {
        double res = 0;
        for (int i = 0; i < product.length; i++) {
            res+=amount[i] * pricesMap[product[i]];
        }
        return res;
    }
}
