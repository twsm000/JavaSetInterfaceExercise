package model.services;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import model.entities.Course;
import model.entities.Instructor;
import model.entities.Student;

public class StudentCountService {

    private Instructor instructor;
    private Set<Student> students = new TreeSet<>();
    
    public StudentCountService(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        if (this.instructor.equals(instructor))
            return;
        
        this.instructor = instructor;
        students.clear();
    }
    
    public void unionAll(Course course) {
        if (!course.getInstructor().equals(instructor))
            return;
        
        students.addAll(course.getStudents());
    }
    
    public int count() {
        return students.size();
    }
    
    public Iterator<Student> getStudents() {
        return students.iterator();
    }
}
