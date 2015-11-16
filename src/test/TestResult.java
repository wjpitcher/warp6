package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestResult {
	private final String _DATEFORMAT = "dd/MM/yy HH:mm:ss";
	private Date _start;
	private Date _end;
	private String _report = "";
	private String _title;
	private boolean _result = true;

	private Exception _error;
	
	public TestResult(String title){
		_title = title;
	}
	
	public void start(){
	     DateFormat df = new SimpleDateFormat(_DATEFORMAT);
		_start =  new Date();
		_report = "Start: " + df.format(_start) + "\n";
	}
	
	public void end(){
		DateFormat df = new SimpleDateFormat(_DATEFORMAT);
		_end =  new Date();
		_report += "End: " + df.format(_end)
		         + "\nElapse time: " + (long)(_end.getTime() - _start.getTime()) + " ms\n";
	}
	
	public void addComment(String comment){
		_report += comment + "\n" ;
	}
	
	public String report(){
		return _report;
	}

	public void setException(Exception error){
		_result = false;
		_report += "Error: " + error.toString() + "\n";  
		_error = error;
	}
	
	public Exception getException(){

		return _error;
	}
	
	public void setResult(Boolean result){
		_result = result;
	}
	
	public boolean getResult(){
		return _result;
	}
	
	public String toString(){
		if(getResult())
			return _title + " - Pass\n";
		else
			return _title + " - Fail\n" + report();
			
	}
}
