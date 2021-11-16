package com.heqing.mybatis.dao;

import com.heqing.mybatis.model.Teacher;

/**
 * @author heqing
 * @since 2021-07-21
 */
public interface TeacherDao {

    /**
     * 保存信息
     * @param teacher
     */
    void save(Teacher teacher);

    /**
     * 根据班主任ID查找管理的班级
     * @param teacherId 实体类ID
     * @return List<T>  实体列表
     */
    Teacher getTeacherById(long teacherId);
}
