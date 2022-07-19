package com.sr.registerstudent.repository;

import com.sr.registerstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT u FROM Student u WHERE u.studentRollNumber = :rollNumber")
    Student findStudentByRollNumber(@Param("rollNumber") String rollNumber);

    @Query("SELECT Max(u.studentSerialNumber) FROM Student u WHERE u.studentDepartment = :department")
    String getNewSerialNumber(@Param("department") String department);
}
