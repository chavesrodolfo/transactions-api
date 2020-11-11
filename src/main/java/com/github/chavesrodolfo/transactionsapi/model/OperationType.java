package com.github.chavesrodolfo.transactionsapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.chavesrodolfo.transactionsapi.model.representations.OperationTypeVO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class OperationType {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

	public OperationType(OperationTypeVO operationTypeVO) {
        this.id = operationTypeVO.getId();
        this.description = operationTypeVO.getDescription();
    }
    
    public OperationTypeVO transform() {
        OperationTypeVO operationTypeVO = new OperationTypeVO();
        operationTypeVO.setId(this.id);
        operationTypeVO.setDescription(this.description);
		return operationTypeVO;
	}
}
