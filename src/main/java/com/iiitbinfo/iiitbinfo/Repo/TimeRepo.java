package com.iiitbinfo.iiitbinfo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iiitbinfo.iiitbinfo.entity.Time;

@Repository
public interface TimeRepo extends JpaRepository<Time, Long>{

}
