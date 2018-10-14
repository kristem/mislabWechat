package org.mislab.mislabwechat.manager.impl;

import org.mislab.mislabwechat.manager.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManagerImpl implements CacheManager {

	@Override
	public void put(String key, Object value) {

	}

	@Override
	public Integer getSignInNumber(String key) {
		return null;
	}

	@Override
    public boolean containsKey(String key) {
        return false;
    }
}
