/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_mcderpvqcs.db_levelcheck.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.auto_mcderpvqcs.db_levelcheck.Parent1;


/**
 * ServiceImpl object for domain model class Parent1.
 *
 * @see Parent1
 */
@Service("DB_LevelCheck.Parent1Service")
@Validated
public class Parent1ServiceImpl implements Parent1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Parent1ServiceImpl.class);


    @Autowired
    @Qualifier("DB_LevelCheck.Parent1Dao")
    private WMGenericDao<Parent1, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Parent1, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB_LevelCheckTransactionManager")
    @Override
    public Parent1 create(Parent1 parent1) {
        LOGGER.debug("Creating a new Parent1 with information: {}", parent1);

        Parent1 parent1Created = this.wmGenericDao.create(parent1);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(parent1Created);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Parent1 getById(Integer parent1Id) {
        LOGGER.debug("Finding Parent1 by id: {}", parent1Id);
        return this.wmGenericDao.findById(parent1Id);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Parent1 findById(Integer parent1Id) {
        LOGGER.debug("Finding Parent1 by id: {}", parent1Id);
        try {
            return this.wmGenericDao.findById(parent1Id);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No Parent1 found with id: {}", parent1Id, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public List<Parent1> findByMultipleIds(List<Integer> parent1Ids, boolean orderedReturn) {
        LOGGER.debug("Finding Parent1s by ids: {}", parent1Ids);

        return this.wmGenericDao.findByMultipleIds(parent1Ids, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "DB_LevelCheckTransactionManager")
    @Override
    public Parent1 update(Parent1 parent1) {
        LOGGER.debug("Updating Parent1 with information: {}", parent1);

        this.wmGenericDao.update(parent1);
        this.wmGenericDao.refresh(parent1);

        return parent1;
    }

    @Transactional(value = "DB_LevelCheckTransactionManager")
    @Override
    public Parent1 delete(Integer parent1Id) {
        LOGGER.debug("Deleting Parent1 with id: {}", parent1Id);
        Parent1 deleted = this.wmGenericDao.findById(parent1Id);
        if (deleted == null) {
            LOGGER.debug("No Parent1 found with id: {}", parent1Id);
            throw new EntityNotFoundException(String.valueOf(parent1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "DB_LevelCheckTransactionManager")
    @Override
    public void delete(Parent1 parent1) {
        LOGGER.debug("Deleting Parent1 with {}", parent1);
        this.wmGenericDao.delete(parent1);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Page<Parent1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Parent1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Page<Parent1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Parent1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB_LevelCheck for table Parent1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service DB_LevelCheck for table Parent1 to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}