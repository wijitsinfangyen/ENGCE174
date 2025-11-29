package lab2.lab2_10;

public class ShoppingCart {
    Product[] items;
    int itemCount;

    public ShoppingCart() {
        items = new Product[10]; 
        itemCount = 0;
    }

    void addProduct(Product p) {
        items[itemCount] = p;
        itemCount++;
    }

    double calculateTotalPrice() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].price;
        }
        return total;
    }
}
