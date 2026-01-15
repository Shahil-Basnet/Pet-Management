/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.AdoptionApplication;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdoptionController {

    private LinkedList<AdoptionApplication> applications = new LinkedList<>();
    private int nextApplicationId = 1;

    /**
     * Submit a new adoption application
     */
    public boolean submitAdoptionApplication(AdoptionApplication application) {
        application.setApplicationId(nextApplicationId++);
        applications.add(application);
        return true;
    }

    /**
     * Get all adoption applications
     */
    public LinkedList<AdoptionApplication> getAllApplications() {
        return applications;
    }

    /**
     * Get pending applications
     */
    public LinkedList<AdoptionApplication> getPendingApplications() {
        LinkedList<AdoptionApplication> pending = new LinkedList<>();
        for (AdoptionApplication app : applications) {
            if ("Pending".equals(app.getStatus())) {
                pending.add(app);
            }
        }
        return pending;
    }

    /**
     * Update application status
     */
    public boolean updateApplicationStatus(int applicationId, String newStatus) {
        for (AdoptionApplication app : applications) {
            if (app.getApplicationId() == applicationId) {
                app.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * Get application by ID
     */
    public AdoptionApplication getApplicationById(int id) {
        for (AdoptionApplication app : applications) {
            if (app.getApplicationId() == id) {
                return app;
            }
        }
        return null;
    }

    /**
     * Get count of pending applications
     */
    public int getPendingApplicationsCount() {
        int count = 0;
        for (AdoptionApplication app : applications) {
            if ("Pending".equals(app.getStatus())) {
                count++;
            }
        }
        return count;
    }

    public void loadAdoptionApplications(JTable adoptionTable) {
        DefaultTableModel model = (DefaultTableModel) adoptionTable.getModel();
        model.setRowCount(0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        for (AdoptionApplication app : applications) {
            model.addRow(new Object[]{
                app.getApplicationId(),
                app.getApplicantName(),
                app.getApplicantEmail(),
                app.getApplicantPhone(),
                app.getApplicantAddress(),
                app.getPreferredBreed().isEmpty() ? "Any" : app.getPreferredBreed(),
                app.getPreferredAge(),
                app.getStatus(),
                dateFormat.format(app.getApplicationDate())
            });
        }
    }

    public void loadAdoptionHistoryToTable(JTable historyTable) {
        DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
        model.setRowCount(0); // Clear existing

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        // Get ALL applications
        LinkedList<AdoptionApplication> allApps = getAllApplications();

        for (AdoptionApplication app : allApps) {
            if ("Approved".equals(app.getStatus()) || "Rejected".equals(app.getStatus())) {
                model.addRow(new Object[]{
                    app.getApplicationId(),
                    app.getApplicantName(),
                    app.getApplicantEmail(),
                    app.getStatus(),
                    dateFormat.format(app.getApplicationDate())
                });
            }
        }

    }
}
