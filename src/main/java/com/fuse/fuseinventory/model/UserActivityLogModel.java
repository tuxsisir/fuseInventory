package com.fuse.fuseinventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_activity_log")
public class UserActivityLogModel extends AuditModel {
    /**
     * User Activity Log Model
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "user_activity_log_generator")
    @SequenceGenerator(
            name = "user_activity_log_generator",
            sequenceName = "user_activity_log_sequence",
            initialValue = 1000
    )
    private Long id;

    // columns 

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @NotBlank
    @Size(min = 1, max = 100)
    private String action; // updated / created / deleted / added / increased / decreased

    @NotBlank
    @Size(min = 1, max = 100)
    private String activity; // inventory / inventory log

    // - columns

    // getter setters
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFullName() {
        return user.getFullName();
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setActivity(final String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }
}