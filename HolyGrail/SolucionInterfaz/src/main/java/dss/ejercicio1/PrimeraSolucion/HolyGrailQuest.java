package dss.ejercicio1.PrimeraSolucion;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TransferQueue;

public class HolyGrailQuest implements Quest <Holy> {

    public HolyGrailQuest() {}
    public Holy embark() throws QuestFailedException {
        return new HolyGrail();
    }


}
