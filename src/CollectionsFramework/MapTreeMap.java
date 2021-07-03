package CollectionsFramework;

import java.util.Map;
import java.util.TreeMap;

public class MapTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> toVaccinate = new TreeMap<>();
        //only difference : printing and storing in sorted order based on keys
        //adding elements
        toVaccinate.put(301,"Ritesh");
        toVaccinate.put(302,"Rakesh");
        toVaccinate.put(304,"Suresh");

        //same key , it will override the value
        toVaccinate.put(302,"Rajesh");
        //same key but will now not update
        toVaccinate.putIfAbsent(302,"Rakesh");
        System.out.println(toVaccinate);


        //iterating over the entries
        for(Map.Entry<Integer,String> v : toVaccinate.entrySet()){
            System.out.println(v.getKey() + " " + v.getValue());
        }

        //for iterating only over keys
        for(Integer i:toVaccinate.keySet()){
            System.out.println(i);
        }

        //for iterating only over values
        for(String v : toVaccinate.values()){
            System.out.println(v);
        }
        //checks idf key is present
        System.out.println(toVaccinate.containsKey(302));
        //checks if value is present
        System.out.println(toVaccinate.containsValue("Rinky"));
        //gets a value of particular key
        System.out.println(toVaccinate.get(301));
        //checks if it is empty
        System.out.println(toVaccinate.isEmpty());
        //removes element corresponding to key
        System.out.println(toVaccinate.remove(301));
        //replaces the value of given key with new value
        System.out.println(toVaccinate.replace(302,"Rakesh"));
        //empties the map
        toVaccinate.clear();
    }
}
