package com.tom_roush.pdfbox.pdmodel.interactive.annotation;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.graphics.PDLineDashPattern;

/**
 * This class represents a PDF /BS entry the border style dictionary.
 *
 * @author Paul King
 */
public class PDBorderStyleDictionary implements COSObjectable
{

    /*
     * The various values of the style for the border as defined in the PDF 1.6
     * reference Table 8.13
     */

    /**
     * Constant for the name of a solid style.
     */
    public static final String STYLE_SOLID = "S";

    /**
     * Constant for the name of a dashed style.
     */
    public static final String STYLE_DASHED = "D";

    /**
     * Constant for the name of a beveled style.
     */
    public static final String STYLE_BEVELED = "B";

    /**
     * Constant for the name of a inset style.
     */
    public static final String STYLE_INSET = "I";

    /**
     * Constant for the name of a underline style.
     */
    public static final String STYLE_UNDERLINE = "U";

    private final COSDictionary dictionary;

    /**
     * Constructor.
     */
    public PDBorderStyleDictionary()
    {
        dictionary = new COSDictionary();
    }

    /**
     * Constructor.
     *
     * @param dict
     *            a border style dictionary.
     */
    public PDBorderStyleDictionary( COSDictionary dict )
    {
        dictionary = dict;
    }

    /**
     * returns the dictionary.
     *
     * @return the dictionary
     */
    @Override
    public COSDictionary getCOSObject()
    {
        return dictionary;
    }

    /**
     * This will set the border width in points, 0 = no border.
     *
     * @param w
     *            float the width in points
     */
    public void setWidth( float w )
    {
        getCOSObject().setFloat("W", w);
    }

    /**
     * This will retrieve the border width in points, 0 = no border.
     *
     * @return flaot the width of the border in points
     */
    public float getWidth()
    {
        return getCOSObject().getFloat("W", 1);
    }

    /**
     * This will set the border style, see the STYLE_* constants for valid values.
     *
     * @param s
     *            the border style to use
     */
    public void setStyle( String s )
    {
        getCOSObject().setName("S", s);
    }

    /**
     * This will retrieve the border style, see the STYLE_* constants for valid
     * values.
     *
     * @return the style of the border
     */
    public String getStyle()
    {
        return getCOSObject().getNameAsString("S", STYLE_SOLID);
    }

    /**
     * This will set the dash style used for drawing the border.
     *
     * @param dashArray
     *            the dash style to use
     */
    public void setDashStyle( COSArray dashArray )
    {
        COSArray array = null;
        if( dashArray != null )
        {
            array = dashArray;
        }
        getCOSObject().setItem("D", array);
    }

    /**
     * This will retrieve the dash style used for drawing the border.
     *
     * @return the dash style of the border
     */
    public PDLineDashPattern getDashStyle()
    {
        COSArray d = (COSArray) getCOSObject().getDictionaryObject("D");
        if (d == null)
        {
            d = new COSArray();
            d.add( COSInteger.THREE );
            getCOSObject().setItem("D", d);
        }
        return new PDLineDashPattern( d, 0 );
    }

}
