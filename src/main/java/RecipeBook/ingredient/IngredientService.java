package RecipeBook.ingredient;

import RecipeBook.recipe.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public Ingredient addIngredient(IngredientRequest request) {

        Ingredient newIngredient = new Ingredient(
                request.getRecipe(),
                request.getType(),
                request.getName(),
                request.getDescription()
        );

        return ingredientRepository.save(newIngredient);
    }

    public void deleteIngredient(IngredientDeleteRequest request) {
        boolean isFound = ingredientRepository.existsById(request.getId());

        if (isFound)
            ingredientRepository.deleteById(request.getId());
        else
            throw new IngredientNotFoundException(request.getId());
    }

    public Ingredient modifyIngredient(IngredientModifyRequest request) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(request.getId());

        if (ingredient.isEmpty())
            throw new IngredientNotFoundException(request.getId());

        Ingredient ingredientDB = ingredient.get();
        ingredientDB.setName(request.getName());
        ingredientDB.setType(request.getType());
        ingredientDB.setDescription(request.getDescription());

        return ingredientRepository.save(ingredientDB);
    }

    public List<Ingredient> getIngredients(Recipe recipe) {
        return ingredientRepository.findAllByRecipe(recipe);
    }
}
