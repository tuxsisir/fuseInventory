package com.fuse.fuseinventory.repository;

import com.fuse.fuseinventory.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryModel, Long> {
    Page<InventoryModel> findByInventoryType(String inventory_type, Pageable pageable);
}