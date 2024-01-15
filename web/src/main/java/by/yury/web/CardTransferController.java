package by.yury.web;

import by.yury.data.dao.CardDao;
import by.yury.data.pojo.Card;
import by.yury.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CardTransferController {

    @Autowired
    CardDao cardDao;

    @Autowired
    CardService cardService;

    @PostMapping("/cardtransfer")

    public String getPage(@RequestParam("cardsender") String cardSend,
                          @RequestParam("cardrecipient") String cardRep,
                          @RequestParam("sumtransfer")String sumTrans, Model model, Authentication authentication){

    if (cardSend.isEmpty()||cardRep.isEmpty()||sumTrans.isEmpty()){
        return "cardTransfer";
    }

    Card cardSender = cardDao.readCardByNumber(cardSend);
    if (Integer.parseInt(cardSender.getCash()) >= Integer.parseInt(sumTrans)){
        String cardSenderId = cardSender.getId();
        cardService.cardMathSender(cardSenderId, sumTrans);
    }else{
        return "cardTransfer";
    }
    Card cardRecipient = cardDao.readCardByNumber(cardRep);
    String cardRecipientId = cardRecipient.getId();
    cardService.cardMathRecipient(cardRecipientId, sumTrans);

        return "general";
    }



    @GetMapping("/cardtransfer")

    public String getSearchPage(){

        return "cardtransfer";
    }
}
