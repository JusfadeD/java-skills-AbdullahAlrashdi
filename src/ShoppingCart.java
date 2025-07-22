public class ShoppingCart {

    public static double calculateTotal(double[] prices, String customerType) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total = total + prices[i];
        }

        if (customerType.equals("PREMIUM")) {
            total = total * 0.9;
        } else if (customerType.equals("VIP")) {
            total = total * 0.8;
        }

        return total;
    }

    public static double findMostExpensive(double[] prices) {
        double max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    public static int countExpensiveItems(double[] prices, double threshold) {
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > threshold) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};

        System.out.println("regular");
        System.out.println(calculateTotal(cart, "REGULAR"));

        System.out.println("premium");
        System.out.println(calculateTotal(cart, "PREMIUM"));

        System.out.println("vip");
        System.out.println(calculateTotal(cart, "VIP"));

        System.out.println("max item");
        System.out.println(findMostExpensive(cart));

        System.out.println("above 30");
        System.out.println(countExpensiveItems(cart, 30));
    }
}
