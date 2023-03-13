package com.giot.rewards.backend.services;

import org.springframework.stereotype.Service;

@Service
public interface IUserServices {
    public Integer calculatePoints(Double amount);
}
