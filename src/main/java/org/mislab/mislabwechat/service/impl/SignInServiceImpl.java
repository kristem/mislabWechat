package org.mislab.mislabwechat.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.mislab.mislabwechat.bizService.impl.SignInBizServiceImpl;
import org.mislab.mislabwechat.constant.ReturnCode;
import org.mislab.mislabwechat.entity.dto.ResponseEntity;
import org.mislab.mislabwechat.entity.model.SignInResultModel;
import org.mislab.mislabwechat.entity.po.SignInParam;
import org.mislab.mislabwechat.entity.vo.SignInStatus;
import org.mislab.mislabwechat.entity.vo.SignInfo;
import org.mislab.mislabwechat.service.SignInService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.mislab.mislabwechat.constant.ExceptionMessages.PARAM_EMPTY;
import static org.mislab.mislabwechat.constant.ExceptionMessages.SUCCESS;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class SignInServiceImpl implements SignInService {
	@Resource
	private SignInBizServiceImpl signInBizService;

    @Override
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseEntity<SignInResultModel> signIn(@RequestBody SignInParam signInParam) {
        // step1.参数校验（openId、signNum）
	    if (signInParam == null
	        || signInParam.getSignNum() == null
	        || StringUtils.isBlank(signInParam.getOpenId())) {
		    return new ResponseEntity<>(ReturnCode.PARAM_EMPTY, PARAM_EMPTY, null);
	    }

	    // step2.调用底层实现
	    SignInResultModel resultModel = signInBizService.signInStatus(signInParam);
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE,SUCCESS, resultModel);
    }

    @Override
    @RequestMapping(value = "/getSignNum", method = RequestMethod.GET)
    public ResponseEntity<Integer> getSignNum() {
    	Integer signInNumber = signInBizService.getSignNumber();
        return new ResponseEntity<>(ReturnCode.SUCCESS_CODE, SUCCESS, signInNumber);
    }
}
