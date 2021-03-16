package com.lambdaschool.orders.controllers;


import com.lambdaschool.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {


   @Autowired
   private OrderServices orderServices;


   @GetMapping(value = "/order/{orderid}", produces = "application/json")
   public ResponseEntity<?> getCustomerById(@PathVariable long orderid){

      return new ResponseEntity<>(orderServices.getOrderByID(orderid), HttpStatus.OK);

   }


   @GetMapping(value = "/order/advanceamount", produces = "application/json")
   public ResponseEntity<?> getAdvanceAmounts(){

      return new ResponseEntity<>(orderServices.getAdvanceAmounts(), HttpStatus.OK);

   }


}
