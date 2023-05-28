package RecipeBook.recipe;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RecipeNameRequest {
    private Long recipeId;
    private String newName;
}
