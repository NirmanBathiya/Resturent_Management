package com.User.Userservice.service;

import com.Order.Oredrservice.response.OrderResponse;
import com.User.Userservice.entity.User;
import com.User.Userservice.repository.UserRepo;
import com.User.Userservice.response.UserReponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public UserReponse getUserById(int Id){
        Optional<User> user = userRepo.findById(Id);
        UserReponse userReponse =mapper.map(user,UserReponse.class);

        //get serviceInstance list using serviceId
        ServiceInstance serviceInstance = loadBalancerClient.choose("Oredrservice");
        //read url and add path that returns url
        String uri = serviceInstance.getUri().toString();

        //get metadata
        String contexpath = serviceInstance.getMetadata().get("configpath");

        // make HTTP call and get response data
        OrderResponse orderResponse = restTemplate.getForObject(uri + contexpath + "/order/{userId}",OrderResponse.class,id);

        userReponse.setOrderResponse (orderResponse);
        return userReponse;


    }
}
