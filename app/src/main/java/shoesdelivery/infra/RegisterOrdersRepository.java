package shoesdelivery.infra;

import shoesdelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="registerOrders", path="registerOrders")
public interface RegisterOrdersRepository extends PagingAndSortingRepository<RegisterOrders, Long> {

    

    
}
