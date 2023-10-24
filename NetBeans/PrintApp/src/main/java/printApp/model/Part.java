package printApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;


@Entity
public class Part extends Entitet {

    @Column(nullable = false)
    private String partName;
    private String stlOriginal;
    private String stlSupported;
    private String slicedFile;
    @ManyToOne
    private Project project;
    private BigDecimal cost;
    private Integer printTime;
    @OneToMany(mappedBy = "part", fetch = FetchType.EAGER)
    private List<PrintJob> printJobs;

    public Part(Integer id, String partName, String stlOriginal, String stlSupported, String slicedFile, Project project, BigDecimal cost, Integer printTime) {
        super(id);
        this.partName = partName;
        this.stlOriginal = stlOriginal;
        this.stlSupported = stlSupported;
        this.slicedFile = slicedFile;
        this.project = project;
        this.cost = cost;
        this.printTime = printTime;
    }


    

    public Part() {
        super();
    }

    public List<PrintJob> getPrintJobs() {
        return printJobs;
    }

    
    
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getStlOriginal() {
        return stlOriginal;
    }

    public void setStlOriginal(String stlOriginal) {
        this.stlOriginal = stlOriginal;
    }

    public String getStlSupported() {
        return stlSupported;
    }

    public void setStlSupported(String stlSupported) {
        this.stlSupported = stlSupported;
    }

    public String getSlicedFile() {
        return slicedFile;
    }

    public void setSlicedFile(String slicedFile) {
        this.slicedFile = slicedFile;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }
    
    

    @Override
    public String toString() {

        return partName;
    }

}
