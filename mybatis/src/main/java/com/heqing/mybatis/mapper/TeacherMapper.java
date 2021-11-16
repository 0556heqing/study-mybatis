package com.heqing.mybatis.mapper;

import com.heqing.mybatis.model.SchoolClass;
import com.heqing.mybatis.model.Teacher;
import org.apache.ibatis.annotations.*;

/**
 * @author heqing
 * @since 2021-07-21
 */
@Mapper
public interface TeacherMapper {

    /**
     * 根据id获取教师信息
     * @param teacherId
     * @return
     */
    @Results(
        id="teacherResult",
        value={
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="id",property="superviseSchoolClass",javaType = SchoolClass.class,
                    one=@One(select="com.heqing.mybatis.mapper.SchoolClassMapper.getSchoolClassByHeadTeacherId")),
            @Result(column="{id=id,name=name}",property="schoolClassDirector",
                    many=@Many(select="com.heqing.mybatis.mapper.SchoolClassMapper.listSchoolClassByDirector")),
            @Result(column="id",property="teachSchoolClasses",
                    many=@Many(select="com.heqing.mybatis.mapper.SchoolClassMapper.listSchoolClassByTeacherId"))
        }
    )
    @Select("SELECT id, name FROM teacher WHERE id = #{teacherId}")
    Teacher getTeacherById(@Param("teacherId") long teacherId);
}
