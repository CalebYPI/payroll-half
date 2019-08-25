package com.ruiters.caleb.service.demography.impl;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.repository.demography.RaceRepository;
import com.ruiters.caleb.repository.demography.impl.RaceRepositoryImpl;
import com.ruiters.caleb.service.demography.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {
    private static RaceServiceImpl service = null;
    private RaceRepository repository;

    private RaceServiceImpl() { this.repository = RaceRepositoryImpl.getRaceRepositoryImpl(); }

    private static RaceServiceImpl getService() {
        if (service == null)
            service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Set<Race> getAll() { return repository.getAll(); }

    @Override
    public Race create(Race race) { return repository.create(race); }

    @Override
    public Race update(Race race) { return repository.update(race); }

    @Override
    public void delete(String s) { repository.delete(s); }

    @Override
    public Race read(String s) { return repository.read(s); }
}
