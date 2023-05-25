package dss.ejercicio2.SegundaSolucion;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TransferQueue;

public class HolyGrailQuest implements Quest<Holy> {

    @Autowired
    private Holy treasure;
    public HolyGrailQuest() {
        //...
    }
    public Holy embark() throws QuestFailedException {
        //...
        return treasure;
    }


}
