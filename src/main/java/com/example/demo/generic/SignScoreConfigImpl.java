package com.example.demo.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author sunqi
 *
 * 2020年9月8日
 */
@Component
public class SignScoreConfigImpl implements IConfig<SignScore>{

	@Override
	public SignScore getConfig(String configValue) {

		/**查询规则，将规则json串转成实体类
		 * {
		 * "signInScore":5
		 * }
		 *
		 * {
		 * "amount":5,
		 * "score":51,
		 * }
		 *
		 */

		Config config = null;
		//return JSON.parseObject(config.getValue(), SignScore.class);
		return null;
	}

	@Override
	public ConfigTypeEnum getType() {
		return ConfigTypeEnum.SIGN_SCORE_RULE;
	}

}
