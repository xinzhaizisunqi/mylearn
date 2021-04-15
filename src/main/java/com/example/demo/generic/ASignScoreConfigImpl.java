package com.example.demo.generic;

import org.springframework.stereotype.Component;


/**
 * @author sunqi
 *
 * 2020年9月8日
 */
@Component
public class ASignScoreConfigImpl implements AIConfig<ASignScore> {

	@Override
	public ASignScore getConfig(String configValue) {

		/**查询规则，将规则json串转成实体类
		 * {
		 * "signInScore":5
		 * }
		 *,
		 * {
		 * "amount":5,
		 * "score":51,
		 * }
		 *
		 */

		AConfig config = null;
		//return JSON.parseObject(config.getValue(), SignScore.class);
		return null;
	}

	@Override
	public AConfigTypeEnum getType() {
		return AConfigTypeEnum.SIGN_SCORE_RULE;
	}

}
