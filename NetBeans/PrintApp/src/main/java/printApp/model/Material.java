package printApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Material extends Entitet {

    @Column(nullable = false)
    private String materialName;
    @Column(nullable = false)
    private String manufacturer;
    private BigDecimal costPerUnit;
    private BigDecimal calibratedExposure;
    private BigDecimal layerHeight;
    private BigDecimal bottomExposure;
    private Integer liftDistance;
    private BigDecimal liftSpeed;
    private Integer bottomLiftDistance;
    private BigDecimal bottomLiftSpeed;
    private BigDecimal retractSpeed;
    private BigDecimal bottomRetractSpeed;
    private BigDecimal lightOffDelay;

    public Material(Integer id, String materialName, String manufacturer, BigDecimal costPerUnit, BigDecimal calibratedExposure, BigDecimal layerHeight, BigDecimal bottomExposure, Integer liftDistance, BigDecimal liftSpeed, Integer bottomLiftDistance, BigDecimal bottomLiftSpeed, BigDecimal retractSpeed, BigDecimal bottomRetractSpeed, BigDecimal lightOffDelay) {
        super(id);
        this.materialName = materialName;
        this.manufacturer = manufacturer;
        this.costPerUnit = costPerUnit;
        this.calibratedExposure = calibratedExposure;
        this.layerHeight = layerHeight;
        this.bottomExposure = bottomExposure;
        this.liftDistance = liftDistance;
        this.liftSpeed = liftSpeed;
        this.bottomLiftDistance = bottomLiftDistance;
        this.bottomLiftSpeed = bottomLiftSpeed;
        this.retractSpeed = retractSpeed;
        this.bottomRetractSpeed = bottomRetractSpeed;
        this.lightOffDelay = lightOffDelay;
    }

    public Material() {
        super();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public BigDecimal getCalibratedExposure() {
        return calibratedExposure;
    }

    public void setCalibratedExposure(BigDecimal calibratedExposure) {
        this.calibratedExposure = calibratedExposure;
    }

    public BigDecimal getLayerHeight() {
        return layerHeight;
    }

    public void setLayerHeight(BigDecimal layerHeight) {
        this.layerHeight = layerHeight;
    }

    public BigDecimal getBottomExposure() {
        return bottomExposure;
    }

    public void setBottomExposure(BigDecimal bottomExposure) {
        this.bottomExposure = bottomExposure;
    }

    public Integer getLiftDistance() {
        return liftDistance;
    }

    public void setLiftDistance(Integer liftDistance) {
        this.liftDistance = liftDistance;
    }

    public BigDecimal getLiftSpeed() {
        return liftSpeed;
    }

    public void setLiftSpeed(BigDecimal liftSpeed) {
        this.liftSpeed = liftSpeed;
    }

    public Integer getBottomLiftDistance() {
        return bottomLiftDistance;
    }

    public void setBottomLiftDistance(Integer bottomLiftDistance) {
        this.bottomLiftDistance = bottomLiftDistance;
    }

    public BigDecimal getBottomLiftSpeed() {
        return bottomLiftSpeed;
    }

    public void setBottomLiftSpeed(BigDecimal bottomLiftSpeed) {
        this.bottomLiftSpeed = bottomLiftSpeed;
    }

    public BigDecimal getRetractSpeed() {
        return retractSpeed;
    }

    public void setRetractSpeed(BigDecimal retractSpeed) {
        this.retractSpeed = retractSpeed;
    }

    public BigDecimal getBottomRetractSpeed() {
        return bottomRetractSpeed;
    }

    public void setBottomRetractSpeed(BigDecimal bottomRetractSpeed) {
        this.bottomRetractSpeed = bottomRetractSpeed;
    }

    public BigDecimal getLightOffDelay() {
        return lightOffDelay;
    }

    public void setLightOffDelay(BigDecimal lightOffDelay) {
        this.lightOffDelay = lightOffDelay;
    }

    @Override
    public String toString() {
    return getMaterialName(); 
    }

    
}
