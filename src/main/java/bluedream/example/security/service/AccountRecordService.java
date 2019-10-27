package bluedream.example.security.service;


import bluedream.example.security.domain.AccountRecord;
import bluedream.example.security.repository.AccountRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
public class AccountRecordService {

    @Autowired
    private AccountRecordRepository accRecordRepository;

    public List<AccountRecord> findByUserId(Long userId) {
        return accRecordRepository.findAllByUserId(userId, Sort.by("accountId").descending());
    }

    public Iterable<AccountRecord> findAll() {

        return accRecordRepository.findAll(Sort.by("accountId").ascending());
    }


    public AccountRecord addRecord(AccountRecord accountRecord) {

        return accRecordRepository.save(accountRecord);
    }

    public AccountRecord doWithdrawals(Long userId, int withdrawalsAmt) {
        AccountRecord newAccRecord = new AccountRecord();
        List<AccountRecord> accountRecordList = findByUserId(userId);

        if (accountRecordList.size() >1) {
            AccountRecord accountRecord = accountRecordList.get(0);
            newAccRecord.setUserId(accountRecord.getUserId());
            newAccRecord.setWithdrawalsAmount(withdrawalsAmt);
            newAccRecord.setAccountBalance(accountRecord.getAccountBalance() - withdrawalsAmt);
            newAccRecord.setDepositAmount(0);
            newAccRecord.setNote("Withdrawals");
            accRecordRepository.save(newAccRecord);

        }

        return newAccRecord;
    }

}
