package com.fuse.fuseinventory.controller;

import com.fuse.fuseinventory.exception.ResourceNotFoundException;
import com.fuse.fuseinventory.model.InventoryModel;
import com.fuse.fuseinventory.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    // @Autowired
    // private UserActivityRepository userActivityRepository;

    @GetMapping("/inventory")
    public Page<InventoryModel> getInventory(Pageable pageable) {
        return inventoryRepository.findAll(pageable);
    }

    @PostMapping("/inventory")
    public InventoryModel createInventory(@Valid @RequestBody InventoryModel inventory) {
        return inventoryRepository.save(inventory);
    }

    @PutMapping("/inventory/{inventoryId}")
    public InventoryModel updateInventory(@PathVariable Long inventoryId,
                                        @Valid @RequestBody InventoryModel inventoryRequest) {
        return inventoryRepository.findById(inventoryId)
                .map(inventory -> {
                    inventory.setName(inventoryRequest.getName());
                    inventory.setInventoryType(inventoryRequest.getInventoryType());
                    inventory.setQuantity(inventoryRequest.getQuantity());
                    inventory.setDescription(inventoryRequest.getDescription());
                    return inventoryRepository.save(inventory);
                }).orElseThrow(() -> new ResourceNotFoundException("Bad Request! Inventory Not Found."));
    }


    @DeleteMapping("/inventory/{inventoryId}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .map(inventory -> {
                    inventoryRepository.delete(inventory);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Inventory Not Found."));
    }
}