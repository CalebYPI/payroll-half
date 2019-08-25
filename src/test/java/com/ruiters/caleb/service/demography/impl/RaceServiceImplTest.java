package com.ruiters.caleb.service.demography.impl;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.factory.demography.RaceFactory;
import com.ruiters.caleb.repository.demography.RaceRepository;
import com.ruiters.caleb.repository.demography.impl.RaceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceImplTest {

    private RaceRepositoryImpl repository;
    private Race race;

    private Race getSavedRace() {  return this.repository.getAll().iterator().next(); }

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRaceRepositoryImpl();
        this.race = RaceFactory.buildRace("All of em");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("Created: " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void b_read() {
        Race savedRace = getSavedRace();
        Race read = this.repository.read(savedRace.getId());
        System.out.println("Read: " + read);
        Assert.assertSame(savedRace, read);
    }

    @Test
    public void c_update() {
        String newRace = "One of them";
        Race update = new Race.Builder().copy(getSavedRace()).raceDesc(newRace).build();
        System.out.println("Updated to: " + update);
        this.repository.update(update);
        Assert.assertSame(update.getDesc(), newRace);
    }

    @Test
    public void d_getAll() {
        Set<Race> races = this.repository.getAll();
        System.out.println("All: " + races);
    }

    @Test
    public void e_delete() {
        Race savedRace = getSavedRace();
        this.repository.delete(savedRace.getId());
        d_getAll();
    }
}