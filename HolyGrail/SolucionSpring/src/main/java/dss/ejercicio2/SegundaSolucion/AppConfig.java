package dss.ejercicio2.SegundaSolucion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Knight knight() {
        return new KnightOfTheRoundTable("Rey Arturo", quest());
    }

    @Bean
    public Quest<Holy> quest() {
        return new HolyGrailQuest();
    }

    @Bean
    public HolyGrailQuest holyGrailQuest() {
        return new HolyGrailQuest();
    }

    @Bean
    public Holy treasure() {
        return new HolyGrail();
    }




}
