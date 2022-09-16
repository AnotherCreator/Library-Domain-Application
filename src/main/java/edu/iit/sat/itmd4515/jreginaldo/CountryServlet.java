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

        String countryCodeParam = request.getParameter("countryCode");
        String countryNameParam = request.getParameter("countryName");
        String countryCtntParam = request.getParameter("countryContinent");
        String countryRgnParam = request.getParameter("countryRegion");
        String surfAreaParam = request.getParameter("surfaceArea");
        String populationParam = request.getParameter("population");
        String localNameParam = request.getParameter("localName");
        String govFormParam = request.getParameter("governmentForm");
        String countryCode2Param = request.getParameter("countryCode2");

        // Che

        Country ctry = new Country();
        ctry.setCode(countryCodeParam);
        ctry.setName(countryNameParam);
        ctry.setContinent(countryCtntParam);
        ctry.setRegion(countryRgnParam);
        ctry.setSurfaceArea(Double.valueOf(surfAreaParam));
        ctry.setPopulation(Integer.valueOf(populationParam));
        ctry.setLocalName(localNameParam);
        ctry.setGovernmentForm(govFormParam);
        ctry.setCode2(countryCode2Param);

        LOG.info(ctry.toString());
    }
}
