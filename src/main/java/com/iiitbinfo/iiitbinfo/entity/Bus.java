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
@Table(name = "bus")

public class Bus {
    @Id
    @Column(name = "bus_id")
    private Long busId;
    
    @Column(name = "to_from")
    private Boolean toFrom;
}
