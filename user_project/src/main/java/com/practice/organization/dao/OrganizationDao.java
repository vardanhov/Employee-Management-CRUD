package com.practice.organization.dao;

import com.practice.organization.model.Organization;

import java.util.List;


public interface OrganizationDao {


    /**
     * Organizatin list
     *
     *
     */
    List<Organization> filter(String name, String inn, Boolean isActive);


    /**
     * Get Organization by id
     *
     *
     */
    Organization getById(Long id);


    /**
     * Save Organization
     *
     *
     */
    void save(Organization save);


    /**
     * Update Organization
     *
     *
     */
    void update(Organization update);


    void delete(Long id);
}
