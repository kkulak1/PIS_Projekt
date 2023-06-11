package RecipeBook.ingredient;

import RecipeBook.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @SequenceGenerator(
            name = "ingredient_sequence",
            sequenceName = "ingredient_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingredient_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "recipe_id"
    )
    private Recipe recipe;

    private String type;
    private String name;
    private String description;

    public Ingredient(Recipe recipe, String type, String name, String description) {
        this.recipe = recipe;
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
