class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {
    private Product[] products;

    public EcommerceSearch(Product[] products) {
        this.products = products;
    }

    // Linear search implementation
    public Product linearSearch(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Binary search implementation
    public Product binarySearch(String productId) {
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("1", "Laptop", "Electronics"),
                new Product("2", "Smartphone", "Electronics"),
                new Product("3", "Book", "Literature"),
                new Product("4", "Shoes", "Footwear")
        };

        EcommerceSearch search = new EcommerceSearch(products);

        // Linear search
        System.out.println("Linear Search:");
        Product result1 = search.linearSearch("3");
        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Product not found");
        }

        // Binary search
        System.out.println("\nBinary Search:");
        Product result2 = search.binarySearch("3");
        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Product not found");
        }
    }
}
