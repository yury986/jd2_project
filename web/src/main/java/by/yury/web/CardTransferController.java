package by.yury.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CardTransferController {

    @PostMapping("/cardtransfer")

    public String getPage(){
        return "cardTransfer";
    }



    @GetMapping("/cardtransfer")

    public String getSearchPage(){

        return "cardtransfer";
    }


}
