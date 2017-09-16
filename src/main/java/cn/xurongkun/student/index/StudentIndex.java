package cn.xurongkun.student.index;

import org.apache.solr.client.solrj.beans.Field;

public class StudentIndex {
    /** 姓 */
    private String firstName;

    /** 名 */
    private String secondName;

    /** 姓名 */
    @Field
    private String name;

    /** 昵称 */
    @Field
    private String nickName;

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
}
