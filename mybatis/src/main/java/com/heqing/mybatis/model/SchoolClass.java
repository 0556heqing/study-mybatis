package com.heqing.mybatis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Data
public class SchoolClass implements Serializable {

	private long id;
	private String name;
	private long headTeacherId;
	private long classDirectorId;
	private String classDirectorName;

}
