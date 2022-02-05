package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private Product first = new Book(1, "Воскресение", "Толстой", 350);
    private Product two = new Book(2, "мастер и Маргарита", "Булгаков", 500);
    private Product three = new Smartphone(3, "Galaxy", "Samsung", 43500);
    private Product four = new Smartphone(4, "Iphone 13", "Apple", 70000);
    private ProductManager manager = new ProductManager(new ProductRepository());

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }

    @Test
    void shouldSearchByNameBook() {

        Product[] actual = manager.searchBy("Воскресение");
        Product[] ex = {new Book(1, "Воскресение", "Толстой", 350)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByAuthorBook() {

        Product[] actual = manager.searchBy("Булгаков");
        Product[] ex = {new Book(2, "мастер и Маргарита", "Булгаков", 500)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {

        Product[] actual = manager.searchBy("Iphone 13");
        Product[] ex = {new Smartphone(4, "Iphone 13", "Apple", 70000)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByCompanySmartphone() {

        Product[] actual = manager.searchBy("Samsung");
        Product[] ex = {new Smartphone(3, "Galaxy", "Samsung", 43500)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByCompanySmartphoneWithoutBook() {

        Product[] actual = manager.searchBy("Apple");
        Product[] ex = {new Smartphone(4, "Iphone 13", "Apple", 70000)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByAuthorBookWithoutSmartphone() {

        Product[] actual = manager.searchBy("Толстой");
        Product[] ex = {new Book(1, "Воскресение", "Толстой", 350)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByCompanyNull() {

        Product[] actual = manager.searchBy("Nokia");
        Product[] ex = {};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByCompanyForTwoSmartphone() {
        manager.add(first);

        Product[] actual = manager.searchBy("Воскресение");
        Product[] ex = {new Book(1, "Воскресение", "Толстой", 350),
                new Book(1, "Воскресение", "Толстой", 350)};

        assertArrayEquals(ex, actual);
    }
}