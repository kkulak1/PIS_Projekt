package RecipeBook.step;

import RecipeBook.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Step {
    @SequenceGenerator(
            name = "step_sequence",
            sequenceName = "step_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "step_sequence"
    )
    private Long id;
    private String steps;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "recipe_id"
    )
    private Recipe recipe;

    public Step(String steps, Recipe recipe) {
        this.setSteps(steps);
        this.setRecipe(recipe);
    }
}
