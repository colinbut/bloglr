/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.bloglr.common.transformer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * A transformer interface that allowing the transformation from type T to type U
 * 
 * @author colin
 *
 * @param <T> 
 * @param <U>
 */
public interface TypeTransformer <T, U> {

	/**
	 * Transforms a type of U to type T
	 * 
	 * @param u type U to transform from
	 * @return transformed type T
	 */
	T transform(U u);
	
	/**
	 * Transforms a list of type U to a list of type 
	 * T
	 * 
	 * @param u list of type U
	 * @return {@link List} of T
	 */
	Collection<T> transform(Collection<U> u);
}
