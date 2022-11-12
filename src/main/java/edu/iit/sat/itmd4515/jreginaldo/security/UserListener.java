package edu.iit.sat.itmd4515.jreginaldo.security;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

public class UserListener {

    @Inject private Pbkdf2PasswordHash hash;

    @PrePersist
    @PreUpdate
    private void prePersistAndUpdate(User u) {
        // Hash password before updated in DB
        u.setPassword(hash.generate(u.getPassword().toCharArray()));
    }
}
