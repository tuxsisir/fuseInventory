package com.fuse.fuseinventory.controller;

import com.fuse.fuseinventory.model.UserActivityLogModel;
import com.fuse.fuseinventory.repository.UserActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserActivityLogController {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @GetMapping("/logs")
    public Page<UserActivityLogModel> getUserLogs(Pageable pageable) {
        return userActivityRepository.findAll(pageable);
    }
}