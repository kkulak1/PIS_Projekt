package RecipeBook.quantity;

import RecipeBook.ingredient.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    Quantity findQuantityByIngredient(Ingredient ingredient);

}
