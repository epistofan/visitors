package lv.visitorreg.visitors.Service;

import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.Visitor;
import lv.visitorreg.visitors.Logics.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class AddVisitorService {

    @Autowired
    Repository repository;


        public Visitor addVisitor(int userId, String accessPoint, Visitor visitor){

            int orderNumberCounter;

            LocalDate localDate = LocalDate.now();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            LocalDateTime localDateTime = LocalDateTime.now();

            String date = localDate.format(dateTimeFormatter);

            Timestamp timestamp = Timestamp.valueOf(localDateTime);


            List<Visitor> arrivedVisitors = repository.selectVisitors(userId, date);

            if (arrivedVisitors.isEmpty()) {
                orderNumberCounter = 1;

            } else {

                orderNumberCounter = (arrivedVisitors.size() + 1);
            }

            //Validator validator = new Validator();


            visitor.setInDate(timestamp);
            visitor.setInTime(timestamp);
            visitor.setOrderNumber(orderNumberCounter);
            visitor.setUserId(userId);
            visitor.setAccessPoint(accessPoint);


            return repository.getVisitor(repository.addVisitors(visitor));
        }


}

