package RecipeBook.recipe;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody RecipeRequest request) {
        return recipeService.addRecipe(request);
    }

    @PostMapping("/change-name")
    public Recipe changeName(@RequestBody RecipeNameRequest request) {
        return recipeService.changeName(request);
    }

    @DeleteMapping("/delete")
    public String deleteRecipeById(@RequestBody RecipeDeleteRequest request) {
        recipeService.deleteRecipeById(request);
        return "Deleted successfully";
    }
}
