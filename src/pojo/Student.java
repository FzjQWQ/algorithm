package pojo;

/**
 * @author roy f
 */
public class Student implements Comparable<Student>{
    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {
        if (student == null) {
            return false;
        }
        if (this.getClass() != student.getClass()) {
            return false;
        }
        if (student == this) {
            return true;
        }
        final Student student1 = (Student) student;
        return this.name.equals(student1.name);
    }


    @Override
    public int compareTo(Student o) {
//        if (this.score < o.score) {
//            return -1;
//        } else if (this.score == o.score) {
//            return 0;
//        } else {
//            return 1;
//        }
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", this.name, this.score);
    }
}
