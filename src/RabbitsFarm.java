import java.util.ArrayList;
import java.util.List;

public class RabbitsFarm {
    public List<Rabbit> maleRabbits = new ArrayList<>();
    public List<Rabbit> femaleRabbits = new ArrayList<>();
    public List<Rabbit> tempFemaleRabbits = new ArrayList<>();
    public int months;

    public void createFemaleRabbit() {
        femaleRabbits.add(new Rabbit(0, Sex.FEMALE));
    }

    public void tempCreateFemaleRabbit() {
        tempFemaleRabbits.add(new Rabbit(0, Sex.FEMALE));
    }

    public void createMaleRabbit() {
        maleRabbits.add(new Rabbit(0, Sex.MALE));
    }

    public int simulate(int maleCount, int femaleCount, long limit) {
        for (int i = 0; i < femaleCount; i++) {
            createFemaleRabbit();
        }
        for (int i = 0; i < maleCount; i++) {
            createMaleRabbit();
        }
        for (int i = 0; femaleRabbits.size() + maleRabbits.size() <= limit; i++) {
            months = i;
            for (Rabbit rabbit : femaleRabbits) {
                rabbit.age++;
            }
            for (Rabbit rabbit : maleRabbits) {
                rabbit.age++;
            }
            for (Rabbit rabbit : femaleRabbits) {
                if (rabbit.age >= 4 && rabbit.age < 96) {
                    for (int j = 0; j < 14; j++) {
                        tempCreateFemaleRabbit();
                    }
                    for (int j = 0; j < 5; j++) {
                        createMaleRabbit();
                    }
                }
            }
            femaleRabbits.addAll(tempFemaleRabbits);
        }
        return months;
    }

}
