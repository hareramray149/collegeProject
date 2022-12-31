package com.project.collegeProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.collegeProject.entity.Student;
import com.project.collegeProject.model.StudentWithSchoolDetails;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query(value="select * from student where st_id = ?;", nativeQuery = true)
	public Student getStudentData(Integer student_id);
	
	@Query(value="select student.st_name, student.st_roll, student.st_class, school.s_name from student INNER JOIN school on student.st_school_id = school.s_id;", nativeQuery = true)
	public List<Object[]> getStudentAndSchoolData();

}
