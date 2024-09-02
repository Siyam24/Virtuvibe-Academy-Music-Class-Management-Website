package net.javaguides.mmsbackend.repository;

import net.javaguides.mmsbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
