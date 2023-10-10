package printApp.model;

import java.sql.Time;
import java.util.Date;
import jakarta.persistence.Entity;

@Entity
public class Project extends Entitet{
	
	private String projectName;
	private Date creationDate;
	private Date completionDate;
	private boolean isCompleted;
	private Time totalPrintTime;
	private int totalPrintCount;
	private float totalCost;
	private String projectDescription;
	
	
	
	
	
	
	public Project(int id, String projectName, Date creationDate, Date completionDate, boolean isCompleted,
			Time totalPrintTime, int totalPrintCount, float totalCost, String projectDescription) {
		super(id);
		this.projectName = projectName;
		this.creationDate = creationDate;
		this.completionDate = completionDate;
		this.isCompleted = isCompleted;
		this.totalPrintTime = totalPrintTime;
		this.totalPrintCount = totalPrintCount;
		this.totalCost = totalCost;
		this.projectDescription = projectDescription;
		
	}
	public Project() {
		super();
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Time getTotalPrintTime() {
		return totalPrintTime;
	}
	public void setTotalPrintTime(Time totalPrintTime) {
		this.totalPrintTime = totalPrintTime;
	}
	public int getTotalPrintCount() {
		return totalPrintCount;
	}
	public void setTotalPrintCount(int totalPrintCount) {
		this.totalPrintCount = totalPrintCount;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	
	@Override
	public String toString() {
		
		return projectName;
	}
	

}
