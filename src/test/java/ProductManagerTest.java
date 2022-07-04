import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "Product1", 23);
    Product product2 = new Product(2, "Product2", 56);
    Product product3 = new Product(3, "Product3", 27);
    Product product4 = new Product(4, "Product4", 34);

    Book book1 = new Book(5, "Book1", 44, "Author1");
    Book book2 = new Book(6, "Book2", 44, "Author1");
    Book book3 = new Book(7, "Book3", 44, "Author2");

    Smartphone smartphone1 = new Smartphone(8, "smartphone1", 56, "manuf1");
    Smartphone smartphone2 = new Smartphone(8, "smartphone2", 18, "manuf2");
    Smartphone smartphone3 = new Smartphone(8, "smartphone3", 47, "manuf2");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void shouldGetAllProduct() {
        Product[] expected = {product1, product2, product3, product4, book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Product[] actual = manager.getAllProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName() {

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = manager.searchBy("Product");
        assertArrayEquals(expected, actual);
    }
}
