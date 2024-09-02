package net.javaguides.mmsbackend.mapper;

import net.javaguides.mmsbackend.dto.StudentDto;
import net.javaguides.mmsbackend.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNo(),
                student.getAddress(),
                student.getPaymentStatus()
        );
    }

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getPhoneNo(),
                studentDto.getAddress(),
                studentDto.getPaymentStatus()
        );
    }
}
