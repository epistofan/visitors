package lv.visitorreg.visitors.Service;

import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class GetVisitorsService {

    @Autowired
    Repository repository;


        public List<Visitor> getVisitors(int userId, String date){

            //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


            return repository.selectVisitors(userId, date);
        }


}

