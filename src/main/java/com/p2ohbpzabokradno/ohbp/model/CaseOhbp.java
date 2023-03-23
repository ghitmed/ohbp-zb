package com.p2ohbpzabokradno.ohbp.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;



@Entity
@Table(name = "CaseOhbp")
public class CaseOhbp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer caseID;

    @Column(name = "trijazna_kategorija")
    private int triageCategory;

    @Column(name = "ime_pacijenta")
    private String patientFirstName;

    @Column(name = "prezime_pacijenta")
    private String patientLastName;

    @Column(name = "vrijeme_dolaska_pacijenta")
    @DateTimeFormat(pattern = "dd/mm/yyyy HH:mm:ss")
    private Date timeOfArrival;

    @Column(name = "postupak_u_tijeku")
    private int workInProgress;

    @Column(name = "postupak_završen")
    private int completedWork;

    @Column(name = "status_pacijenta_dijagnostika")
    private String patientStatus;

    @Column(name = "lokacija_pacijenta")
    private String patientLocation;

    @Column(name = "opservacija_pacijenta")
    private int patientObservation;


    public CaseOhbp() {
    }

    public CaseOhbp(Integer caseID, int triageCategory, String patientFirstName, String patientLastName, Date timeOfArrival, int workInProgress, int completedWork, String patientStatus, String patientLocation, int patientObservation) {
        this.caseID = caseID;
        this.triageCategory = triageCategory;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.timeOfArrival = timeOfArrival;
        this.workInProgress = workInProgress;
        this.completedWork = completedWork;
        this.patientStatus = patientStatus;
        this.patientLocation = patientLocation;
        this.patientObservation = patientObservation;
    }

    public Integer getCaseID() {
        return caseID;
    }

    public void setCaseID(Integer caseID) {
        this.caseID = caseID;
    }

    public int getTriageCategory() {
        return triageCategory;
    }

    public void setTriageCategory(int triageCategory) {
        this.triageCategory = triageCategory;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Date getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(Date timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public int getWorkInProgress() {
        return workInProgress;
    }

    public void setWorkInProgress(int workInProgress) {
        this.workInProgress = workInProgress;
    }

    public int getCompletedWork() {
        return completedWork;
    }

    public void setCompletedWork(int completedWork) {
        this.completedWork = completedWork;
    }

    public String getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(String patientStatus) {
        this.patientStatus = patientStatus;
    }

    public String getPatientLocation() {
        return patientLocation;
    }

    public void setPatientLocation(String patientLocation) {
        this.patientLocation = patientLocation;
    }

    public int getPatientObservation() {
        return patientObservation;
    }

    public void setPatientObservation(int patientObservation) {
        this.patientObservation = patientObservation;
    }

    @Override
    public String toString() {
        return "CaseOhbp{" +
                "caseID=" + caseID +
                ", triageCategory=" + triageCategory +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", timeOfArrival=" + timeOfArrival +
                ", workInProgress=" + workInProgress +
                ", completedWork=" + completedWork +
                ", patientStatus='" + patientStatus + '\'' +
                ", patientLocation='" + patientLocation + '\'' +
                ", patientObservation=" + patientObservation +
                '}';
    }
}
