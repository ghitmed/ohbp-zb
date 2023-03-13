package com.p2ohbpzabokradno.ohbp.controller;

import com.p2ohbpzabokradno.ohbp.model.CaseOhbp;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CaseOhbpController {


    @Autowired
    private CaseOhbpRepository caseOhbpRepository;


    @GetMapping("/template/admnistrator_page")
    public String getAll(Model model, @RequestParam(required = false) String keyword,
                         @RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "8") int size,
                         @RequestParam(defaultValue = "id,asc") String[] sort) {
        try {
            List<CaseOhbp> casesCaseOhbp = new ArrayList<CaseOhbp>();

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

            casesCaseOhbp = mediquePage.getContent();

            model.addAttribute("Slučaj broj", casesCaseOhbp);
            model.addAttribute("Trenutna stranica", mediquePage.getNumber() + 1);
            model.addAttribute("Ukupno slučaja", mediquePage.getTotalElements());
            model.addAttribute("Ukupno stranica", mediquePage.getTotalPages());
            model.addAttribute("Veličina stranice", size);
            model.addAttribute("Sortiranje", sortField);
            model.addAttribute("Smjer sortiranja", sortDirection);
            model.addAttribute("Obrnuti smjer sortiranja ", sortDirection.equals("asc") ? "desc" : "asc");
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "administrator_page";
    }
}