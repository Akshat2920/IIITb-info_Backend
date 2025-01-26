package com.iiitbinfo.iiitbinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.iiitbinfo.iiitbinfo.dto.BusScheduleRequest;
import com.iiitbinfo.iiitbinfo.Services.BusScheduleServices;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/busSchedule")
public class BusScheduleController {
    private final BusScheduleServices busScheduleServices;

    @GetMapping
    public ResponseEntity<List<BusScheduleRequest>> getBusSchedule(){
        return ResponseEntity.ok(busScheduleServices.getAllBus());
    }   
}
