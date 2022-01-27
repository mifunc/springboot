package com.rumenz.lession5.controller.repository;

import com.rumenz.lession5.controller.entity.Rumenz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @className: AnnotationRepository
 * @description: TODO 类描述
 * @author: mac
 * @date: 2021/11/4
 **/

@Repository
public interface RumenzRepository extends JpaRepository<Rumenz,Integer> {

    @Query("select new Rumenz (z.id,z.name) from Rumenz z")
    List<Rumenz> getList();

}
