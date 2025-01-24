package com.iiitbinfo.iiitbinfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "days")

public class Days {
    @Id
    @Column(name = "days_id")
    private Long daysId;
    
    @Column(name = "day")
    private String Day;
}
