import java.util.Random;

public class Pocisk {
    private int numerPocisku;
    Random random = new Random();

    public Pocisk(int numer) {
        this.numerPocisku = numer;
    }

    public void generujOdlamki(int liczbaOdlamkow) {
        Random random = new Random();

        for (int i = 1; i <= liczbaOdlamkow; ++i) {
            Odlamek odlamek = new Odlamek(i);
            odlamek.komunikat();
            odlamek.generujKolejneOdlamki(random);
        }
    }

     class Odlamek {
         int numerOdlamka;
         int wektorX;
         int wektorY;

        public Odlamek(int numer) {
            this.numerOdlamka = numer;
            this.wektorX = random.nextInt(-50,50); //new Random().nextInt(101) - 50;
            this.wektorY = random.nextInt(-50,50); //new Random().nextInt(101) - 50;
        }

        public void komunikat() {
            System.out.println("Pocisk " + Pocisk.this.numerPocisku +
                    " - wygenerowano odłamek " + this.numerOdlamka +
                    " o wektorze przesunięcia (x: " + wektorX + ", y: " + wektorY + ")");
        }

        public void generujKolejneOdlamki(Random random) {
            int liczbaOdlamkow = random.nextInt(7) + 1;
            for (int i = 1; i <= liczbaOdlamkow; ++i) {
                OdlamekOdlamka kolejnyOdłamek = new OdlamekOdlamka(numerOdlamka, i);
                kolejnyOdłamek.komunikat();
            }
        }
    }

     class OdlamekOdlamka {
         int numerOdlamka;
         int numerOdlamkaRodzica;
         int wektorX;
         int wektorY;

        public OdlamekOdlamka(int numerRodzica, int numer) {
            this.numerOdlamkaRodzica = numerRodzica;
            this.numerOdlamka = numer;
            this.wektorX = random.nextInt(-50,50);
            this.wektorY = random.nextInt(-50,50);
        }

        public void komunikat() {
            System.out.println("Pocisk " + Pocisk.this.numerPocisku + " - wygenerowano odłamek odłamka " +
                    this.numerOdlamkaRodzica + "." + this.numerOdlamka + " o wektorze przesunięcia (x: " + wektorX + ", y: " + wektorY + ")");
        }
    }
}
