package RecipeBook.cost;

public class CostNotFoundException extends RuntimeException {
    CostNotFoundException(Long id) {
        super("Could not find cost with id " + id);
    }
}
