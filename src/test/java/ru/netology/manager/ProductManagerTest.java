package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class ProductManagerTest {

    @Test
    void shouldSearchByNameBook() {
        Product first = new Book(1, "Воскресение", "Толстой", 350);
        Product two = new Book(2, "мастер и Маргарита", "Булгаков", 500);
        Product three = new Smartphone(3, "Galaxy", "Samsung", 43500);
        Product four = new Smartphone(4, "Iphone 13", "Apple", 70000);
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(first);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Воскресение");
        Product[] ex = {new Book(1, "Воскресение", "Толстой", 350)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByAuthorBook() {
        Product first = new Book(1, "Воскресение", "Толстой", 350);
        Product two = new Book(2, "мастер и Маргарита", "Булгаков", 500);
        Product three = new Smartphone(3, "Galaxy", "Samsung", 43500);
        Product four = new Smartphone(4, "Iphone 13", "Apple", 70000);
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(first);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Булгаков");
        Product[] ex = {new Book(2, "мастер и Маргарита", "Булгаков", 500)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        Product first = new Book(1, "Воскресение", "Толстой", 350);
        Product two = new Book(2, "мастер и Маргарита", "Булгаков", 500);
        Product three = new Smartphone(3, "Galaxy", "Samsung", 43500);
        Product four = new Smartphone(4, "Iphone 13", "Apple", 70000);
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(first);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Iphone 13");
        Product[] ex = {new Smartphone(4, "Iphone 13", "Apple", 70000)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByCompanySmartphone() {
        Product first = new Book(1, "Воскресение", "Толстой", 350);
        Product two = new Book(2, "мастер и Маргарита", "Булгаков", 500);
        Product three = new Smartphone(3, "Galaxy", "Samsung", 43500);
        Product four = new Smartphone(4, "Iphone 13", "Apple", 70000);
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(first);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Samsung");
        Product[] ex = {new Smartphone(3, "Galaxy", "Samsung", 43500)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByCompanySmartphoneWithoutBook() {
        Product three = new Smartphone(3, "Galaxy", "Samsung", 43500);
        Product four = new Smartphone(4, "Iphone 13", "Apple", 70000);
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(three);
        manager.add(four);
        Product[] actual = manager.searchBy("Apple");
        Product[] ex = {new Smartphone(4, "Iphone 13", "Apple", 70000)};

        assertArrayEquals(ex, actual);
    }

    @Test
    void shouldSearchByAuthorBookWithoutSmartphone() {
        Product first = new Book(1, "Воскресение", "Толстой", 350);
        Product two = new Book(2, "мастер и Маргарита", "Булгаков", 500);
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(first);
        manager.add(two);
        Product[] actual = manager.searchBy("Толстой");
        Product[] ex = {new Book(1, "Воскресение", "Толстой", 350)};

        assertArrayEquals(ex, actual);
    }
}