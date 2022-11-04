package shoesdelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="ShoppingList_table")
@Data
public class ShoppingList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


}