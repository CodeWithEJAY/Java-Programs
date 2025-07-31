import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // ---------- Data Models ----------
    static class Item {
        final int id;           // stable identifier mapped from the arrays
        final String name;
        final double price;
        int stock;

        Item(int id, String name, double price, int stock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
    }

    static class CartLine {
        final Item item;
        int qty;

        CartLine(Item item, int qty) {
            this.item = item;
            this.qty = qty;
        }

        double lineTotal() {
            return item.price * qty;
        }
    }

    // ---------- Program State ----------
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Item> inventory = new ArrayList<>();
    private static final ArrayList<CartLine> cart = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== Welcome to Snack Shop ===");

        // ---- Arrays to define the initial catalog ----
        String[] names = {
                "Dried Mangoes", "Polvoron", "Ube Hopia", "Banana Chips", "Piaya",
                "Chicharon", "Barquillos", "Pastillas", "Otap", "Espasol"
        };
        double[] prices = {
                120.00, 80.00, 150.00, 90.00, 65.00,
                110.00, 95.00, 70.00, 85.00, 75.00
        };
        int[] stocks = {
                5, 10, 7, 12, 8,
                6, 9, 10, 6, 8
        };
        // Build the live inventory ArrayList from the arrays
        for (int i = 0; i < names.length; i++) {
            inventory.add(new Item(i, names[i], prices[i], stocks[i]));
        }

        // ---- Menu loop ----
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> showInventory();
                case 2 -> addToCartFlow();
                case 3 -> viewCart();
                case 4 -> removeFromCartFlow();
                case 5 -> checkoutFlow();
                case 0 -> {
                    System.out.println("Thank you for visiting! Goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ---------- Menu UI ----------
    private static void printMainMenu() {
        System.out.println();
        System.out.println("--------- Main Menu ---------");
        System.out.println("[1] View Available Items");
        System.out.println("[2] Add Item to Cart");
        System.out.println("[3] View Cart");
        System.out.println("[4] Remove Item from Cart");
        System.out.println("[5] Checkout");
        System.out.println("[0] Exit");
    }

    // Show only items with stock > 0 (out-of-stock items disappear)
    private static void showInventory() {
        System.out.println();
        System.out.println("----- Available Snacks (Stock > 0) -----");
        List<Item> visible = getVisibleInventory();
        if (visible.isEmpty()) {
            System.out.println("All items are currently out of stock.");
            return;
        }
        int idx = 1;
        for (Item it : visible) {
            System.out.printf("%2d) %-15s  PHP %.2f  (stock: %d)%n", idx++, it.name, it.price, it.stock);
        }
    }

    // Build a dynamic list of items that are in stock
    private static List<Item> getVisibleInventory() {
        ArrayList<Item> visible = new ArrayList<>();
        for (Item it : inventory) {
            if (it.stock > 0) visible.add(it);
        }
        return visible;
    }

    private static void addToCartFlow() {
        List<Item> visible = getVisibleInventory();
        if (visible.isEmpty()) {
            System.out.println("No items available to add. Inventory is out of stock.");
            return;
        }

        showInventory();
        int pick = readInt("Enter the item number to add (as shown above): ");
        if (pick < 1 || pick > visible.size()) {
            System.out.println("Invalid item number.");
            return;
        }
        Item chosen = visible.get(pick - 1);
        System.out.printf("Selected: %s (PHP %.2f) — Stock: %d%n", chosen.name, chosen.price, chosen.stock);

        int qty = readInt("Enter quantity: ");
        if (qty <= 0) {
            System.out.println("Quantity must be at least 1.");
            return;
        }
        if (qty > chosen.stock) {
            System.out.printf("Sorry, only %d left in stock.%n", chosen.stock);
            return;
        }

        // Deduct stock immediately (so it can disappear when it hits 0)
        chosen.stock -= qty;

        // Add to cart (combine with existing line if same item already in cart)
        CartLine line = findCartLine(chosen);
        if (line == null) {
            cart.add(new CartLine(chosen, qty));
        } else {
            line.qty += qty;
        }

        System.out.printf("Added %d × %s to your cart. Remaining stock: %d%n", qty, chosen.name, chosen.stock);
        if (chosen.stock == 0) {
            System.out.println("Note: This item is now out of stock and will no longer appear in the inventory list.");
        }
    }

    private static void viewCart() {
        System.out.println();
        System.out.println("------------ Your Cart ------------");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0.0;
        int idx = 1;
        for (CartLine cl : cart) {
            double lineTotal = cl.lineTotal();
            total += lineTotal;
            System.out.printf("%2d) %-15s  PHP %.2f  × %d  =  PHP %.2f%n",
                    idx++, cl.item.name, cl.item.price, cl.qty, lineTotal);
        }
        System.out.println("-----------------------------------");
        System.out.printf("Cart Total: PHP %.2f%n", total);
    }

    private static void removeFromCartFlow() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to remove.");
            return;
        }
        viewCart();
        int pick = readInt("Enter the cart line number to remove: ");
        if (pick < 1 || pick > cart.size()) {
            System.out.println("Invalid cart line.");
            return;
        }
        CartLine chosen = cart.get(pick - 1);

        int qty = readInt("Enter quantity to remove (<= current quantity): ");
        if (qty <= 0 || qty > chosen.qty) {
            System.out.println("Invalid quantity.");
            return;
        }

        // Return stock to the inventory item
        chosen.item.stock += qty;
        chosen.qty -= qty;

        if (chosen.qty == 0) {
            cart.remove(pick - 1);
        }

        System.out.printf("Removed %d × %s from your cart. Stock restored to %d.%n",
                qty, chosen.item.name, chosen.item.stock);
    }

    private static void checkoutFlow() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add items before checking out.");
            return;
        }

        viewCart();
        System.out.print("Proceed to checkout? (Y/N): ");
        String ans = sc.next().trim();
        if (!ans.equalsIgnoreCase("Y")) {
            System.out.println("Checkout cancelled.");
            return;
        }

        double total = 0.0;
        for (CartLine cl : cart) {
            total += cl.lineTotal();
        }

        // Print a simple receipt
        System.out.println();
        System.out.println("=========== RECEIPT ===========");
        for (CartLine cl : cart) {
            System.out.printf("%-15s  PHP %.2f  × %d  =  PHP %.2f%n",
                    cl.item.name, cl.item.price, cl.qty, cl.lineTotal());
        }
        System.out.println("-------------------------------");
        System.out.printf("TOTAL DUE: PHP %.2f%n", total);
        System.out.println("Thank you for your purchase!");
        System.out.println("===============================");

        // Clear the cart (stock is already deducted at add time)
        cart.clear();
    }

    // ---------- Helpers ----------
    private static CartLine findCartLine(Item item) {
        for (CartLine cl : cart) {
            if (cl.item.id == item.id) return cl;
        }
        return null;
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int v = sc.nextInt();
                sc.nextLine(); // consume newline
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                sc.nextLine(); // clear invalid input
            }
        }
    }
}
