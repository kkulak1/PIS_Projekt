package RecipeBook.step;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/step")
@RequiredArgsConstructor
public class StepController {
    private final StepService stepService;

    @PutMapping("/change-steps")
    public Step changeStep(@RequestBody StepRequest request) { return stepService.changeStep(request); }

}
