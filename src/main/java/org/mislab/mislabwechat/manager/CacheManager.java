package org.mislab.mislabwechat.manager;

public interface CacheManager {
    void put(String key, Object value);

    Integer getSignInNumber(String key);

    boolean containsKey(String key);
}

