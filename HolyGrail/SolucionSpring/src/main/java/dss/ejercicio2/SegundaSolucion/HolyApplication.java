package dss.ejercicio2.SegundaSolucion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HolyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolyApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        Holy grail = knight.embarkOnQuest();
        if (grail.isHoly()) {
            System.out.println("Al fin lo encontramos, el Santo Grial");
        } else {
            System.out.println("No es el Santo Grial, rayos y centellas!");
        }

    }

}
