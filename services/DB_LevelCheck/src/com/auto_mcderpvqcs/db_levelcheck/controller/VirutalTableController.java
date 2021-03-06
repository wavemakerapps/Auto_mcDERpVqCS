/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_mcderpvqcs.db_levelcheck.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.auto_mcderpvqcs.db_levelcheck.VirutalTable;
import com.auto_mcderpvqcs.db_levelcheck.VirutalTableId;
import com.auto_mcderpvqcs.db_levelcheck.service.VirutalTableService;


/**
 * Controller object for domain model class VirutalTable.
 * @see VirutalTable
 */
@RestController("DB_LevelCheck.VirutalTableController")
@Api(value = "VirutalTableController", description = "Exposes APIs to work with VirutalTable resource.")
@RequestMapping("/DB_LevelCheck/VirutalTable")
public class VirutalTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirutalTableController.class);

    @Autowired
	@Qualifier("DB_LevelCheck.VirutalTableService")
	private VirutalTableService virutalTableService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new VirutalTable instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirutalTable createVirutalTable(@RequestBody VirutalTable virutalTable) {
		LOGGER.debug("Create VirutalTable with information: {}" , virutalTable);

		virutalTable = virutalTableService.create(virutalTable);
		LOGGER.debug("Created VirutalTable with information: {}" , virutalTable);

	    return virutalTable;
	}

    @ApiOperation(value = "Returns the VirutalTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirutalTable getVirutalTable(@RequestParam("stringcol") String stringcol, @RequestParam("charcol") String charcol) {

        VirutalTableId virutaltableId = new VirutalTableId();
        virutaltableId.setStringcol(stringcol);
        virutaltableId.setCharcol(charcol);

        LOGGER.debug("Getting VirutalTable with id: {}" , virutaltableId);
        VirutalTable virutalTable = virutalTableService.getById(virutaltableId);
        LOGGER.debug("VirutalTable details with id: {}" , virutalTable);

        return virutalTable;
    }



    @ApiOperation(value = "Updates the VirutalTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirutalTable editVirutalTable(@RequestParam("stringcol") String stringcol, @RequestParam("charcol") String charcol, @RequestBody VirutalTable virutalTable) {

        virutalTable.setStringcol(stringcol);
        virutalTable.setCharcol(charcol);

        LOGGER.debug("VirutalTable details with id is updated with: {}" , virutalTable);

        return virutalTableService.update(virutalTable);
    }


    @ApiOperation(value = "Deletes the VirutalTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVirutalTable(@RequestParam("stringcol") String stringcol, @RequestParam("charcol") String charcol) {

        VirutalTableId virutaltableId = new VirutalTableId();
        virutaltableId.setStringcol(stringcol);
        virutaltableId.setCharcol(charcol);

        LOGGER.debug("Deleting VirutalTable with id: {}" , virutaltableId);
        VirutalTable virutalTable = virutalTableService.delete(virutaltableId);

        return virutalTable != null;
    }


    /**
     * @deprecated Use {@link #findVirutalTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VirutalTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirutalTable> searchVirutalTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VirutalTables list by query filter:{}", (Object) queryFilters);
        return virutalTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VirutalTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirutalTable> findVirutalTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VirutalTables list by filter:", query);
        return virutalTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VirutalTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirutalTable> filterVirutalTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VirutalTables list by filter", query);
        return virutalTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVirutalTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return virutalTableService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public StringWrapper exportVirutalTablesAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = VirutalTable.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> virutalTableService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of VirutalTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVirutalTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting VirutalTables");
		return virutalTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVirutalTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return virutalTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VirutalTableService instance
	 */
	protected void setVirutalTableService(VirutalTableService service) {
		this.virutalTableService = service;
	}

}