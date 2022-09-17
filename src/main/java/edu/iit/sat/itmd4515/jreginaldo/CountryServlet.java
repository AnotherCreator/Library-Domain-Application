package edu.iit.sat.itmd4515.jreginaldo;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

@WebServlet(name = "CountryServlet", value = "/ctry")
public class CountryServlet extends HttpServlet {

    @Resource
    Validator validator;

    private static final Logger LOG = Logger.getLogger(CountryServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("CountryServlet.doGet");

//        request.setAttribute("country", ctry);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/country.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("CountryServlet.doPost");

        // Get user input
        String countryCodeParam = request.getParameter("countryCode");
        String countryNameParam = request.getParameter("countryName");
        String countryCtntParam = request.getParameter("countryContinent");
        String countryRgnParam = request.getParameter("countryRegion");
        String surfAreaParam = request.getParameter("surfaceArea");
        String populationParam = request.getParameter("population");
        String localNameParam = request.getParameter("localName");
        String govFormParam = request.getParameter("governmentForm");
        String countryCode2Param = request.getParameter("countryCode2");

        // Check if number values are valid
        Double surfaceArea = null;
        if (surfAreaParam != null && !surfAreaParam.isBlank()) {
            surfaceArea = Double.valueOf(surfAreaParam);
        }
        Integer population = null;
        if (populationParam != null && !populationParam.isBlank()) {
            population = Integer.valueOf(populationParam);
        }

        // Create new object(s)
        Country ctry = new Country();
        ctry.setCode(countryCodeParam);
        ctry.setName(countryNameParam);
        ctry.setContinent(countryCtntParam);
        ctry.setRegion(countryRgnParam);
        ctry.setSurfaceArea(surfaceArea);
        ctry.setPopulation(population);
        ctry.setLocalName(localNameParam);
        ctry.setGovernmentForm(govFormParam);
        ctry.setCode2(countryCode2Param);

        LOG.info(ctry.toString());

        Set<ConstraintViolation<Country>> violations = validator.validate(ctry);

        if (violations.size() > 0) { // If violations exist, send user back to form page and display errors
            for (ConstraintViolation<Country> violation : violations) {
                LOG.info(violation.toString());
            }

            request.setAttribute("errors", violations);
            request.setAttribute("country", ctry);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/country.jsp");
            requestDispatcher.forward(request, response);

        } else { // If no violations, send user to confirmation page displaying the final information
            // "ctry" is the ID that will be used to pull out of request scope
            // ctry is the input into the request scope
            request.setAttribute("country", ctry);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
