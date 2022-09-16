package edu.iit.sat.itmd4515.jreginaldo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "CountryServlet", value = "/ctry")
public class CountryServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CountryServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("CountryServlet.doGet");
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

        // Create object
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
    }
}
