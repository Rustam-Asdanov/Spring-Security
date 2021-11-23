package com.example.spring_group_one.lesson_five.auth;

import com.example.spring_group_one.lesson_five.dao.AccountService;
import com.example.spring_group_one.lesson_five.model.Account;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.spring_group_one.lesson_five.security.UserRole.GUEST;

@Service
public class ApplicationUserFilter {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUserFilter(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<ApplicationUser> selectApplicationByUsername(String username){
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUserList = Lists.newArrayList();

        for(Account theAccount : accountService.getAccountList()){
            ApplicationUser applicationUser = new ApplicationUser(
                    theAccount.getLogin(),
                    passwordEncoder.encode(theAccount.getPassword()),
                    GUEST.name(),
                    GUEST.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            );

            applicationUserList.add(applicationUser);
        }

        return applicationUserList;
    }

}
