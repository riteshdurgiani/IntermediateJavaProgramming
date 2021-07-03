package CollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsClass {

    public static void main(String[] args) {
        List<Integer> demo = new ArrayList<>();
        demo.add(23);
        demo.add(22);
        demo.add(45);
        demo.add(89);
        demo.add(2);
        demo.add(43);


        System.out.println(Collections.min(demo));
        System.out.println(Collections.max(demo));
        System.out.println(Collections.frequency(demo,22));
        System.out.println(Collections.reverseOrder());

        Collections.sort(demo);
        System.out.println(demo);

        Collections.sort(demo, Comparator.reverseOrder());
        System.out.println(demo);


        List<Vaccination> toVaccinate = new ArrayList<>();
        //need to make the used class implement Comparable interface
        //override the method compareTo
        //compare it based on the field you want to sort
        toVaccinate.add(new Vaccination(303,"Ritesh"));
        toVaccinate.add(new Vaccination(909,"Tushar"));
        toVaccinate.add(new Vaccination(306,"Ritesh"));


        //this method internally uses compareTo method of the class
        Collections.sort(toVaccinate);
        System.out.println(toVaccinate);

        //another way to implement sorting
        //if you want to sort based on field other than that specified in the overridden compare to method
        //of the Comparable interface
        //use this type , pass Comparator as an anonymous class and then override the compareTo method
        Collections.sort(toVaccinate, new Comparator<Vaccination>() {
            @Override
            public int compare(Vaccination o1, Vaccination o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(toVaccinate);


        //using Lambda another way inroduced after jav a 8

        Collections.sort(toVaccinate, (o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println(toVaccinate);


    }
}
