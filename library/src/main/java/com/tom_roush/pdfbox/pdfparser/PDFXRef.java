package com.tom_roush.pdfbox.pdfparser;

import com.tom_roush.pdfbox.cos.COSObject;

/**
 * @author Alexander Funk
 */
public interface PDFXRef
{

    /**
     * Returns the object referenced by the given object number.
     * 
     * @param objectNumber the object to be returned
     * @return the object corresponding to the given object number
     */
    
    COSObject getObject(int objectNumber);
}
