package com.lec.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private Date hiredate;
//	private Timestamp hiredate2;
	private int sal;
	private int comm;
	private int deptno;
	public Emp(int empno, String ename, String job, String mgr, Date hiredate, int sal, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		if (job.length()<8) {
			return empno+"\t"+ename+"\t"+job+"\t\t"+(mgr==null? "-":mgr)+"\t"+hiredate
					+ "\t" + sal + "\t"+comm+"\t" + deptno;
			
		}else {
			return empno+"\t"+ename+"\t"+job+"\t"+(mgr==null? "-":mgr)+"\t"+hiredate
					+ "\t" + sal + "\t"+comm+"\t" + deptno;
		}
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

}
