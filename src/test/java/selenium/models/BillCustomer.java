package selenium.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillCustomer {
    private String name;
    private Address address;
    private String phoneNumber;
    private String accountNumber;
}
