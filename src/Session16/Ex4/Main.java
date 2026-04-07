package Session16.Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Bánh mì", 20));
        products.add(new Product("Sữa", 35));
        products.add(new Product("Tai nghe", 250));
        products.add(new Product("Chuột máy tính", 180));
        products.add(new Product("Bút", 10));

        ProductProcessor processor = new ProductProcessorImpl();

        ProductProcessor.printProductList(products);

        System.out.println();

        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền (> 100).");

            Predicate<Product> expensiveProduct = product -> product.getPrice() > 100;
            List<Product> expensiveProducts = products.stream()
                    .filter(expensiveProduct)
                    .collect(Collectors.toList());

            System.out.println("Các sản phẩm đắt tiền:");
            for (Product product : expensiveProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        System.out.println();

        double totalValue = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị sản phẩm: " + totalValue);
    }
}