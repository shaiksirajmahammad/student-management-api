package com.apis.LearningApis.Service;

import com.apis.LearningApis.DTO.Student;
import com.apis.LearningApis.Enity.Studententity;
import com.apis.LearningApis.Mapper.MyMapper;
import com.apis.LearningApis.Mapper.MyMapper;
import com.apis.LearningApis.Repository.repo;
//import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    repo data;
    @Autowired
    ModelMapper mapper;


    public List<Student> getAllStudents() {
        List<Student>list=new ArrayList<>();
       List<Studententity>obj=data.findAll();
       for(Studententity i:obj){
           Student std=mapper.map(i,Student.class);
            list.add(std);
       }
       return list;
    }

    public Student addStudent(Student std) {
       Studententity e= data.save(mapper.map(std,Studententity.class));
        return mapper.map(e,Student.class);
    }

    public Student getStudent(int id) {

        return mapper.map(data.findById(id).orElseThrow(()->new IllegalArgumentException("no such id")),Student.class);
    }

    public void deleteStudent(int id) {
//        return mapper.map(data.findById(id).orElseThrow(()->new IllegalArgumentException("no such id")),Student.class);
        if(!data.existsById(id)){
            throw new IllegalArgumentException("no such id");
        }
        data.deleteById(id);

    }

    public Student put(int id, Student obj) {
      Studententity std=  data.findById(id).orElseThrow(()->new IllegalArgumentException("no such id"));
      std.name=obj.getName()!=null? obj.getName():std.name;
      std.email=obj.getEmail()!=null? obj.getEmail():std.email;
      std=data.save(std);
      return mapper.map(std,Student.class);
    }

    public Student update(int id, Map<Object, Object> hash) {
        Studententity std=data.findById(id).orElseThrow(()->new IllegalArgumentException("no such id"));
        for(Object i:hash.keySet()){
            String j=(String) i;
            switch (j) {
                case "name":
                    std.name = (String) hash.get(i);
                    break;
                case "email":
                    std.email = (String) hash.get(i);
                    break;
                default:
                    throw new IllegalArgumentException("no such field");

            }


        }
        std=data.save(std);
        return mapper.map(std,Student.class);

    }
}
