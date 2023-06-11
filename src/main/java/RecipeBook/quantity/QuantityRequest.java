package RecipeBook.quantity;

import RecipeBook.ingredient.Ingredient;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class QuantityRequest {
    private float value;
    private String unit;
    private Ingredient ingredient;
}
