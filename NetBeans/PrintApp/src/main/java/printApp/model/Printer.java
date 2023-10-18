package printApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Printer extends Entitet {

    @Column(nullable = false)
    private String printerName;
    @Column(nullable = false)
    private String manufacturer;
    private Integer printerTime;
    private Integer fepCount;
    @OneToMany(mappedBy = "printer")
    private List<PrintJob> printJobs = new ArrayList<>();

    public Printer() {
        super();
    }

    public Printer(Integer id, String printerName, String manufacturer, Integer printerTime, Integer fepCount) {
        super(id);
        this.printerName = printerName;
        this.manufacturer = manufacturer;
        this.printerTime = printerTime;
        this.fepCount = fepCount;
    }

    public List<PrintJob> getPrintJobs() {
        return printJobs;
    }

    public void setPrintJobs(List<PrintJob> printJobs) {
        this.printJobs = printJobs;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPrinterTime() {
        return printerTime;
    }

    public void setPrinterTime(Integer printerTime) {
        this.printerTime = printerTime;
    }

    public Integer getFepCount() {
        return fepCount;
    }

    public void setFepCount(Integer fepCount) {
        this.fepCount = fepCount;
    }

    @Override
    public String toString() {
        return printerName;
    }
    
    

}
