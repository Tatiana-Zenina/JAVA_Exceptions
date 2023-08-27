import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product item1 = new Product(40, "морковь", 90);
        Product item2 = new Product(108, "рюкзак", 3_000);
        Product item3 = new Product(456, "видеокарта", 250_000);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(40);

        Product[] actual = repo.findAll();
        Product[] expected = {item2, item3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product item1 = new Product(40, "морковь", 90);
        Product item2 = new Product(108, "рюкзак", 3000);
        Product item3 = new Product(456, "видеокарта", 250_000);

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(56)
        );
    }

}