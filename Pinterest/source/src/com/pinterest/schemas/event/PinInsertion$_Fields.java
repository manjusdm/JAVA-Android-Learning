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
    public static final getFieldName ADS_INSERTION_ID;
    public static final getFieldName PIN_ID;
    public static final getFieldName SLOT;
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
            return PIN_ID;

        case 2: // '\002'
            return ADS_INSERTION_ID;

        case 3: // '\003'
            return SLOT;
        }
    }

    public static SLOT findByThriftIdOrThrow(int i)
    {
        SLOT slot = findByThriftId(i);
        if (slot == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());
        } else
        {
            return slot;
        }
    }

    public static findByThriftId valueOf(String s)
    {
        return (findByThriftId)Enum.valueOf(com/pinterest/schemas/event/PinInsertion$_Fields, s);
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
        PIN_ID = new <init>("PIN_ID", 0, (short)1, "pinId");
        ADS_INSERTION_ID = new <init>("ADS_INSERTION_ID", 1, (short)2, "adsInsertionId");
        SLOT = new <init>("SLOT", 2, (short)3, "slot");
        $VALUES = (new .VALUES[] {
            PIN_ID, ADS_INSERTION_ID, SLOT
        });
        byName = new HashMap();
        _thriftId _lthriftid;
        for (Iterator iterator = EnumSet.allOf(com/pinterest/schemas/event/PinInsertion$_Fields).iterator(); iterator.hasNext(); byName.put(_lthriftid.getFieldName(), _lthriftid))
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
