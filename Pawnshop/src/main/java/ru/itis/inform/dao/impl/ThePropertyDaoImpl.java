package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.inform.dao.interfaces.ThePropertyDao;
import ru.itis.inform.models.TheProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Работа с таблицой the_property
 */
@Repository
public class ThePropertyDaoImpl implements ThePropertyDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String CREATE_THE_PROPERTY_SQL =
            "SELECT add_property(:goodsId, :address, :dwellingSpace);";

    private static final String DELETE_THE_PROPERTY_SQL =
            "DELETE FROM the_property WHERE the_property_id = :thePropertyId;";

    private static final String GET_THE_PROPERTY_BY_ID_SQL =
            "SELECT * FROM property_view " +
                    "WHERE the_property_id = :thePropertyId;";

    private static final String GET_ALL_PROPERTYS_SQL =
            "SELECT * FROM property_view ORDER BY(the_property_id);";

    private static final String UPDATE_THE_PROPERTY_SQL =
            "UPDATE the_property SET (address, dwelling_space) = " +
                    "(:address, :dwellingSpace)" +
                    "WHERE the_property_id = :propertyId;";

    private RowMapper<TheProperty> thePropertyMapper() {
        return (resultSet, i) -> (TheProperty) new TheProperty.Builder()
                .propertyId(resultSet.getInt("the_property_id"))
                .dwellingSpace(resultSet.getInt("dwelling_space"))
                .address(resultSet.getString("address"))
                .goodsId(resultSet.getInt("goods_id"))
                .goodsPrice(resultSet.getInt("pawnshop_price"))
                .goodsType(resultSet.getString("goods_type"))
                .description(resultSet.getString("description"))
                .build();
    }

    @Override
    public void saveTheProperty(TheProperty theProperty) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("goodsId", theProperty.getGoodsId());
        params.put("address", theProperty.getAddress());
        params.put("dwellingSpace", theProperty.getDwellingSpace());

        namedParameterJdbcTemplate.queryForObject(CREATE_THE_PROPERTY_SQL, params, String.class);
    }

    @Override
    public void deleteTheProperty(int thePropertyId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("thePropertyId", thePropertyId);
        namedParameterJdbcTemplate.update(DELETE_THE_PROPERTY_SQL, params);
    }

    @Override
    public TheProperty getTheProperty(int thePropertyId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("thePropertyId", thePropertyId);
        return namedParameterJdbcTemplate.queryForObject(GET_THE_PROPERTY_BY_ID_SQL, params, thePropertyMapper());
    }

    @Override
    public List<TheProperty> getAll() {
        return namedParameterJdbcTemplate.query(GET_ALL_PROPERTYS_SQL, thePropertyMapper());
    }

    @Override
    public void updateTheProperty(int thePropertyId, TheProperty theProperty) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("propertyId", thePropertyId);
        params.put("address", theProperty.getAddress());
        params.put("dwellingSpace", theProperty.getDwellingSpace());
        namedParameterJdbcTemplate.update(UPDATE_THE_PROPERTY_SQL, params);
    }
}
