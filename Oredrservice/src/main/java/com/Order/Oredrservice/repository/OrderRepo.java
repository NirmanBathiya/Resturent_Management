package com.Order.Oredrservice.repository;

import com.Order.Oredrservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
    @Query(
            nativeQuery = true,
            value
                    = "SELECT ea.Oid, ea.Name FROM resturent_managrment.order ea join resturent_managrment.user e on e.Oid = ea.Id where ea.Id=:userId")
     Optional<Order> findUserByUserId(@Param("UserId") int userId);


}





