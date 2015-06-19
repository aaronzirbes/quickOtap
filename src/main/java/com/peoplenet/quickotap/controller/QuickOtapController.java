package com.peoplenet.quickotap.controller;

import com.peoplenet.quickotap.service.QuickOtapService;
import com.peoplenet.quickotap.model.Otap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class QuickOtapController {

    private static final Logger LOG = LoggerFactory.getLogger(QuickOtapController.class);
    
    @Resource
    private QuickOtapService quickOtapService;

    @RequestMapping(value = {"/process"}, method = {RequestMethod.POST}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public void processEvent(@RequestBody Otap otap) {
        
        if (otap != null)
        {
            quickOtapService.startOtap(otap);
        }

    }

    @RequestMapping(value = {"/packages"}, method = {RequestMethod.GET}, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public void returnPackages(@RequestParam("topic") String topic, @RequestBody Otap otap) {

        //Coming Soon
        
        if (otap != null)
        {
            quickOtapService.startOtap(otap);
        }

    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void unexpectedException(final Exception ex) {
        LOG.error("Something really bad happened.", ex);
    }

}