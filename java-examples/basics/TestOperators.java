public class TestOperators {
    public static void main(String[] args) {
        int quantity = 25;
        double price = 20;
        String item = "Bat";
        double subTotal = quantity * price;
        double deliveryFee = (subTotal >= 100) ? 0.0 : 25;
        double total = subTotal + deliveryFee;
        int itemsPerBox = 10; // fits how many items
        int remaining = quantity % itemsPerBox;
        System.out.println("Item Name = "+item);
        System.out.println("Sub Total = "+subTotal);
        System.out.println("Delivery Fee = "+deliveryFee);
        System.out.println("Total = "+total);
        System.out.println("Remaining: "+remaining);
        System.out.println((remaining == 0) ? "No box required" 
            : "Box required for "+remaining+" items");
    }
}
