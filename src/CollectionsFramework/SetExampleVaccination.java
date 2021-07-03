package CollectionsFramework;

import java.util.HashSet;
import java.util.Set;

public class SetExampleVaccination {
    public static void main(String[] args) {
        Set<Vaccination> toVaccinate = new HashSet<>();
        toVaccinate.add(new Vaccination(303,"Ritesh"));
        toVaccinate.add(new Vaccination(909,"Tushar"));
        toVaccinate.add(new Vaccination(303,"Ritesh"));

        System.out.println(toVaccinate);
        //not allowed to add multiple
    }
}
