package com.tom_roush.pdfbox.pdmodel.font;

import java.io.IOException;

import com.tom_roush.pdfbox.cos.COSDictionary;

/**
 * Type 1 Multiple Master Font.
 *
 * @author Ben Litchfield
 */
public class PDMMType1Font extends PDType1Font
{
    /**
     * Creates an MMType1Font from a Font dictionary in a PDF.
     *
     * @param fontDictionary font dictionary
     */
    public PDMMType1Font(COSDictionary fontDictionary) throws IOException
    {
        super(fontDictionary);
    }
}
