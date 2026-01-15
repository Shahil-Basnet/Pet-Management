/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class AdoptionApplication {

    private int applicationId;
    private String applicantName;
    private String applicantEmail;
    private String applicantPhone;
    private String applicantAddress;
    private String preferredBreed;
    private String preferredAge;
    private String additionalNotes;
    private Date applicationDate;
    private String status; // "Pending", "Approved", "Rejected"

    // Constructor
    public AdoptionApplication(String applicantName, String applicantEmail,
            String applicantPhone, String applicantAddress,
            String preferredBreed, String preferredAge) {
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.applicantPhone = applicantPhone;
        this.applicantAddress = applicantAddress;
        this.preferredBreed = preferredBreed;
        this.preferredAge = preferredAge;
        this.applicationDate = new Date();
        this.status = "Pending";
    }

    // Getters and setters
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int id) {
        this.applicationId = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public String getApplicantAddress() {
        return applicantAddress;
    }

    public String getPreferredBreed() {
        return preferredBreed;
    }

    public String getPreferredAge() {
        return preferredAge;
    }


    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
