package org.apache.hive.beeline;

import java.util.Map;

/**
 * This is the client session hook used for the Beeline.
 * This is to support executions prior and post to Beeline session existence.
 */
public interface BeelineSessionHook
{
    /**
     * Execution happening prior to Beeline session establishment
     * @param hiveConfVariables
     * @param user
     * @param url connection url
     */
    void executePreHook(Map<String, String> hiveConfVariables, String user, String url) throws Exception;

    /**
     * Execution happening post to Beeline session closure
     * This will be called in connection closure flow {@link Commands#close(String)} .
     * @param hiveConfVariables
     * @param user
     */
    void executePostHook(Map<String, String> hiveConfVariables, String user);
}