package org.tartea.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.tartea.entity.School;
import org.tartea.entity.Teacher;
import org.tartea.entity.User;

@Mapper(uses = {TypeConversionWorker.class})
public interface TeacherMapper {


    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher userToTeacher(User user);

    @Mapping(source ="school.id",target="schoolId")
    @Mapping(source ="school.name",target="schoolName")
    @Mapping(source ="school.type",target="type",qualifiedByName = "convertToInteger")
    @Mapping(source ="user.id",target="id")
    @Mapping(source ="user.name",target="name")
    @Mapping(source ="user.age",target="age")
    Teacher convertToTeacher(User user, School school);


    @Mapping(source ="school.type",target="type",qualifiedByName = "convertToInteger")
    Teacher convertToTeacher(School school);


    void copyModel(Teacher teacher, @MappingTarget Teacher oldTeacher);
}
