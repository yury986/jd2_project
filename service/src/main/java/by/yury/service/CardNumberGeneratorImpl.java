package by.yury.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CardNumberGeneratorImpl implements CardNumberGenerator {


    public String generator(){

        SecureRandom rn = new SecureRandom();
         String cardNumber = IntStream.range(0, 16)
                .mapToObj(i -> String.valueOf(rn.nextInt(10)))
                .collect(Collectors.joining());

        return cardNumber;
    }

}
