import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        //1 do 2 pocisków
        int projectileCount = random.nextInt(2) + 1;

        for (int i = 1; i <= projectileCount; i++) {
            Pocisk generator = new Pocisk(i);
            //5 do 10 fragmentów
            generator.generateFragments(random.nextInt(6) + 5);
            generator.checkCollisions();
        }
    }
}
