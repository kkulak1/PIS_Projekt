package RecipeBook.quantity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/quantity")
@RequiredArgsConstructor
public class QuantityController {
    private final QuantityService quantityService;

    @PostMapping("/add")
    public Quantity addQuantity(@RequestBody QuantityRequest request) {
        return quantityService.addQuantity(request);
    }

    @DeleteMapping("/delete")
    public String deleteQuantity(@RequestBody Quantity quantity) {
        quantityService.deleteQuantity(quantity.getId());
        return "Deleted successfully";
    }

    @PutMapping("/modify")
    public Quantity modifyQuantity(@RequestBody Quantity quantity) {
        return quantityService.modifyQuantity(quantity);
    }

}
