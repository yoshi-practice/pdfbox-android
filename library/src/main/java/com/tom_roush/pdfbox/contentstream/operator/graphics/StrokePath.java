package com.tom_roush.pdfbox.contentstream.operator.graphics;

import java.util.List;

import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.cos.COSBase;

import java.io.IOException;

/**
 * S Stroke the path.
 *
 * @author Ben Litchfield
 */
public final class StrokePath extends GraphicsOperatorProcessor
{
    @Override
    public void process(Operator operator, List<COSBase> operands) throws IOException
    {
        context.strokePath();
    }

    @Override
    public String getName()
    {
        return "S";
    }
}
