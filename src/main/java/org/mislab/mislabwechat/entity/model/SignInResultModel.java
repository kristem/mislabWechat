package org.mislab.mislabwechat.entity.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignInResultModel implements Serializable {
	private Boolean flag;
	private String message;
}
