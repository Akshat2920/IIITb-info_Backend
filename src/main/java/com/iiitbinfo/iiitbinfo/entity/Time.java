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
@Table(name = "time")

public class Time {
    @Id
    @Column(name = "time_id")
    private Long daysId;
    
    @Column(name = "time")
    private String Time;
}
