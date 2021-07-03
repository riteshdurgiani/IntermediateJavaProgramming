package CollectionsFramework;

import java.util.Objects;

public class Vaccination implements Comparable<Vaccination>{
    String name;
    int uniqueAadharIdCode;

    public Vaccination(int uniqueAadharIdCode,String name) {
        this.uniqueAadharIdCode = uniqueAadharIdCode;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vaccination{" +
                "name='" + name + '\'' +
                ", uniqueAadharIdCode=" + uniqueAadharIdCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return uniqueAadharIdCode == that.uniqueAadharIdCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueAadharIdCode);
    }


    @Override
    public int compareTo(Vaccination o) {
        return this.uniqueAadharIdCode - o.uniqueAadharIdCode;
    }
}
