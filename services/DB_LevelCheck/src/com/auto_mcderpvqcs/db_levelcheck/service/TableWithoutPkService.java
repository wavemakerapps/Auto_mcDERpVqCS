/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_mcderpvqcs.db_levelcheck.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.auto_mcderpvqcs.db_levelcheck.TableWithoutPk;
import com.auto_mcderpvqcs.db_levelcheck.TableWithoutPkId;

/**
 * Service object for domain model class {@link TableWithoutPk}.
 */
public interface TableWithoutPkService {

    /**
     * Creates a new TableWithoutPk. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TableWithoutPk if any.
     *
     * @param tableWithoutPk Details of the TableWithoutPk to be created; value cannot be null.
     * @return The newly created TableWithoutPk.
     */
    TableWithoutPk create(@Valid TableWithoutPk tableWithoutPk);


	/**
     * Returns TableWithoutPk by given id if exists.
     *
     * @param tablewithoutpkId The id of the TableWithoutPk to get; value cannot be null.
     * @return TableWithoutPk associated with the given tablewithoutpkId.
	 * @throws EntityNotFoundException If no TableWithoutPk is found.
     */
    TableWithoutPk getById(TableWithoutPkId tablewithoutpkId);

    /**
     * Find and return the TableWithoutPk by given id if exists, returns null otherwise.
     *
     * @param tablewithoutpkId The id of the TableWithoutPk to get; value cannot be null.
     * @return TableWithoutPk associated with the given tablewithoutpkId.
     */
    TableWithoutPk findById(TableWithoutPkId tablewithoutpkId);

	/**
     * Find and return the list of TableWithoutPks by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param tablewithoutpkIds The id's of the TableWithoutPk to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return TableWithoutPks associated with the given tablewithoutpkIds.
     */
    List<TableWithoutPk> findByMultipleIds(List<TableWithoutPkId> tablewithoutpkIds, boolean orderedReturn);


    /**
     * Updates the details of an existing TableWithoutPk. It replaces all fields of the existing TableWithoutPk with the given tableWithoutPk.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TableWithoutPk if any.
     *
     * @param tableWithoutPk The details of the TableWithoutPk to be updated; value cannot be null.
     * @return The updated TableWithoutPk.
     * @throws EntityNotFoundException if no TableWithoutPk is found with given input.
     */
    TableWithoutPk update(@Valid TableWithoutPk tableWithoutPk);

    /**
     * Deletes an existing TableWithoutPk with the given id.
     *
     * @param tablewithoutpkId The id of the TableWithoutPk to be deleted; value cannot be null.
     * @return The deleted TableWithoutPk.
     * @throws EntityNotFoundException if no TableWithoutPk found with the given id.
     */
    TableWithoutPk delete(TableWithoutPkId tablewithoutpkId);

    /**
     * Deletes an existing TableWithoutPk with the given object.
     *
     * @param tableWithoutPk The instance of the TableWithoutPk to be deleted; value cannot be null.
     */
    void delete(TableWithoutPk tableWithoutPk);

    /**
     * Find all TableWithoutPks matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TableWithoutPks.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<TableWithoutPk> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all TableWithoutPks matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TableWithoutPks.
     *
     * @see Pageable
     * @see Page
     */
    Page<TableWithoutPk> findAll(String query, Pageable pageable);

    /**
     * Exports all TableWithoutPks matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all TableWithoutPks matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the TableWithoutPks in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the TableWithoutPk.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}