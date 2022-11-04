package shoesdelivery.domain;

import shoesdelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="paymentHistories", path="paymentHistories")
public interface PaymentHistoryRepository extends PagingAndSortingRepository<PaymentHistory, Long>{

}
