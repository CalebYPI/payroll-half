package com.ruiters.caleb.repository.demography.impl;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.factory.demography.RaceFactory;
import com.ruiters.caleb.repository.demography.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryImplTest {

    private RaceRepository repository;
    private Race race;

    private Race getSavedRace() {
        Set<Race> savedRaces = this.repository.getAll();
        return savedRaces.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRaceRepositoryImpl();
        this.race = RaceFactory.buildRace("All of em");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("Created: " + created);
        d_getAll();
        Assert.assertSame(created, this.race);
    }

    @Test
    public void b_read() {
        Race savedRace = getSavedRace();
        System.out.println("GenderID: " + savedRace.getId());
        Race read = this.repository.read(savedRace.getId());
        System.out.println("Read: " + read);
        d_getAll();
        Assert.assertSame(savedRace, read);
    }

    @Test
    public void c_update() {
        String newRace = "One of them";
        Race race = new Race.Builder().copy(getSavedRace()).raceDesc(newRace).build();
        System.out.println("About to update: " + race);
        Race updated = this.repository.update(race);
        System.out.println("Updated to: " + updated);
        d_getAll();
        Assert.assertSame(newRace, updated);
    }

    @Test
    public void d_getAll() {
        Set<Race> all = this.repository.getAll();
        System.out.println("All: " + all);
        //Assert.assertSame(1, all.size());
    }

    @Test
    public void e_delete() {
        Race savedRace = getSavedRace();
        this.repository.delete(savedRace.getId());
        d_getAll();
    }
}