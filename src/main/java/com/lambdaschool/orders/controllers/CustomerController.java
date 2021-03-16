package com.lambdaschool.orders.controllers;


import com.lambdaschool.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.function.Predicate;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {


   @Autowired
   private CustomerServices customerServices;


   @GetMapping(value = "/{all}", produces = "application/json")
   public ResponseEntity<?> getAllOrders(@PathVariable String all){
      String [] a = {"orders", "customers", "all"};
//      System.out.println(all);
      if (Arrays.stream(a).anyMatch(Predicate.isEqual(all))) {
         return new ResponseEntity<>( customerServices.getAllOrders(), HttpStatus.OK);
      } else {
         return new ResponseEntity<>( "nothing", HttpStatus.OK);
      }
   }


   @GetMapping(value = "/customer/{cusid}", produces = "application/json")
   public ResponseEntity<?> getCustomerById(@PathVariable long cusid){

      return new ResponseEntity<>(customerServices.getCustomerById(cusid), HttpStatus.OK);

   }

   @GetMapping(value = "/namelike/{term}", produces = "application/json")
   public ResponseEntity<?> getCustomersByName(@PathVariable String term){

      return new ResponseEntity<>(customerServices.getCustomersByName(term), HttpStatus.OK);

   }


   @GetMapping(value =  "/orders/count", produces = "application/json")
   public ResponseEntity<?> getOrderCountsByCustomers(){
      return new ResponseEntity<>(customerServices.getCustomersOrderCounts(),HttpStatus.OK);
   }


}
