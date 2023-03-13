package com.p2ohbpzabokradno.ohbp.klase_staro;

import java.text.SimpleDateFormat;

public class Procedure {

    private long id;
    private String proclocation;
    private String procName;
    private String status;
    private static final SimpleDateFormat startTime = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
    private static final SimpleDateFormat endTime = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");

    public Procedure() {
    }

    public Procedure(long id, String proclocation, String procName, String status) {
        this.id = id;
        this.proclocation = proclocation;
        this.procName = procName;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProclocation() {
        return proclocation;
    }

    public void setProclocation(String proclocation) {
        this.proclocation = proclocation;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "id=" + id +
                ", proclocation='" + proclocation + '\'' +
                ", procName='" + procName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
