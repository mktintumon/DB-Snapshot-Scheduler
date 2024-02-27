package com.scheduler.cyraacs.repo;

import com.scheduler.cyraacs.models.CrSnaphot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrSnapshotRepo extends JpaRepository<CrSnaphot , Integer> {

}
