package com.rabtank.fishbot_function.repository.impl;

import com.rabtank.fishbot_function.entity.Fish;
import com.rabtank.fishbot_function.entity.FishingLocation;
import com.rabtank.fishbot_function.repository.FishingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishingLocationRepositoryImpl implements FishingLocationRepository {

    @Autowired
    @Qualifier("fishingJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public FishingLocation findByName(String name) {
        String sql = "SELECT * FROM location WHERE name = ?";
        try {
            FishingLocation location = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(FishingLocation.class), name);
            if (location != null) {
                location.setFishList(findFishByLocationId(location.getId()));
            }
            return location;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<FishingLocation> findAll() {
        String sql = "SELECT * FROM location";
        try {
            List<FishingLocation> locations = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FishingLocation.class));
            for (FishingLocation location : locations) {
                location.setFishList(findFishByLocationId(location.getId()));
            }
            return locations;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private List<Fish> findFishByLocationId(int locationId) {
        String sql = "SELECT f.* FROM fish f JOIN fish_in_location fil ON f.id = fil.fish_id WHERE fil.location_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fish.class), locationId);
    }
}