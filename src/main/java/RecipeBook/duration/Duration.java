package RecipeBook.duration;

import RecipeBook.recipe.Recipe;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Duration {
    @SequenceGenerator(
            name = "duration_sequence",
            sequenceName = "duration_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "duration_sequence"
    )
    private Long id;

    private Long amountOfTime;
    private String unit;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "recipe_id"
    )
    private Recipe recipe;

    public Duration(Long amountOfTime, String unit, Recipe recipe) {
        this.amountOfTime = amountOfTime;
        this.unit = unit;
        this.recipe = recipe;
    }
}
