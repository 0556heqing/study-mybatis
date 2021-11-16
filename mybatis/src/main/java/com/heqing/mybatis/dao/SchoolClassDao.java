package com.heqing.mybatis.dao;

import com.heqing.mybatis.model.SchoolClass;
import com.heqing.mybatis.model.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heqing
 * @since 2021-07-21
 */
public interface SchoolClassDao {

    /**
     * 保存信息
     * @param schoolClass
     */
    void save(SchoolClass schoolClass);

    /**
     * 根据id获取班级信息
     * @param id
     * @return
     */
    SchoolClass getSchoolClassById(long id);

    /**
     * 根据班主任获取班级信息
     * @param teacherId
     * @return
     */
    SchoolClass getSchoolClassByHeadTeacherId(long teacherId);

    /**
     * 根据授课老师获取信息
     * @param teacher
     * @return
     */
    List<SchoolClass> listSchoolClassByDirector(@Param("teacher") Teacher teacher);

    /**
     * 根据授课老师id获取班级信息
     * @param teacherId
     * @return
     */
    List<SchoolClass> listSchoolClassByTeacherId(long teacherId);
}
