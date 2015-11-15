package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestResult {
	private final String _DATEFORMAT = "dd/MM/yy HH:mm:ss";
	private Date _start;
	private Date _end;
	private String _report = "";
	private boolean _result;

	private Exception _error;
	
	public void start(){
	     DateFormat df = new SimpleDateFormat(_DATEFORMAT);
		_start =  new Date();
		_report = "Start: " + df.format(_start);
	}
	
	public void end(){
		DateFormat df = new SimpleDateFormat(_DATEFORMAT);
		_end =  new Date();
		_report += "\nEnd: " + df.format(_end)
		         + "\nElapse time: " + (long)(_end.getTime() - _start.getTime()) + " ms";
		
	}
	
	public void addComment(String comment){
		_report += "\n" + comment;
	}
	
	public String report(){
		return _report + "\n";
	}

	public void setException(Exception error){
		_result = false;
		_report += "\nError: " + error.toString();  
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
		
}
