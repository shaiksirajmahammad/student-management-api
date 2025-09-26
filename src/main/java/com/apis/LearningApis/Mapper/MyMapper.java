package com.apis.LearningApis.Mapper;

import com.apis.LearningApis.DTO.Student;
import com.apis.LearningApis.Enity.Studententity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
