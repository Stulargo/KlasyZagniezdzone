import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pocisk {
    private int projectileNumber;
    private Random random;
    private List<Fragment> fragments;

    public Pocisk(int number) {
        this.projectileNumber = number;
        this.random = new Random();
        this.fragments = new ArrayList<>();
    }

    public void generateFragments(int fragmentCount) {
        for (int i = 1; i <= fragmentCount; ++i) {
            Fragment fragment = new Fragment(i);
            fragment.displayInfo();
            fragment.generateSubFragments();
            fragments.add(fragment);
        }
    }

    public void checkCollisions() {
        for (int i = 0; i < fragments.size(); ++i) {
            Fragment f1 = fragments.get(i);
            // Sprawdzamy każdy fragment z każdym innym
            for (int j = i + 1; j < fragments.size(); ++j) {
                Fragment f2 = fragments.get(j);
                if (f1.deltaX == f2.deltaX && f1.deltaY == f2.deltaY) {
                    System.out.println("Kolizja fragmentów: Pocisk " + projectileNumber +
                            " - Fragment " + f1.fragmentId + " koliduje z Fragmentem " + f2.fragmentId +
                            " na wektorze (x: " + f1.deltaX + ", y: " + f1.deltaY + ")");
                }
            }

            f1.checkSubFragmentCollisions();
        }
    }

    private class Fragment {
        private int fragmentId;
        private int deltaX;
        private int deltaY;
        private List<SubFragment> subFragments;

        public Fragment(int id) {
            this.fragmentId = id;
            this.deltaX = random.nextInt(-5, 6);
            this.deltaY = random.nextInt(-5, 6);
            this.subFragments = new ArrayList<>();
        }

        public void displayInfo() {
            System.out.println("Pocisk " + Pocisk.this.projectileNumber +
                    " - Zgenerowano odłamek " + this.fragmentId +
                    " z wektorem (x: " + deltaX + ", y: " + deltaY + ")");
        }

        public void generateSubFragments() {
            int subFragmentCount = random.nextInt(2) + 1;  // Ograniczamy liczbę sub-fragmentów
            for (int i = 1; i <= subFragmentCount; ++i) {
                SubFragment subFragment = new SubFragment(fragmentId, i, deltaX, deltaY);
                subFragment.displayInfo();
                subFragments.add(subFragment);
            }
        }

        // Sprawdzamy kolizje sub-fragmentów
        public void checkSubFragmentCollisions() {
            for (int i = 0; i < subFragments.size(); ++i) {
                SubFragment sf1 = subFragments.get(i);
                for (int j = i + 1; j < subFragments.size(); ++j) {
                    SubFragment sf2 = subFragments.get(j);
                    if (sf1.deltaX == sf2.deltaX && sf1.deltaY == sf2.deltaY) {
                        System.out.println("Kolizja sub-fragmentów: Pocisk " + Pocisk.this.projectileNumber +
                                " - Sub-fragment " + sf1.subFragmentId + " koliduje z Sub-fragmentem " + sf2.subFragmentId +
                                " na wektorze (x: " + sf1.deltaX + ", y: " + sf1.deltaY + ")");
                    }
                }
            }
        }
    }

    private class SubFragment {
        private int parentFragmentId;
        private int subFragmentId;
        private int deltaX;
        private int deltaY;

        public SubFragment(int parentId, int id, int parentDeltaX, int parentDeltaY) {
            this.parentFragmentId = parentId;
            this.subFragmentId = id;
            this.deltaX = parentDeltaX + random.nextInt(-3, 4);
            this.deltaY = parentDeltaY + random.nextInt(-3, 4);
        }

        public void displayInfo() {
            System.out.println("Pocisk " + Pocisk.this.projectileNumber +
                    " - Zgenerowany sub-fragment " + this.parentFragmentId + "." + this.subFragmentId +
                    " z wektorem (x: " + deltaX + ", y: " + deltaY + ")");
        }
    }
}
