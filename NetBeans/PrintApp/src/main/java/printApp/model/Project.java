package printApp.model;

import jakarta.persistence.Column;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project extends Entitet {

    @Column(nullable = false)
    private String projectName;

    private Date creationDate;
    private Date completionDate;
    @Column(columnDefinition = "boolean")
    private boolean isCompleted;

    private Integer totalPrintTime;
    @Column(nullable = true)
    private Integer totalPrintCount;
    @Column(nullable = true)
    private BigDecimal totalCost;
    private String projectDescription;
    @OneToMany(mappedBy ="project", fetch = FetchType.EAGER )
    private List<Part> parts = new ArrayList<>();

    public Project(String projectName, Date creationDate, Date completionDate, boolean isCompleted, Integer totalPrintTime, Integer totalPrintCount, BigDecimal totalCost, String projectDescription, List<Part> parts, Integer id) {
        super(id);
        this.projectName = projectName;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.isCompleted = isCompleted;
        this.totalPrintTime = totalPrintTime;
        this.totalPrintCount = totalPrintCount;
        this.totalCost = totalCost;
        this.projectDescription = projectDescription;
        this.parts = parts;
    }

    

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
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

    public Integer getTotalPrintTime() {
        return totalPrintTime;
    }

    public void setTotalPrintTime(Integer totalPrintTime) {
        this.totalPrintTime = totalPrintTime;
    }

    public Integer getTotalPrintCount() {
        return totalPrintCount;
    }

    public void setTotalPrintCount(Integer totalPrintCount) {
        this.totalPrintCount = totalPrintCount;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
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
