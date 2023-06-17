package RecipeBook.cost;

import RecipeBook.ingredient.Ingredient;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CostRequest {
    private Ingredient ingredient;
    private BigDecimal value;
    private String unit;
}
