package RecipeBook.recipe;

import RecipeBook.appuser.AppUser;
import RecipeBook.appuser.AppUserService;
import RecipeBook.cost.Cost;
import RecipeBook.cost.CostService;
import RecipeBook.duration.Duration;
import RecipeBook.duration.DurationRepository;
import RecipeBook.duration.DurationRequest;
import RecipeBook.duration.DurationService;
import RecipeBook.ingredient.Ingredient;
import RecipeBook.ingredient.IngredientService;
import RecipeBook.quantity.Quantity;
import RecipeBook.quantity.QuantityService;
import RecipeBook.step.Step;
import RecipeBook.step.StepService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final AppUserService appUserService;
    private final DurationService durationService;
    private final DurationRepository durationRepository;
    private final StepService stepService;
    private final IngredientService ingredientService;
    private final QuantityService quantityService;
    private final CostService costService;

    public Recipe addRecipe(RecipeRequest request) {

        AppUser appUser = appUserService.getCurrentUser();

        Recipe newRecipe = new Recipe(
                appUser,
                request.getName(),
                request.getDescription());

        return recipeRepository.save(newRecipe);
    }

    public Recipe changeName(RecipeNameRequest request) {
        Recipe recipeDB = recipeRepository.findRecipeById(request.getRecipeId());

        if (recipeDB == null)
            throw new RecipeNotFoundException(request.getRecipeId());

        if (Objects.nonNull(request.getNewName()) && !"".equalsIgnoreCase(request.getNewName()))
            recipeDB.setName(request.getNewName());

        return recipeRepository.save(recipeDB);
    }

    public void deleteRecipeById(RecipeDeleteRequest request) {
        boolean isFound = recipeRepository.existsById(request.getId());

        if (isFound)
            recipeRepository.deleteById(request.getId());
        else
            throw new RecipeNotFoundException(request.getId());
    }

    public List<Recipe> getRecipeByUser() {
        AppUser currentUser = appUserService.getCurrentUser();
        return recipeRepository.findAllByAppUser(currentUser);
    }

    public String getRecipeDetails(Recipe recipe) {
        Step step = stepService.getStep(recipe);
        List<Ingredient> ingredients = ingredientService.getIngredients(recipe);

//        Duration duration;
//        try {
//            duration = durationService.findDurationByRecipe(recipe);
//        } catch (NotFoundException e) {
//            duration = new Duration();
//            duration.setAmountOfTime(0L);
//        }

        List<Quantity> quantities = new ArrayList<Quantity>();
        for (Ingredient ingredient : ingredients) {
            Quantity quantity = quantityService.getQuantity(ingredient);
            if (quantity == null) {
                quantity = new Quantity();
                quantity.setQuantityValue(0);
            }
            quantities.add(quantity);
        }

        List<Cost> costs = new ArrayList<Cost>();
        for (Ingredient ingredient : ingredients) {
            Cost cost = costService.getCost(ingredient);
            if (cost == null) {
                cost = new Cost();
                cost.setCostValue(BigDecimal.valueOf(0));
            }
            costs.add(cost);
        }


        if (step == null) {
            step = new Step();
            step.setSteps("");
        }
        if (ingredients.isEmpty())
            ingredients = new ArrayList<Ingredient>();


        String jsonString = new JSONObject()
                .put("steps", step.getSteps())
                .put("ingredients", ingredients)
//                .put("duration", duration)
                .put("quantities", quantities)
                .put("costs", costs)
                .toString();

        return jsonString;
    }

    public String changeDuration(DurationRequest durationRequest) {
        Duration duration = durationService.findDurationByRecipe(durationRequest.getRecipe());

        duration.setAmountOfTime(durationRequest.getNewTime());

        durationRepository.save(duration);

        return "ok";
    }
}
