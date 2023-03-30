package com.p2ohbpzabokradno.ohbp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


//string slucaj
@Entity
@Table(name = "CaseOhbp")
public class CaseOhbp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "trijaza")
    private int triageCategory;

    @Column(name = "hslucaj")
    private String caseID;

    @Column(name = "ime")
    private String patientFirstName;

    @Column(name = "prezime")
    private String patientLastName;

    @Column(name = "vr_dolaska")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date timeOfArrival;

    @Column(name = "p_retrijaza")
    private  int patientReTriage;


    @Column(name = "po_zavrsen")
    private int completedWork;


    @Column(name = "po_traje")
    private int workInProgress;


    @Column(name = "p_dijagnostika")
    private String patientStatus;

    @Column(name = "p_lokacija")
    private String patientLocation;

    @Column(name = "p_opservacija")
    private int patientObservation;

    @Column(name = "p_arhiva")
    private  int patientArchive;

    public CaseOhbp(Integer caseID, String triageCategory, String patientFirstName, String patientLastName, Date timeOfArrival, int workInProgress, int completedWork, String patientStatus, String patientLocation, int patientObservation) {
    }

    public CaseOhbp() {
    }

    public CaseOhbp(int id, int triageCategory, String caseID, String patientFirstName, String patientLastName, Date timeOfArrival, int patientReTriage, int completedWork, int workInProgress, String patientStatus, String patientLocation, int patientObservation, int patientArchive) {
        this.id = id;
        this.triageCategory = triageCategory;
        this.caseID = caseID;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.timeOfArrival = timeOfArrival;
        this.patientReTriage = patientReTriage;
        this.completedWork = completedWork;
        this.workInProgress = workInProgress;
        this.patientStatus = patientStatus;
        this.patientLocation = patientLocation;
        this.patientObservation = patientObservation;
        this.patientArchive = patientArchive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTriageCategory() {
        return triageCategory;
    }

    public void setTriageCategory(int triageCategory) {
        this.triageCategory = triageCategory;
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
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

    public int getPatientReTriage() {
        return patientReTriage;
    }

    public void setPatientReTriage(int patientReTriage) {
        this.patientReTriage = patientReTriage;
    }

    public int getCompletedWork() {
        return completedWork;
    }

    public void setCompletedWork(int completedWork) {
        this.completedWork = completedWork;
    }

    public int getWorkInProgress() {
        return workInProgress;
    }

    public void setWorkInProgress(int workInProgress) {
        this.workInProgress = workInProgress;
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

    public int getPatientArchive() {
        return patientArchive;
    }

    public void setPatientArchive(int patientArchive) {
        this.patientArchive = patientArchive;
    }

    @Override
    public String toString() {
        return "CaseOhbp{" +
                "id=" + id +
                ", triageCategory=" + triageCategory +
                ", caseID=" + caseID +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                ", timeOfArrival=" + timeOfArrival +
                ", patientReTriage=" + patientReTriage +
                ", completedWork=" + completedWork +
                ", workInProgress=" + workInProgress +
                ", patientStatus='" + patientStatus + '\'' +
                ", patientLocation='" + patientLocation + '\'' +
                ", patientObservation=" + patientObservation +
                ", patientArchive=" + patientArchive +
                '}';
    }
}
