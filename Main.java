import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Pacjent pacjent = new Pacjent("Viktor", "Ibarbo ");
        pacjent.nerka = pacjent.new Nerka("Dobra", "W normie", 1);
        pacjent.watroba = pacjent.new Watroba("Dobre", "Bardzo dobre", 2);

        System.out.println(pacjent.nerka.filtracjaKrwi);
        System.out.println(pacjent.nerka.produkcjaHormonow);
        System.out.println(pacjent.nerka.waga);

        System.out.println(pacjent.watroba.funkcjeMetaboliczne);
        System.out.println(pacjent.watroba.detoksylacja);
        System.out.println(pacjent.watroba.waga);

        Duck kaczka = new Duck("Marek");
        kaczka.howIFly();
        Duck kaczka2 = new Duck("Grzegorz");
        kaczka2.howIFly();
        Duck kaczka3 = new Duck("Szymon");
        kaczka3.howIFly();

        Duck nieKaczka = new Duck("aha") {
            void howIFly() {
                System.out.println("I am flying like a swan");
            }
        };
        nieKaczka.howIFly();

            Random random2 = new Random();
            int projectileCount = random.nextInt(6) + 1;

                for (int i = 1; i <= projectileCount; i++) {
                    Pocisk generator = new Pocisk(i);
                    generator.generateFragments(100);
                }
    }
}
