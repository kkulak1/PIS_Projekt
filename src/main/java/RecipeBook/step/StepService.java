package RecipeBook.step;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class StepService {

    private final StepRepository stepRepository;

    public Step changeStep(StepRequest request) {

        Step step = stepRepository.findStepByRecipe(request.getRecipe());
        if (step == null) {
            Step newStep = new Step(request.getSteps(), request.getRecipe());
            return stepRepository.save(newStep);
        }

        if (Objects.nonNull(request.getSteps()) && !"".equalsIgnoreCase(request.getSteps()))
            step.setSteps(request.getSteps());

        return stepRepository.save(step);
    }

}
