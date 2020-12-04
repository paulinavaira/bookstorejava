//package com.jedify.bookstore;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Configuration
//class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
//    @Autowired
//    UserRepository userRepository;
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(inputName-> {
//            User user = userRepository.findByUsername(inputName);
//            if (user != null) {
//                if(user.getUsername().equals("pato@gmail.com")){
//                    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                            AuthorityUtils.createAuthorityList("ADMIN"));
//                } else {
//                    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                            AuthorityUtils.createAuthorityList("USER"));
//                }
//            } else {
//                throw new UsernameNotFoundException("Unknown user: " + inputName);
//            }
//        });
//    }
//}
