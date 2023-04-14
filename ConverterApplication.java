import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
public class ConverterApplication {

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("from") double from, @RequestParam("to") String to, Model model) {
        String url = "http://localhost:8080/convert/" + to + "?from=" + from;
        ConversionResult result = restTemplate.getForObject(url, ConversionResult.class);
        model.addAttribute("result", result);
        return "result";
    }

    public static void main(String[] args) {
        SpringApplication.run(ConverterApplication.class, args);
    }
}
