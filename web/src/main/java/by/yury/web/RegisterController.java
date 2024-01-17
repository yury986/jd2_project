package by.yury.web;

import by.yury.data.dao.ClientDao;
import by.yury.data.dao.PersonDao;
import by.yury.data.pojo.Client;
import by.yury.data.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    ClientDao clientDao;
    @Autowired
    PersonDao personDao;



    @PostMapping("/register_1")


    public String getRegResult(
            @RequestParam("first_name") String firstNameReq,
            @RequestParam("last_name") String lastNameReq,
            @RequestParam("username") String usernameReq,
            @RequestParam("password") String passwordReq,
            @RequestParam("address") String addressReq,
            @RequestParam("passport") String passportReq,
            @RequestParam("contact") String contactReq) throws SQLException, ClassNotFoundException {


        if (firstNameReq.isEmpty() || lastNameReq.isEmpty() || usernameReq.isEmpty() ||
                passwordReq.isEmpty() || addressReq.isEmpty() || passportReq.isEmpty() || contactReq.isEmpty()) {

            return "register_1";
        }


        List<String> usersNames = clientDao.readName();
        for (String name : usersNames) {
            if (name.equals(usernameReq)) {
                return"register_1";
            }else{
                Client userWeb = new Client (null,usernameReq,passwordReq,"ROLE_USER");
                String savedClientId = clientDao.saveNewClient(userWeb);
            }
        }

        List<String> passports = personDao.readPassport();
         for (String passport : passports ) {
             if (passport.equals(passportReq)) {
                 return "register_1";
             }else{
                 Person person = new Person(null, firstNameReq, lastNameReq, addressReq, passportReq, contactReq);
                 String savedPersonId = personDao.saveNewPerson(person);

             }
         }
        return null;
    }

    @GetMapping("/register_1")

    public String getSearchPage(){

        return "register_1";
    }
}

