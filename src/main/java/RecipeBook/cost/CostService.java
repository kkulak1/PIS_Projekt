package RecipeBook.cost;

import RecipeBook.ingredient.Ingredient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CostService {
    private final CostRepository costRepository;

    public Cost addCost(CostRequest request) {
        Cost cost = new Cost(
                request.getIngredient(),
                request.getValue(),
                request.getUnit()
        );

        return costRepository.save(cost);
    }

    public void deleteCost(Long costId) {
        boolean isFound = costRepository.existsById(costId);

        if (isFound)
            costRepository.deleteById(costId);
        else
            throw new CostNotFoundException(costId);
    }

    public Cost modifyCost(Cost cost) {
        Optional<Cost> costDB = costRepository.findById(cost.getId());

        if (costDB.isEmpty())
            throw new CostNotFoundException(cost.getId());

        Cost updatedCost = costDB.get();
        updatedCost.setCostUnit(cost.getCostUnit());
        updatedCost.setCostValue(cost.getCostValue());

        return costRepository.save(updatedCost);
    }

    public Cost getCost(Ingredient ingredient) {
        return costRepository.getCostByIngredient(ingredient);
    }
}
