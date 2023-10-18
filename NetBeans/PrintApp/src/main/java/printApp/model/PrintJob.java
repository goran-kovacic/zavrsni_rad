package printApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;


@Entity
public class PrintJob extends Entitet {

    private BigDecimal volume;
    private Integer printTime;
    private BigDecimal cost;
    private boolean result;
    @ManyToOne
    private Printer printer;
    @ManyToOne
    private Material material;
    @ManyToOne
    private Part part;

    public PrintJob() {
        super();
    }

    public PrintJob(Integer id, BigDecimal volume, Integer printTime, BigDecimal cost, boolean result, Printer printer, Material material, Part part) {
        super(id);
        this.volume = volume;
        this.printTime = printTime;
        this.cost = cost;
        this.result = result;
        this.printer = printer;
        this.material = material;
        this.part = part;
    }

   

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }

    @Override
    public String toString() {
        return part.getPartName();
    }
    
    

}
