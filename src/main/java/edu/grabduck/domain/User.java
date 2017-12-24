package edu.grabduck.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document(collection = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class User implements UserDetails {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String username;
    private Collection<Role> authorities;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
