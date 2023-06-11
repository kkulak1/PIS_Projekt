package RecipeBook.ingredient;

public class IngredientNotFoundException extends RuntimeException {
    IngredientNotFoundException(Long id) {
        super("Could not find ingredient with id " + id);
    }
}
