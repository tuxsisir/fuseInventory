package com.fuse.fuseinventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inventory")
public class InventoryModel extends AuditModel {
    /**
     * Inventory Model
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "inventory_generator")
    @SequenceGenerator(
            name = "inventory_generator",
            sequenceName = "inventory_sequence",
            initialValue = 1000
    )
    private Long id;

    // columns 

    // name of the inventory
    @NotBlank
    @Size(min = 1, max = 255)
    private String name;

    // inventory type - consumable / non-consumable
    @NotBlank
    @Size(min = 1, max = 20)
    private String inventory_type;

    // description of the inventory -
    @Column(columnDefinition = "text")
    private String description;

    @NotNull
    @Column(columnDefinition = "integer")
    private Integer quantity;

    // - columns

    // getter setters
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    // consumable / non-consumable
    public String getInventoryType() {        
        return inventory_type;
    }   
    // consumable / non-consumable
    public void setInventoryType(final String inventoryType) {
        this.inventory_type = inventoryType;
    }

     // quantity
     public Integer getQuantity() {        
        return quantity;
    }   
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}