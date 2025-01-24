package com.iiitbinfo.iiitbinfo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BusScheduleRequest {
    private BusDTO bus;
    private TimeDTO time;
    private Long count;
}
