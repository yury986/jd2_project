package by.yury.web;

import by.yury.data.dao.ClientDao;
import by.yury.data.dto.CreditDto;
import by.yury.data.pojo.Client;
import by.yury.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreditController {
    @Autowired
    ClientDao clientDao;
    @Autowired
    CreditService creditService;


    @PostMapping("/credits")



    public String getDepositResult(@RequestParam("sumcredit") String sumCredit,
                                   @RequestParam("percentcredit") String percentCredit, Authentication authentication) throws NumberFormatException {

        if (sumCredit.isEmpty() || percentCredit.isEmpty()) {

            return "credit";

        } else {

            if (authentication != null) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String userName = userDetails.getUsername();
                Client client = clientDao.readClientByName(userName);
                String clientId = client.getId();

                CreditDto creditDto = new CreditDto(null, sumCredit, percentCredit);
                creditService.saveNewCredit(creditDto, clientId);

            }

            return "general";
        }
    }


        @GetMapping("/credits")

        public String getCardPage () {

            return "credit";
        }


}