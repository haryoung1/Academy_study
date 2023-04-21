package com.lec.jeju.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private String mid;
	private String mpw;
	private String mname;
	private String memail;
	private String maddr;
	private String mpost;
	private Date mbirth;
	private String mphoto;
	private Date mrdate;
}
