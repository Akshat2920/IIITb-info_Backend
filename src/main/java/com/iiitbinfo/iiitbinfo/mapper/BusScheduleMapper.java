package com.iiitbinfo.iiitbinfo.mapper;
import org.springframework.stereotype.Component;

import com.iiitbinfo.iiitbinfo.entity.Bus;
import com.iiitbinfo.iiitbinfo.entity.Time;
import com.iiitbinfo.iiitbinfo.entity.BusSchedule;
import com.iiitbinfo.iiitbinfo.dto.BusDTO;
import com.iiitbinfo.iiitbinfo.dto.TimeDTO;
import com.iiitbinfo.iiitbinfo.dto.BusScheduleRequest;

@Component
public class BusScheduleMapper {
    public BusScheduleRequest toDTO(Bus bus, Time time, BusSchedule busSchedule){
        return BusScheduleRequest.builder()
            .bus(BusDTO.builder()
                .toFrom(bus.getToFrom())
                .build())
            .time(TimeDTO.builder()
                .Time(time.getTime())
                .build())
            .build();
    }

}
