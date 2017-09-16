package cn.xurongkun.student.entity;

import cn.xurongkun.base.entity.BaseEntity;
import cn.xurongkun.common.Sex;

/**
 * 学生实体
 * @author  xurongkun
 */
public class Student extends BaseEntity {
    /** 姓 */
    private String firstName;

    /** 名 */
    private String secondName;

    /** 姓名 */
    private String name;

    /** 昵称 */
    private String nickName;

    /** 年龄 */
    private Integer age;

    /** 性别 */
    private Sex sex;

    /** 备注 */
    private String memo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}
