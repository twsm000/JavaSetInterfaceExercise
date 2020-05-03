package application;

import java.util.Iterator;
import java.util.Scanner;

import model.entities.Course;
import model.entities.Instructor;
import model.entities.Student;
import model.services.StudentCountService;

/* Em um portal de cursos online, cada usuário possui um código único, representado por um número inteiro.
 * 
 * Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se matricular em quantos cursos quiser.
 * Assim, o número total de alunas de um instrutor não é simplesmente a sema dos alunos de todos os cursos que ele possui, 
 * pois pode haver alunos repetidos em mais de um curso.
 * 
 * O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
 * 
 * Seu programa deve ler os alunos dos cursos A, B e C do instruturo Alex, depois mostrar a quantidade total e alunos dele, 
 * conforme o exemplo.
 * */

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        try {
            System.out.println("Enter the instructor id: ");
            int id = scan.nextInt();
            scan.nextLine();
            
            System.out.println("Enter the instructor name: ");
            String name = scan.next();
            
            Instructor instructor = new Instructor(id, name);             
            StudentCountService countService = new StudentCountService(instructor); 
            
            System.out.println("Total of courses to insert: ");
            int courseCount = scan.nextInt();
            
            for (int i = 1; i <= courseCount; i++) {
                System.out.println("Enter the course name: ");
                Course course = new Course(scan.next(), instructor);
                
                System.out.println("How may students for course " + course.getName() + "?");
                int studentCount = scan.nextInt();
                
                for (int j = 1; j <= studentCount; j++) {
                    System.out.println("Enter the student id: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    
                    System.out.println("Enter the student name: ");
                    name = scan.next();
                    course.enroll(new Student(id, name));
                }
                
                countService.unionAll(course);                
            }
            
            System.out.println(countService.getInstructor());
            System.out.println("Enrolled students: " + countService.count());
            
            Iterator<Student> students = countService.getStudents();
            while (students.hasNext()) {
                System.out.println(students.next());
            }
        } 
        finally {
            scan.close();
        }
    }
}
