package com.iiitbinfo.iiitbinfo.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iiitbinfo.iiitbinfo.entity.Bus;

@Repository
public interface BusRepo extends JpaRepository<Bus, Long>{

}
