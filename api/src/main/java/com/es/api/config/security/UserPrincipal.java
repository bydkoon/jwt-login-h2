package com.es.api.config.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//@Getter
//public class UserPrincipal implements UserDetails {
//
//    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
//    private String id;	// DB에서 PK 값
//    private String name;		// 로그인용 ID 값
//    private String password;	// 비밀번호
//    private String regNo;	//주민번호
//    private Collection<GrantedAuthority> authorities;	//권한 목록
//
////    public UserPrincipal(User user) {
////        this.user = user;
////    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//    @Override
//    public String getUsername() {
//        return id;
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//
//    }
//}


