/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import printApp.model.Material;
import printApp.util.PrintAppException;

/**
 *
 * @author AMD
 */
public class MaterialController extends Controller<Material> {

    @Override
    public List<Material> read() {
        return session.createQuery("from Material", Material.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {
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

    private void controlBottomExposure() throws PrintAppException {
        if (entitet.getBottomExposure() == null) {
            return;
        }

        if (entitet.getBottomExposure().floatValue() <= 0f) {
            throw new PrintAppException("Bottom exposure must be a positive number");
        }
    }

    private void controlBottomLiftDistance() throws PrintAppException {
        if (entitet.getBottomLiftDistance() == null) {
            return;
        }

        if (entitet.getBottomLiftDistance() <= 0) {
            throw new PrintAppException("Bottom lift distance must be a positive number");
        }

    }

    private void controlBottomLiftSpeed() throws PrintAppException {
        if (entitet.getBottomLiftSpeed() == null) {
            return;
        }

        if (entitet.getBottomLiftSpeed().floatValue() <= 0f) {
            throw new PrintAppException("Bottom lift speed must be a positive number");
        }
    }

    private void controlBottomRetractSpeed() throws PrintAppException {
        if (entitet.getBottomRetractSpeed() == null) {
            return;
        }

        if (entitet.getBottomRetractSpeed().floatValue() <= 0f) {
            throw new PrintAppException("Bottom retract speed must be a positive number");
        }
    }

    private void controlCalibratedExposure() throws PrintAppException {
        if (entitet.getCalibratedExposure() == null) {
            return;
        }

        if (entitet.getCalibratedExposure().floatValue() <= 0f) {
            throw new PrintAppException("Exposure must be a positive number");
        }
    }

    private void controlCostPerUnit() throws PrintAppException {
        if (entitet.getCostPerUnit() == null) {
            return;
        }

        if (entitet.getCostPerUnit().floatValue() <= 0f) {
            throw new PrintAppException("Cost must be a positive number");
        }
    }

    private void controlLayerHeight() throws PrintAppException {
        if (entitet.getLayerHeight() == null) {
            return;
        }

        if (entitet.getLayerHeight().floatValue() <= 0f) {
            throw new PrintAppException("Layer height must be a positive number");
        }
    }

    private void controlLiftDistance() throws PrintAppException {
        if (entitet.getLiftDistance() == null) {
            return;
        }

        if (entitet.getLiftDistance() <= 0) {
            throw new PrintAppException("Lift distance must be a positive number");
        }
    }

    private void controlLiftSpeed() throws PrintAppException {
        if (entitet.getLiftSpeed() == null) {
            return;
        }

        if (entitet.getLiftSpeed().floatValue() <= 0f) {
            throw new PrintAppException("Lift speed must be a positive number");
        }
    }

    private void controlLightOffDelay() throws PrintAppException {
        if (entitet.getLightOffDelay() == null) {
            return;
        }

        if (entitet.getLightOffDelay().floatValue() < 0f) {
            throw new PrintAppException("Light off delay must be a positive number");
        }
    }

    private void controlRetractSpeed() throws PrintAppException {
        if (entitet.getRetractSpeed() == null) {
            return;
        }

        if (entitet.getRetractSpeed().floatValue() <= 0f) {
            throw new PrintAppException("Retract speed must be a positive number");
        }
    }

}
