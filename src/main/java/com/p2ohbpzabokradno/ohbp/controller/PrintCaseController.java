package com.p2ohbpzabokradno.ohbp.controller;

import com.p2ohbpzabokradno.ohbp.model.CaseOhbp;
import com.p2ohbpzabokradno.ohbp.repository.CaseOhbpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.print.*;
import java.io.IOException;


@Controller
public class PrintCaseController {


    @Autowired
    private CaseOhbpRepository caseOhbpRepository;

    private byte[] generatePdf(String cellId) {
        return new byte[0];
    }
    public class printCaseOhbp {

        @GetMapping("/print/{CaseOhbp.caseID}")
        public ResponseEntity<byte[]> printCell(@PathVariable String CaseOhbp ) throws IOException, PrintException {

            // generiranje pdf-a prema odabranoj celiji
            byte[] pdfBytes = generatePdf(CaseOhbp);

            // headeri za generiranje pdfa
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline").filename("cell_" + CaseOhbp + ".pdf").build());

            // slanje pdf-a na virtualni printer
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.PDF;
            Doc doc = new SimpleDoc(pdfBytes, flavor, null);
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            DocPrintJob job = service.createPrintJob();
            job.print(doc, null);

            // vracanje pdfBytes
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(pdfBytes.length)
                    .body(pdfBytes);

        }
    }
}