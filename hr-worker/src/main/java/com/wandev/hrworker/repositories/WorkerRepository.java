package com.wandev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wandev.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
