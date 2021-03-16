package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.CustomersRepository;
import com.lambdaschool.orders.views.CustomersOrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
@Service(value = "customerservice")
public class CustomerServicesImpl implements CustomerServices {



   @Autowired
   private CustomersRepository customersRepository;


   @Override
   public List<Customer> getAllOrders(){
      return StreamSupport.stream(customersRepository.findAll().spliterator(), false).collect(Collectors.toList());
   }


   @Override
   public Customer getCustomerById(long cusid){

      return customersRepository.findById(cusid).orElseThrow(() -> new EntityNotFoundException("Customer "+cusid + " Not Found"));
   }
   @Override
   public List<Customer> getCustomersByName(String term){
      return StreamSupport.stream(customersRepository.findAll().spliterator(),false).filter(i -> i.getCUSTNAME().matches("(?i)^.*"+term+".*$")).collect(Collectors.toList());
   }


   @Override
   public List<CustomersOrderCounts> getCustomersOrderCounts(){
      System.out.println(customersRepository.getCustomersOrderCounts());
      return customersRepository.getCustomersOrderCounts();}

   @Transactional
   @Override
   public Customer save(Customer customer) {
      return customersRepository.save(customer);
   }


}
