import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * Created by July on 4/16/15.
 */
public class StripeAPI
{
    public static void main(String[] args) throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException
    {
        Stripe.apiKey = "sk_test_BQokikJOvBiI2HlWgH4olfQ2";

        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("limit", 100);

        HashSet<String> emails = new HashSet<String>();

        for(Customer currentCustomer : Customer.all(customerParams).getData()){
            emails.add(currentCustomer.getEmail());
        }
        System.out.println(emails);

    }
}
