package bluedream.example.security.controller;

import bluedream.example.security.domain.AccountRecord;

import bluedream.example.security.domain.User;
import bluedream.example.security.service.AccountRecordService;
import bluedream.example.security.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @Autowired
    private AccountRecordService accRecordService;

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @GetMapping(value ="/AccRecords")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public Iterable<AccountRecord> fetchAllAccRecord(){

        return accRecordService.findAll();
    }

    @PostMapping(value ="/AccWithdrawals/{userId}")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public AccountRecord WithdrawalsAccRecord(@PathVariable String userId, @RequestParam(name = "WDAmount", required = true, defaultValue = "0") int WithdrawalsAmt){

        System.out.println("WithdrawalsAmt: " + WithdrawalsAmt);
        return accRecordService.doWithdrawals(Long.parseLong(userId), WithdrawalsAmt);
    }
}
