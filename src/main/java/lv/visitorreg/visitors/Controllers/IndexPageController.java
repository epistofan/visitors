package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexPageController {


    @Autowired
    Repository repository;

    @GetMapping("/")
    public String index(Map<String, Object> model) {


        LocalDate localDate = LocalDate.now();

        System.out.println("hello");
        System.out.println(localDate.toString());

        //Timestamp timestamp = Timestamp.valueOf(localDate);
       // List<Visitors> visitors = repository.selectPerson();
        List<Visitors> visitors = repository.selectVisitors(localDate.toString());

       model.put("visitors", visitors);
       model.put("date", localDate);

        return "index";
    }

    @PostMapping("main")
    public String main(String firstName, String lastName, String company, String address, String date, Map<String, Object> model) {

        List<Visitors> visitors = repository.selectVisitors(date);

       model.put("person", visitors);
        model.put("date", date);

        return "index";
    }
}
