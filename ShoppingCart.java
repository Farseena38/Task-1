import java.util.Scanner;

public class ShoppingCart {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Product prices
        int priceA = 20;
        int priceB = 40;
        int priceC = 50;

        // Discount Rules
        int flat10Discount = 10;
        double bulk5Discount = 0.05;
        double bulk10Discount = 0.1;
        double tiered50Discount = 0.5;

        // Fees
        int giftWrapFee = 1;
        int shippingFeePerPackage = 5;
        int itemsPerPackage = 10;

        // Input quantities and gift wrap choice
        // Ask user for the quantity of each product and if it's wrapped as a gift
        System.out.println("Enter the quantity for Product A:");
        int quantityA = scanner.nextInt();
        System.out.println("Is Product A wrapped as a gift? (yes/no):");
        boolean giftWrapA = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Enter the quantity for Product B:");
        int quantityB = scanner.nextInt();
        System.out.println("Is Product B wrapped as a gift? (yes/no):");
        boolean giftWrapB = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Enter the quantity for Product C:");
        int quantityC = scanner.nextInt();
        System.out.println("Is Product C wrapped as a gift? (yes/no):");
        boolean giftWrapC = scanner.next().equalsIgnoreCase("yes");

        // Calculate total amounts for each product
        // Multiply quantity by price for each product to get total amount
        int totalA = quantityA * priceA;
        int totalB = quantityB * priceB;
        int totalC = quantityC * priceC;

        // Calculate subtotal
        // Sum of total amounts for all products
        int subtotal = totalA + totalB + totalC;

        // Calculate discounts
        // Determine which discount rule applies and calculate the discount amount
        int discountAmount = 0;
        String discountName = "";

        if (subtotal > 200) {
            discountAmount = flat10Discount;
            discountName = "Flat $10 discount";
        } else if (quantityA > 10 || quantityB > 10 || quantityC > 10) {
            double maxDiscount = Math.max(Math.max(totalA, totalB), totalC) * bulk5Discount;
            discountAmount = (int) Math.round(maxDiscount);
            discountName = "Bulk 5% discount";
        } else if (quantityA + quantityB + quantityC > 20) {
            discountAmount = (int) Math.round(subtotal * bulk10Discount);
            discountName = "Bulk 10% discount";
        } else if (quantityA + quantityB + quantityC > 30 && (quantityA > 15 || quantityB > 15 || quantityC > 15)) {
            int discountableQuantity = Math.max(Math.max(quantityA - 15, quantityB - 15), quantityC - 15);
            discountAmount = discountableQuantity * priceC / 2;
            discountName = "Tiered 50% discount";
        }

        // Calculate shipping fee
        // Determine the number of packages needed based on total items and calculate shipping fee
        int totalItems = quantityA + quantityB + quantityC;
        int totalPackages = (int) Math.ceil((double) totalItems / itemsPerPackage);
        int shippingFee = totalPackages * shippingFeePerPackage;

        // Calculate gift wrap fee
        // Calculate the total fee for wrapping selected products
        int giftWrapTotalFee = (giftWrapA ? quantityA : 0) + (giftWrapB ? quantityB : 0) + (giftWrapC ? quantityC : 0);
        int totalGiftWrapFee = giftWrapTotalFee * giftWrapFee;

        // Calculate total
        // Calculate the final total amount by subtracting discount, adding shipping fee, and adding gift wrap fee
        int total = subtotal - discountAmount + shippingFee + totalGiftWrapFee;
        
     // Output details
        // Display the details of each product, subtotal, discount, fees, and total
        System.out.println("Product A: Quantity=" + quantityA + ", Total=" + totalA);
        System.out.println("Product B: Quantity=" + quantityB + ", Total=" + totalB);
        System.out.println("Product C: Quantity=" + quantityC + ", Total=" + totalC);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount Applied: " + discountName + ", Amount=" + discountAmount);
        System.out.println("Shipping Fee: " + shippingFee);
        System.out.println("Gift Wrap Fee: " + totalGiftWrapFee);
        System.out.println("Total: " +total);
	
	}

}
