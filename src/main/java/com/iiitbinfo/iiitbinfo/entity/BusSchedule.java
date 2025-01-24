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
@Table(name = "bus_schedule")

public class BusSchedule {
    @Id
    @Column(name = "b_id")
    private Long BId;
    
    @Column(name = "t_id")
    private Long TId;
    
    @Column(name = "count")
    private Long Count;
}
