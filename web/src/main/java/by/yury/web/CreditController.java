package by.yury.web;

import by.yury.data.dto.CreditDto;
import by.yury.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreditController {

    @Autowired
    CreditService creditService;

    @PostMapping("/credits")

    public String getDepositResult(@RequestParam("sumcredit") String sumCredit,
                                   @RequestParam("percentcredit") String percentCredit) throws NumberFormatException{

        if (sumCredit.isEmpty() ||  percentCredit.isEmpty()) {

            return "credit";

        } else {
            CreditDto creditDto = new CreditDto(null, sumCredit, percentCredit);
            creditService.saveNewCredit(creditDto);
            return "general";
        }

    }

    @GetMapping("/credits")

    public String getCardPage(){

        return "credit";
    }

}