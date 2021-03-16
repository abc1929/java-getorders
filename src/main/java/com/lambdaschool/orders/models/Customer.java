package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long CUSTCODE;  // primary key, not null Long
   private String CUSTNAME;  //not null
   private String CUSTCITY;
   private String WORKINGAREA;
   private String CUSTCOUNTRY;
   private String GRADE;
   private double OPENINGAMT;


   public long getCUSTCODE() {
      return CUSTCODE;
   }

   public void setCUSTCODE(long CUSTCODE) {
      this.CUSTCODE = CUSTCODE;
   }

   public String getCUSTNAME() {
      return CUSTNAME;
   }

   public void setCUSTNAME(String CUSTNAME) {
      this.CUSTNAME = CUSTNAME;
   }

   public String getCUSTCITY() {
      return CUSTCITY;
   }

   public void setCUSTCITY(String CUSTCITY) {
      this.CUSTCITY = CUSTCITY;
   }

   public String getWORKINGAREA() {
      return WORKINGAREA;
   }

   public void setWORKINGAREA(String WORKINGAREA) {
      this.WORKINGAREA = WORKINGAREA;
   }

   public String getCUSTCOUNTRY() {
      return CUSTCOUNTRY;
   }

   public void setCUSTCOUNTRY(String CUSTCOUNTRY) {
      this.CUSTCOUNTRY = CUSTCOUNTRY;
   }

   public String getGRADE() {
      return GRADE;
   }

   public void setGRADE(String GRADE) {
      this.GRADE = GRADE;
   }

   public double getOPENINGAMT() {
      return OPENINGAMT;
   }

   public void setOPENINGAMT(double OPENINGAMT) {
      this.OPENINGAMT = OPENINGAMT;
   }

   public double getRECEIVEAMT() {
      return RECEIVEAMT;
   }

   public void setRECEIVEAMT(double RECEIVEAMT) {
      this.RECEIVEAMT = RECEIVEAMT;
   }

   public double getPAYMENTAMT() {
      return PAYMENTAMT;
   }

   public void setPAYMENTAMT(double PAYMENTAMT) {
      this.PAYMENTAMT = PAYMENTAMT;
   }

   public double getOUTSTANDINGAMT() {
      return OUTSTANDINGAMT;
   }

   public void setOUTSTANDINGAMT(double OUTSTANDINGAMT) {
      this.OUTSTANDINGAMT = OUTSTANDINGAMT;
   }

   public String getPHONE() {
      return PHONE;
   }

   public void setPHONE(String PHONE) {
      this.PHONE = PHONE;
   }


   private double RECEIVEAMT;
   private double PAYMENTAMT;
   private double OUTSTANDINGAMT;
   private String PHONE;


   @ManyToOne()
   @JoinColumn(name =  "AGENTCODE", nullable = false)
   private Agent agent;


   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Order> orders = new ArrayList<>();

   public List<Order> getOrders() {
      return orders;
   }


   // AGENTCODE oreign key (one agent to many customers) not null

   @JsonIgnoreProperties(value = "customers", allowSetters = true)
   public Agent getAgent() {
      return agent;
   }

   public void setAgent(Agent agent) {
      this.agent = agent;
   }


   public Customer(String CUSTNAME, String CUSTCITY, String WORKINGAREA, String CUSTCOUNTRY, String GRADE, double OPENINGAMT, double RECEIVEAMT, double PAYMENTAMT, double OUTSTANDINGAMT, String PHONE, Agent agent) {
      this.CUSTNAME = CUSTNAME;
      this.CUSTCITY = CUSTCITY;
      this.WORKINGAREA = WORKINGAREA;
      this.CUSTCOUNTRY = CUSTCOUNTRY;
      this.GRADE = GRADE;
      this.OPENINGAMT = OPENINGAMT;
      this.RECEIVEAMT = RECEIVEAMT;
      this.PAYMENTAMT = PAYMENTAMT;
      this.OUTSTANDINGAMT = OUTSTANDINGAMT;
      this.PHONE = PHONE;
      this.agent = agent;
   }

   public Customer() {
   }


}
