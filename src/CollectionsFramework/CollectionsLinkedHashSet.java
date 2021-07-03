package CollectionsFramework;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionsLinkedHashSet {
    public static void main(String[] args) {
        Set<String> vaccineFirstDoseRemaining = new LinkedHashSet<>();
        //adding elements and printing in order as maintains a doubly linked list

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
