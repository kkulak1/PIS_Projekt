package RecipeBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class PisProjektApplication {
	public static void main(String[] args) {
		SpringApplication.run(PisProjektApplication.class, args);
	}

	@GetMapping("/")
	public String firstTest() {
		return "First test";
	}

	@GetMapping("/test-json")
	public Map<String, String> jsonTest() {
		HashMap<String, String> map = new HashMap<>();
		map.put("key", "value");
		map.put("foo", "bar");
		map.put("aa", "bb");
		return map;
	}
}