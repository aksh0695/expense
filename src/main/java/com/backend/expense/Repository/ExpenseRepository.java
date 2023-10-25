package com.backend.expense.Repository;

import com.backend.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

    @Query(value = "SELECT * FROM expense WHERE   user_user_id = ?1", nativeQuery = true)
    List<Expense> findByUserId(Integer userId);
}
