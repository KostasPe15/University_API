package com.example.universityapi.student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> studentList;

    public StudentService() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public List<Student> getAllStudents() {
        return this.studentList;
    }

    public Student getStudentByID(long id){
        Student astudent = studentList.stream()
                .filter(student -> student.getID().equals(id))
                .findFirst().get();
        return astudent;
    }

    public Student updateStudent(int id, Student updatedStudent) {
        for(Student student : studentList){
            if(student.getID()==id){
                if(!student.getFirstName().equals(updatedStudent.getFirstName())&&updatedStudent.getFirstName()!=null)
                    student.setFirstName(updatedStudent.getFirstName());
                if(!student.getLastName().equals(updatedStudent.getLastName())&&updatedStudent.getLastName()!=null)
                    student.setLastName(updatedStudent.getLastName());

                return student;
            }
        }
        return new Student();
    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = null;
        for(Student student:studentList){
            if(student.getID()==id)
                studentToBeDeleted = student;
        }
        if(studentToBeDeleted!=null)
            studentList.remove(studentToBeDeleted);
    }
}
