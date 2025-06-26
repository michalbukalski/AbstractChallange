import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product) {}

public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil Painting", 1350, "Impressionistic work by ABF painted in 2000"));

        storeProducts.add(new ArtObject("Sculpture", 3000, "Bronze work by JKF, produced in 1950"));

        storeProducts.add(new Furniture("Desk", 1200, "A beautiful oak desk with brass handles"));
        storeProducts.add(new Furniture("Table", 800, "A modern glass table with steel legs"));
        storeProducts.add(new Furniture("Chair", 450, "A comfortable leather chair with wooden legs"));

        listProducts();


//        Porszanie się tekstu w konsoli #just for fun
//
//        int max = 20;
//        int pos = 0;
//        int dir = 1;
//
//        for (int step = 0; step < max * 2; step++) {
//            System.out.print("\r" + " ".repeat(pos) + "+------------+\n" +
//                    " ".repeat(pos) + "|  Order 1   |\n" +
//                    " ".repeat(pos) + "+------------+");
//            try { Thread.sleep(100); } catch (InterruptedException e) {}
//            System.out.print("\r" + " ".repeat(50) + "\r"); // czyści linię
//
//            pos += dir;
//            if (pos == max || pos == 0) dir *= -1; // zmiana kierunku
//        }

//        System.out.println("\nOrder 1");
//        System.out.println("-".repeat(50));
        System.out.println("+------------+");
        System.out.println("|  Order 1   |");
        System.out.println("+------------+");

        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("+------------+");
        System.out.println("|  Order 2   |");
        System.out.println("+------------+");

        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 2, 2);
        addItemToOrder(order2, 4, 8);
        printOrder(order2);

        System.out.println("+------------+");
        System.out.println("|  Order 3   |");
        System.out.println("+------------+");

        var order3 = new ArrayList<OrderItem>();
        addItemToOrder(order3, 3, 5);
        addItemToOrder(order3, 0, 2);
        addItemToOrder(order3, 4, 8);
        addItemToOrder(order3, 1, 1);
        printOrder(order3);

    }

    public static void listProducts() {
        for (var item : storeProducts) {
            System.out.println("-".repeat(50));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty) {
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {

        double salesTotal = 0;
        for (var item : order) {
            item.product().printPricedItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total: %6.2f zł %n", salesTotal);
    }
}
