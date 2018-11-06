package com.springinaction.pizza.domain;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
   private static final long serialVersionUID = 1L;
   private Customer customer;
   private List<Pizza> pizzas;
   private Payment payment;
 
   public Order() {
      pizzas = new ArrayList<Pizza>();
      customer = new Customer();
   }
 
   //getters and setters
}