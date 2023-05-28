package RecipeBook.recipe;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;


    public Recipe changeName(RecipeNameRequest request) {
        Recipe recipeDB = recipeRepository.findRecipeById(request.getRecipeId());

        if (recipeDB == null)
            throw new RecipeNotFoundException(request.getRecipeId());

        if (Objects.nonNull(request.getNewName()) && !"".equalsIgnoreCase(request.getNewName()))
            recipeDB.setName(request.getNewName());

        return recipeRepository.save(recipeDB);
    }

}
