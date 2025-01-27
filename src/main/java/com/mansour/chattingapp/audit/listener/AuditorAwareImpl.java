package com.mansour.chattingapp.audit.listener;

import org.springframework.data.domain.AuditorAware;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return SecurityUtil.getCurrentUserId();
    }
}
