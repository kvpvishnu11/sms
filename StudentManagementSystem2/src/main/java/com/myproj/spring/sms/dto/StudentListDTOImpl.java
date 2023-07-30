package com.myproj.spring.sms.dto;

public class StudentListDTOImpl implements StudentListDTO {
    private Long studentid;
    private String firstname;
    private String lastname;

    public StudentListDTOImpl(Long studentid, String firstname, String lastname) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public Long getStudentid() {
        return studentid;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }
}
