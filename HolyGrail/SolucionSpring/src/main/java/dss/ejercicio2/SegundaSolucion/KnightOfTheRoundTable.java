package dss.ejercicio2.SegundaSolucion;

public class KnightOfTheRoundTable implements Knight {
    private String name;
    private Quest<Holy> quest;

    public KnightOfTheRoundTable(String name, Quest<Holy> quest) {
        this.name = name;
        this.quest = quest;
    }


    public void setQuest(Quest<Holy> quest) {
        this.quest = quest;
    }


    @Override
    public Holy embarkOnQuest() {
        try {
            return quest.embark();
        } catch (QuestFailedException e) {
            throw new RuntimeException(e);
        }
    }
}
