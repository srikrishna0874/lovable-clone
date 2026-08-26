package com.springboot.lovable_clone.service;

import com.springboot.lovable_clone.dto.subscription.PlanLimitResponse;
import com.springboot.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsage(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
