package com.scheduler.cyraacs.repo;

import com.scheduler.cyraacs.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task,Integer> {
}
