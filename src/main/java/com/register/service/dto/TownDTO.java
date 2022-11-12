package com.register.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TownDTO extends AbstractDTO {
	
	
	private Integer id;
	
	
	private String name;
	
	private int provinceId;

}
