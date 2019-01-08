package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexPageController {

    int i;

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
        if (visitors.isEmpty()){
            i=0;
        }

       model.put("visitors", visitors);
       model.put("date", localDate);

        return "index";
    }

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    public String addVisitor(String firstName, String lastName, String company, String address, String cardNumber, Map<String, Object> model) {

        Visitors visitor = new Visitors();
        visitor.setFirstName(firstName);
        visitor.setLastName(lastName);
        visitor.setCompany(company);
        visitor.setAddress(address);
        visitor.setCardNumber(cardNumber);

        repository.addVisitors(visitor);
        LocalDate localDate = LocalDate.now();
        List<Visitors> visitors = repository.selectVisitors(localDate.toString());


       model.put("visitors", visitors);
        model.put("date", localDate);

        return "index";
    }



    @RequestMapping(value = "/selectByDate", method = RequestMethod.POST)
    public String selectByDate(String selectedDate, Map<String, Object> model) {


        System.out.println("working!");
        List<Visitors> visitors = repository.selectVisitors(selectedDate);

        LocalDate localDate = LocalDate.of(2019, 01, 07);

        model.put("visitors", visitors);
        model.put("date", localDate);

        return "index";
    }

    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    public String selectById(String id, Map<String, Object> model) {


        System.out.println("working!");

        LocalDateTime localDateTime = LocalDateTime.now();

        repository.addVisitorsOutTime(localDateTime, id);
        LocalDate localDate = LocalDate.now();

        List<Visitors> visitors = repository.selectVisitors(localDate.toString());

        model.put("visitors", visitors);
        model.put("date", localDate);

        return "index";
    }
}
