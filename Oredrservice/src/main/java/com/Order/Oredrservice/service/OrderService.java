package com.Order.Oredrservice.service;

import com.Order.Oredrservice.entity.Order;
import com.Order.Oredrservice.repository.OrderRepo;
import com.Order.Oredrservice.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    // Get ServiceInstance list using serviceId
    ServiceInstance serviceInstance = loadBalancerClient.choose("ADDRESS-SERVICE");
    // Read URI and Add path that returns url
    String uri = serviceInstance.getUri().toString();
    // Get metadata
    String contextPath = serviceInstance.getMetadata().get("configPath");
  //  private Object Id;
    // Make HTTP call and get Response data
    OrderResponse orderResponse = restTemplate.getForObject(uri + contextPath + "/Order/{Id}", OrderResponse.class, id);

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper mapper;



    public OrderResponse findUserByUserId(int  userId) {
        Optional<Order> orderByUserId = orderRepo.findUserByUserId(userId);
        OrderResponse orderResponse = mapper.map(orderByUserId, OrderResponse.class);
        return orderResponse;
    }







}
