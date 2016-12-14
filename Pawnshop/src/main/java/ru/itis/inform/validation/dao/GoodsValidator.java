package ru.itis.inform.validation.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.config.DaoConfig;

@Component
public class GoodsValidator {
    private static final String VERIFY_GOODS_ID_EXISTENCE =
            "SElECT CASE WHEN EXISTS " +
                    " (SELECT goods_id FROM goods WHERE goods_id = ?)" +
                    " THEN TRUE ELSE FALSE" +
                    " END;";

    private JdbcTemplate jdbcTemplate = new DaoConfig().jdbcTemplate();

    public boolean verifyGoods(int goodsId) {
        return jdbcTemplate.queryForObject(VERIFY_GOODS_ID_EXISTENCE, Boolean.class, goodsId);
    }
}
