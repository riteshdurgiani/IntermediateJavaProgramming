package StreamAPIsJava;

public class Employee1 {
    private String name;
    private int getAge;

    public Employee1(String name, int getAge) {
        this.name = name;
        this.getAge = getAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGetAge() {
        return getAge;
    }

    public void setGetAge(int getAge) {
        this.getAge = getAge;
    }

    @Override
    public String toString() {
        return name;
    }
}
