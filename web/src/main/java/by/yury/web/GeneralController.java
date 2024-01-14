package by.yury.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GeneralController {

    @PostMapping("/general")

    public String getPage(){

        return "general";
    }


    @GetMapping("/general")

    public String getSearchPage(){

        return "general";
    }

}

