package com.register.service.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProvinceDTO extends AbstractDTO  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id ;
	
	private String name;

}
