package com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;

import java.util.ArrayList;
import java.util.List;

/**
 * A User attribute object.
 * 
 * @author Johannes Koch
 */
public class PDUserAttributeObject extends PDAttributeObject
{

    /**
     * Attribute owner for user properties
     */
    public static final String OWNER_USER_PROPERTIES = "UserProperties";


    /**
     * Default constructor
     */
    public PDUserAttributeObject()
    {
        this.setOwner(OWNER_USER_PROPERTIES);
    }

    /**
     * 
     * @param dictionary the dictionary
     */
    public PDUserAttributeObject(COSDictionary dictionary)
    {
        super(dictionary);
    }


    /**
     * Returns the user properties.
     * 
     * @return the user properties
     */
    public List<PDUserProperty> getOwnerUserProperties()
    {
        COSArray p = (COSArray) this.getCOSObject().getDictionaryObject(COSName.P);
        List<PDUserProperty> properties = new ArrayList<PDUserProperty>(p.size());
        for (int i = 0; i < p.size(); i++)
        {
            properties.add(
                new PDUserProperty((COSDictionary) p.getObject(i), this));
        }
        return properties;
    }

    /**
     * Sets the user properties.
     * 
     * @param userProperties the user properties
     */
    public void setUserProperties(List<PDUserProperty> userProperties)
    {
        COSArray p = new COSArray();
        for (PDUserProperty userProperty : userProperties)
        {
            p.add(userProperty);
        }
        this.getCOSObject().setItem(COSName.P, p);
    }

    /**
     * Adds a user property.
     * 
     * @param userProperty the user property
     */
    public void addUserProperty(PDUserProperty userProperty)
    {
        COSArray p = (COSArray) this.getCOSObject()
            .getDictionaryObject(COSName.P);
        p.add(userProperty);
        this.notifyChanged();
    }

    /**
     * Removes a user property.
     * 
     * @param userProperty the user property
     */
    public void removeUserProperty(PDUserProperty userProperty)
    {
        if (userProperty == null)
        {
            return;
        }
        COSArray p = (COSArray) this.getCOSObject().getDictionaryObject(COSName.P);
        p.remove(userProperty.getCOSObject());
        this.notifyChanged();
    }

    /**
     * @param userProperty  
     */
    public void userPropertyChanged(PDUserProperty userProperty)
    {
        
    }

    @Override
    public String toString()
    {
        return new StringBuilder().append(super.toString())
            .append(", userProperties=")
            .append(this.getOwnerUserProperties()).toString();
    }

}
