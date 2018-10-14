package org.mislab.mislabwechat.service;

import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.po.SignInParam;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;

public interface SignInService {
    ResponseEntity<SignInStatus> signIn(SignInParam signInParam);

    ResponseEntity<SignInfo> getSignNum();
}
