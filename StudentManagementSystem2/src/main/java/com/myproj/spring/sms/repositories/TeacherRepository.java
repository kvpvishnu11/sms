package com.myproj.spring.sms.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.myproj.spring.sms.dto.StudentListDTOImpl; // Updated import
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.entities.Student;
import com.myproj.spring.sms.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT NEW com.myproj.spring.sms.dto.StudentListDTOImpl(s.student_id, u.first_name, u.last_name) " +
           "FROM Enrollment e " +
           "JOIN Student s ON e.student_id = s.student_id " +
           "JOIN Course c ON e.course_id = c.course_id " +
           "JOIN Teacher t ON c.teacher_id = t.teacher_id " +
           "JOIN UserLogin u ON s.user_id = u.user_id " +
           "WHERE t.teacher_id = :teacherId")
    public List<StudentListDTOImpl> fetchStudentsByTeacherId(@Param("teacherId") long teacherId);
    
    @Query("SELECT NEW com.myproj.spring.sms.dto.TeacherListDTOImpl(t.teacher_id, u.first_name, u.last_name) " +
            "FROM Teacher t " +
            "JOIN UserLogin u ON t.user_id = u.user_id")
    public List<TeacherListDTOImpl> listAllTeachers();
    
    @Query(value = "SELECT * FROM teacher WHERE user_id = :id", nativeQuery = true)
    public Teacher findByTeacherid(Long id);
}
