/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.metastore.model;

import org.apache.hadoop.hive.metastore.api.FieldSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MLightTable {

    private String tableName;
    private List<MFieldSchema> partitionKeys;
    private List<MFieldSchema> cols;
    private Map<String, String> parameters;
    private String tableType;
    private String location;
    private String viewOriginalText;

    public MLightTable() {}

    /**
     * @param tableName
     * @param partitionKeys
     * @param cols
     * @param parameters
     * @param tableType
     * @param location
     * @param viewOriginalText
     */
    public MLightTable(String tableName, List<MFieldSchema> partitionKeys, List<MFieldSchema> cols,
                  Map<String, String> parameters, String tableType, String location, String viewOriginalText) {
        this.tableName = tableName;
        this.partitionKeys = partitionKeys;
        this.cols = cols;
        this.parameters = parameters;
        this.tableType = tableType;
        this.location = location;
        this.viewOriginalText = viewOriginalText;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the partKeys
     */
    public List<FieldSchema> getPartitionKeys() {
        return convertToFieldSchemas(partitionKeys);
    }

    /**
     * @param partKeys the partKeys to set
     */
    public void setPartitionKeys(List<MFieldSchema> partKeys) {
        this.partitionKeys = partKeys;
    }

    /**
     * @return the cols
     */
    public List<FieldSchema> getCols() {
        return convertToFieldSchemas(cols);
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(List<MFieldSchema> cols) {
        this.cols = cols;
    }

    /**
     * @return the parameters
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * @param tableType the tableType to set
     */
    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    /**
     * @return the tableType
     */
    public String getTableType() {
        return tableType;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the original view text, or null if this table is not a view
     */
    public String getViewOriginalText() {
        return viewOriginalText;
    }

    /**
     * @param viewOriginalText the original view text to set
     */
    public void setViewOriginalText(String viewOriginalText) {
        this.viewOriginalText = viewOriginalText;
    }

    private List<FieldSchema> convertToFieldSchemas(List<MFieldSchema> mkeys) {
        List<FieldSchema> keys = null;
        if (mkeys != null) {
            keys = new ArrayList<>(mkeys.size());
            for (MFieldSchema part : mkeys) {
                keys.add(new FieldSchema(part.getName(), part.getType(), part
                        .getComment()));
            }
        }
        return keys;
    }
}
