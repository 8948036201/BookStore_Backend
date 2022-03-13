package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO addOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderDetails();

}
