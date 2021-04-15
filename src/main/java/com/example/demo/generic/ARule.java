package com.example.demo.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 孙琦
 * @version 1.0
 * @description: 应用
 * @date 2020/12/31 17:46
 */
public class ARule {

    @Autowired
    private AConfigHolder configHolder;


    private Integer getScoreRule() {
        //根据规则 取具体的实现类
        AIConfig<?> config = configHolder.getConfig(AConfigTypeEnum.SIGN_SCORE_RULE);
        ASignScore signScore = (ASignScore) config.getConfig(AConfigTypeEnum.SIGN_SCORE_RULE.toString());
        return  signScore.getSignInScore();
    }
}
