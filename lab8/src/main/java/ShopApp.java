public class ShopApp {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        // Add a new product
        productDAO.addProduct("Laptop", 1500.50, 10);

        // Get a product by ID
        productDAO.getProductById(1);

        // Update a product by ID
        productDAO.updateProduct(1, "Gaming Laptop", 2000.75, 5);

        // Delete a product by ID
        productDAO.deleteProduct(1);
    }
}