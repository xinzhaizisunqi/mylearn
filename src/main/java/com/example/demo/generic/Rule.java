package com.example.demo.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2020/12/31 17:46
 */
public class Rule {

    @Autowired
    private ConfigHolder configHolder;


    private Integer getScoreRule() {
        IConfig<?> config = configHolder.getConfig(ConfigTypeEnum.SIGN_SCORE_RULE);
        SignScore signScore = (SignScore) config.getConfig(ConfigTypeEnum.SIGN_SCORE_RULE.toString());
        return  signScore.getSignInScore();
    }
}
