package com.tom_roush.pdfbox.pdmodel.common.filespecification;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSString;

/**
 * A file specification that is just a string.
 *
 * @author Ben Litchfield
 */
public class PDSimpleFileSpecification extends PDFileSpecification
{
    private COSString file;

    /**
     * Constructor.
     */
    public PDSimpleFileSpecification()
    {
        file = new COSString("");
    }

    /**
     * Constructor.
     *
     * @param fileName The file that this spec represents.
     */
    public PDSimpleFileSpecification(COSString fileName)
    {
        file = fileName;
    }

    /**
     * This will get the file name.
     *
     * @return The file name.
     */
    @Override
    public String getFile()
    {
        return file.getString();
    }

    /**
     * This will set the file name.
     *
     * @param fileName The name of the file.
     */
    @Override
    public void setFile(String fileName)
    {
        file = new COSString(fileName);
    }

    /**
     * Convert this standard java object to a COS object.
     *
     * @return The cos object that matches this Java object.
     */
    @Override
    public COSBase getCOSObject()
    {
        return file;
    }

}
