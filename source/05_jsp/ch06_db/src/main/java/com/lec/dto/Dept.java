package com.lec.dto;
// SELECT DEPTNO, DNAME FROM DEPT;
public class Dept {
	private int deptno;
	private String dname;
	public Dept() {}
	public Dept(int deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + "]";
	}
	
}
