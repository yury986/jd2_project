package by.yury.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AccountNumberGeneratorImpl implements AccountNumberGenerator{

    public String generator(){

        SecureRandom rd = new SecureRandom();
        String accountNumber = IntStream.range(0, 16)
                .mapToObj(i -> String.valueOf(rd.nextInt(10)))
                .collect(Collectors.joining());

        return accountNumber;

    }
}
