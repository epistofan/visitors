package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.DAL.UserCheckRepo;

import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import lv.visitorreg.visitors.Domain.Visitor;
import lv.visitorreg.visitors.Logics.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexPageController {

            
    @Autowired
    Repository repository;
    @Autowired
    UserCheckRepo userCheckRepo;


    @PostMapping("/index")
    public String index(String username, String psw, Map<String, Object> model) {

        int i;
        String accessPoint;
        int UserId;
        LoginUser LoginUser;

        LoginUser = userCheckRepo.checkLoginUser(username, psw);
        UserId = LoginUser.getUserId();
        accessPoint = LoginUser.getAccessPoint();

        LocalDate localDate = LocalDate.now();

        System.out.println("hello-IndexController/index");
        System.out.println(localDate.toString());

        List<Visitor> visitors = repository.selectVisitors(UserId, localDate.toString());
        if (visitors.isEmpty()){
            i=0;
        }
        String response = null;
       model.put("visitors", visitors);
       model.put("date", localDate);
        model.put("accessPoint", accessPoint);
        model.put("response", response);
        return "index";
    }

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    public String addVisitor(HttpSession httpSession, String firstName, String lastName, String cardNumber, String company, String responsiblePerson, String roomName, Map<String, Object> model) {
        int orderNumberCounter;
        String accessPoint;
        int UserId;
        LoginUser LoginUser;

        LoginUser loginUser = (LoginUser)httpSession.getAttribute("UserID");
        UserId = loginUser.getUserId();
        accessPoint = loginUser.getAccessPoint();

        System.out.println("hello-IndexController/addVisitor");
        LocalDate localDate = LocalDate.now();
        List<Visitor> visitors1 = repository.selectVisitors(UserId, localDate.toString());

        if(visitors1.isEmpty()){
            orderNumberCounter = 1;

        }else{

            orderNumberCounter = (visitors1.size()+1);
        }
        List<String> parameters = new ArrayList<>();
            parameters.add(firstName);
            parameters.add(lastName);
            parameters.add(cardNumber);
            parameters.add(company);
            parameters.add(responsiblePerson);
            parameters.add(roomName);


        Validator validator = new Validator();
        validator.validate(parameters);

        Visitor visitor = new Visitor();
        visitor.setOrderNumber(orderNumberCounter);
        visitor.setFirstName(firstName);
        visitor.setLastName(lastName);
        visitor.setCompany(company);
        visitor.setResponsiblePerson(responsiblePerson);
        visitor.setCardNumber(cardNumber);
        visitor.setRoomName(roomName);
        visitor.setUserId(UserId);
        visitor.setAccessPoint(accessPoint);

        repository.addVisitors(visitor);

        List<Visitor> visitors = repository.selectVisitors(UserId, localDate.toString());


        String response = null;
       model.put("visitors", visitors);
        model.put("date", localDate);
        model.put("accessPoint", accessPoint);
        model.put("response", response);

        return "index";
    }



    @RequestMapping(value = "/selectByDate", method = RequestMethod.POST)
    public String selectByDate(HttpSession httpSession, String selectedDate, Map<String, Object> model) {
        String accessPoint;
        int UserId;

        LoginUser loginUser = (LoginUser)httpSession.getAttribute("UserID");
        UserId = loginUser.getUserId();
        accessPoint = loginUser.getAccessPoint();
        System.out.println("working!");
        List<Visitor> visitors = repository.selectVisitors(UserId, selectedDate);
        String response = null;


        model.put("visitors", visitors);
        model.put("date", selectedDate);
        model.put("response", response);
        model.put("accessPoint", accessPoint);
        return "index";
    }

    @RequestMapping(value = "/addVisitorOutTime", method = RequestMethod.POST)
    public String addVisitorOutTimeByOrderNumber(HttpSession httpSession, String orderNumber, String password, Map<String, Object> model) {

        int j;
        int UserId;
        Timestamp inDate = null;
        LoginUser loginUser = (LoginUser)httpSession.getAttribute("UserID");
        UserId = loginUser.getUserId();
        String accessPoint = loginUser.getAccessPoint();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        if (!repository.selectResponsiblePerson(password).isEmpty()) {

            List<ResponsiblePerson> responsiblePerson = repository.selectResponsiblePerson(password);

            String responsiblePerson1 = responsiblePerson.get(0).getResponsiblePerson();

            List<Visitor> visitors1 = repository.selectVisitors(UserId, localDate.toString());

            for(j=0; j<visitors1.size(); j++){
                if(visitors1.get(j).getOrderNumber() == Integer.valueOf(orderNumber)){
                    inDate = visitors1.get(j).getInDate();

                }else {
                    System.out.println("Order number not found");
                }

            }


            repository.addVisitorsOutTime(localDateTime, orderNumber, responsiblePerson1, inDate);


            String response = null;
            List<Visitor> visitors = repository.selectVisitors(UserId, localDate.toString());


            model.put("visitors", visitors);
            model.put("date", localDate);
            model.put("response", response);
            model.put("accessPoint", accessPoint);
            System.out.println("working add out time!");
            return "index";
        }else{
            //LocalDate localDate = LocalDate.now();

            List<Visitor> visitors = repository.selectVisitors(UserId, localDate.toString());

            model.put("visitors", visitors);
            model.put("date", localDate);
            String response = "Atbildīga persona nav atrasta";
            System.out.println("nav atrasta atbildiga persona!");
            model.put("response", response);
            model.put("accessPoint", accessPoint);
            return "index";
        }

    }
}
