package School;

import java.util.Comparator;

public class StudentComparator {

    // Comparator to sort by name
    public static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareToIgnoreCase(s2.getName());
        }
    }

    // Comparator to sort by roll number
    public static class RollNoComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.getRollno(), s2.getRollno());
        }
    }
}
