package com.project.comgle.admin.repository;

import com.project.comgle.admin.entity.Category;
import com.project.comgle.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category,Long> {

    Optional<Category> findByCategoryNameAndCompany(String categoryName, Company company);
    List<Category> findAllByCompany(Company company);

}