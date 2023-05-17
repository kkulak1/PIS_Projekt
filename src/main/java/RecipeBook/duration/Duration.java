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

    Long amountOfTime;
    String Unit;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "recipe_id"
    )
    private Recipe recipe;
}
