package com.github.tulliocba.money.api.repository;

import com.github.tulliocba.money.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
