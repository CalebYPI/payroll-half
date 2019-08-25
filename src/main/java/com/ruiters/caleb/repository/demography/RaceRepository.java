package com.ruiters.caleb.repository.demography;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race> getAll();
}
