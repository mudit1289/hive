package org.apache.hive.beeline;

        import java.util.Map;

public class DefaultBeelineSessionHook implements BeelineSessionHook
{
    @Override
    public void executePreHook(Map<String, String> hiveConfVariables, String user, String url) {}

    @Override
    public void executePostHook(Map<String, String> hiveConfVariables, String user) {}
}