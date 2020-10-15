package dto;

import java.io.Serializable;

/*
CREATE TABLE MEMBER(
	ID VARCHAR2(30) PRIMARY KEY,
	PWD VARCHAR2(30) NOT NULL,
	NAME VARCHAR2(30) NOT NULL,
	EMAIL VARCHAR2(30) UNIQUE,
	AUTH NUMBER(1) 
);
*/
public class MemberDto implements Serializable {

	private String id;
	private String pwd;
	private String name;
	private int age;
	private int auth;		// 관리자/사용자
	
	public MemberDto() {
	}

	public MemberDto(String id, String pwd, String name, int age, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.auth = auth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", auth=" + auth + "]";
	}
	
	
}




