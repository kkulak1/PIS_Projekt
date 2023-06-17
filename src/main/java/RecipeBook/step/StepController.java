package RecipeBook.step;

import RecipeBook.recipe.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/step")
@RequiredArgsConstructor
public class StepController {
    private final StepService stepService;

    @PutMapping("/change-steps")
    public Step changeStep(@RequestBody StepRequest request) { return stepService.changeStep(request); }

    @GetMapping("/get")
    public Step getStep(@RequestBody Recipe recipe) {
        return stepService.getStep(recipe);
    }
}
