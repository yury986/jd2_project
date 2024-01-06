package by.yury.web;

import by.yury.data.dao.AccountDao;
import by.yury.data.dao.CardDao;
import by.yury.data.pojo.Account;
import by.yury.data.pojo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class CardController {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CardDao cardDao;

    @PostMapping("/card")

    public ModelAndView getCardResult(@RequestParam("typecard") String typeCard,
                                      @RequestParam("cash") String cash, Model model) throws NumberFormatException{

        SecureRandom rn = new SecureRandom();
        String cardNumber = IntStream.range(0, 16)
                .mapToObj(i -> String.valueOf(rn.nextInt(10)))
                .collect(Collectors.joining());

        SecureRandom rd = new SecureRandom();
        String accountNumber = IntStream.range(0, 16)
                .mapToObj(i -> String.valueOf(rd.nextInt(10)))
                .collect(Collectors.joining());

        Account account = new Account(null, accountNumber,"USD");

        if (Integer.parseInt(cash)>=0 && Integer.parseInt(cash)<=100000){
            String accountId = accountDao.saveNewAccount(account);
        }

        Card card = new Card(null, typeCard, cardNumber,cash);
        card.setAccount(account);

        if (typeCard.equals("Visa") || typeCard.equals("Visa Gold") || typeCard.equals("Visa Platinum")
        &&(Integer.parseInt(cash)>=0 && Integer.parseInt(cash)<=100000)) {
            String cardId = cardDao.saveNewCard(card);



            model.addAttribute("cardNumber",cardNumber);
            model.addAttribute("accountNumber", accountNumber);

            return new ModelAndView("cardnumber");
        } else {
            return new ModelAndView("card");
        }


    }

   /* public String getCardResult(@RequestParam("typecard") String typeCard) throws SQLException, ClassNotFoundException{


        Card card = new Card(null, typeCard);

        if (typeCard.equals("Visa")||typeCard.equals("Visa Gold")||typeCard.equals("Visa Platinum")){
            String cardNumber = cardDao.saveNewCard(card);

            return "cardnumber";
        }else{
            return "card";
        }*/




    @GetMapping("/card")

    public String getCardPage(){

        return "card";
    }




}

