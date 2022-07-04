import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public  boolean conformity (Product product, String searchText) {
        if (product.getName().contains(searchText)) {
            return true;
        } else {
            return false;
        }
    }

    public int searchCount (String text) {
        int countSearch = 0;
        for (Product product : repo.getProduct()) {
            if (conformity(product, text)) {
                countSearch++;
            }
        }
        return countSearch;
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[searchCount(text)];
        int copyToIndex = 0;
        for (Product product : repo.getProduct()) {
           if (conformity(product,text)) {
             result[copyToIndex] = product;
             copyToIndex++;
           }
        }
        return result;
    }

    public Product[] getAllProduct() {
        return repo.getProduct();
    }
}
