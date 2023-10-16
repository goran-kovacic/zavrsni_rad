/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package printApp.controller;

import java.util.List;
import printApp.model.Part;
import printApp.util.PrintAppException;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author AMD
 */
public class PartController extends Controller<Part> {

    @Override
    public List<Part> read() {
        return session.createQuery("from Part", Part.class).list();
    }

    @Override
    protected void controlCreate() throws PrintAppException {
        controlName();
        controlStlOriginal();
        controlStlSupported();
        controlSlicedFile();
    }

    @Override
    protected void controlUpdate() throws PrintAppException {
        controlName();
        controlStlOriginal();
        controlStlSupported();
        controlSlicedFile();
    }

    @Override
    protected void controlDelete() throws PrintAppException {

    }

    private void controlName() throws PrintAppException {

        if (entitet.getPartName() == null) {
            throw new PrintAppException("Part name must be defined!");
        }
        if (entitet.getPartName().isEmpty()) {
            throw new PrintAppException("Part name cannot be emtpy!");
        }

    }

    private void controlStlOriginal() throws PrintAppException {

        try {
            Path p = Paths.get(entitet.getStlOriginal());

            if (!p.isAbsolute() || p.toFile().isDirectory()) {
                throw new PrintAppException("Not a valid file path!");
            }
        } catch (NullPointerException e) {
        }

    }

    private void controlStlSupported() throws PrintAppException {
        try {
            Path p = Paths.get(entitet.getStlSupported());

            if (!p.isAbsolute() || p.toFile().isDirectory()) {
                throw new PrintAppException("Not a valid file path!");
            }
        } catch (NullPointerException e) {
        }
    }

    private void controlSlicedFile() throws PrintAppException {

        try {
            Path p = Paths.get(entitet.getSlicedFile());

            if (!p.isAbsolute() || p.toFile().isDirectory()) {
                throw new PrintAppException("Not a valid file path!");
            }
        } catch (NullPointerException e) {
        }

    }

}
