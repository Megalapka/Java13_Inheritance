package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotFoundException;

public class ProductRepositoryTest {

    Product product1 = new Product(1, "Product1", 23);
    Product product2 = new Product(2, "Product2", 56);
    Product product3 = new Product(3, "Product3", 27);
    Product product4 = new Product(4, "Product4", 34);

    Book book1 = new Book(5, "Book1", 44, "Author1");
    Book book2 = new Book(6, "Book2", 44, "Author1");
    Book book3 = new Book(7, "Book3", 44, "Author2");

    Smartphone smartphone1 = new Smartphone(8, "smartphone1", 56, "manuf1");
    Smartphone smartphone2 = new Smartphone(9, "smartphone2", 18, "manuf2");
    Smartphone smartphone3 = new Smartphone(10, "smartphone3", 47, "manuf2");


    @Test
    public void shouldSaveProduct() {
        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveBook() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);

    }


    @Test
    public void shouldSaveSmartphone() {
        ProductRepository repo = new ProductRepository();

        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldExceptionWithRemoveById() {
        ProductRepository repo = new ProductRepository();

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });

    }

    @Test
    public void shouldExceptionWithSaveSmartphone() {
        ProductRepository repo = new ProductRepository();

        repo.save(smartphone1);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(smartphone1);
        });


    }
}
