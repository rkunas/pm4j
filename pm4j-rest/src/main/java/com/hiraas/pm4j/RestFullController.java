package com.hiraas.pm4j;

import com.hiraas.pm4j.pms.CustomerDialogPm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customer")
public class RestFullController {

    private final CustomerDialogPm dialogPm = new CustomerDialogPm();

    @GetMapping
    public ResponseEntity<CustomerDialogPm> getFulldialog() {
        return ResponseEntity.ok(dialogPm);
    }

    @GetMapping("/**")
    public ResponseEntity getWild(final HttpServletRequest request) {

        String path = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        return ResponseEntity.ok(path);
    }

}
