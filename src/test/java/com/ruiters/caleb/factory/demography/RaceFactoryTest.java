package com.ruiters.caleb.factory.demography;

import com.ruiters.caleb.domain.demography.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    private String raceType;

    @Before
    public void setUp() throws Exception {
        this.raceType = "All of em";
    }

    @Test
    public void buildRace() {
        Race race = RaceFactory.buildRace(this.raceType);
        Assert.assertNotNull(race.getId());
        Assert.assertNotNull(race);
    }
}