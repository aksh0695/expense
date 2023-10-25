package com.backend.expense.controller;

import com.backend.expense.Repository.ExpenseRepository;
import com.backend.expense.Repository.UserRepository;
import com.backend.expense.constants.Endpoints;
import com.backend.expense.entity.Expense;
import com.backend.expense.entity.TransactionObjects;
import com.backend.expense.entity.TransactionType;
import com.backend.expense.entity.User;
import com.backend.expense.service.SplitwiseService;
import com.backend.expense.utils.SplitwiseClient;
import com.github.scribejava.core.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

@CrossOrigin(
        origins = {
                "http://localhost:4200"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("/v1/expense")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    SplitwiseService splitwiseService;

    @PostMapping("/create")
    private ResponseEntity<String> createExpense(@RequestBody Expense expense){
        Expense res = expenseRepository.save(expense);
        return ResponseEntity.ok(res.toString());
    }
    @GetMapping("/all/{id}")
    private ResponseEntity<List<TransactionObjects>> getExpenses(@PathVariable Integer id) throws Exception {
        User user = userRepository.getById(id);
        ResponseEntity<Object> spliwiseExpenses = splitwiseService.getExpensesForUser(user);
           List<LinkedHashMap> expensesList = (List<LinkedHashMap>) ((LinkedHashMap)spliwiseExpenses.getBody()).get("expenses");
           List<TransactionObjects> transactionData = new ArrayList<>();
           for(LinkedHashMap expense : expensesList){
               TransactionObjects transactionObjects = new TransactionObjects();
               transactionObjects.setTransactionId(BigInteger.valueOf((Long) expense.get("id")));
               transactionObjects.setTransactionDetail((String) expense.get("description"));
               transactionObjects.setTransactionType(TransactionType.EXPENSE);
               final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
               transactionObjects.setTransactionDate(sdf.parse((String)expense.get("date")));
               transactionObjects.setTrasactionCost(Double.valueOf( (String)expense.get("cost")));
               transactionObjects.setTransactionCategory((String) ((LinkedHashMap)expense.get("category")).get("name"));
               transactionData.add(transactionObjects);
           }
        List<Expense> expenses = expenseRepository.findByUserId(user.getUserId());
        for(Expense expense : expenses){
            TransactionObjects transactionObjects = new TransactionObjects();
            transactionObjects.setTransactionDetail(expense.getDetail());
            transactionObjects.setTransactionId(BigInteger.valueOf(expense.getId().intValue()));
            transactionObjects.setTransactionDate(expense.getTransactionDate());
            transactionObjects.setTransactionType(expense.getTransactionType());
            transactionObjects.setTransactionCategory(expense.getCategory());
            transactionObjects.setTrasactionCost(expense.getCost());
            transactionData.add(transactionObjects);
        }
        return ResponseEntity.ok(transactionData);
    }
}
