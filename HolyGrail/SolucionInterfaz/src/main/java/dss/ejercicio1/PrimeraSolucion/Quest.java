package dss.ejercicio1.PrimeraSolucion;

public interface Quest<T extends Holy> { 
    
    abstract Holy embark() throws QuestFailedException;

}