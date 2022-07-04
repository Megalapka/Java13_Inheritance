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


//   With List:
    public Product[] searchBy(String text) {

        List<Product> list = new ArrayList<Product>();

        for (Product product : repo.getProduct()) {
           if (conformity(product,text)) {
               list.add(product);
           }
        }
        Product[] result = new Product[list.size()];
        result = list.toArray(result);
        return result;
    }




    public Product[] getAllProduct() {
        return repo.getProduct();
    }
}
