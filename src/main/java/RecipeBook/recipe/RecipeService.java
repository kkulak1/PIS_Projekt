package RecipeBook.recipe;

import RecipeBook.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public Recipe addRecipe(RecipeRequest request) {
//        AppUser appUser = getUserFromJWT();
        AppUser appUser = new AppUser();

        Recipe newRecipe = new Recipe(
                appUser,
                request.getCoverImagePath(),
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

}
