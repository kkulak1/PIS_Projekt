package RecipeBook.quantity;

public class QuantityNotFoundException extends RuntimeException {
    QuantityNotFoundException(Long id) {
        super("Could not find quantity with id " + id);
    }
}
