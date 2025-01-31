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

package org.apache.hadoop.hive.ql.ddl.misc;

import java.io.Serializable;

import org.apache.hadoop.hive.ql.ddl.DDLDesc;
import org.apache.hadoop.hive.ql.ddl.DDLTask2;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.plan.Explain;
import org.apache.hadoop.hive.ql.plan.Explain.Level;

/**
 * DDL task description for Inserting Commit Hooks.
 */
@Explain(displayName = "Commit Insert Hook", explainLevels = { Level.USER, Level.DEFAULT, Level.EXTENDED })
public class InsertCommitHookDesc implements DDLDesc, Serializable {
  private static final long serialVersionUID = 1L;

  static {
    DDLTask2.registerOperation(InsertCommitHookDesc.class, InsertCommitHookOperation.class);
  }

  private final Table table;
  private final boolean overwrite;

  public InsertCommitHookDesc(Table table, boolean overwrite) {
    this.table = table;
    this.overwrite = overwrite;
  }

  public Table getTable() {
    return table;
  }

  @Explain(displayName = "is overwrite", displayOnlyOnTrue = true,
      explainLevels = { Level.USER, Level.DEFAULT, Level.EXTENDED })
  public boolean isOverwrite() {
    return overwrite;
  }
}
