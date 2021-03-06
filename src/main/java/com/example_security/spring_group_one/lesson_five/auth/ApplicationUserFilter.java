package com.example_security.spring_group_one.lesson_five.auth;

import com.example_security.spring_group_one.lesson_five.dao.AccountService;
import com.example_security.spring_group_one.lesson_five.model.Account;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example_security.spring_group_one.lesson_five.security.UserRole.GUEST;

@Service
public class ApplicationUserFilter {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUserFilter(AccountService accountService,
                                 PasswordEncoder passwordEncoder)
    {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<ApplicationUser> selectApplicationByUsername(String username) {
        List<ApplicationUser> applicationUserList = new ArrayList<>();
        Account theAccount = accountService.findAccountByLogin(username);
        applicationUserList.add(
                new ApplicationUser(
                        theAccount.getLogin(),
//                        passwordEncoder.encode(theAccount.getPassword()),
                        theAccount.getPassword(),
                        GUEST.name(),
                        GUEST.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );


        return applicationUserList
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

}
