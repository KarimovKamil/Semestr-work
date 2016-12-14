package ru.itis.inform.validation.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.config.DaoConfig;

@Component
public class OperationValidator {
    private static final String VERIFY_OPERATION_ID_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT operation_id FROM operation WHERE operation_id = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private JdbcTemplate jdbcTemplate = new DaoConfig().jdbcTemplate();

    public boolean verifyOperation(int operationId) {
        return jdbcTemplate.queryForObject(VERIFY_OPERATION_ID_EXISTENCE, Boolean.class, operationId);
    }
}
