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

import com.auto_mcderpvqcs.db_levelcheck.TableWithoutPk;
import com.auto_mcderpvqcs.db_levelcheck.TableWithoutPkId;


/**
 * ServiceImpl object for domain model class TableWithoutPk.
 *
 * @see TableWithoutPk
 */
@Service("DB_LevelCheck.TableWithoutPkService")
@Validated
public class TableWithoutPkServiceImpl implements TableWithoutPkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TableWithoutPkServiceImpl.class);


    @Autowired
    @Qualifier("DB_LevelCheck.TableWithoutPkDao")
    private WMGenericDao<TableWithoutPk, TableWithoutPkId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TableWithoutPk, TableWithoutPkId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "DB_LevelCheckTransactionManager")
    @Override
    public TableWithoutPk create(TableWithoutPk tableWithoutPk) {
        LOGGER.debug("Creating a new TableWithoutPk with information: {}", tableWithoutPk);

        TableWithoutPk tableWithoutPkCreated = this.wmGenericDao.create(tableWithoutPk);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(tableWithoutPkCreated);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public TableWithoutPk getById(TableWithoutPkId tablewithoutpkId) {
        LOGGER.debug("Finding TableWithoutPk by id: {}", tablewithoutpkId);
        return this.wmGenericDao.findById(tablewithoutpkId);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public TableWithoutPk findById(TableWithoutPkId tablewithoutpkId) {
        LOGGER.debug("Finding TableWithoutPk by id: {}", tablewithoutpkId);
        try {
            return this.wmGenericDao.findById(tablewithoutpkId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No TableWithoutPk found with id: {}", tablewithoutpkId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public List<TableWithoutPk> findByMultipleIds(List<TableWithoutPkId> tablewithoutpkIds, boolean orderedReturn) {
        LOGGER.debug("Finding TableWithoutPks by ids: {}", tablewithoutpkIds);

        return this.wmGenericDao.findByMultipleIds(tablewithoutpkIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "DB_LevelCheckTransactionManager")
    @Override
    public TableWithoutPk update(TableWithoutPk tableWithoutPk) {
        LOGGER.debug("Updating TableWithoutPk with information: {}", tableWithoutPk);

        this.wmGenericDao.update(tableWithoutPk);
        this.wmGenericDao.refresh(tableWithoutPk);

        return tableWithoutPk;
    }

    @Transactional(value = "DB_LevelCheckTransactionManager")
    @Override
    public TableWithoutPk delete(TableWithoutPkId tablewithoutpkId) {
        LOGGER.debug("Deleting TableWithoutPk with id: {}", tablewithoutpkId);
        TableWithoutPk deleted = this.wmGenericDao.findById(tablewithoutpkId);
        if (deleted == null) {
            LOGGER.debug("No TableWithoutPk found with id: {}", tablewithoutpkId);
            throw new EntityNotFoundException(String.valueOf(tablewithoutpkId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "DB_LevelCheckTransactionManager")
    @Override
    public void delete(TableWithoutPk tableWithoutPk) {
        LOGGER.debug("Deleting TableWithoutPk with {}", tableWithoutPk);
        this.wmGenericDao.delete(tableWithoutPk);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Page<TableWithoutPk> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TableWithoutPks");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager")
    @Override
    public Page<TableWithoutPk> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TableWithoutPks");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service DB_LevelCheck for table TableWithoutPk to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "DB_LevelCheckTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service DB_LevelCheck for table TableWithoutPk to {} format", options.getExportType());
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