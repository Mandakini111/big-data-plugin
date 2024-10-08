/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2022 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.big.data.kettle.plugins.hive;

import com.google.common.annotations.VisibleForTesting;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.hadoop.shim.api.cluster.NamedClusterService;
import org.pentaho.hadoop.shim.api.jdbc.DriverLocator;

// Intenionally disabled.  The Simba Hive driver is currently unsupported.
//@DatabaseMetaPlugin( type = "HIVE2SIMBA", typeDescription = "Hadoop Hive 2 with Simba Driver" )
public class Hive2SimbaDatabaseMeta extends BaseSimbaDatabaseMeta {

  @VisibleForTesting static final String JAR_FILE = "HiveJDBC41.jar";
  @VisibleForTesting static final String DRIVER_CLASS_NAME = "org.apache.hive.jdbc.HiveSimbaDriver";
  @VisibleForTesting static final String JDBC_URL_PREFIX = "jdbc:hive2://";
  @VisibleForTesting static final int DEFAULT_PORT = 10000;


  public Hive2SimbaDatabaseMeta( DriverLocator driverLocator, NamedClusterService namedClusterService ) {
    super( driverLocator, namedClusterService );
  }

  @Override protected String getJdbcPrefix() {
    return JDBC_URL_PREFIX;
  }

  @Override
  public String getDriverClass() {
    return DRIVER_CLASS_NAME;
  }

  @Override
  public String[] getUsedLibraries() {
    return new String[] { JAR_FILE };
  }

  @Override
  public int getDefaultDatabasePort() {
    return DEFAULT_PORT;
  }
}
