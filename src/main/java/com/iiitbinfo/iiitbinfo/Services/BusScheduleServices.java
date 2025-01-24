package com.iiitbinfo.iiitbinfo.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import com.iiitbinfo.iiitbinfo.entity.Bus;
import com.iiitbinfo.iiitbinfo.entity.Time;
import com.iiitbinfo.iiitbinfo.entity.BusSchedule;
import com.iiitbinfo.iiitbinfo.Repo.BusRepo;
import com.iiitbinfo.iiitbinfo.Repo.TimeRepo;
import com.iiitbinfo.iiitbinfo.Repo.BusScheduleRepo;
import com.iiitbinfo.iiitbinfo.mapper.BusScheduleMapper;
import com.iiitbinfo.iiitbinfo.dto.BusScheduleRequest;


@Service
@RequiredArgsConstructor
public class BusScheduleServices {
    private final BusRepo busRepo;
    private final TimeRepo timeRepo;
    private final BusScheduleRepo busScheduleRepo;
    private final BusScheduleMapper busScheduleMapper;

    public List<BusScheduleRequest> getAllBus() {
        List<BusSchedule> busSchedules = busScheduleRepo.findAll();
        
        return busSchedules.stream().map(busSchedule -> {
            Bus bus = busRepo.findById(busSchedule.getBId())
                            .orElseThrow(() -> new RuntimeException("Bus not found"));
            Time time = timeRepo.findById(busSchedule.getTId())
                            .orElseThrow(() -> new RuntimeException("time not found"));
            return busScheduleMapper.toDTO(bus, time, busSchedule);
        }).collect(Collectors.toList());
    }
}
