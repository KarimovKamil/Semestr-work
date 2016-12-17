package ru.itis.inform.validation.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.config.DaoConfig;

@Component
public class ThePropertyValidator {
    private static final String VERIFY_THE_PROPERTY_ID_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT the_property_id FROM the_property WHERE the_property_id = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private static final String VERIFY_THE_PROPERTY_WITH_THIS_GOODS_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT the_property_id FROM the_property WHERE goods_id = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private JdbcTemplate jdbcTemplate = new DaoConfig().jdbcTemplate();

    public boolean verifyTheProperty(int thePropertyId) {
        return jdbcTemplate.queryForObject(VERIFY_THE_PROPERTY_ID_EXISTENCE, Boolean.class, thePropertyId);
    }

    public boolean verifyThePropertyWithThisGoods(int goodsId) {
        return jdbcTemplate.queryForObject(VERIFY_THE_PROPERTY_WITH_THIS_GOODS_EXISTENCE, Boolean.class, goodsId);
    }
}
