package com.myproj.spring.sms.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.myproj.spring.sms.dto.StudentListDTOImpl; // Updated import
import com.myproj.spring.sms.dto.TeacherListDTOImpl;
import com.myproj.spring.sms.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT NEW com.myproj.spring.sms.dto.StudentListDTOImpl(s.studentid, u.firstname, u.lastname) " +
           "FROM Enrollment e " +
           "JOIN Student s ON e.studentid = s.studentid " +
           "JOIN Course c ON e.courseid = c.courseid " +
           "JOIN Teacher t ON c.teacherid = t.teacherid " +
           "JOIN UserLogin u ON s.userid = u.userid " +
           "WHERE t.teacherid = :teacherId")
    public List<StudentListDTOImpl> fetchStudentsByTeacherId(@Param("teacherId") long teacherId);
    
    @Query("SELECT NEW com.myproj.spring.sms.dto.TeacherListDTOImpl(t.teacherid, u.firstname, u.lastname) " +
            "FROM Teacher t " +
            "JOIN UserLogin u ON t.userid = u.userid")
    public List<TeacherListDTOImpl> listAllTeachers();
}
