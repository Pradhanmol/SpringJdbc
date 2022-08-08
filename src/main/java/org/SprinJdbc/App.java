package org.SprinJdbc;

import org.SprinJdbc.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "My Program Started....................." );
        //SpringJdbc=> jdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        //This one is for config.xml file where we tell the file path & then tell the which bean you want to take
     /*   ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        //this is for taking input from user
        InputStreamReader inputObject = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputObject);*/
        //for inserting the data in table
/*        Student student= new Student();
        student.setId(116);
        student.setName("Harsit Goel");
        student.setCity("New Delhi");
        student.setPincode(110089);
        int result = studentDao.insert(student);
        System.out.println("Student"+result);*/
        //for updating the data in table
/*        Student student = new Student();
        student.setName("Vivek Kumar");
        student.setCity("New delhi");
        student.setId(113);
        int result = studentDao.change(student);
        System.out.println("One student get updated"+result);*/
/*        Student student = new Student();
        student.setId(113);
        int result = studentDao.delete(student);
        System.out.println("One student get deleted"+result);*/

/*        //Inserting the data through user input
        Student student= new Student();
        System.out.println("Enter the userId :-\n");
        student.setId(Integer.parseInt(br.readLine()));
        System.out.println("Enter the userName :-\n");
        student.setName(br.readLine());
        System.out.println("Enter the City :-\n");
        student.setCity(br.readLine());
        System.out.println("Enter the pincode of city :-\n");
        student.setPincode(Integer.parseInt(br.readLine()));
        int result = studentDao.insert(student);
        System.out.println("Student"+result);*/

        //Get the data from table by select
/*        System.out.println("Enter the user id :-\n");
        Student student= studentDao.getStudent(Integer.parseInt(br.readLine()));
        System.out.println(student);*/
        //For getting all the data from student table
        List<Student> students = studentDao.getAllStudent();
        for(Student s:students){
            System.out.println(s);
        }
    }
}
