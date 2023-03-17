package com.p2ohbpzabokradno.ohbp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "CaseOhbp")
public class CaseOhbp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer caseID;

    @Column(name = "trijazna_kategorija")
    private String triageCategory;

    @Column(name = "ime_pacijenta")
    private String patientFirstName;

    @Column(name = "prezime_pacijenta")
    private String patientLastName;

    @Column(name = "vrijeme_dolaska_pacijenta")
    @DateTimeFormat(pattern = "dd/mm/yyyy HH:mm:ss")
    private Date timeOfArrival;

    @Column(name="trenutno radilište")
    private int workInProcess;

   @Column(name="izdane interne uputnice")
   private int completedWork;

    @Column(name = "dijagnostika_pacijenta")
    private String patientStatus;

    @Column(name = "lokacija_pacijenta")
    private String patientLocation;

}
