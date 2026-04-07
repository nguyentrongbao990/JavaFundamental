package Session16.Ex4;

import java.util.List;
import java.util.function.Predicate;

public interface ProductProcessor {

    double calculateTotalValue(List<Product> products);

    static void printProductList(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Danh sách sản phẩm đang trống.");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    default boolean hasExpensiveProduct(List<Product> products) {
        Predicate<Product> expensiveProduct = product -> product.getPrice() > 100;

        for (Product product : products) {
            if (expensiveProduct.test(product)) {
                return true;
            }
        }
        return false;
    }
}