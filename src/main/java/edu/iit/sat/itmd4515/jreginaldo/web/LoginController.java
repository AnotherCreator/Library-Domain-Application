package edu.iit.sat.itmd4515.jreginaldo.web;

import edu.iit.sat.itmd4515.jreginaldo.security.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(MemberController.class.getName());

    private User user;

    @Inject
    SecurityContext securityContext;
    @Inject
    FacesContext facesContext;

    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside LoginController.postConstuct");

        user = new User();
    }

    public String getAuthenticatedUser() {
        return facesContext.getExternalContext().getRemoteUser();
    }

    public String doLogin() {
        LOG.info("Inside LoginController.doLogin" + this.user.getUserName());

        // JSR-375 AuthN
        Credential cred = new UsernamePasswordCredential(
                this.user.getUserName(),
                new Password(this.user.getPassword()));

        AuthenticationStatus authenticationStatus = securityContext.authenticate(
                (HttpServletRequest) facesContext.getExternalContext().getRequest(),
                (HttpServletResponse) facesContext.getExternalContext().getResponse(),
                AuthenticationParameters.withParams().credential(cred));

        switch (authenticationStatus) {
            case SUCCESS:
            case SEND_CONTINUE:
                LOG.info(authenticationStatus.toString());
                break;

            case SEND_FAILURE:
            case NOT_DONE:
                LOG.info(authenticationStatus.toString());
                return "/error.xhtml";

        }

        return "/welcome.xhtml?faces-redirect=true";
    }

    public String doLogOut() throws ServletException {

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        request.logout();


        return "/login.xhtml?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
