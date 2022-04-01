package org.tartea;

import org.junit.Test;
import org.tartea.convert.TeacherMapper;
import org.tartea.entity.School;
import org.tartea.entity.Teacher;
import org.tartea.entity.User;

public class ApiTest {

    @Test
    public void test() {
        User user = new User(120, "小明", 12);
        Teacher teacher = TeacherMapper.INSTANCE.userToTeacher(user);
        System.out.println(teacher.toString());
    }

    @Test
    public void test1() {
        User user = new User(120, "小明", 12);
        School school = new School(22, "大学", "100");
        Teacher teacher = TeacherMapper.INSTANCE.convertToTeacher(user, school);
        System.out.println(teacher.toString());
    }

    @Test
    public void test2() {
        School school = new School(22, "大学", "100");
        Teacher teacher = TeacherMapper.INSTANCE.convertToTeacher(school);
        System.out.println(teacher.toString());
    }

    @Test
    public void test3() {
        School school = new School(22, "大学", "100");
        Teacher teacher = TeacherMapper.INSTANCE.convertToTeacher(school);
        System.out.println(teacher.toString());

        Teacher newTeacher = new Teacher();
        newTeacher.setId(11);
        newTeacher.setName("中学");
        TeacherMapper.INSTANCE.copyModel(newTeacher, teacher);
        System.out.println(teacher.toString());
    }

}
