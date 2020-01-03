package org.apache.hive.beeline;

import java.util.Map;

public interface BeelineSessionHook
{
    void executePreHook(Map<String, String> hiveConfVariables, String user, String url) throws Exception;

    void executePostHook(Map<String, String> hiveConfVariables, String user);
}