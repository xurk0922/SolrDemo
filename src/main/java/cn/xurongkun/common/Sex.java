package cn.xurongkun.common;

public enum Sex {


    MALE(0, "男"),
    FEMALE(1, "女");




    private Integer flag;
    private String name;
    private Sex(Integer flag, String name) {
        this.flag = flag;
        this.name = name;
    }
}
