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
public class DurationAddRequest {
    private Long amountOfTime;
    private String unit;
    private Recipe recipe;
}
