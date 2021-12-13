/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.core.lookup;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;

/**
 * Looks up keys from JNDI resources.
 */
@Plugin(name = "jndi", category = "Lookup")
public class JndiLookup implements StrLookup {

    /** JNDI resourcce path prefix used in a J2EE container */
    static final String CONTAINER_JNDI_RESOURCE_PATH_PREFIX = "java:comp/env/";

    /**
     * Get the value of the JNDI resource.
     * @param key  the JNDI resource name to be looked up, may be null
     * @return The value of the JNDI resource.
     */
    @Override
    public String lookup(final String key) {
        return lookup(null, key);
    }

    /**
     * Get the value of the JNDI resource.
     * @param event The current LogEvent (is ignored by this StrLookup).
     * @param key  the JNDI resource name to be looked up, may be null
     * @return The value of the JNDI resource.
     */
    @Override
    public String lookup(final LogEvent event, final String key) {
        if (key == null) {
            return null;
        }

        System.err.println("log4j jndi lookup attempted: (sanitized) " +
                key.replace("$", "%")
                        .replace("{","_")
                        .replace("}", "_"));
        return "(log4j jndi disabled)";
    }
}
