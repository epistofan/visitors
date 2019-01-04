package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexPageController {


    @Autowired
    Repository repository;

    @GetMapping("index")
    public String index(Map<String, Object> model) {

        Date date = new Date();
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        //Timestamp timestamp = Timestamp.valueOf(localDate);
       // List<Visitors> visitors = repository.selectPerson();

       // model.put("visitors", visitors);
        model.put("date", date);

        return "index";
    }

    @PostMapping("index")
    public String main(String date, Map<String, Object> model) {

        //List<Visitors> visitors = repository.selectPerson();

       // model.put("person", visitors);
        model.put("date", date);

        return "index";
    }
}
