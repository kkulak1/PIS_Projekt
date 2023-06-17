package RecipeBook.ingredient;

import RecipeBook.recipe.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/ingredient")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping("/add")
    public Ingredient addIngredient(@RequestBody IngredientRequest request) {
        return ingredientService.addIngredient(request);
    }

    @DeleteMapping("/delete")
    public String deleteIngredient(@RequestBody IngredientDeleteRequest request) {
        ingredientService.deleteIngredient(request);
        return "Deleted successfully";
    }

    @PutMapping("/modify")
    public Ingredient modifyIngredient(@RequestBody IngredientModifyRequest request) {
        return ingredientService.modifyIngredient(request);
    }

    @GetMapping("/get")
    public List<Ingredient> getIngredients(@RequestBody Recipe recipe) {
        return ingredientService.getIngredients(recipe);
    }

}
