package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import lv.visitorreg.visitors.Domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexPageController {

    int i;

    int orderNumberCounter = 1;

    @Autowired
    Repository repository;

    @GetMapping("/")
    public String index(Map<String, Object> model) {


        LocalDate localDate = LocalDate.now();

        System.out.println("hello");
        System.out.println(localDate.toString());

        //Timestamp timestamp = Timestamp.valueOf(localDate);
       // List<Visitor> visitors = repository.selectPerson();
        List<Visitor> visitors = repository.selectVisitors(localDate.toString());
        if (visitors.isEmpty()){
            i=0;
        }
        String response = null;
       model.put("visitors", visitors);
       model.put("date", localDate);
        model.put("response", response);
        return "index";
    }

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    public String addVisitor(String firstName, String lastName, String cardNumber, String company, String responsiblePerson, String roomName,  Map<String, Object> model) {

        LocalDate localDate = LocalDate.now();
        List<Visitor> visitors1 = repository.selectVisitors(localDate.toString());

        if(visitors1.isEmpty()){
            orderNumberCounter = 1;

        }else{

            orderNumberCounter = (visitors1.size()+1);
        }



        Visitor visitor = new Visitor();
        visitor.setOrderNumber(orderNumberCounter);
        visitor.setFirstName(firstName);
        visitor.setLastName(lastName);
        visitor.setCompany(company);
        visitor.setResponsiblePerson(responsiblePerson);
        visitor.setCardNumber(cardNumber);
        visitor.setRoomName(roomName);

        repository.addVisitors(visitor);

        List<Visitor> visitors = repository.selectVisitors(localDate.toString());

        String response = null;
       model.put("visitors", visitors);
        model.put("date", localDate);
        model.put("response", response);

        return "index";
    }



    @RequestMapping(value = "/selectByDate", method = RequestMethod.POST)
    public String selectByDate(String selectedDate, Map<String, Object> model) {


        System.out.println("working!");
        List<Visitor> visitors = repository.selectVisitors(selectedDate);
        String response = null;
        model.put("visitors", visitors);
        model.put("date", selectedDate);
        model.put("response", response);
        return "index";
    }

    @RequestMapping(value = "/addVisitorOutTimeByOrderNumber", method = RequestMethod.POST)
    public String addVisitorOutTimeByOrderNumber(String orderNumber, String password, Map<String, Object> model) {




        LocalDateTime localDateTime = LocalDateTime.now();

        if (!repository.selectResponsiblePerson(password).isEmpty()) {

            List<ResponsiblePerson> responsiblePerson = repository.selectResponsiblePerson(password);

            String responsiblePerson1 = responsiblePerson.get(0).getResponsiblePerson();

            repository.addVisitorsOutTime(localDateTime, orderNumber, responsiblePerson1);

            LocalDate localDate = LocalDate.now();
            String response = null;
            List<Visitor> visitors = repository.selectVisitors(localDate.toString());

            model.put("visitors", visitors);
            model.put("date", localDate);
            model.put("response", response);
            System.out.println("working add out time!");
            return "index";
        }else{
            LocalDate localDate = LocalDate.now();

            List<Visitor> visitors = repository.selectVisitors(localDate.toString());

            model.put("visitors", visitors);
            model.put("date", localDate);
            String response = "Atbildīga persona nav atrasta";
            System.out.println("nav atrasta atbildiga persona!");
            model.put("response", response);
            return "index";
        }


    }
}
