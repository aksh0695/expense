package com.backend.expense.controller;

import com.backend.expense.Model.ResponseModel;
import com.backend.expense.Repository.UserRepository;
import com.backend.expense.constants.Endpoints;
import com.backend.expense.entity.User;
import com.backend.expense.utils.SplitwiseClient;
import com.github.scribejava.core.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(
        origins = {
                "http://localhost:4200",
                "http://localhost:8080"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("/v1/user")

public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/all")
    private ResponseEntity<String> getUser() throws Exception {
        SplitwiseClient splitwiseClient = new SplitwiseClient();
        //String response = splitwiseClient.makeRequest(Endpoints.GET_GROUPS, Verb.GET);
        List<User> users = userRepository.findAll();
         String response = users.get(0).toString();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    private ResponseEntity<String> createUser(@RequestBody User user) throws Exception {

        User res = userRepository.save(user);
        return ResponseEntity.ok(res.toString());
    }
    
    @PostMapping("/authenticate")
    private ResponseEntity<ResponseModel> authenticateUser(@RequestBody User user) throws Exception{
    	ResponseModel<User> responseModel = new ResponseModel();
    	List<User> input = userRepository.findByEmail(user.getEmail());
    	if(input.size() > 0 && input.get(0).getPassword().equals(user.getPassword())) {
    		
    		responseModel.setHttpStatus(HttpStatus.OK);
    		responseModel.setResponseMessage("Successfully Authenticated");
    		responseModel.setResponseStatus("SUCCESS");
    		responseModel.setResponseBody(input.get(0));
    		return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    	}else {
    		responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
    		responseModel.setResponseMessage("Invalid Credentials Provided");
    		responseModel.setResponseStatus("FAILURE");
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseModel);
    	}
    }
}
