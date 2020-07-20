package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private final Product product1 = new Product(1, "product1", 1);
    private final Book book1 = new Book(2, "book1", 1, "author1", 100, 1994);
    private final TShirt tShirt1 = new TShirt(3, "t-shirt1", 1, "color1", "size1");


    @BeforeEach
    void setUp() {
        repository.save(product1);
        repository.save(book1);
        repository.save(tShirt1);
    }

    @Test
    public void shouldRemoveByIdIfElemExists() {
        repository.removeById(2);

        Product[] expected = {product1, tShirt1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveByIdIfElemNotExists() {
        assertThrows(NotFoundException.class, () -> repository.removeById(-1));
    }
}
