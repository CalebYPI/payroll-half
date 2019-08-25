package com.ruiters.caleb.service.demography;

import com.ruiters.caleb.domain.demography.Race;
import com.ruiters.caleb.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
