package by.yury.web;


import by.yury.data.dto.CardDto;
import by.yury.service.CardService;
import by.yury.service.model.AccountFromWeb;
import by.yury.service.model.CardFromWeb;
import org.springframework.beans.factory.annotation.Autowired;
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









    @PostMapping("/card")

    public ModelAndView getCardResult(@RequestParam("typecard") String typeCard,
                                      @RequestParam("cash") String cash, Model model) throws NumberFormatException{

//        SecureRandom rn = new SecureRandom();
//        String cardNumber = IntStream.range(0, 16)
//                .mapToObj(i -> String.valueOf(rn.nextInt(10)))
//                .collect(Collectors.joining());

//        SecureRandom rd = new SecureRandom();
//        String accountNumber = IntStream.range(0, 16)
//                .mapToObj(i -> String.valueOf(rd.nextInt(10)))
//                .collect(Collectors.joining());

        AccountFromWeb accountFromWeb = new AccountFromWeb(null, "USD");
        CardFromWeb cardFromWeb = new CardFromWeb(null, typeCard, cash);
//
//        if (Integer.parseInt(cash)>=0 && Integer.parseInt(cash)<=100000){
//            String accountId = accountDao.saveNewAccount(account);
//        }


       // card.setAccount(account);

        if (typeCard.equals("Visa") || typeCard.equals("Visa Gold") || typeCard.equals("Visa Platinum")
        &&(Integer.parseInt(cash)>=0 && Integer.parseInt(cash)<=100000)) {
            cardService.saveNewCard(cardFromWeb,accountFromWeb);



            model.addAttribute("cardNumber", cardDto.getCardNumb());
         //   model.addAttribute("accountNumber");

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

