package RecipeBook.ingredient;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class IngredientModifyRequest {
    private Long id;
    private String type;
    private String name;
    private String description;
}
