import java.util.ArrayList;
import java.util.List;

class RabbitsFarm {
    private List<Rabbit> maleRabbits = new ArrayList<>();
    private List<Rabbit> femaleRabbits = new ArrayList<>();
    private List<Rabbit> tempFemaleRabbits = new ArrayList<>();
    private int months;

    private void createFemaleRabbit() {
        femaleRabbits.add(new Rabbit(0, Sex.FEMALE));
    }

    private void tempCreateFemaleRabbit() {
        tempFemaleRabbits.add(new Rabbit(0, Sex.FEMALE));
    }

    private void createMaleRabbit() {
        maleRabbits.add(new Rabbit(0, Sex.MALE));
    }

    int simulate(int maleCount, int femaleCount, long limit) {
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
                if (rabbit.age >= 96) {
                    maleRabbits.remove(rabbit);
                }
            }
            for (Rabbit rabbit : femaleRabbits) {
                if (rabbit.age >= 96) {
                    femaleRabbits.remove(rabbit);
                }
                if (rabbit.age >= 4) {
                    for (int j = 0; j < 14; j++) {
                        tempCreateFemaleRabbit();
                    }
                    for (int j = 0; j < 5; j++) {
                        createMaleRabbit();
                    }
                }
            }
            femaleRabbits.addAll(tempFemaleRabbits);
            tempFemaleRabbits.clear();

        }
        return months;
    }
}
