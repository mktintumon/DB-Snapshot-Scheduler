package com.scheduler.cyraacs.repo;

import com.scheduler.cyraacs.models.ControlRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrRepo extends JpaRepository<ControlRequirements,Integer> {

    ControlRequirements findByControlId(Integer id);
}
