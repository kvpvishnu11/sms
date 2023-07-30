package com.myproj.spring.sms.dto;

public class TeacherListDTOImpl implements TeacherListDTO {

	
	  private Long teacherid;
	    private String firstname;
	    private String lastname;

	    public TeacherListDTOImpl(Long teacherid, String firstname, String lastname) {
	        this.teacherid = teacherid;
	        this.firstname = firstname;
	        this.lastname = lastname;
	    }

	@Override
	public Long getTeacherid() {
		// TODO Auto-generated method stub
		return teacherid;
	}

	@Override
	public String getFirstname() {
		// TODO Auto-generated method stub
		return firstname;
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return lastname;
	}

}
