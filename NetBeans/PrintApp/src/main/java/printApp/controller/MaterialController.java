/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import printApp.model.Material;
import printApp.model.Part;
import printApp.model.PrintJob;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class MaterialController extends Controller<Material> {
    
    private final String errorMessage = """
                                        Must be a positive number.
                                        If writing decimals use period as separator.""";

    @Override
    public List<Material> read() {
        return session.createQuery("from Material", Material.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {
        controlName();
        appendName();
        controlBottomExposure();
        controlBottomLiftDistance();
        controlBottomLiftSpeed();
        controlBottomRetractSpeed();
        controlCalibratedExposure();
        controlCostPerUnit();
        controlLayerHeight();
        controlLiftDistance();
        controlLiftSpeed();
        controlLightOffDelay();
        controlRetractSpeed();
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
        controlName();
        controlBottomExposure();
        controlBottomLiftDistance();
        controlBottomLiftSpeed();
        controlBottomRetractSpeed();
        controlCalibratedExposure();
        controlCostPerUnit();
        controlLayerHeight();
        controlLiftDistance();
        controlLiftSpeed();
        controlLightOffDelay();
        controlRetractSpeed();
    }

    @Override
    protected void controlDelete() throws PrintAppException {
        
        if(!entitet.getPrintJobs().isEmpty()){
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot delete resin because it has associated print jobs: \n");
             for (PrintJob p : entitet.getPrintJobs()){
                sb.append(p.getPart().getPartName());
                sb.append("\n");
            }
            sb.append("\nRemove these print jobs before deleting the printer.");
            throw new PrintAppException(sb.toString());
        }

    }

    private void controlName() throws PrintAppException {
        if (entitet.getMaterialName() == null) {
            throw new PrintAppException("Material name must be defined!");
        }
        if (entitet.getMaterialName().isEmpty()) {
            throw new PrintAppException("Material name cannot be emtpy!");
        }
        if (entitet.getManufacturer() == null) {
            throw new PrintAppException("Manufacturer name must be defined!");
        }
        if (entitet.getManufacturer().isEmpty()) {
            throw new PrintAppException("Manufacturer name cannot be emtpy!");
        }
    }
    
    private void appendName() {
        List<Material> list = session.createQuery("from Material m where m.materialName like :condition", Material.class)
                .setParameter("condition", entitet.getMaterialName()+ "%")
                .list();

        if (list != null && !list.isEmpty()) {
            entitet.setMaterialName(entitet.getMaterialName()+ " (" + (list.size()) + ")");
        }
    }

    private void controlBottomExposure() throws PrintAppException {
        if (entitet.getBottomExposure() == null) {
            return;
        }

        if (entitet.getBottomExposure().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlBottomLiftDistance() throws PrintAppException {
        if (entitet.getBottomLiftDistance() == null) {
            return;
        }

        if (entitet.getBottomLiftDistance() <= 0) {
            throw new PrintAppException(errorMessage);
        }

    }

    private void controlBottomLiftSpeed() throws PrintAppException {
        if (entitet.getBottomLiftSpeed() == null) {
            return;
        }

        if (entitet.getBottomLiftSpeed().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlBottomRetractSpeed() throws PrintAppException {
        if (entitet.getBottomRetractSpeed() == null) {
            return;
        }

        if (entitet.getBottomRetractSpeed().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlCalibratedExposure() throws PrintAppException, NullPointerException {
        if (entitet.getCalibratedExposure() == null) {
            return;
        }
        
        
        if (entitet.getCalibratedExposure().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }

    }

    private void controlCostPerUnit() throws PrintAppException {
        if (entitet.getCostPerUnit() == null) {
            return;
        }

        if (entitet.getCostPerUnit().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlLayerHeight() throws PrintAppException {
        if (entitet.getLayerHeight() == null) {
            return;
        }

        if (entitet.getLayerHeight().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlLiftDistance() throws PrintAppException {
        if (entitet.getLiftDistance() == null) {
            return;
        }

        if (entitet.getLiftDistance() <= 0) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlLiftSpeed() throws PrintAppException {
        if (entitet.getLiftSpeed() == null) {
            return;
        }

        if (entitet.getLiftSpeed().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlLightOffDelay() throws PrintAppException {
        if (entitet.getLightOffDelay() == null) {
            return;
        }

        if (entitet.getLightOffDelay().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

    private void controlRetractSpeed() throws PrintAppException {
        if (entitet.getRetractSpeed() == null) {
            return;
        }

        if (entitet.getRetractSpeed().floatValue() <= 0f) {
            throw new PrintAppException(errorMessage);
        }
    }

}
