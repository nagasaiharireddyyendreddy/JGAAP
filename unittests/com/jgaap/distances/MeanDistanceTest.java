/*
 * JGAAP -- a graphical program for stylometric authorship attribution
 * Copyright (C) 2009,2011 by Patrick Juola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package com.jgaap.distances;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.jgaap.generics.Event;
import com.jgaap.generics.EventSet;
import com.jgaap.generics.NumericEventSet;

/**
 * @author michael
 *
 */
public class MeanDistanceTest {

	/**
	 * Test method for {@link com.jgaap.distances.MeanDistance#distance(com.jgaap.generics.EventSet, com.jgaap.generics.EventSet)}.
	 */
	@Test
	public void testDistance() {
		EventSet es1 = new NumericEventSet();
		EventSet es2 = new NumericEventSet();
		Vector<Event> test1 = new Vector<Event>();
		test1.add(new Event("1.0"));
		test1.add(new Event("2.0"));
		test1.add(new Event("3.0"));
		test1.add(new Event("4.0"));
		test1.add(new Event("5.0"));

		es1.addEvents(test1);
		es2.addEvents(test1);
		assertTrue(new MeanDistance().distance(es1, es2) == 0);

		Vector<Event> test2 = new Vector<Event>();
		test2.add(new Event("1.0"));
		test2.add(new Event("2.0"));
		test2.add(new Event("3.0"));
		
		es2 = new NumericEventSet();
		es2.addEvents(test2);
		double result = new MeanDistance().distance(es1, es2);
		assertTrue(DistanceTestHelper.inRange(result, 1.0, 0.0000000001));
	}

}
