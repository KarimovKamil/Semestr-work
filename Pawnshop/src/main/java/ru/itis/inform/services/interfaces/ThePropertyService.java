package ru.itis.inform.services.interfaces;

import ru.itis.inform.models.TheProperty;

import java.util.List;

/**
 * Created by Kamil Karimov on 17.12.2016.
 */
public interface ThePropertyService {
    
    void saveProperty(int goodsId, TheProperty property);

    void deleteProperty(int propertyId);

    TheProperty getProperty(int propertyId);

    List<TheProperty> getAll();

    void updateProperty(int PropertyId, TheProperty property);
}
