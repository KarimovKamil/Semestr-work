package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.TheProperty;

import java.util.List;

public interface ThePropertyDao {

    int saveTheProperty(TheProperty theProperty);

    void deleteTheProperty(int thePropertyId);

    TheProperty getTheProperty(int thePropertyId);

    List<TheProperty> getAll();

    //void updateTheProperty(int thePropertyId, TheProperty theProperty);

}
