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

    private class Fragment {
        private int fragmentId;
        private int deltaX;
        private int deltaY;
        private List<SubFragment> subFragments;

        public Fragment(int id) {
            this.fragmentId = id;
            this.deltaX = random.nextInt(-10, 11);
            this.deltaY = random.nextInt(-10, 11);
            this.subFragments = new ArrayList<>();
        }

        public void displayInfo() {
            System.out.println("Pocisk " + Pocisk.this.projectileNumber +
                    " - Zgenerowano odłamek " + this.fragmentId +
                    " w następujacym wektorze (x: " + deltaX + ", y: " + deltaY + ")");
        }

        public void generateSubFragments() {
            int subFragmentCount = random.nextInt(7) + 1;
            for (int i = 1; i <= subFragmentCount; ++i) {
                SubFragment subFragment = new SubFragment(fragmentId, i, deltaX, deltaY);
                subFragment.displayInfo();
                subFragments.add(subFragment);
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
            this.deltaX = parentDeltaX + random.nextInt(-10, 11);
            this.deltaY = parentDeltaY + random.nextInt(-10, 11);
        }

        public void displayInfo() {
            System.out.println("Pocisk " + Pocisk.this.projectileNumber + " - zgenerowany odłamek z pocisku " + this.parentFragmentId + "." + this.subFragmentId + " z następującym wektorem (x: " + deltaX + ", y: " + deltaY + ")");
        }
    }
}
