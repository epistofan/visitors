package lv.visitorreg.visitors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@ServletComponentScan
public class VisitorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitorsApplication.class, args);
	}

}

