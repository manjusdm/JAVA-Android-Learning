// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.exceptions;


public class RealmIOException extends RuntimeException
{

    public RealmIOException()
    {
    }

    public RealmIOException(String s)
    {
        super(s);
    }

    public RealmIOException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public RealmIOException(Throwable throwable)
    {
        super(throwable);
    }
}
