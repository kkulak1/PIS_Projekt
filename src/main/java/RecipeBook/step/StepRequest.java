package RecipeBook.step;

import RecipeBook.recipe.Recipe;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class StepRequest {
    private Recipe recipe;
    private String steps;
}
