package com.p2ohbpzabokradno.ohbp;

import java.text.SimpleDateFormat;

public class Case {

    private long id;
    private String location;
    private String caseStatus;
    private String caseName;
    private static final SimpleDateFormat startTime = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
    private static final SimpleDateFormat endTime = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");

    public Case() {
    }

    public Case(long id, String location, String caseStatus, String caseName) {
        this.id = id;
        this.location = location;
        this.caseStatus = caseStatus;
        this.caseName = caseName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                ", caseName='" + caseName + '\'' +
                '}';
    }
}
