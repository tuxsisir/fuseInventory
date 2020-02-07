package com.fuse.fuseinventory.repository;

import com.fuse.fuseinventory.model.UserActivityLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivityLogModel, Long> {
}