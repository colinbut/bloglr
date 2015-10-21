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
 * A converter that converts from {@link Date} to {@link LocalDateTime}
 * 
 * @author colin
 *
 */
public class DateToLocalDateTimeConverter implements Converter<LocalDateTime, Date> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocalDateTime convert(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

}
