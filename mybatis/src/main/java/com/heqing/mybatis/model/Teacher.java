package com.heqing.mybatis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author heqing
 * @since 2021-07-21
 */
@NoArgsConstructor
@Data
public class Teacher implements Serializable {

	private long id;

	/**
	 * 名字
	 */
	private String name;

	/**
	 * 管理班级/班主任(一对一)
	 */
	private SchoolClass superviseSchoolClass;

	/**
	 * 管理年级/年级主任（一对多）
	 */
	private List<SchoolClass> schoolClassDirector;

	/**
	 * 授课班级（多对多）
	 */
	private List<SchoolClass> teachSchoolClasses;

}
