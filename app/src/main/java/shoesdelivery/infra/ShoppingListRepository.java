package shoesdelivery.infra;

import shoesdelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="shoppingLists", path="shoppingLists")
public interface ShoppingListRepository extends PagingAndSortingRepository<ShoppingList, Long> {

    

    
}
