public class Pacjent {
    String imie;
    String nazwisko;

    public Pacjent(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    Watroba watroba;
    Nerka nerka;
    class Watroba{
        String funkcjeMetaboliczne;
        String detoksylacja;
        int waga;

        public Watroba(String funkcjeMetaboliczne, String detoksylacja, int waga) {
            this.funkcjeMetaboliczne = funkcjeMetaboliczne;
            this.detoksylacja = detoksylacja;
            this.waga = waga;
        }
    }

    class Nerka{
        String filtracjaKrwi;
        String produkcjaHormonow;
        int waga;

        public Nerka(String filtracjaKrwi, String produkcjaHormonow, int waga) {
            this.filtracjaKrwi = filtracjaKrwi;
            this.produkcjaHormonow = produkcjaHormonow;
            this.waga = waga;
        }
    }
}

