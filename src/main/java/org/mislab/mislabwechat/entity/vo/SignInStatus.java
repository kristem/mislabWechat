package org.mislab.mislabwechat.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回给前端的对象（openId,签到是否成功）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInStatus {
    private String openId;
    private boolean flag;
}
