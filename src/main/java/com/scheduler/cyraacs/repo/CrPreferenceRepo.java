package com.scheduler.cyraacs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduler.cyraacs.models.CrPreference;
import org.springframework.stereotype.Repository;

@Repository
public interface CrPreferenceRepo extends JpaRepository<CrPreference , Integer>{
    CrPreference findTimeZoneOfSchedulerById(Integer id);
}
