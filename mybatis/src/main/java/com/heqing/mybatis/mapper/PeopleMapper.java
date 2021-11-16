package com.heqing.mybatis.mapper;

import com.heqing.mybatis.model.People;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author heqing
 * @since 2021-07-21
 */
@CacheNamespace
@Mapper
public interface PeopleMapper {

    /**
     * 保存信息
     * @param people
     * @return
     */
    @Insert("INSERT INTO people(name,age,gender,create_time) VALUES(#{name},#{age},#{gender},#{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int savePeople(People people);

    /**
     * 批量保存信息
     * @param peopleList
     * @return
     */
    @InsertProvider(type=SqlProvider.class, method="saveBatchPeople")
    int saveBatchPeople(List<People> peopleList);

    /**
     * 修改信息
     * @param people
     * @return
     */
    @Update("update people set name = #{name}, age = #{age}, gender= #{gender}, create_time = #{createTime} where id = #{id}")
    int updatePeopleByKey(People people);

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @Results(
        id="peopleResultMap",
        value={
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="age",property="age"),
            @Result(column="gender",property="gender"),
            @Result(column="create_time",property="createTime")
        }
    )
    @Select("SELECT id, name, age, gender, create_time  FROM people WHERE id = #{id}")
    People getPeopleByKey(Long id);

    /**
     * 获取索引信息
     * @return
     */
    @Select("SELECT id, name, age, gender, create_time FROM people ORDER BY id DESC")
    @ResultMap("peopleResultMap")
    List<People> listPeople();

    /**
     * 根据参数获取信息
     * @param people
     * @return
     */
    @Select("<script>" +
            "SELECT " +
                "id, name, age, gender, create_time " +
            "FROM people" +
            "<where> " +
                "<if test=\"id != null and id != ''\"> AND id=#{id} </if>" +
                "<if test=\"name != null and name != ''\"> AND name=#{name} </if>" +
                "<if test=\"age != null and age != ''\"> AND age=#{age} </if>" +
                "<if test=\"gender != null and gender != ''\"> AND gender=#{gender} </if>" +
                "<if test=\"createTime != null\"> AND date(create_time)=date(#{createTime,jdbcType=TIMESTAMP}) </if>" +
            "</where>" +
            "ORDER BY id DESC" +
            "</script>")
    @ResultMap("peopleResultMap")
    List<People> listPeopleByParam(People people);

    /**
     * 根据id列表获取信息
     * @param idList
     * @return
     */
    @SelectProvider(type=SqlProvider.class, method="listPeopleByKey")
    @ResultMap("peopleResultMap")
    List<People> listPeopleByKey(List<Long> idList);

    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    @Delete("DELETE FROM people WHERE id = #{id}")
    int deletePeopleByKey(Long id);

    /**
     * 根据id列表批量删除信息
     * @param idList
     * @return
     */
    @DeleteProvider(type=SqlProvider.class, method="deleteBatchPeopleByKey")
    int deleteBatchPeopleByKey(List<Long> idList);

    /**
     * 根据参数批量删除信息
     * @param people
     * @return
     */
    @Delete("<script>" +
            "DELETE FROM people " +
            "<where>" +
                "<if test=\"id != null and id != ''\"> AND id=#{id} </if>" +
                "<if test=\"name != null and name != ''\"> AND name=#{name} </if>" +
                "<if test=\"age != null and age != ''\"> AND age=#{age} </if>" +
                "<if test=\"gender != null and gender != ''\"> AND gender=#{gender} </if>" +
                "<if test=\"createTime != null\"> AND date(create_time)=date(#{createTime,jdbcType=TIMESTAMP}) </if>" +
            "</where>" +
            "</script>")
    int deletePeopleByParam(People people);
}
