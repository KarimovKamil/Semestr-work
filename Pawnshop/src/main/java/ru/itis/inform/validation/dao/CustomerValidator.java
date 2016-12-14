package ru.itis.inform.validation.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.config.DaoConfig;

@Component
public class CustomerValidator {
    private static final String VERIFY_CUSTOMER_ID_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT customer_id FROM customer WHERE customer_id = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private static final String VERIFY_CUSTOMER_PHONE_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT customer_id FROM customer WHERE phone_number = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private static final String VERIFY_CUSTOMER_PASSPORT_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT customer_id FROM customer WHERE passport = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private JdbcTemplate jdbcTemplate = new DaoConfig().jdbcTemplate();

    public boolean verifyCustomer(int userId) {
        return jdbcTemplate.queryForObject(VERIFY_CUSTOMER_ID_EXISTENCE, Boolean.class, userId);
    }

    public boolean verifyPhoneExistence(String phone) {
        return jdbcTemplate.queryForObject(VERIFY_CUSTOMER_PHONE_EXISTENCE, Boolean.class, phone);
    }

    public boolean verifyPassportExistence(String passport) {
        return jdbcTemplate.queryForObject(VERIFY_CUSTOMER_PASSPORT_EXISTENCE, Boolean.class, passport);
    }
}
