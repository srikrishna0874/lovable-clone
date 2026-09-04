package com.springboot.lovable_clone.service.impl;

import com.springboot.lovable_clone.dto.subscription.PlanResponse;
import com.springboot.lovable_clone.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
