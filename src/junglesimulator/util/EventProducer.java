package util;

import entity.Shark;

public class EventProducer {

    public void startSimulation(Shark shark) {
        while (isAlive(shark)) {
            int eventPercentage = (int) (Math.random() * 100);

            if (eventPercentage >= 0 && eventPercentage <= 40) {
                sleep(shark);
            } else if (eventPercentage > 40 && eventPercentage <= 45) {
                eatFish(shark);
            } else if (eventPercentage > 45 && eventPercentage <= 50) {
                eatSquid(shark);
            } else if (eventPercentage > 50 && eventPercentage <= 55) {
                eatSeaweedPlankton(shark);
            } else if (eventPercentage > 55 && eventPercentage <= 60) {
                eatTrash(shark);
            } else if (eventPercentage > 60 && eventPercentage <= 86) {
                searchPray(shark);
            } else if (eventPercentage > 86 && eventPercentage <= 94) {
                migrate(shark);
            } else if (eventPercentage > 94 && eventPercentage <= 96) {
                spawn(shark);
            } else if (eventPercentage > 96 && eventPercentage <= 98) {
                breakFreeFromHook(shark);
            } else {
                battlePoacher(shark);
            }

        }
    }

    private String returnEnergyHealthLevel(int e, int h) {
        return "Текущий уровень энергии:" + e + ". Текущий уровень здоровья:" + h + ".";
    }

    private boolean isAlive(Shark shark) {
        int health = shark.getHealth();
        return health > 0;
    }

    private void checkAndSetMinEnergyMaxHealth(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        if (energy == 0) health -= 5;
        if (health > 100) health = 100;
        shark.setHealth(health);


    }

    // 1. Акула спит (sleep): Возобновляется 20 энергии.
    private void sleep(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy + 20, 100);
        shark.setEnergy(energy);
        System.out.println("Акула поспала." + returnEnergyHealthLevel(energy, health));
    }

    // 2. Акула ест рыбу (eatFish): Тратит 5 единицы энергии и возобновляет 5*коэфф здоровья.
    private void eatFish(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 5, 0);
        health += (int) (5 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула съела рыбу." + returnEnergyHealthLevel(energy, health));
    }

    // 3. Акула ест кальмара (eatSquid): Тратит 2 единицы энергии и возобновляет 2*коэфф здоровья.
    private void eatSquid(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 2, 0);
        health += (int) (2 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула съела кальмара." + returnEnergyHealthLevel(energy, health));
    }

    // 4. Акула ест водоросли и планктон (eatSeaweedPlankton) : Тратит 1 единицу энергии и возобновляет 0.1*коэфф здоровья.
    private void eatSeaweedPlankton(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 1, 0);
        health += (int) (0.1 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула съела водорасли и планктон." + returnEnergyHealthLevel(energy, health));
    }

    // 5. Акула ест отходы: пластик, стекло, метал (eatTrash): Тратит 15 единиц энергии и теряет 5*коэфф здоровья.
    private void eatTrash(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 15, 0);
        health -= (int) (5 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула пыталась съесть мусор." + returnEnergyHealthLevel(energy, health));
    }

    // 6. Акула плывет в посиках добычи (searchPray) Тратит 4 единицы энергии.
    private void searchPray(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 4, 0);
        shark.setEnergy(energy);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула плывёт в посиках добычи." + returnEnergyHealthLevel(energy, health));
    }

// 7. Акула мигрирует в стае (migrate) Тратит 6 единиц энергии.

    private void migrate(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 6, 0);
        shark.setEnergy(energy);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула мигрирует в стае." + returnEnergyHealthLevel(energy, health));
    }

    // 8. Акула размножается (spawn) Тратит 20 единиц энергии.
    private void spawn(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 20, 0);
        shark.setEnergy(energy);
        checkAndSetMinEnergyMaxHealth(shark);
        System.out.println("Акула размножается." + returnEnergyHealthLevel(energy, health));
    }
// 9. Акула вырывается из крючка рыболова (breakFreeFromHook) Тратит 20 единиц енергии и 10 здоровья.

    private void breakFreeFromHook(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 20, 0);
        checkAndSetMinEnergyMaxHealth(shark);
        health -= 10;
        shark.setEnergy(energy);
        shark.setHealth(health);
        System.out.println("Акула вырывается из крючка рыболова." + returnEnergyHealthLevel(energy, health));
    }

    // 10. Акула сражается с браконьером (battlePoacher) Тратит 40 единиц энергии и 40 здоровья.
    private void battlePoacher(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 40, 0);
        checkAndSetMinEnergyMaxHealth(shark);
        health -= 40;
        shark.setEnergy(energy);
        shark.setHealth(health);
        System.out.println("Акула сражается с браконьером." + returnEnergyHealthLevel(energy, health));
    }
}
