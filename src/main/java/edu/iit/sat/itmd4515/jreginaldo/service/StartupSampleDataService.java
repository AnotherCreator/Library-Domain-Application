package edu.iit.sat.itmd4515.jreginaldo.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

@Startup
@Singleton
public class StartupSampleDataService {

    private static final Logger LOG = Logger.getLogger(StartupSampleDataService.class.getName());

    public StartupSampleDataService() {

    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside StartupSampleDataService.postConstruct method");
    }
}
