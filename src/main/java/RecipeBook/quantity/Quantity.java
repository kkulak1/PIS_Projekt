package RecipeBook.quantity;

import RecipeBook.ingredient.Ingredient;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Quantity {
    @SequenceGenerator(
            name = "quantity_sequence",
            sequenceName = "quantity_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quantity_sequence"
    )
    private Long id;

    private float quantityValue;
    private String quantityUnit;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "ingredient_id"
    )
    private Ingredient ingredient;

    public Quantity(float quantityValue, String quantityUnit, Ingredient ingredient) {
        this.quantityValue = quantityValue;
        this.quantityUnit = quantityUnit;
        this.ingredient = ingredient;
    }
}
