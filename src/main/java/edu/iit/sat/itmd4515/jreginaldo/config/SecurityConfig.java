package edu.iit.sat.itmd4515.jreginaldo.config;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

// General structure as demo'd in class

@Named
@ApplicationScoped
@DeclareRoles({"ADMIN_ROLE", "EMPLOYEE_ROLE", "MEMBER_ROLE"})
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "SELECT PASSWORD FROM sec_user WHERE USERNAME = ?",
        groupsQuery = "SELECT GROUPNAME FROM sec_user_groups WHERE USERNAME = ?"
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "/error.xhtml"
        )
)
public class SecurityConfig {

}
