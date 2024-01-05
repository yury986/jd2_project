package by.yury.web;

import by.yury.data.dao.CardDao;
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
    CardDao cardDao;

    @PostMapping("/card")

    public ModelAndView getCardResult(@RequestParam("typecard") String typeCard, Model model) {

        SecureRandom random = new SecureRandom();
        String cardNumber = IntStream.range(0, 16)
                .mapToObj(i -> String.valueOf(random.nextInt(10)))
                .collect(Collectors.joining());
// TODO: 01.01.2024
        Card card = new Card(null, typeCard, cardNumber,"0");

        if (typeCard.equals("Visa") || typeCard.equals("Visa Gold") || typeCard.equals("Visa Platinum")) {
            cardDao.saveNewCard(card);

            model.addAttribute("cardNumber",cardNumber);

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

