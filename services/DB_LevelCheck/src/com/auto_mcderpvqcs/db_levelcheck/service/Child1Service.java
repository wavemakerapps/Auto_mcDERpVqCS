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

import com.auto_mcderpvqcs.db_levelcheck.Child1;

/**
 * Service object for domain model class {@link Child1}.
 */
public interface Child1Service {

    /**
     * Creates a new Child1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Child1 if any.
     *
     * @param child1 Details of the Child1 to be created; value cannot be null.
     * @return The newly created Child1.
     */
    Child1 create(@Valid Child1 child1);


	/**
     * Returns Child1 by given id if exists.
     *
     * @param child1Id The id of the Child1 to get; value cannot be null.
     * @return Child1 associated with the given child1Id.
	 * @throws EntityNotFoundException If no Child1 is found.
     */
    Child1 getById(Integer child1Id);

    /**
     * Find and return the Child1 by given id if exists, returns null otherwise.
     *
     * @param child1Id The id of the Child1 to get; value cannot be null.
     * @return Child1 associated with the given child1Id.
     */
    Child1 findById(Integer child1Id);

	/**
     * Find and return the list of Child1s by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param child1Ids The id's of the Child1 to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Child1s associated with the given child1Ids.
     */
    List<Child1> findByMultipleIds(List<Integer> child1Ids, boolean orderedReturn);


    /**
     * Updates the details of an existing Child1. It replaces all fields of the existing Child1 with the given child1.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Child1 if any.
     *
     * @param child1 The details of the Child1 to be updated; value cannot be null.
     * @return The updated Child1.
     * @throws EntityNotFoundException if no Child1 is found with given input.
     */
    Child1 update(@Valid Child1 child1);

    /**
     * Deletes an existing Child1 with the given id.
     *
     * @param child1Id The id of the Child1 to be deleted; value cannot be null.
     * @return The deleted Child1.
     * @throws EntityNotFoundException if no Child1 found with the given id.
     */
    Child1 delete(Integer child1Id);

    /**
     * Deletes an existing Child1 with the given object.
     *
     * @param child1 The instance of the Child1 to be deleted; value cannot be null.
     */
    void delete(Child1 child1);

    /**
     * Find all Child1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Child1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Child1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Child1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Child1s.
     *
     * @see Pageable
     * @see Page
     */
    Page<Child1> findAll(String query, Pageable pageable);

    /**
     * Exports all Child1s matching the given input query to the given exportType format.
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
     * Exports all Child1s matching the given input query to the given exportType format.
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
     * Retrieve the count of the Child1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Child1.
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