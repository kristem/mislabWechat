package org.mislab.mislabwechat.manager.impl;

import org.mislab.mislabwechat.manager.SignInManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SignInManagerImpl implements SignInManager {

	@Async
	@Override
	public void saveSignInMessage(String openId) {

	}
}
