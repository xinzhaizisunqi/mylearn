package com.example.demo.generic;

import java.io.Serializable;

/**
 * @author sunqi
 *
 * 2020年9月15日
 */

public class Config implements Serializable {
    private Long id;

    private String configkey;

    private String value;

    private String description;

    private static final long serialVersionUID = 1L;

   
}