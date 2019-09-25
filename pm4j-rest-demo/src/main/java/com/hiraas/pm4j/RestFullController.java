package com.hiraas.pm4j;

import com.hiraas.pm4j.pms.CustomerDialogPm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class RestFullController {

    public final CustomerDialogPm dialogPm = new CustomerDialogPm();

    @GetMapping("/dialogpm/**/doit")
    public ResponseEntity commandDoIt(HttpServletRequest request) {

        new PmRestCommand()
                .doIt(request, dialogPm);

        return ResponseEntity.ok(dialogPm);
    }

    @GetMapping("/dialogpm/**/value/{pmVal}")
    public ResponseEntity setValue(HttpServletRequest request, @PathVariable("pmVal") String pmVal){

        new PmRestValue()
                .setValue(request,dialogPm, pmVal);

        return ResponseEntity.ok(dialogPm);
    }

    @GetMapping("/fullpm/**")
    public ResponseEntity pmFull(HttpServletRequest request) {

        dialogPm.searchText.setValue("e");
        dialogPm.searchCommandPm.doIt();
        return ResponseEntity.ok(dialogPm);
    }



}
