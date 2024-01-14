package by.yury.web;

import by.yury.data.dao.ClientDao;
import by.yury.data.dto.CardDto;
import by.yury.data.pojo.Client;
import by.yury.service.CardService;
import by.yury.service.model.AccountFromWeb;
import by.yury.service.model.CardFromWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    CardDto cardDto;

    @Autowired
    ClientDao clientDao;

    @PostMapping("/card")

    public ModelAndView getCardResult(@RequestParam("typecard") String typeCard,
                                      @RequestParam("cash") String cash, Model model, Authentication authentication) throws NumberFormatException{

        String clientId = null;

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String userName = userDetails.getUsername();
            Client client = clientDao.readClientByName(userName);
             clientId = client.getId();
        }

        AccountFromWeb accountFromWeb = new AccountFromWeb(null, "USD");
        CardFromWeb cardFromWeb = new CardFromWeb(null, typeCard, cash);



        if (typeCard.equals("Visa") || typeCard.equals("Visa Gold") || typeCard.equals("Visa Platinum")
        &&(Integer.parseInt(cash)>=0 && Integer.parseInt(cash)<=100000)) {
            cardService.saveNewCard(cardFromWeb,accountFromWeb,clientId);



            model.addAttribute("cardNumber", cardService.getCardNumb());
         //   model.addAttribute("accountNumber");

            return new ModelAndView("cardnumber");
        } else {
            return new ModelAndView("card");
        }

    }


    @GetMapping("/card")

    public String getCardPage(){

        return "card";
    }

}

