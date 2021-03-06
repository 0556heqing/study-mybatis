package com.heqing.mybatis.mapper;

import com.heqing.mybatis.model.SchoolClass;
import com.heqing.mybatis.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author heqing
 * @since 2021-07-21
 */
@Mapper
public interface SchoolClassMapper {

    /**
     * 根据班主任获取信息
     * @param teacherId
     * @return
     */
    @Results(
        id="schoolClassResult",
        value={
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="head_teacher_id",property="headTeacherId"),
            @Result(column="class_director_id",property="classDirectorId"),
            @Result(column="class_director_name",property="classDirectorName"),
        }
    )
    @Select("SELECT id, name, head_teacher_id, class_director_id, class_director_name FROM school_class WHERE head_teacher_id = #{id}")
    SchoolClass getSchoolClassByHeadTeacherId(long teacherId);

    /**
     * 根据授课教师获取信息
     * @param teacher
     * @return
     */
    @SelectProvider(type= SqlProvider.class, method="listSchoolClassByDirector")
    @ResultMap("schoolClassResult")
    List<SchoolClass> listSchoolClassByDirector(Teacher teacher);

    /**
     * 根据授课教师id获取信息
     * @param teacherId
     * @return
     */
    @Select("<script>" +
            "SELECT " +
                "c.* " +
            "FROM school_class c " +
            "LEFT JOIN teacher_class tc " +
                "ON c.id = tc.class_id " +
            "WHERE tc.teacher_id = #{id} " +
            "</script>")
    @ResultMap("schoolClassResult")
    List<SchoolClass> listSchoolClassByTeacherId(long teacherId);
}
