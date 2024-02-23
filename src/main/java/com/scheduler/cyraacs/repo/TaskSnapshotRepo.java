package com.scheduler.cyraacs.repo;

import com.scheduler.cyraacs.models.Task_snapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskSnapshotRepo extends JpaRepository<Task_snapshot , Integer> {
}
