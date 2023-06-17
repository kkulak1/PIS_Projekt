package RecipeBook.quantity;

import RecipeBook.ingredient.Ingredient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QuantityService {
    private final QuantityRepository quantityRepository;

    public Quantity addQuantity(QuantityRequest request) {
        Quantity quantity = new Quantity(
                request.getValue(),
                request.getUnit(),
                request.getIngredient()
        );

        return quantityRepository.save(quantity);
    }

    public void deleteQuantity(Long  quantityId) {
        boolean isFound = quantityRepository.existsById(quantityId);

        if (isFound)
            quantityRepository.deleteById(quantityId);
        else
            throw new QuantityNotFoundException(quantityId);
    }

    public Quantity modifyQuantity(Quantity quantity) {
        Optional<Quantity> quantityDB = quantityRepository.findById(quantity.getId());

        if (quantityDB.isEmpty())
            throw new QuantityNotFoundException(quantity.getId());

        Quantity updatedQuantity = quantityDB.get();
        updatedQuantity.setQuantityValue(quantity.getQuantityValue());
        updatedQuantity.setQuantityUnit(quantity.getQuantityUnit());

        return quantityRepository.save(updatedQuantity);
    }

    public Quantity getQuantity(Ingredient ingredient) {
        return quantityRepository.findQuantityByIngredient(ingredient);
    }
}
