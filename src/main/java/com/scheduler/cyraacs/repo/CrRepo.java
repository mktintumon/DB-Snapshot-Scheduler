package com.scheduler.cyraacs.repo;

import com.scheduler.cyraacs.models.ControlRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Date;



@Repository
public interface CrRepo extends JpaRepository<ControlRequirements,Integer> {

    ControlRequirements findByControlId(Integer id);
    List<ControlRequirements> findByFrequencyExpiryDate(Date frequencyExpiryDate);
}
