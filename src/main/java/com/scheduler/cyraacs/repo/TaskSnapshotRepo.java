package com.scheduler.cyraacs.repo;

import com.scheduler.cyraacs.models.TaskSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSnapshotRepo extends JpaRepository<TaskSnapshot , Integer> {
}
