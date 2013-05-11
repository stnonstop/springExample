package com.gg.example.springExample.web;

import com.gg.example.springExample.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: adurmaz
 * Date: 5/11/13
 * Time: 1:56 PM
 */
@Controller
public class PetClinicController {

    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping("/vets")
    @ResponseBody
    public String getVets(){
        return StringUtils.collectionToCommaDelimitedString(petClinicService.getVets());
    }

    @RequestMapping("/vets2")
    public void getVets2(HttpServletResponse response) throws IOException {
        response.getWriter().write(StringUtils.collectionToCommaDelimitedString(petClinicService.getVets()));
    }

    @RequestMapping("/findOwners/{lastName}")
    public ModelAndView findOwners(@PathVariable("lastName") String lastName){
        ModelAndView modelAndView = new ModelAndView("ownerResults");
        modelAndView.addObject("owners", petClinicService.findOwners(lastName));
        return modelAndView;
    }
}
