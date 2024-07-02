package com.example.zhbe.repositories;

import com.example.zhbe.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Category,Integer> {

}
