package shoesdelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="ViewOrderDetails_table")
@Data
public class ViewOrderDetails {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


}