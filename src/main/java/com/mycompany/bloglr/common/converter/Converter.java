/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.converter;

/**
 * Converter that converts from type U to produce type T
 * 
 * @author colin
 *
 * @param <T>
 * @param <U>
 */
public interface Converter <T, U> {

	/**
	 * Convert type U to type T
	 * 
	 * @param u type U to convert from
	 * @return converted type T
	 */
	T convert(U u);
	
}
