package lv.visitorreg.visitors.Controllers;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.DAL.UserCheckRepo;

import lv.visitorreg.visitors.Domain.*;
import lv.visitorreg.visitors.Logics.Validator;
import lv.visitorreg.visitors.SecurityFilters.TokenManager;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    TokenManager tokenManager;


    @RequestMapping(value = "/addVisitor", method = RequestMethod.POST)
    @ResponseBody
    public Visitor addVisitor(@RequestBody Visitor visitor, ServletRequest servletRequest) {


            HttpServletRequest request = (HttpServletRequest) servletRequest;

            String token = request.getHeader("Authorization");

        HashMap userInfo = tokenManager.parseToken(token);

            int userId = (int) userInfo.get("userId");

        String accessPoint = (String) userInfo.get("accessPoint");

        System.out.println("hello-IndexController/addVisitor");



        return addVisitorService.addVisitor(userId, accessPoint, visitor);

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
        public List<Visitor> visitors(String date, ServletRequest servletRequest) {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader("Authorization");

        HashMap userInfo = tokenManager.parseToken(token);

        int userId = (int) userInfo.get("userId");


        return getVisitorsService.getVisitors(userId, date);

    }


    @RequestMapping("/getAccessPoint")
    public AccessPoint accessPoint(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader("Authorization");

        HashMap userInfo = tokenManager.parseToken(token);

        int userId = (int) userInfo.get("userId");


    AccessPoint accessPoint  = new AccessPoint();
    accessPoint.setAccessPoint((String) userInfo.get("accessPoint"));

            return accessPoint;
        }


    }

