// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.adapter;

import com.pinterest.analytics.Pinalytics;
import com.pinterest.api.ApiResponse;
import com.pinterest.api.ApiResponseHandler;
import com.pinterest.api.model.ModelHelper;
import com.pinterest.api.model.User;
import com.pinterest.schemas.event.EventType;

class this._cls0 extends ApiResponseHandler
{

    final this._cls0 this$0;

    public void onFailure(Throwable throwable, ApiResponse apiresponse)
    {
        super.onFailure(throwable, apiresponse);
        throwable = ModelHelper.getUser(cess._mth200(this._cls0.this).getUid());
        if (throwable != null)
        {
            boolean flag;
            if (!throwable.getFollowing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            throwable.setFollowing(flag);
            ModelHelper.updateUser(throwable);
            if (cess._mth300(this._cls0.this) != null)
            {
                cess._mth300(this._cls0.this).onComplete();
            }
        }
    }

    public void onSuccess(ApiResponse apiresponse)
    {
        super.onSuccess(apiresponse);
        if (cess._mth200(this._cls0.this).getFollowing())
        {
            apiresponse = EventType.USER_FOLLOW;
        } else
        {
            apiresponse = EventType.USER_UNFOLLOW;
        }
        Pinalytics.a(apiresponse, cess._mth200(this._cls0.this).getUid());
    }

    llowRunnableComplete()
    {
        this$0 = this._cls0.this;
        super();
    }
}
