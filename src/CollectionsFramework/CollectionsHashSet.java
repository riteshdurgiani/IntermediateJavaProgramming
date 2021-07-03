package CollectionsFramework;

import java.util.HashSet;
import java.util.Set;

public class CollectionsHashSet {
    public static void main(String[] args) {
        Set<String> vaccineFirstDoseRemaining = new HashSet<>();

        //adding elements
        vaccineFirstDoseRemaining.add("Ritesh");
        vaccineFirstDoseRemaining.add("Tushar");
        vaccineFirstDoseRemaining.add("Sakshi");
        vaccineFirstDoseRemaining.add("Vivek");

        System.out.println(vaccineFirstDoseRemaining);

        vaccineFirstDoseRemaining.remove("Tushar");
        System.out.println(vaccineFirstDoseRemaining);
        System.out.println(vaccineFirstDoseRemaining.contains("Ritesh"));

        System.out.println(vaccineFirstDoseRemaining.size());
        System.out.println(vaccineFirstDoseRemaining.isEmpty());




    }
}
