package org.example.assuranceapp.controllers;


import org.example.assuranceapp.models.Devis;
import org.example.assuranceapp.service.serviceInterface.DevisServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/devis")
public class DevisController {

    @Autowired
    DevisServiceInt devisService;

    @GetMapping("/display")
    public ModelAndView showGeneratedDevis(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/auth/login");
        }

        Devis generatedDevis = (Devis) session.getAttribute("generatedDevis");
        if (generatedDevis == null) {
            return new ModelAndView("redirect:/home?error=No devis generated!");
        }

        ModelAndView modelAndView = new ModelAndView("Devis");
        modelAndView.addObject("devis", generatedDevis);

        return modelAndView;
    }


    @PostMapping("/accept")
    public String acceptDevis(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Devis generatedDevis = (Devis) session.getAttribute("generatedDevis");

        if (generatedDevis != null) {
            // Set the Devis as accepted
            generatedDevis.setEstAccepte(true);
            devisService.updateDevis(generatedDevis); // Save the updated Devis

            // Optionally clear the session attribute
            session.removeAttribute("generatedDevis");

            return "redirect:/home?message=Devis accepted successfully!";
        }

        return "redirect:/home?error=No devis to accept!";
    }

    // Method to decline the Devis
    @PostMapping("/decline")
    public String declineDevis(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Devis generatedDevis = (Devis) session.getAttribute("generatedDevis");

        if (generatedDevis != null) {
            // Optionally, you might want to delete it or just clear the session
            session.removeAttribute("generatedDevis");
            return "redirect:/home?message=Devis declined.";
        }

        return "redirect:/home?error=No devis to decline!";
    }

}
