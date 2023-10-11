package printApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;



@Entity
public class Printer extends Entitet {

    @Column(nullable = false)
    private String printerName;
    @Column(nullable = false)
    private String manufacturer;
    private Integer printerTime;
    private Integer fepCount;

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

}
