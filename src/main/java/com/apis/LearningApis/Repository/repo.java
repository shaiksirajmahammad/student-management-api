package com.apis.LearningApis.Repository;

import com.apis.LearningApis.Enity.Studententity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<Studententity,Integer> {

}
