package net.javaguides.mmsbackend.repository;

import net.javaguides.mmsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
