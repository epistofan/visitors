package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.DAL.UserCheckRepo;

import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import lv.visitorreg.visitors.Domain.Visitor;
import lv.visitorreg.visitors.Logics.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

@RestController
public class IndexPageController {


    @Autowired
    Repository repository;
    @Autowired
    UserCheckRepo userCheckRepo;


    @PostMapping("/index")
    public List<Visitor> visitor(String username, String psw, Map<String, Object> model) {

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
        if (visitors.isEmpty()) {
            i = 0;
        }
        String response = null;
        model.put("visitors", visitors);
        model.put("date", localDate);
        model.put("accessPoint", accessPoint);
        model.put("response", response);
        return visitors;
    }

    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    @ResponseBody
    public Visitor addVisitor(@RequestBody Visitor visitor, HttpSession httpSession) {

        int orderNumberCounter;
        String accessPoint;
        int UserId;


        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");
        UserId = loginUser.getUserId();
        accessPoint = loginUser.getAccessPoint();

        System.out.println("hello-IndexController/addVisitor");
        LocalDate localDate = LocalDate.now();
        List<Visitor> arrivedVisitors = repository.selectVisitors(UserId, localDate.toString());

        if (arrivedVisitors.isEmpty()) {
            orderNumberCounter = 1;

        } else {

            orderNumberCounter = (arrivedVisitors.size() + 1);
        }

        Validator validator = new Validator();

        visitor.setOrderNumber(orderNumberCounter);
        visitor.setUserId(UserId);
        visitor.setAccessPoint(accessPoint);

        repository.addVisitors(visitor);

        return visitor;
    }


    @RequestMapping(value = "/selectByDate", method = RequestMethod.POST)
    public String selectByDate(HttpSession httpSession, String selectedDate, Map<String, Object> model) {
        String accessPoint;
        int UserId;

        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");
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
    @ResponseBody
    public ResponseTransfer addVisitorOutTimeByOrderNumber(@RequestBody AddOutTimeObject addOutTimeObject, HttpSession httpSession) {

        System.out.println(addOutTimeObject.getOrderNumber());
        System.out.println(addOutTimeObject.getPassword());
        Integer result;
        int j;
        int UserId;
        Timestamp inDate = null;
        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");
        UserId = loginUser.getUserId();
        String accessPoint = loginUser.getAccessPoint();
        System.out.println(accessPoint);
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        if (repository.selectResponsiblePerson(addOutTimeObject.getPassword()).isEmpty()) {
            System.out.println("responsible person not found");

            return new ResponseTransfer("nava atrasta atbildiga persona");
        } else {

            List<ResponsiblePerson> responsiblePerson = repository.selectResponsiblePerson(addOutTimeObject.getPassword());

            String responsiblePerson1 = responsiblePerson.get(0).getResponsiblePerson();

            List<Visitor> visitors1 = repository.selectVisitors(UserId, localDate.toString());

            for (j = 0; j < visitors1.size(); j++) {
                if (visitors1.get(j).getOrderNumber() == Integer.valueOf(addOutTimeObject.getOrderNumber())) {
                    inDate = visitors1.get(j).getInDate();
                }
            }
            result = repository.addVisitorsOutTime(localDateTime, addOutTimeObject.getOrderNumber(), responsiblePerson1, inDate);

            System.out.println("working add out time!");
            System.out.println("update result " + result);

            return new ResponseTransfer("ir iziets!!, gaidisim jus atkal");
        }

    }


    //@CrossOrigin(origins = "http://192.168.40.100:8888")
    @RequestMapping("/loginUser")
    public List<Visitor> visitors(HttpSession httpSession) {

        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");

        int UserId = loginUser.getUserId();
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.toString());

        List<Visitor> visitors = repository.selectVisitors(UserId, localDate.toString());

        if (visitors.isEmpty()) {
            return null;
        } else {
            return visitors;
        }
    }

    @RequestMapping("/getAccessPoint")
    public LoginUser loginUser(HttpSession httpSession) {

        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");

            return loginUser;
        }


    }

