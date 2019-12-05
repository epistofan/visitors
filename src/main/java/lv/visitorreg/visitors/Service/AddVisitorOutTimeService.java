package lv.visitorreg.visitors.Service;

import lv.visitorreg.visitors.DAL.Repository;
import lv.visitorreg.visitors.Domain.AddOutTimeObject;
import lv.visitorreg.visitors.Domain.LoginUser;
import lv.visitorreg.visitors.Domain.ResponsiblePerson;
import lv.visitorreg.visitors.Domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class AddVisitorOutTimeService {

    @Autowired
    Repository repository;


        public Visitor addOutTime(int userId, String accessPoint, AddOutTimeObject addOutTimeObject) {

            Timestamp inDate = null;
            Integer visitorId;
            int j;

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDate localDate = LocalDate.now();
            String date = localDate.format(dateTimeFormatter);

            if (repository.selectResponsiblePerson(addOutTimeObject.getPassword()).isEmpty()) {
                System.out.println("responsible person not found");

                return null;
            } else {

                List<ResponsiblePerson> responsiblePerson = repository.selectResponsiblePerson(addOutTimeObject.getPassword());

                String responsiblePerson1 = responsiblePerson.get(0).getResponsiblePerson();

               /* List<Visitor> visitors1 = repository.selectVisitors(userId, date);


                for (j = 0; j < visitors1.size(); j++) {
                    if (visitors1.get(j).getOrderNumber() == Integer.valueOf(addOutTimeObject.getVisitorId()) {
                        inDate = visitors1.get(j).getInDate();
                    }
                }*/
                visitorId = repository.addVisitorsOutTime(localDateTime, addOutTimeObject.getVisitorId(), responsiblePerson1);

                System.out.println("working add out time!");
                System.out.println("update result - " + visitorId);


                return repository.getVisitor(addOutTimeObject.getVisitorId());
            }
        }

}

