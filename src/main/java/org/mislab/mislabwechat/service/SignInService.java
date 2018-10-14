package org.mislab.mislabwechat.service;

import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.model.SignInResultModel;
import org.mislab.mislabwechat.entity.po.SignInParam;

public interface SignInService {
    ResponseEntity<SignInResultModel> signIn(SignInParam signInParam);

    ResponseEntity<Integer> getSignNum();
}
