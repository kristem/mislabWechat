package org.mislab.mislabwechat.bizService;

import org.mislab.mislabwechat.entity.model.SignInResultModel;
import org.mislab.mislabwechat.entity.po.SignInParam;
import org.mislab.mislabwechat.entity.po.Signer;
import org.mislab.mislabwechat.entity.po.User;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;

import java.util.List;

public interface SignInBizService {
    Integer getSignNumber();

    SignInResultModel signIn(SignInParam signInParam);
}
