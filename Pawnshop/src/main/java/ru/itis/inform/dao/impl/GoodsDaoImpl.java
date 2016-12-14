package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.GoodsDao;
import ru.itis.inform.dao.config.DaoConfig;
import ru.itis.inform.models.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsDaoImpl implements GoodsDao {
    private static final String CREATE_GOODS_SQL =
            "INSERT INTO goods (goods_type, pawnshop_price) VALUES (:goodsType, :pawnshopPrice) " +
                    "RETURNING goods_id;";
    private static final String DELETE_GOODS_SQL =
            "DELETE FROM goods WHERE goods_id = :goodsId;";
    private static final String GET_GOODS_BY_ID_SQL =
            "SELECT * FROM goods WHERE goods_id = :goodsId;";
    private static final String GET_ALL_GOODS_SQL =
            "SELECT * FROM goods;";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = new DaoConfig().namedParameterJdbcTemplate();

    private RowMapper<Goods> goodsMapper() {
        return (resultSet, i) -> {
            Goods goods = new Goods.Builder()
                    .goodsId(resultSet.getInt("goods_id"))
                    .goodsType(resultSet.getString("goods_type"))
                    .goodsPrice(resultSet.getInt("pawnshop_price"))
                    .build();

            return goods;
        };
    }

    public int saveGoods(Goods goods) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("goodsType", goods.getGoodsType());
        params.put("pawnshopPrice", goods.getGoodsPrice());

        return namedParameterJdbcTemplate.queryForObject(CREATE_GOODS_SQL, params, int.class);
    }

    public void deleteGoods(int goodsId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("goodsId", goodsId);
        namedParameterJdbcTemplate.update(DELETE_GOODS_SQL, params);
    }

    public Goods getGoods(int goodsId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("goodsId", goodsId);
        return namedParameterJdbcTemplate.queryForObject(GET_GOODS_BY_ID_SQL, params, goodsMapper());
    }

    public List<Goods> getAll() {
        return namedParameterJdbcTemplate.query(GET_ALL_GOODS_SQL, goodsMapper());
    }

    public void updateGoods(int goodsId, Goods goods) {

    }
}
