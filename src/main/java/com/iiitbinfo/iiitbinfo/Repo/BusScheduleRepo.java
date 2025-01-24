package com.iiitbinfo.iiitbinfo.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iiitbinfo.iiitbinfo.entity.BusSchedule;
import java.util.List;

@Repository
public interface BusScheduleRepo extends JpaRepository<BusSchedule, Long> {
    List<BusSchedule> findAll();
}
