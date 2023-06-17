package RecipeBook.recipe;

import RecipeBook.duration.DurationRequest;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/get")
    public List<Recipe> getRecipeByUser() {
        return recipeService.getRecipeByUser();
    }

    @GetMapping("/get-details")
    public String getRecipeDetails(@RequestBody Recipe recipe) {
        return recipeService.getRecipeDetails(recipe);
    }


    @PutMapping("/change-duration")
    public ResponseEntity<String> changeDuration(@RequestBody DurationRequest durationRequest){
        return ResponseEntity.ok(recipeService.changeDuration(durationRequest));
    }
}

