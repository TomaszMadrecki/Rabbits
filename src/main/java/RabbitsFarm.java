import java.util.ArrayList;
import java.util.List;

class RabbitsFarm {
    private List<Rabbit> maleRabbits = new ArrayList<>();
    private List<Rabbit> femaleRabbits = new ArrayList<>();
    private List<Rabbit> tempFemaleRabbits = new ArrayList<>();
    private List<Rabbit> deathRabbits = new ArrayList<>();
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
        if (femaleCount == 0) {
            return 0;
        }
        for (int i = 0; i < femaleCount; i++) {
            createFemaleRabbit();
        }
        for (int i = 0; i < maleCount; i++) {
            createMaleRabbit();
        }
        for (int i = 0; femaleRabbits.size() + maleRabbits.size() <= limit; i++) {
            for (Rabbit rabbit : femaleRabbits) {
                rabbit.age++;
            }
            for (Rabbit rabbit : maleRabbits) {
                rabbit.age++;
                if (rabbit.age >= 96) {
                    deathRabbits.add(rabbit);
                    maleRabbits.remove(rabbit);
                }
            }
            for (Rabbit rabbit : femaleRabbits) {
                if (rabbit.age >= 4) {
                    for (int j = 0; j < 14; j++) {
                        tempCreateFemaleRabbit();
                    }
                    for (int j = 0; j < 5; j++) {
                        createMaleRabbit();
                    }
                }
                if (rabbit.age == 96) {
                    deathRabbits.add(rabbit);
                    femaleRabbits.remove(rabbit);
                }
            }
            femaleRabbits.addAll(tempFemaleRabbits);
            tempFemaleRabbits.clear();
            months = i+1;
            System.out.println("female: " + femaleRabbits.size());
            System.out.println("male: " + maleRabbits.size());
        }
        System.out.println("Number of death rabbits: " + deathRabbits.size());
        return months;
    }
}
