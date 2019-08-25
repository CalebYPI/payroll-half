package com.ruiters.caleb.repository.demography.impl;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.repository.demography.RaceRepository;

import java.util.*;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl repository = null;
    private Map<String, Race> raceMap;

    private RaceRepositoryImpl() { this.raceMap = new HashMap<>(); }

    private static RaceRepositoryImpl raceRepositoryImpl = null;

    public static RaceRepositoryImpl getRaceRepositoryImpl() {
        if (raceRepositoryImpl == null)
            raceRepositoryImpl = new RaceRepositoryImpl();
        return raceRepositoryImpl;
    }

    public Set<Race> getAll() {
        Collection<Race> races = this.raceMap.values();
        Set<Race> set = new HashSet<>();
        set.addAll(races);
        return set;
    }

    public Race create(Race race) {
        this.raceMap.put(race.getId(),race);
        return race;
    }

    public Race update(Race race) {
        this.raceMap.replace(race.getId(),race);
        return this.raceMap.get(race.getId());
    }

    public void delete(String s) {
        this.raceMap.remove(s);
    }

    public Race read(String s) {
        return this.raceMap.get(s);
    }
}
