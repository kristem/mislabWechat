package org.mislab.mislabwechat.bizService.impl;

import org.mislab.mislabwechat.bizService.SignInBizService;
import org.mislab.mislabwechat.constant.ExceptionMessages;
import org.mislab.mislabwechat.constant.RedisConstant;
import org.mislab.mislabwechat.entity.model.SignInResultModel;
import org.mislab.mislabwechat.entity.po.SignInParam;

import org.mislab.mislabwechat.manager.CacheManager;
import org.mislab.mislabwechat.manager.SignInManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@EnableAsync
public class SignInBizServiceImpl implements SignInBizService {
    @Resource
    private CacheManager cacheManager;
    @Resource
    private SignInManager signInManager;

    @Override
    public Integer getSignNumber() {
        return cacheManager.getSignInNumber(RedisConstant.SING_IN_NUMBER_KEY);
    }

    @Override
    public SignInResultModel signIn(SignInParam signInParam) {
        // step1.从redis获取签到码
        int signInNumber = cacheManager.getSignInNumber(RedisConstant.SING_IN_NUMBER_KEY);

        // step2.判断签到码是否正确
        if (signInParam.getSignNum() != signInNumber) {
            return SignInResultModel.builder().flag(Boolean.FALSE).message(ExceptionMessages.SIGN_IN_NUMBER_ERROR).build();
        }

        // step3.从redis查看该openId是否存在
        boolean containsOpenId = cacheManager.containsKey(signInParam.getOpenId());
        if (containsOpenId) {
            return SignInResultModel.builder().flag(Boolean.FALSE).message(ExceptionMessages.DUPLICATED_SIGN_IN_ERROR).build();
        }

        // step4.把签到信息写到DB和redis中
        cacheManager.put(signInParam.getOpenId(), signInParam.getSignNum());
        signInManager.saveSignInMessage(signInParam.getOpenId());

        return SignInResultModel.builder().flag(Boolean.TRUE).build();
    }

}
