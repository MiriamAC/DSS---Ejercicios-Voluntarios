package dss.ejercicio1.PrimeraSolucion;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dss.ejercicio1.PrimeraSolucion.Holy;
import dss.ejercicio1.PrimeraSolucion.HolyGrailQuest;
import dss.ejercicio1.PrimeraSolucion.KnightOfTheRoundTable;
import dss.ejercicio1.PrimeraSolucion.QuestFailedException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class KnightOfTheRoundTableTest{

    @Test
    public void testEmbarkOnQuest() throws QuestFailedException {
            KnightOfTheRoundTable knight =  new KnightOfTheRoundTable("CruzadoMagico", new HolyGrailQuest());
            Holy grail = knight.embarkOnQuest();
            assertNotNull(grail);
            assertTrue(grail.isHoly());
        }
    }
