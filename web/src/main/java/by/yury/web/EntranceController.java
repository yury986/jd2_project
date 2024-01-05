package by.yury.web;

import by.yury.data.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;


@Controller
public class EntranceController {

    @Autowired
    ClientDao clientDao;

    @PostMapping("/entrance")

    public String getEntranceResult(

            @RequestParam("username") String userNameReq1,
            @RequestParam("password") String passwordReq1) throws SQLException, ClassNotFoundException{

        List<String> usersNames = clientDao.readName();
        List<String> usersPasswords = clientDao.readPassword();

        for (String name : usersNames) {
            if (name.equals(userNameReq1)){
                for (String passwords : usersPasswords){
                    if (passwords.equals(passwordReq1)){
                        return "general";
                    }
                }

            }
        }
        return "register_1";
    }

    @GetMapping("/entrance")

    public String getEntrancePage(){

        return "entrance";
    }
}
