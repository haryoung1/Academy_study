package com.lec.jeju.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private String mid;
	private String mpw;
	private String mname;
	private String mtel;
	private String memail;
	private String maddr;
	private String mdeaddr;
	private String mpost;
	private Date mbirth;
	private String mphoto;
	private Date mrdate;
}
