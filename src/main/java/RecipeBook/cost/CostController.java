package RecipeBook.cost;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cost")
@RequiredArgsConstructor
public class CostController {
    private final CostService costService;

    @PostMapping("/add")
    public Cost addCost(@RequestBody CostRequest request) {
        return costService.addCost(request);
    }

    @DeleteMapping("/delete")
    public String deleteCost(@RequestBody Cost cost) {
        costService.deleteCost(cost.getId());
        return "Deleted successfully";
    }

    @PutMapping("/modify")
    public Cost modifyCost(@RequestBody Cost cost) {
        return costService.modifyCost(cost);
    }

}
