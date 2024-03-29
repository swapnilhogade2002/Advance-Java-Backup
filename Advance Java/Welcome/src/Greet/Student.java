package Greet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stud implements Comparable<Stud> {
    int no, marks;
    String name;

    public Stud(int no, int marks, String name) {
        super();
        this.no = no;
        this.marks = marks;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stud [no=" + no + ", marks=" + marks + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Stud other) {
        // You can specify your sorting logic here
        // For example, you can sort by 'marks' in ascending order
        return Integer.compare(this.marks, other.marks);
    }
}

public class Student {

    public static void main(String[] args) {
        List<Stud> studs = new ArrayList<>();
        studs.add(new Stud(1, 99, "swapnil"));
        studs.add(new Stud(2, 89, "swara"));
        studs.add(new Stud(3, 88, "swapnil"));

        Collections.sort(studs);

        for (Stud s : studs) {
            System.out.println(s);
        }
    }
}
