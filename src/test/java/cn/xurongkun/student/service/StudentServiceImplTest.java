package cn.xurongkun.student.service;

import cn.xurongkun.student.index.StudentIndex;
import org.junit.Test;

public class StudentServiceImplTest {
    private StudentServiceImpl service = new StudentServiceImpl();
    @Test
    public void clear() throws Exception {
        service.clear();
    }

    @Test
    public void add() throws Exception {
        StudentIndex index = new StudentIndex();
        index.setName("test");
        index.setNickName("test");

        service.add(index);
    }

    @Test
    public void query() throws Exception {
        System.out.println(service.query("*:*", null, null, "name"));
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteByQuery() throws Exception {
    }
}
