import java.util.Random;

public class Main {
    public static int bossHealth = 650;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {270, 260, 250};
    public static int[] heroesDamage = {10, 15, 20};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic"};
    public static int[] health= {280};
    public static String[] healer = {"Medic"};
    public static int[] MedicHealer= {0};
    public static String Medic;
    public static int round_number = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }
    }
    public static void chooseDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefence = heroesAttackType[randomIndex];
        System.out.println("Boss chose: " + bossDefence);
    }
    public static void round() {
        round_number++;
        setHealHeroes();
        chooseDefence();
        bossHits();
        bossHits1();
        heroesHit();
        printStatistics();
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDamage < 0) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = (heroesHealth[i]  - bossDamage);
                }
            }

        }
    }
    public static void bossHits1() {
        for (int i = 0; i < health.length; i++) {
            if (health[i] > 0){
                if (health[i] - bossDamage <0){
                    health[i] = 0;
                }
                else  {
                    health[i] = (health[i] - bossDamage);
                }
            }
        }
    }
    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            int damage = heroesDamage[i];
            if (heroesAttackType[i] == bossDefence) {
                Random random = new Random();
                int coeff = random.nextInt(11);
                damage = heroesDamage[i] * coeff;
                System.out.println("Critical damage: " + heroesDamage[i]
                        + " * " + coeff + " = " + damage);
            }
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossHealth - damage < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - damage;
                }
            }
        }
    }
    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    public static void printStatistics() {

        System.out.println("ROUND " + round_number + "  _________________");
        System.out.println("Boss health: " + bossHealth + "; damage: " + bossDamage);
        for (int i = 0; i < healer.length; i++) {
            System.out.println(healer[i] + " health: " + health[i]
            + "; damage: " + MedicHealer[i] );
        }


        }{
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health: " + heroesHealth[i]
                    + "; damage: " + heroesDamage[i]);
        }
    }
    public static void setHealHeroes() {
        Random random = new Random();
        int randomReflex = random.nextInt(heroesAttackType.length);
        Medic = heroesAttackType[randomReflex];
        random = new Random();
        int heroy = random.nextInt(101);

        int huu = 0;
        if (heroesHealth[2] > 0) {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] <= 0) {
                    heroesHealth[i] = 0;
                }
                else if (heroesHealth[i] <= 100 && heroesHealth[i] > 1) {
                    System.out.println(heroesHealth[i]);
                    huu = heroesHealth[i];
                    heroesHealth[i] = huu + heroy;
                    System.out.println("Medic heal: " + heroesAttackType[i] +" " +heroesHealth[i] + "hp");
                    break;
                }
            }
        }
    }
}
