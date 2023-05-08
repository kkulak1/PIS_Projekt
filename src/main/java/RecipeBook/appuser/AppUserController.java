package RecipeBook.appuser;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(name = "backend", contextId = "AppUserController")
public interface AppUserController {

    @PostMapping("testing")
    public static String testing() {
        return "worked";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(String firstName) {
//
//        return "token" + firstName;
//    }
}
