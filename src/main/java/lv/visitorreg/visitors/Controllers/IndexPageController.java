package lv.visitorreg.visitors.Controllers;


import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.DAL.UserCheckRepo;

import lv.visitorreg.visitors.Domain.AddOutTimeObject;
import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import lv.visitorreg.visitors.Domain.Visitor;
import lv.visitorreg.visitors.Logics.Validator;
import lv.visitorreg.visitors.Service.AddVisitorOutTimeService;
import lv.visitorreg.visitors.Service.AddVisitorService;
import lv.visitorreg.visitors.Service.GetVisitorsService;
import lv.visitorreg.visitors.mbus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;


@RestController
public class IndexPageController {


    @Autowired
    Repository repository;
    @Autowired
    UserCheckRepo userCheckRepo;
    @Autowired
    mbus mbus;
    @Autowired
    AddVisitorService addVisitorService;
    @Autowired
    AddVisitorOutTimeService addVisitorOutTimeService;
    @Autowired
    GetVisitorsService getVisitorsService;


    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    @ResponseBody
    public Visitor addVisitor(@RequestBody Visitor visitor, HttpSession httpSession) {


        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");
        int UserId = loginUser.getUserId();
        String accessPoint = loginUser.getAccessPoint();
        System.out.println("hello-IndexController/addVisitor");



        return addVisitorService.addVisitor(UserId, accessPoint, visitor);

    }


    @RequestMapping(value = "/addVisitorOutTime", method = RequestMethod.POST)
    @ResponseBody
    public Visitor addVisitorOutTimeByOrderNumber(@RequestBody AddOutTimeObject addOutTimeObject, HttpSession httpSession) {



        LoginUser loginUser = (LoginUser) httpSession.getAttribute("UserID");
        int userId = loginUser.getUserId();
        String accessPoint = loginUser.getAccessPoint();


        return addVisitorOutTimeService.addOutTime(userId, accessPoint, addOutTimeObject);


    }


    //@CrossOrigin(origins = "http://192.168.40.100:8888")
    @RequestMapping("/getUsers")
        public List<Visitor> visitors(String date) {

        //HttpServletRequest request = (HttpServletRequest) servletRequest;

       // LoginUser loginUser = (LoginUser) request.getAttribute("UserID");

        int userId = 1; //loginUser.getUserId();



        return getVisitorsService.getVisitors(userId, date);

    }


    @RequestMapping("/getAccessPoint")
    public LoginUser loginUser(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        LoginUser loginUser = (LoginUser) request.getAttribute("UserID");

            return loginUser;
        }


    }

