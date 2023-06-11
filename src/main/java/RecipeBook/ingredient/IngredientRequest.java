package RecipeBook.ingredient;

import RecipeBook.recipe.Recipe;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class IngredientRequest {
    private Recipe recipe;
    private String type;
    private String name;
    private String description;
}
