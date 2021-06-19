package com.laioffer.eco.controller;

import com.laioffer.eco.model.Account;
import com.laioffer.eco.model.JwtRequest;
import com.laioffer.eco.model.JwtResponse;
import com.laioffer.eco.service.AccountService;
import com.laioffer.eco.service.UserService;
import com.laioffer.eco.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    /*
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    */

//    @PostMapping(path = "/register")
//    public void registerNewAccount(@RequestBody Account account) {
//        accountService.addNewAccount(account);
//    }


    @PostMapping("/register")
    public JwtResponse register(@RequestBody Account account) throws Exception {
        accountService.findAccountByEmailJWT(account);

        /*
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            account.getEmail(),
                            account.getPassword()
                    )
            );
        } catch(BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        */

        final UserDetails userDetails = userService.loadUserByUsername(account.getEmail());

        final String token = jwtUtility.generateToken(userDetails);

        accountService.setToken(account, token);

        return new JwtResponse(account.getId(), account.getFirstName(), token);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest jwtRequest) throws Exception {

        String email = jwtRequest.getEmail();
        String password = jwtRequest.getPassword();

        final UserDetails userDetails = userService.loadUserByUsername(email);

        if (!userDetails.getPassword().equals(password)) {
            throw  new Exception("Wrong Password");
        }

        Account account = accountService.getAccountByEmail(email);

        String token = account.getToken();
        if (!jwtUtility.validateToken(token, userDetails)) {
            token = jwtUtility.generateToken(userDetails);
            accountService.setToken(account, token);
        }

        return new JwtResponse(account.getId(), account.getFirstName(), token);
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping(path = "/get_info/{accountId}")
    public Account getAccountById(@PathVariable("accountId") Integer id) {
        return accountService.getAccountById(id);
    }

    @GetMapping(path = "/get_info/email={account_email}")
    public Account getAccountByEmail(@PathVariable("account_email") String email) {
        return accountService.getAccountByEmail(email);
    }

    @PutMapping(path = "/edit_info/{accountId}")
    public void updateAccount(
            @PathVariable(value = "accountId") Integer accountId,
            @RequestBody Account account
    ) {
        accountService.updateAccount(accountId, account.getPassword(),
                account.getFirstName(), account.getLastName(),
                account.getPhone(), account.getEmail(),
                account.getAddress(), account.getZipcode());
    }
}

