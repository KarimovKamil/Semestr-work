package ru.itis.inform.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.ThePropertyDao;
import ru.itis.inform.dao.config.DaoConfig;
import ru.itis.inform.models.TheProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ThePropertyDaoImpl implements ThePropertyDao {
    private static final String CREATE_THE_PROPERTY_SQL =
            "INSERT INTO the_property (goods_id, address, dwelling_space) " +
                    "VALUES (:goodsId, :address, :dwellingSpace) RETURNING the_property_id;";
    private static final String DELETE_THE_PROPERTY_SQL =
            "DELETE FROM the_property WHERE the_property_id = :thePropertyId;";
    private static final String GET_THE_PROPERTY_BY_ID_SQL =
            "SELECT * FROM the_property INNER JOIN goods ON goods.goods_id = the_property.goods_id " +
                    "WHERE the_property_id = :thePropertyId;";
    private static final String GET_ALL_PROPERTYS_SQL =
            "SELECT * FROM the_property INNER JOIN goods ON goods.goods_id = the_property.goods_id;";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = new DaoConfig().namedParameterJdbcTemplate();

    private RowMapper<TheProperty> thePropertyMapper() {
        return (resultSet, i) -> {
            TheProperty theProperty = (TheProperty) new TheProperty.Builder()
                    .dwellingSpace(resultSet.getInt("dwelling_space"))
                    .address(resultSet.getString("address"))
                    .goodsId(resultSet.getInt("goods_id"))
                    .goodsPrice(resultSet.getInt("pawnshop_price"))
                    .goodsType(resultSet.getString("goods_type"))
                    .build();

            return theProperty;
        };
    }

    public int saveTheProperty(TheProperty theProperty) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("goodsId", theProperty.getGoodsId());
        params.put("address", theProperty.getAddress());
        params.put("dwellingSpace", theProperty.getDwellingSpace());

        return namedParameterJdbcTemplate.queryForObject(CREATE_THE_PROPERTY_SQL, params, int.class);
    }

    public void deleteTheProperty(int thePropertyId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("thePropertyId", thePropertyId);

        namedParameterJdbcTemplate.update(DELETE_THE_PROPERTY_SQL, params);
    }

    public TheProperty getTheProperty(int thePropertyId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("thePropertyId", thePropertyId);

        return namedParameterJdbcTemplate.queryForObject(GET_THE_PROPERTY_BY_ID_SQL, params, thePropertyMapper());
    }

    public List<TheProperty> getAll() {
        return namedParameterJdbcTemplate.query(GET_ALL_PROPERTYS_SQL, thePropertyMapper());
    }
}
