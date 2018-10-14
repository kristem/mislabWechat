package org.mislab.mislabwechat.manager.impl;

import org.mislab.mislabwechat.dao.SignerMapper;
import org.mislab.mislabwechat.dao.UserMapper;
import org.mislab.mislabwechat.entity.po.Signer;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.manager.SignInManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SignInManagerImpl implements SignInManager {
	@Resource
	private UserMapper userMapper;
	@Resource
	private SignerMapper signerMapper;

	@Async
	@Override
	public void saveSignInMessage(String openId) {
		// step1.根据DB获取该学生的基本信息
		User user = userMapper.findUserByOpenId(openId);

		// step2.将信息存储到签到表
		if (user != null) {
			Signer signer = Signer.builder().studentId(user.getStudentId()).studentName(user.getStudentName()).build();
			signerMapper.insertSigner(signer);
		}
	}
}
