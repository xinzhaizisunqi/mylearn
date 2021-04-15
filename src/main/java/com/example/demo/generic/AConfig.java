package com.example.demo.generic;

import java.io.Serializable;

/**
 * @author sunqi
 *
 * 2020年9月15日
 */

public class AConfig implements Serializable {
    private Long id;

    private String configkey;

    /**
     * example
     * {
     *     "signInScore":5
     * }
     */
    private String value;

    private String description;

    private static final long serialVersionUID = 1L;

   
}