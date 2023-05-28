package RecipeBook.duration;

import RecipeBook.recipe.Recipe;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DurationService {
    private final DurationRepository durationRepository;

    public Duration findDurationByRecipe(Recipe recipe) {
        return durationRepository.findByRecipe(recipe)
                .orElseThrow(() -> new NotFoundException(String.format("Duration for such recipe not found!")));
    }
}
