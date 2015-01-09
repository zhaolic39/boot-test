package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class DemoApplication {
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
      return "Hello world!";
    }
    
    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setShowBanner(true);
        app.run(args);
    }
}
