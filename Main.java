//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pacjent pacjent = new Pacjent("Mateusz", "Dubiel");
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

        Duck nieKaczka = new Duck("aha")
        {
            void howIFly() {
            System.out.println("I am flying like a swan");
        }
        };
        nieKaczka.howIFly();




    }
}
