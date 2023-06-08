package RecipeBook.recipe;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RecipeRequest {
    private String name;
    private String description;
}
