package com.hanswuast.springboot.control;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {


    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultController.class);

    @RequestMapping("/")
    public String index() {
        LOGGER.info("Du und dein hanuwast");
        return "Greetings from Spring Boot!";
    }


    @RequestMapping("/scheisse")
    public String scheisse() {

        return "Greetings from Scheisse!";
    }


}