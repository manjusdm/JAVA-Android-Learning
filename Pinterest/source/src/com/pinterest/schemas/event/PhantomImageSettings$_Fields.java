// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.schemas.event;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.TFieldIdEnum;

public final class _fieldName extends Enum
    implements TFieldIdEnum
{

    private static final getFieldName $VALUES[];
    public static final getFieldName CLIP_RECT;
    public static final getFieldName LOAD_IMAGES;
    private static final Map byName;
    private final String _fieldName;
    private final short _thriftId;

    public static _fieldName findByName(String s)
    {
        return (_fieldName)byName.get(s);
    }

    public static byName findByThriftId(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return CLIP_RECT;

        case 2: // '\002'
            return LOAD_IMAGES;
        }
    }

    public static LOAD_IMAGES findByThriftIdOrThrow(int i)
    {
        LOAD_IMAGES load_images = findByThriftId(i);
        if (load_images == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return load_images;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PhantomImageSettings$_Fields, s);
    }

    public static findByThriftId[] values()
    {
        return (findByThriftId[])$VALUES.clone();
    }

    public final String getFieldName()
    {
        return _fieldName;
    }

    public final short getThriftFieldId()
    {
        return _thriftId;
    }

    static 
    {
        CLIP_RECT = new <init>("CLIP_RECT", 0, (short)1, "clipRect");
        LOAD_IMAGES = new <init>("LOAD_IMAGES", 1, (short)2, "loadImages");
        $VALUES = (new .VALUES[] {
            CLIP_RECT, LOAD_IMAGES
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PhantomImageSettings$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
        {
            _lthriftid = (getFieldName)iterator.next();
        }

    }

    private (String s, int i, short word0, String s1)
    {
        super(s, i);
        _thriftId = word0;
        _fieldName = s1;
    }
}