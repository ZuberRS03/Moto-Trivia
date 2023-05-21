package projekt.java101.mototrivia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstEndpoint {

    @GetMapping("/user")
    public String getUser() {
        return "Roman";
    }
}
