package com.gg.example.springExample.web;

import com.gg.example.springExample.model.Vet;
import com.gg.example.springExample.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * User: adurmaz
 * Date: 5/11/13
 * Time: 11:07 AM
 */
@WebServlet(name = "PetClinicServlet")
public class PetClinicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("getVets".equals(action)) {
             WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
             PetClinicService petClinicService = context.getBean(PetClinicService.class);
             Collection<Vet> vets = petClinicService.getVets();
             response.getWriter().write(StringUtils.collectionToCommaDelimitedString(vets));
        } else {
            response.getWriter().write("unknown action :" + action);
        }
    }
}
