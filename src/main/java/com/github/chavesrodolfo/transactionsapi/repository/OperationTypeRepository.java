package com.github.chavesrodolfo.transactionsapi.repository;

import com.github.chavesrodolfo.transactionsapi.model.OperationType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypeRepository extends JpaRepository<OperationType, Long> {
    
}
