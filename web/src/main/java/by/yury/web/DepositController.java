package by.yury.web;

import by.yury.data.dao.ClientDao;
import by.yury.data.dto.CreditDto;
import by.yury.data.dto.DepositDto;
import by.yury.data.pojo.Client;
import by.yury.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DepositController {

    @Autowired
    DepositService depositService;

    @Autowired
    ClientDao clientDao;


    @PostMapping("/deposits")

    public String getDepositResult(@RequestParam("sumdeposit") String sumDeposit,
                                   @RequestParam("percentdeposit") String percentDeposit, Authentication authentication) throws NumberFormatException {

        if (sumDeposit.isEmpty() || percentDeposit.isEmpty()) {

            return "deposit";

        } else {

            if (authentication != null) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String userName = userDetails.getUsername();
                Client client = clientDao.readClientByName(userName);
                String clientId = client.getId();

                DepositDto depositDto = new DepositDto(null, sumDeposit, percentDeposit);
                depositService.saveNewDeposit(depositDto, clientId);

            }

            return "general";
        }
    }



    @GetMapping("/deposits")

    public String getCardPage(){

        return "deposit";
    }

}
