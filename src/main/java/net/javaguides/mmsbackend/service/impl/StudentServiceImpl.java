package net.javaguides.mmsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.mmsbackend.dto.StudentDto;
import net.javaguides.mmsbackend.entity.Student;
import net.javaguides.mmsbackend.exception.ResourceNotFoundException;
import net.javaguides.mmsbackend.mapper.StudentMapper;
import net.javaguides.mmsbackend.repository.StudentRepository;
import net.javaguides.mmsbackend.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not exists with given id : " +studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not exists with given id : " +studentId));

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        student.setPhoneNo(updatedStudent.getPhoneNo());
        student.setAddress(updatedStudent.getAddress());
        student.setPaymentStatus(updatedStudent.getPaymentStatus());

        Student updatedStudentObj = studentRepository.save(student);

        return StudentMapper.mapToStudentDto(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not exists with given id : " +studentId));

        studentRepository.deleteById(studentId);
    }


}