package com.ruiters.caleb.factory.demography;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.util.Misc;

public class RaceFactory {
    public static Race buildRace(String desc) {
        return new Race.Builder().raceId(Misc.generateId()).raceDesc(desc).build();
    }
}
