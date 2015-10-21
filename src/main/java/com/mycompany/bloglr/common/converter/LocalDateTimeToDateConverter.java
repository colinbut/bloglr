/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * A converter that converts from {@link LocalDateTime} to {@link Date}
 * 
 * @author colin
 *
 */
public class LocalDateTimeToDateConverter implements Converter<Date, LocalDateTime> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date convert(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
}
