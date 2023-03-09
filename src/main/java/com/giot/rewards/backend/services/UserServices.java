package com.giot.rewards.backend.services;
import com.giot.rewards.backend.models.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.giot.rewards.backend.models.entities.User;


public class UserServices extends User{

    public UserServices(User user) {

        this.setPoints(user.getPoints());
    }

    public Integer addPoints(Double amount) {

        Integer points = (int) Math.floor(amount * (.10));

        Integer currentPoints = this.getPoints();

        this.setPoints(currentPoints + points);
 
        return this.getPoints();
    }

    
}