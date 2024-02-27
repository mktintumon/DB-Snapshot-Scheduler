package com.scheduler.cyraacs.controller;

import com.scheduler.cyraacs.models.ControlRequirements;
import com.scheduler.cyraacs.repo.CrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CrController {
        @Autowired
        CrRepo crRepo;



        @PostMapping("/setStatusFalse/{cr_id}")
        public void changeComplianceStatusFalse(@PathVariable Integer cr_id) {
                ControlRequirements controlRequirements = crRepo.findByControlId(cr_id);
                controlRequirements.setComplianceStatus(false);
        }

        @PostMapping("/setStatusTrue/{cr_id}")
        public void changeComplianceStatusTrue(@PathVariable Integer cr_id) {
                ControlRequirements controlRequirements = crRepo.findByControlId(cr_id);
                System.out.println(controlRequirements.getControlId());
                controlRequirements.setComplianceStatus(true);
                crRepo.save(controlRequirements);
        }


}
