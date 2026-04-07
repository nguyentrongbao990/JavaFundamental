package Session16.Ex1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductManager {
    private Map<Integer, Product> productMap;

    public ProductManager() {
        productMap = new HashMap<>();
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public boolean addProduct(Product product) {
        if (productMap.containsKey(product.getId())) {
            return false;
        }
        productMap.put(product.getId(), product);
        return true;
    }

    public boolean updateProduct(int id, String newName, double newPrice) {
        Product product = productMap.get(id);
        if (product == null) {
            return false;
        }

        product.setName(newName);
        product.setPrice(newPrice);
        return true;
    }

    public boolean deleteProduct(int id) {
        return productMap.remove(id) != null;
    }

    public void showProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Danh sách sản phẩm đang trống.");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }

    public List<Product> filterProductsByPrice(double minPrice) {
        return productMap.values()
                .stream()
                .filter(product -> product.getPrice() > minPrice)
                .collect(Collectors.toList());
    }

    public double getTotalValue() {
        return productMap.values()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}