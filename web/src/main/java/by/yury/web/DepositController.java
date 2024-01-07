package by.yury.web;

import by.yury.data.dto.DepositDto;
import by.yury.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DepositController {

    @Autowired
    DepositService depositService;

    @PostMapping("/deposits")

    public String getDepositResult(@RequestParam("sumdeposit") String sumDeposit,
                                      @RequestParam("percentdeposit") String percentDeposit) throws NumberFormatException{

        if (sumDeposit.isEmpty() ||  percentDeposit.isEmpty()) {

            return "deposit";

        } else {
            DepositDto depositDto = new DepositDto(null, sumDeposit, percentDeposit);
            depositService.saveNewDeposit(depositDto);
            return "general";
        }

}

    @GetMapping("/deposits")

    public String getCardPage(){

        return "deposit";
    }

}
