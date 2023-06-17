package RecipeBook.cost;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CostNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String costNotFoundHandler(CostNotFoundException exception) {
        return exception.getMessage();
    }
}
