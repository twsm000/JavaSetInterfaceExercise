package model.entities;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private String name;
    private Instructor instructor;
    private Set<Student> students = new HashSet<>();
    
    public Course(String name, Instructor instructor) {
        this.name = name;
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (instructor == null) {
            if (other.instructor != null)
                return false;
        } else if (!instructor.equals(other.instructor))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
           
    @Override
    public String toString() {
        return "Course [name=" + name + ", instructor=" + instructor + "]";
    }

    public void enroll(Student student) {
        students.add(student);
    }
    
    public void leave(Student student) {
        students.remove(student);
    }
    
    public Set<Student> getStudents() {
        return new HashSet<Student>(students);
    }
}
