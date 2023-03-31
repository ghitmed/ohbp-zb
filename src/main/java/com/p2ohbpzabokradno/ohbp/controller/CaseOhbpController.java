package com.p2ohbpzabokradno.ohbp.controller;

import com.p2ohbpzabokradno.ohbp.model.*;
import com.p2ohbpzabokradno.ohbp.repository.CaseOhbpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class CaseOhbpController {

    @Autowired
    private CaseOhbpRepository caseOhbpRepository;
    private Object CaseOhbp;

    @GetMapping("/")
    public String redirectToAdmin() {

        return "redirect:/administrator_page";
    }

    @GetMapping("/redirectToDashboardOhbp")
    public String redirectToDashboardOhbp() {

        return "dashboard_ohbp.html";
    }


    @GetMapping("/redirectToObservationOhbp")
    public String redirectToObservationOhbp() {

        return "observation_ohbp.html";
    }


    @GetMapping("/redirectToPatients")
    public String redirectToPatients() {

        return "patients.html";
    }


    @GetMapping("/redirectToObservationPatients")
    public String redirectToObservationPatients() {

        return "observation_patients.html";
    }


    @GetMapping("/redirectToTriageCategory")
    public String redirectToTriageCategory() {

        return "triage_category.html";
    }


    @GetMapping("/redirectToLegend")
    public String redirectToLegend() {

        return "legend.html";
    }

    ;

    @GetMapping("/redirectToBis")
    public String redirectToBis(Model model) {
        CaseOhbp case123 = new CaseOhbp();
        case123.setTimeOfArrival(new Date());

        model.addAttribute("caseOhbp", case123);
        return "BIS.html";

    }


    @GetMapping("/printID")
    public String printID(Model model) {
        model.addAttribute("allCases", caseOhbpRepository.findAll(Sort.by(Sort.Direction.ASC, "triageCategory")));
        return "printID.html";
    }

    @GetMapping("/administrator_page")
    public String getAllCases(Model model) {
        model.addAttribute("allCases", caseOhbpRepository.findAll(Sort.by(Sort.Direction.ASC, "triageCategory")));
        return "administrator_page.html";
    }

    @GetMapping("/patient_page")
    public String getAllCasesPatient(Model model) {
        model.addAttribute("allCases", caseOhbpRepository.findAll(Sort.by(Sort.Direction.ASC, "triageCategory")));
        return "patients.html";
    }


    @GetMapping("/createNewCase")
    public String createNewCase(@ModelAttribute("caseOhbp") CaseOhbp case123) {
        caseOhbpRepository.save(case123);
        return "redirect:/redirectToBis";

    }


    @GetMapping("/template/admnistrator_page")
    public String getAll(Model model, @RequestParam(required = false) String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "8") int size,
                         @RequestParam(defaultValue = "id,asc") String[] sort) {
        try {
            List<CaseOhbp> casesZbOhbp = new ArrayList<CaseOhbp>();

            String sortField = sort[0];
            String sortDirection = sort[1];

            Direction direction = sortDirection.equals("desc") ? Direction.DESC : Direction.ASC;
            Order order = new Order(direction, sortField);

            Pageable pageable = PageRequest.of(page - 1, size, Sort.by(order));

            Page<CaseOhbp> mediquePage;
            if (keyword == null) {
                mediquePage = caseOhbpRepository.findAll(pageable);
            } else {
                mediquePage = caseOhbpRepository.findByPatientLastNameContainsIgnoreCase(keyword, pageable);
                model.addAttribute("keyword", keyword);
            }

            casesZbOhbp = mediquePage.getContent();

            model.addAttribute("allCases", casesZbOhbp);
            model.addAttribute("currentPage", mediquePage.getNumber() + 1);
            model.addAttribute("totalItems", mediquePage.getTotalElements());
            model.addAttribute("totalPages", mediquePage.getTotalPages());
            model.addAttribute("pageSize", size);
            model.addAttribute("sortField", sortField);
            model.addAttribute("sortDirection", sortDirection);
            model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "administrator_page";
    }


    @GetMapping("/obs_patients")
    public String getAllObservationCasesPatient(Model model) {
        model.addAttribute("allCases", caseOhbpRepository.findAll(Sort.by(Sort.Direction.ASC, "triageCategory")));
        return "observation_patients.html";
    }

    @GetMapping("/obs_ohbp")
    public String getAllObservationCasesOhbp(Model model) {
        model.addAttribute("allCases", caseOhbpRepository.findAll(Sort.by(Sort.Direction.ASC, "triageCategory")));
        return "observation_ohbp.html";
    }

    @GetMapping("/dashboard_ohbp")
    public String getAllDashboardCasesOhbp(Model model) {
        model.addAttribute("allCases", caseOhbpRepository.findAll(Sort.by(Sort.Direction.ASC, "triageCategory")));
        return "dashboard_ohbp.html";
    }

}