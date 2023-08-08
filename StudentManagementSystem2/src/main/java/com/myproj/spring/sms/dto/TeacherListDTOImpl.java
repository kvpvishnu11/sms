package com.myproj.spring.sms.dto;

public class TeacherListDTOImpl implements TeacherListDTO {

	
	  private Long teacher_id;
	    private String first_name;
	    private String last_name;
		public Long getTeacher_id() {
			return teacher_id;
		}
		public void setTeacher_id(Long teacher_id) {
			this.teacher_id = teacher_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public TeacherListDTOImpl(Long teacher_id, String first_name, String last_name) {
			super();
			this.teacher_id = teacher_id;
			this.first_name = first_name;
			this.last_name = last_name;
		}
		public TeacherListDTOImpl() {
			super();
		}

	    

}
