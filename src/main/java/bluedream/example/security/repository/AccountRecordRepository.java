package bluedream.example.security.repository;



import bluedream.example.security.domain.AccountRecord;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface AccountRecordRepository extends JpaRepository<AccountRecord, Long> {
public interface AccountRecordRepository extends PagingAndSortingRepository<AccountRecord, Long> {

    List<AccountRecord> findAllByUserId(Long userId, Sort sort);
}
