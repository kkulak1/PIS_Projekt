package RecipeBook.cost;

import RecipeBook.ingredient.Ingredient;
import jakarta.persistence.*;

public class Cost {
    @SequenceGenerator(
            name = "cost_sequence",
            sequenceName = "cost_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cost_sequence"
    )
    private Long id;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "ingredient_id"
    )
    private Ingredient ingredient;

    private Long costvalue;
    private String costUnit;
}
