package RecipeBook.cost;

import RecipeBook.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
    private BigDecimal costValue;
    private String costUnit;

    public Cost(Ingredient ingredient, BigDecimal costValue, String costUnit) {
        this.ingredient = ingredient;
        this.costValue = costValue;
        this.costUnit = costUnit;
    }
}
