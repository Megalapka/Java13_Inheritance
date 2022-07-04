import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

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


    public Product[] searchBy(String text) {

        ProductRepository repoResult = new ProductRepository();

        for (Product product : repo.getProduct()) {

            if (conformity(product,text)) {
                repoResult.save(product);
            }
        }
        return repoResult.getProduct();
    }

    public Product[] getAllProduct() {
        return repo.getProduct();
    }
}
