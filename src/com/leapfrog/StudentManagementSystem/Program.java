/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.StudentManagementSystem;

import com.leapfrog.StudentManagementSystem.Student.Student;
import com.leapfrog.StudentManagementSystem.StudentDAO.StudentDao;
import com.leapfrog.StudentManagementSystem.StudentDAOImpl.StudentDaoImpl;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        StudentDao studentDao = new StudentDaoImpl();
        while (true) {

            System.out.println("1. Add Students");
            System.out.println("2. Update Students");
            System.out.println("3. Delete Students");
            System.out.println("4. See all Students");
            System.out.println("5. Search Students by ID");
            System.out.println("6. Exit");
            System.out.println("Enter you1r choice:[1-5]");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Adding students:");
                    Student s = new Student();
                    System.out.println("Please enter Student ID:");
                    s.setId(sc.nextInt());
                    System.out.println("Please enter Name:");
                    s.setName(sc.next());
                    System.out.println("Please enter Address:");
                    s.setAddress(sc.next());

                    System.out.println("Please enter Age:");
                    s.setAge(sc.nextInt());
                    System.out.println("Please enter Contact Number:");
                    s.setContactno(sc.next());
                    System.out.println("Please enter Student's level:");
                    s.setLevel(sc.next());
                    System.out.println("Please enter the course:");
                    s.setCourse(sc.next());
                    if (studentDao.insert(s)) {
                        System.out.println("Value Inserted!");
                    } else {
                        System.out.println("Cannot Insert the value.");
                    }

                    break;
                case 2:

                    break;
                case 3:
                    System.out.print("Enter student id to be deleted: ");
                    if (studentDao.delete(sc.nextInt())) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Null Student id. Cannot be deleted. ");
                    }

                    break;
                case 4:
                    System.out.println("displaying all the students");
                    Student[] studentlist = studentDao.getAll();
                    for (int i = 0; i <= studentlist.length; i++) {
                        if (studentlist != null) {
                            System.out.println("Student's ID:" + studentlist[i].getId());
                            System.out.println("Student's Name:" + studentlist[i].getName());
                            System.out.println("Student's Age:" + studentlist[i].getAge());
                            System.out.println("Student's Contact Number:" + studentlist[i].getContactno());
                            System.out.println("Student's Address:" + studentlist[i].getAddress());
                            System.out.println("Student's Level:" + studentlist[i].getLevel());
                            System.out.println("Student's Course:" + studentlist[i].getCourse());
                            
                        }
                    }

                    break;
                case 5:
                    System.out.println("Please enter the student's Id:");
                    System.out.println("");
                    
                    Student student=studentDao.getById(sc.nextInt());
                    if(student!=null)
                    {
                       System.out.println("Student's ID:" + student.getId());
                            System.out.println("Student's Name:" + student.getName());
                            System.out.println("Student's Age:" + student.getAge());
                            System.out.println("Student's Contact Number:" + student.getContactno());
                            System.out.println("Student's Address:" + student.getAddress());
                            System.out.println("Student's Level:" + student.getLevel());
                            System.out.println("Student's Course:" + student.getCourse()); 
                    }
                    else{
                        System.out.println("Student could not be found.");
                    }
                    break;
                    
                case 6:
                    System.exit(0);
                    break;
            }

        }

    }
}
