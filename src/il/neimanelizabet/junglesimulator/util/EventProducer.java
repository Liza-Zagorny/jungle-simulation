package util;

import entity.Shark;

public class EventProducer {

    public void startSimulation(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        System.out.println("Привет, мы начинаем симуляцию жизни акулы в море!" + returnEnergyHealthLevel(energy, health));
        int day = 1;
        int eventOfTheDay = 0;
        while (isAlive(shark)) {
            if (eventOfTheDay == 4 || (day == 1 && eventOfTheDay == 0)) {
                eventOfTheDay = 0;
                System.out.println("Начался день " + day + ":");
                day++;
            }
            int eventPercentage = (int) (Math.random() * 100);
            if (eventPercentage >= 0 && eventPercentage <= 20) {
                sleep(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 20 && eventPercentage <= 25) {
                eatFish(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 25 && eventPercentage <= 35) {
                eatSquid(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 35 && eventPercentage <= 45) {
                eatSeaweedPlankton(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 45 && eventPercentage <= 50) {
                eatTrash(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 50 && eventPercentage <= 85) {
                searchPray(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 85 && eventPercentage <= 95) {
                migrate(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 95 && eventPercentage <= 97) {
                spawn(shark);
                eventOfTheDay++;
            } else if (eventPercentage > 97 && eventPercentage <= 99) {
                breakFreeFromHook(shark);
                eventOfTheDay++;
            } else {
                battlePoacher(shark);
                eventOfTheDay++;
            }
        }

        System.out.println("Ооо нет! Акула умерла на " + (day - 1) + "-й день! Симуляция окончена.");
    }

    private String returnEnergyHealthLevel(int e, int h) {
        return "Текущий уровень энергии:" + e + ". Текущий уровень здоровья:" + h + ".";
    }

    private boolean isAlive(Shark shark) {
        return shark.getHealth() > 0;
    }

    private int checkMinEnergyUpdateHealth(int energy, int health) {
        if (energy == 0) {
            health -= 5;
        }
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    // 1. Акула спит (sleep): Возобновляется 20 энергии.
    private void sleep(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.min(energy + 20, 100);
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
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула съела рыбу." + returnEnergyHealthLevel(energy, updHealth));
    }

    // 3. Акула ест кальмара (eatSquid): Тратит 2 единицы энергии и возобновляет 2*коэфф здоровья.
    private void eatSquid(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 2, 0);
        health += (int) (2 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула съела кальмара." + returnEnergyHealthLevel(energy, updHealth));
    }

    // 4. Акула ест водоросли и планктон (eatSeaweedPlankton) : Тратит 1 единицу энергии и возобновляет 0.1*коэфф здоровья.
    private void eatSeaweedPlankton(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 1, 0);
        health += (int) (0.1 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула проглотила водоросли и планктон." + returnEnergyHealthLevel(energy, updHealth));
    }

    // 5. Акула ест отходы: пластик, стекло, метал (eatTrash): Тратит 15 единиц энергии и теряет 5*коэфф здоровья.
    // C 5% шансом у акулы случается осложнение после поедания отходов и она тут же умирает.
    private void eatTrash(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 15, 0);
        health -= (int) (5 * shark.getHealthRecoveryRate());
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула попыталась съесть мусор." + returnEnergyHealthLevel(energy, updHealth));
        double eventPercentage = Math.random();
        if (eventPercentage > 0.95) {
            shark.setHealth(0);
            System.out.println("К сожалению, акула подавилась мусором и умерла.");
        }
    }

    // 6. Акула плывет в посиках добычи (searchPray) Тратит 4 единицы энергии.
    private void searchPray(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 4, 0);
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула плыла разыскивая добычу." + returnEnergyHealthLevel(energy, updHealth));
    }

// 7. Акула мигрирует в стае (migrate) Тратит 6 единиц энергии.
    private void migrate(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 6, 0);
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула мигрировала в стае." + returnEnergyHealthLevel(energy, updHealth));
    }

    // 8. Акула размножается (spawn) Тратит 20 единиц энергии.
    private void spawn(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 20, 0);
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула совершила размножение." + returnEnergyHealthLevel(energy, updHealth));
    }
// 9. Акула вырывается из крючка рыболова (breakFreeFromHook) Тратит 20 единиц енергии и 10 здоровья.

    private void breakFreeFromHook(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 20, 0);
        health -= 10;
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула сорвалась с крючка рыболова." + returnEnergyHealthLevel(energy, updHealth));
    }

    // 10. Акула сражается с браконьером (battlePoacher) Тратит 50 единиц энергии и 80 здоровья.
    private void battlePoacher(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = Math.max(energy - 50, 0);
        health -= 80;
        shark.setEnergy(energy);
        int updHealth = checkMinEnergyUpdateHealth(energy, health);
        shark.setHealth(updHealth);
        System.out.println("Акула сразилась с браконьером." + returnEnergyHealthLevel(energy, updHealth));
    }
}
