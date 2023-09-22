package com.project.springapistudy.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity,Integer> {
    @Query("SELECT p FROM MenuEntity p ORDER BY p.name DESC")
    List<MenuEntity> findAllDesc();
}
