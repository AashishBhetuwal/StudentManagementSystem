/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.StudentManagementSystem.StudentDAOImpl;

import com.leapfrog.StudentManagementSystem.Student.Student;
import com.leapfrog.StudentManagementSystem.StudentDAO.StudentDao;


public class StudentDaoImpl implements StudentDao {
private int counter=0;
private Student[] studentList=new Student[5];
        
    @Override
    public boolean insert(Student s) {
        if(counter==studentList.length)
        {
            return false;
        }
        studentList[counter]=s;
        return true;
    }

    @Override
    public boolean update(Student s) {
        return true;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<=studentList.length;i++)
        {
       
            Student s=studentList[i];
            if(s!=null && s.getId()==id)
            {
                s=null;
                return true;
            }
            
        }
    return false;
    }

    @Override
    public Student getById(int id) {
        for (int i=0;i<studentList.length;i++){
            Student s=studentList[i];
            if(s!=null && s.getId()==id)
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public Student[] getAll() {
        return studentList;
        
    }
    
}
