package RecipeBook.duration;

import RecipeBook.recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DurationRequest {
    private Recipe recipe;
    private Long newTime;
}
