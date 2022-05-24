package com.example.demo3.controllers;

import com.example.demo3.models.Classes;
import com.example.demo3.models.Student;
import com.example.demo3.repositories.ClassRepository;
import com.example.demo3.repositories.StudentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;


/**
 * com.example.demo3.controllers;
 * Created by Phuoc -19127520
 * Date 24/04/2022 - 10:19 CH
 * Description: ...
 */
@Controller
@RequestMapping(path="students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;
    Configuration configuration=new Configuration();
    SessionFactory sessionFactory=configuration.configure().buildSessionFactory();

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getAllStudents(ModelMap modelMap){
//        modelMap.addAttribute("name","Phuoc");
//        modelMap.addAttribute("age", 18);
       // Iterable<Student> students=studentRepository.findAll();

        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            List<Student> studentList=session.createQuery("FROM Student").list();
            modelMap.addAttribute("students",studentList);
            transaction.commit();
        }catch (HibernateException e){
            if(transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return "student";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudentById(ModelMap modelMap,@PathVariable Long id){
//        Optional<Student> student=studentRepository.findById(id);
//        if(student.isPresent()){
//            Student std=student.get();
//            modelMap.addAttribute("student_detail",std);
//        }
//        else modelMap.addAttribute("student_detail",new Student());
        Session session=sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            List<Student> student=session.createQuery("FROM Student E where E.id="+id).list();
            tx.commit();
            if(!student.isEmpty())
                modelMap.addAttribute("student_detail", student.get(0));
            else
                modelMap.addAttribute("student_detail", new Student());

        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return"student_detail";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editStudent(ModelMap modelMap, @PathVariable long id){
//        Optional<Student> student=studentRepository.findById(id);
//        Iterable<Classes> classes=classRepository.findAll();
//
//        modelMap.addAttribute("classes", classes);
//        modelMap.addAttribute("student",student.get());

        Session session=sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            List<Student> student=session.createQuery("from Student E where E.id="+id).list();
            List<Classes> classes=session.createQuery("from Classes").list();
            tx.commit();
            modelMap.addAttribute("classes", classes);
            modelMap.addAttribute("student", student.get(0));
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return "edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateStudent(ModelMap modelMap, @PathVariable long id, @ModelAttribute("student") Student student){
//        Student student1=studentRepository.findById(id).get();
//        if(student.getName()!=null) student1.setName(student.getName());
//        if(student.getMark()>=0) student1.setMark(student.getMark());
//        if(student.getAddress()!=null) student1.setAddress(student.getAddress());
//        if(student.getNote()!=null) student1.setNote(student.getNote());
//        if(student.getImage()!=null) student1.setImage(student.getImage());
//        if(student.getIdclass()!=null) student1.setIdclass(student.getIdclass());
//        System.out.println(student);
//        studentRepository.save(student1);
        Session session=sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            student.setId(id);
            session.update(student);
            tx.commit();

        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return "redirect:/students/"+student.getId();
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable long id){
        Session session=sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            List<Student> student=session.createQuery("from Student E where E.id="+id).list();
            session.delete(student.get(0));
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return "redirect:/students";
    }
}
