package controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LoanCtrl {

	private LocalDateTime startDate;
	private LocalDateTime endDate;

	
	
	
	
	
	public boolean setDates(LocalDateTime startDate, LocalDateTime endDate) {
		if(startDate.until(endDate, ChronoUnit.DAYS) < 1) {
			return false;
		}
		this.startDate = startDate;
		this.endDate = endDate;
		
		return true;
	}
}
