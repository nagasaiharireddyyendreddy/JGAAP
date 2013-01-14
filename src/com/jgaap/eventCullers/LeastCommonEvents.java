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
package com.jgaap.eventCullers;

import com.jgaap.generics.Event;
import com.jgaap.generics.EventCuller;
import com.jgaap.generics.EventCullingException;
import com.jgaap.generics.EventSet;

import java.util.List;
import java.util.Set;

/**
 * Sort out the N most common events (by average frequency) across all event sets
 */
public class LeastCommonEvents extends EventCuller {

    private EventCuller underlyingCuller = new FrequencyRangeCuller();
	
    @Override
    public Set<Event> train(List<EventSet> eventSets) throws EventCullingException {

        underlyingCuller.setParameter("minPos", -getParameter("numEvents", 50));
        underlyingCuller.setParameter("numEvents", getParameter("numEvents", "50"));

        return underlyingCuller.train(eventSets);
    }

    public LeastCommonEvents() {
        super();
        addParams("numEvents", "N", "50", new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "25", "30", "40", "45", "50", "75", "100", "150", "200" }, true);
    }

    @Override
    public String displayName() {
        return "Least Common Events";
    }

    @Override
    public String tooltipText() {
        return "Analyze only the N least common events across all documents";
    }

    @Override
    public String longDescription() {
        return "Analyze only the N rarest events across all documents; " +
               "the value of N is passed as a parameter (numEvents). ";
    }

    @Override
    public boolean showInGUI() {
        return true;
    }

    @Override
    protected void changeParam(java.awt.event.ActionEvent evt) {
        super.changeParam(evt);
        Integer minPos = -Integer.parseInt(getParameter("numEvents"));
        setParameter("minPos", minPos.toString());
    }
}
