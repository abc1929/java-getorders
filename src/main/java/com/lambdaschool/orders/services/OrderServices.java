package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.views.CustomersOrderCounts;

import java.util.List;

public interface OrderServices {


//   http://localhost:2019/orders/order/9

   Order getOrderByID(long orderid);
//   http://localhost:2019/orders/advanceamount

   List<Order> getAdvanceAmounts();

   Order save(Order order);
}

