package com.first;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class handler
 */
@WebServlet("/handler")
public class handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String EMAIL,NAME,ENO,ADDRESS,PER_ADDRESS,MOBILE;
	String PIN,ACHIEVEMENTS,dt,CGORMARKS,WAR;
	String PD,CATEGORY,GENDER,Preference1,Preference2,Preference3,FATHER;
	String PHDSTREAM,CHOICE4,BOX2,BOX3,BOX4,BOX5,NATIONALITY,CGPA,MARKS;
	String DEGREE,DEP,COLLEGE,UNIV,CITY,BOARD10,BOARD12,MARKS10,MARKS12;
	String ex_p1,ex_p2,ex_p3,ex_p4,ex_college,ex_city,ex_state,ex_dep,ex_degree;
	String ex_thesis,ex_year,ex_cgpa,ex_marks,ex_cgpa_marks,ex_subject,ex_year_other,ex_exam;
	String ex_score,ex_rank,gate_score,gate_area,gate_year,gate_marks,gate_rank,grad_marks,p_grad_marks;
	String time;
	/**
     * Default constructor. 
     */
    public handler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer=response.getWriter();
		writer.println("<!DOCTYPE html><html><head><meta charset='utf-8'><link href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css' rel='stylesheet' type='text/css'/> <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js'></script> <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js'></script> <style> html, body,h1,a{margin: 0;padding: 0;border: 0;outline: 0;font-size: 100%;vertical-align: baseline;background: transparent;}body {line-height: 1;background: #f0f0f0;border: none;color: #333;margin: 0 auto;font: 14px/24px Helvetica, Arial, sans-serif;width: 960px;}h1 {font: normal bold 34px/50px Arial, Helvetica, sans-serif;padding-top: 30px;}a{color: #CC6600;text-decoration: none;} </style> <script> $(document).ready(function() { $('#datepicker').datepicker(); }); </script><title>Welcome!</title></head><body><header id='mast'> <h1>IIIT Delhi</h1> </header> <form method='post'><br> <br> <br>PERSONAL INFORMATION:<br><br><br>Email:<input type='email' name='email' required><br><br>Name:<input name='name' required><br><br>Enrollment Number:<input name='eno'><br><br>Address:<input name='address' required><br><br>Mobile:<input type='number' maxlength='10' name='mobile' required><br><br>PhD Stream:<input type='radio' name='phdstream' value='Computer Science' required>Computer Science <input type='radio' name='phdstream' value='Electronics and Communication'>Electronics and Communication <input type='radio' name='phdstream' value='Computational Biology'>Computational Biology<br><br>PhD Preference1:<select name='preference1' required><option value=''>------</option><option value='one'>Computers</option><option value='two'>Electronics</option><option value='three'>Mechanical</option></select><br><br>PhD Preference2:<select name='preference2' ><option value=''>------</option><option value='one'>Computers</option><option value='two'>Electronics</option><option value='three'>Mechanical</option></select><br><br>PhD Preference3:<select name='preference3'><option value=''>------</option><option value='one'>Computers</option><option value='two'>Electronics</option><option value='three'>Mechanical</option></select><br><br>Gender:<br><br><input type='radio' name='gender' value='Male' required> Male <input type='radio' name='gender' value='Female'> Female<br> <br>Category:<br><br><input type='radio' name='category' value='General' required>General <input type='radio' name='category' value='SC'>SC <input type='radio' name='category' value='ST'>ST <input type='radio' name='category' value='OBC'>OBC<br><br>Physically Disabled:<br><br><input type='radio' name='pd' value='Yes' required>YES<input type='radio' name='pd' value='No'>NO<br><br>DateOfBirth:<br><br><input type='date' name='dateofbirth' max='2015-12-01' required><br><br>Children/war widows:<br><br><input type='radio' name='war' value='No' required>NO <input type='radio' name='war' value='Yes'>YES<br><br>Father's Name:<input name='father' required><br><br>Nationality:<select name='nationality' required><option value='India'>India</option><option value='Pakistan'>Pakistan</option><option value='China'>China</option></select><br><br>PerAddress:<input name='peraddress' required><br><br>Pincode:<input type='number' name='pincode'><br><br><br>Schooling Information:<br><br><br>Xth Board:<input name='board10' required><br><br>xth Marks(%):<input type='number' min='1' name='marks10' required><br><br>Year of Passing Xth=<select name='year10' required><option value='2015'>2015</option><option value='2014'>2014</option><option value='2013'>2013</option><option value='2012'>2012</option><option value='2011'>2011</option></select><br><br>XIIth Board:<input name='board12' required><br><br>XIIth Marks(%):<input type='number' min='1' name='marks12' required><br><br>Year of Passing XIIth=<select name='year12' required><option value='2015'>2015</option><option value='2014'>2014</option><option value='2013'>2013</option><option value='2012'>2012</option><option value='2011'>2011</option></select><br><br>Graduation Information:<br><br><br>Degree:<input name='degree' required><br><br>Department/Discipline:<input name='dep' required><br><br>Name of College:<input name='college' required><br><br>Name of University:<input name='univ' required><br><br>City:<input name='city' required><br><br>State:<select name='state' required><option value=''>none</option><option value='Delhi'>Delhi</option><option value='Gurgaon'>Gurgoan</option><option value='Noida'>Noida</option><option value='Kerela'>Kerela</option><option value='Himachal'>Himachal</option></select><br><br>Year of Graduation:<select name='grad_year' required><option value='2015'>2015</option><option value='2014'>2014</option><option value='2013'>2013</option><option value='2012'>2012</option><option value='2011'>2011</option></select><br><br>CGPA or MARKS?<input type='radio' name='cgpaormarks' value='cgpa'>cgpa<br>&#160&#160&#160&#160<input type='number' max='10' name='cgpavalue'> / <select name='outof'> <option value='4'>4</option><option value='10'>10</option></select><br>&#160&#160&#160&#160<input type='radio' name='cgpaormarks' value='marks'>marks<br>&#160&#160&#160&#160<input type='number' max='100' name='marksvalue'><br><br><input type='checkbox' name='extra1' value='yes'>Are you applying for ECE PhD?<br><br>ECE PhD Subject Preference<br><br>Preference1:<select name='ecepreference1'><option value='Linear Systems'>Linear Systems</option><option value='Embedded Systems'>Embedded Systems</option><option value='Digital Communication'>Digital Communication</option><option value='Communication Network'>Communication Network</option></select><br><br>Preference2:<select name='ecepreference2'><option value='Linear Systems'>Linear Systems</option><option value='Embedded Systems'>Embedded Systems</option><option value='Digital Communication'>Digital Communication</option><option value='Communication Network'>Communication Network</option></select><br><br>Preference3:<select name='ecepreference3'><option value='Linear Systems'>Linear Systems</option><option value='Embedded Systems'>Embedded Systems</option><option value='Digital Communication'>Digital Communication</option><option value='Communication Network'>Communication Network</option></select><br><br>Preference4:<select name='ecepreference4'><option value='Linear Systems'>Linear Systems</option><option value='Embedded Systems'>Embedded Systems</option><option value='Digital Communication'>Digital Communication</option><option value='Communication Network'>Communication Network</option></select><br><br><input type='checkbox' name='extra2' value='yes'>Have you completed your Post Graduation?<br><br>Post - Graduation Information<br><br>Name of College:<input name='pgcollege'><br><br>City:<input name='pgcity'><br><br>State:<select name='pgstate'><option value='Delhi'>Delhi</option><option value='Himachal'>Himachal</option><option value='Kerela'>kerela</option><option value='Noida'>Noida</option></select><br><br>Department/Discipline:<input name='pgdep'><br><br>Degree:<input name='pgdegree'><br><br>Thesis Title:<input name='pgthesis'><br><br>Year of Post Graduation:<select name='pgyear'><option value='2015'>2015</option><option value='2014'>2014</option><option value='2013'>2013</option><option value='2012'>2012</option><option value='2011'>2011</option></select><br><br>CGPA or MARKS?<input type='radio' name='pgcgpaormarks' value='cgpa'>cgpa<br>&#160&#160&#160&#160<input type='number' max='10' name='pgcgpavalue'> / <select name='pgoutof'> <option value='4'>4</option><option value='10'>10</option></select><br>&#160&#160&#160&#160<input type='radio' name='pgcgpaormarks' value='marks'>marks<br>&#160&#160&#160&#160<input type='number' max='100' name='pgmarksvalue'><br><br><br><input type='checkbox' name='extra3' value='yes'> Other Academic Degrees?<br><br>Other Academic Degrees:<br><br>Exam Name:<input name='otherexam'><br><br>Subject:<input name='othersubject'><br><br>Year:<select name='otheryear'><option value='2015'>2015</option><option value='2014'>2014</option><option value='2013'>2013</option><option value='2012'>2012</option><option value='2011'>2011</option></select><br><br>Score:<input name='otherscore'><br><br>Rank:<input name='otherrank'><br><br><br><input type='checkbox' name='extra4' value='yes'>Taken GATE Exam?<br><br>GATE:<br><br>Area:<input name='gatename'><br><br>Year of Graduation:<select name='gateyear'><option value='2015'>2015</option><option value='2014'>2014</option><option value='2013'>2013</option><option value='2012'>2012</option><option value='2011'>2011</option></select><br><br>Marks(out of 100):<input name='gatemarks'><br><br>Score:<input name='gatescore'><br><br>Rank:<input name='gaterank'><br><br><br>Achievements, CV and Statement of Purpose:<br><br><input name=Achievements><br><br>Achievements (Other information like ranks, medals etc.):<input name='achievements'><br><br>CV Resume:<input type='checkbox' onclick='Function()'>Upload File</checkbox><br><script>function Function(){var x = document.createElement('INPUT'); x.setAttribute('type', 'file'); document.body.appendChild(x);}</script><br>Submit:<input type='submit' name='Submit'><br></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		EMAIL=request.getParameter("email");
		NAME=request.getParameter("name");
		ADDRESS=request.getParameter("address");
		PER_ADDRESS=request.getParameter("peraddress");
		MOBILE=request.getParameter("mobile");
		PIN=request.getParameter("pincode");
		ACHIEVEMENTS=request.getParameter("achievements");
		dt=request.getParameter("dateofbirth");
		System.out.println(dt);
		CGORMARKS=request.getParameter("cgpaormarks");
		WAR=request.getParameter("war");
		PD=request.getParameter("pd");
		CATEGORY=request.getParameter("category");
		GENDER=request.getParameter("gender");
		Preference1=request.getParameter("preference1");
		Preference2=request.getParameter("preference2");
		Preference3=request.getParameter("preference3");
		FATHER=request.getParameter("father");
		PHDSTREAM=request.getParameter("phdstream");
		CHOICE4=request.getParameter("outof");
		BOX2=request.getParameter("year10");
		BOX3=request.getParameter("year12");
		BOX4=request.getParameter("state");
		BOX5=request.getParameter("grad_year");
		NATIONALITY=request.getParameter("nationality");
		CGPA=request.getParameter("cgpavalue");
		MARKS=request.getParameter("marksvalue");
		DEGREE=request.getParameter("degree");
		DEP=request.getParameter("dep");
		COLLEGE=request.getParameter("college");
		UNIV=request.getParameter("univ");
		CITY=request.getParameter("city");
		BOARD10=request.getParameter("board10");
		BOARD12=request.getParameter("board12");
		MARKS10=request.getParameter("marks10");
		MARKS12=request.getParameter("marks12");
		ex_p1=request.getParameter("pgcollege");
		ex_p2=request.getParameter("pgcity");
		ex_p3=request.getParameter("pgthesis");
		ex_p4=request.getParameter("pgcgpavalue");
		ex_city=request.getParameter("pgcity");
		ex_college=request.getParameter("pgcollege");
		ex_state=request.getParameter("pgstate");
		ex_dep=request.getParameter("pgdep");
		ex_thesis=request.getParameter("pgthesis");
		ex_degree=request.getParameter("pgdeg");
		ex_year=request.getParameter("pgyear");
		ex_cgpa=request.getParameter("pgcgpavalue");
		ex_marks=request.getParameter("pgmarksvalue");
		ex_cgpa_marks=request.getParameter("pgcgpaormarks");
		ex_subject=request.getParameter("othersubject");
		ex_year_other=request.getParameter("otheryear");
		ex_exam=request.getParameter("otherexam");
		ex_score=request.getParameter("otherscore");
		ex_rank=request.getParameter("otherrank");
		gate_area=request.getParameter("gatename");
		gate_year=request.getParameter("gateyear");;
		gate_score=request.getParameter("gatescore");
		gate_rank=request.getParameter("gaterank");
		gate_marks=request.getParameter("gatemarks");
		ENO="1";
				String f1;
				Calendar cal = Calendar.getInstance();
		        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		        time=sdf.format(cal.getTime());
		        System.out.println(time);
				f1="C:/Users/asd/git/ApProject-2/ApProject-1/src/com/first/db.txt";
				BufferedWriter b=null;
				try{
					//"Time:"+time+"\n"+
					b=new BufferedWriter(new FileWriter(f1,true));
					b.write("Email:"+EMAIL+"\n"+"Name:"+NAME+"\n"+"ENO:"+ENO+"\n"+"Address:"+ADDRESS+"\n");
					b.write("Per_Address:"+PER_ADDRESS+"\n"+"Mobile:"+MOBILE+"\n"+"Pin:"+PIN+"\n"+"Achievements:"+ACHIEVEMENTS+"\n");
					b.write("Time:"+time+"\n"+"Date:"+dt+"\n"+"CgOrMarks:"+CGORMARKS+"\n"+"War:"+WAR+"\n"+"Pd:"+PD+"\n");
					b.write("Category:"+CATEGORY+"\n"+"Gender:"+GENDER+"\n"+"Preference1:"+Preference1+"\n"+"Preference2:"+Preference2+"\n");
					b.write("Preference3"+Preference3+"\n"+"Father:"+FATHER+"\n"+"PhDStream:"+PHDSTREAM+"\n"+"Choice4:"+CHOICE4+"\n"+"Box2:"+BOX2+"\n");
					b.write("Box3:"+BOX3+"\n"+"Box4:"+BOX4+"\n"+"Box5:"+BOX5+"\n"+"Nationality:"+NATIONALITY+"\n"+"Cgpa:"+CGPA+"\n"+"Marks:"+MARKS+"\n");
					b.write("Degree:"+DEGREE+"\n"+"Dep:"+DEP+"\n"+"College:"+COLLEGE+"\n"+"Univ:"+UNIV+"\n"+"City:"+CITY+"\n"+"Board10:"+BOARD10+"\n");
					b.write("Board12:"+BOARD12+"\n"+"Marks10:"+MARKS10+"\n"+"Marks12:"+MARKS12+"\n");
					b.write(ex_p1+"\n"+ex_p2+"\n"+ex_p3+"\n"+ex_p4+"\n"+ex_college+"\n"+ex_city+"\n"+ex_state+"\n"+ex_dep+"\n"+ex_degree+"\n"+ex_thesis+"\n"+ex_year+"\n"+ex_cgpa+"\n"+ex_marks+"\n"+ex_cgpa_marks+"\n");
					b.write(ex_subject+"\n"+ex_year_other+"\n"+ex_exam+"\n"+ex_score+"\n"+ex_rank+"\n"+gate_area+"\n"+gate_year+"\n"+gate_marks+"\n"+gate_score+"\n"+gate_rank+"\n"+ ENO);
					b.close();
					//ex_college,ex_city,ex_state,ex_dep,ex_degree,ex_thesis,ex_year,ex_cgpa,ex_marks,ex_cgpa_marks;
					//String ex_subject,ex_year_other,ex_exam,ex_score,ex_rank,gate_area,gate_year,gate_marks,gate_score,gate_rank;
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}

			String f2="C:/Users/asd/git/ApProject-2/ApProject-1/src/com/first/our.txt";
			BufferedWriter b1=null;
			try{
				b1=new BufferedWriter(new FileWriter(f2,true));
				
				b1.write("hello"+":"+EMAIL+":"+NAME+":"+ENO+":"+CATEGORY+":"+GENDER+":"+PD+":"+dt+":"+PHDSTREAM+":"+DEGREE+":"+ex_degree+":"+BOARD10+":"+BOARD12+":"+DEP+":"+ex_dep+":"+UNIV
					+":"+ex_college+":"+BOX4+":"+ex_state+":"+MARKS10+":"+MARKS12+":"+grad_marks+":"+p_grad_marks+":"+gate_score+":");
				b1.newLine();
				b1.close();
				
				//ex_college,ex_city,ex_state,ex_dep,ex_degree,ex_thesis,ex_year,ex_cgpa,ex_marks,ex_cgpa_marks;
				//String ex_subject,ex_year_other,ex_exam,ex_score,ex_rank,gate_area,gate_year,gate_marks,gate_score,gate_rank;
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	int function(String s1,String s2)
	{
		String a1[]=s1.split("/");
		String a2[]=s2.split("/");
		if(a1[2].compareTo(a2[2])==0)
		{
			if(a1[1].compareTo(a2[1])==0)
			{
				if(a1[0].compareTo(a2[0])==0)
				{
					return 0;
				}
				else if(a1[0].compareTo(a2[0])==1)
				{
					return 1;
				}
				else
				{
					return -1;
				}
				
			}
			else if(a1[1].compareTo(a2[1])==1)
			{
				return 1;
			}
			else {
				return 1;
			}
		}
		else if(a1[0].compareTo(a2[0])==1)
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
}
