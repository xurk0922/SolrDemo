package cn.xurongkun.base.service;

public interface BaseService<T> {
    /**
     * 清除所有索引
     */
    void clear();

    /**
     * 增加索引
     * @param t
     */
    void add(T t);

    /**
     * 查询索引
     * @param statement 查询语句
     * @param start 开始记录位置
     * @param rows 总记录数
     * @param  fields 需要返回的字段
     * @return
     */
    String query(String statement, Integer start, Integer rows, String... fields);

    /**
     * 根据id删除索引
     * @param id
     */
    void delete(Long id);

    /**
     * 删除查询到的
     * @param statement
     */
    void deleteByQuery(String statement);
}
