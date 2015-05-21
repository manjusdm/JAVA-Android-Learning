// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap, GoogleMapOptions, OnMapReadyCallback

public class MapFragment extends Fragment
{

    private final b akR = new b(this);
    private GoogleMap akS;

    public MapFragment()
    {
    }

    public static MapFragment newInstance()
    {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googlemapoptions)
    {
        MapFragment mapfragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googlemapoptions);
        mapfragment.setArguments(bundle);
        return mapfragment;
    }

    public final GoogleMap getMap()
    {
        Object obj = nN();
        if (obj != null)
        {
            try
            {
                obj = ((IMapFragmentDelegate) (obj)).getMap();
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            if (obj != null)
            {
                if (akS == null || akS.nC().asBinder() != ((IGoogleMapDelegate) (obj)).asBinder())
                {
                    akS = new GoogleMap(((IGoogleMapDelegate) (obj)));
                }
                return akS;
            }
        }
        return null;
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        jx.aU("getMapAsync must be called on the main thread.");
        akR.getMapAsync(onmapreadycallback);
    }

    protected IMapFragmentDelegate nN()
    {
        akR.nO();
        if (akR.je() == null)
        {
            return null;
        } else
        {
            return ((a)akR.je()).nN();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/MapFragment.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        com.google.android.gms.maps.b.a(akR, activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        akR.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return akR.onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void onDestroy()
    {
        akR.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView()
    {
        akR.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        com.google.android.gms.maps.b.a(akR, activity);
        attributeset = GoogleMapOptions.createFromAttributes(activity, attributeset);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("MapOptions", attributeset);
        akR.onInflate(activity, bundle1, bundle);
    }

    public void onLowMemory()
    {
        akR.onLowMemory();
        super.onLowMemory();
    }

    public void onPause()
    {
        akR.onPause();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        akR.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(com/google/android/gms/maps/MapFragment.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        akR.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }

    private class b extends com.google.android.gms.dynamic.a
    {

        private final Fragment TG;
        protected f akW;
        private final List akX = new ArrayList();
        private Activity nB;

        static void a(b b1, Activity activity)
        {
            b1.setActivity(activity);
        }

        private void setActivity(Activity activity)
        {
            nB = activity;
            nO();
        }

        protected void a(f f1)
        {
            akW = f1;
            nO();
        }

        public void getMapAsync(OnMapReadyCallback onmapreadycallback)
        {
            if (je() != null)
            {
                ((a)je()).getMapAsync(onmapreadycallback);
                return;
            } else
            {
                akX.add(onmapreadycallback);
                return;
            }
        }

        public void nO()
        {
            if (nB == null || akW == null || je() != null)
            {
                break MISSING_BLOCK_LABEL_132;
            }
            try
            {
                MapsInitializer.initialize(nB);
                IMapFragmentDelegate imapfragmentdelegate = x.S(nB).j(e.k(nB));
                akW.a(new a(TG, imapfragmentdelegate));
                OnMapReadyCallback onmapreadycallback;
                for (Iterator iterator = akX.iterator(); iterator.hasNext(); ((a)je()).getMapAsync(onmapreadycallback))
                {
                    onmapreadycallback = (OnMapReadyCallback)iterator.next();
                }

            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                return;
            }
            akX.clear();
        }

        b(Fragment fragment)
        {
            TG = fragment;
        }
    }


    private class a
        implements MapLifecycleDelegate
    {

        private final Fragment TG;
        private final IMapFragmentDelegate akT;

        public void getMapAsync(OnMapReadyCallback onmapreadycallback)
        {
            try
            {
                class _cls1 extends com.google.android.gms.maps.internal.m.a
                {

                    final OnMapReadyCallback akU;
                    final a akV;

                    public void a(IGoogleMapDelegate igooglemapdelegate)
                    {
                        akU.onMapReady(new GoogleMap(igooglemapdelegate));
                    }

                _cls1(OnMapReadyCallback onmapreadycallback)
                {
                    akV = a.this;
                    akU = onmapreadycallback;
                    super();
                }
                }

                akT.getMapAsync(new _cls1(onmapreadycallback));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapReadyCallback onmapreadycallback)
            {
                throw new RuntimeRemoteException(onmapreadycallback);
            }
        }

        public IMapFragmentDelegate nN()
        {
            return akT;
        }

        public void onCreate(Bundle bundle)
        {
            Bundle bundle1;
            bundle1 = bundle;
            if (bundle != null)
            {
                break MISSING_BLOCK_LABEL_14;
            }
            bundle1 = new Bundle();
            bundle = TG.getArguments();
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (bundle.containsKey("MapOptions"))
            {
                w.a(bundle1, "MapOptions", bundle.getParcelable("MapOptions"));
            }
            akT.onCreate(bundle1);
            return;
            bundle;
            throw new RuntimeRemoteException(bundle);
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            try
            {
                layoutinflater = akT.onCreateView(e.k(layoutinflater), e.k(viewgroup), bundle);
            }
            // Misplaced declaration of an exception variable
            catch (LayoutInflater layoutinflater)
            {
                throw new RuntimeRemoteException(layoutinflater);
            }
            return (View)e.f(layoutinflater);
        }

        public void onDestroy()
        {
            try
            {
                akT.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onDestroyView()
        {
            try
            {
                akT.onDestroyView();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            bundle = (GoogleMapOptions)bundle.getParcelable("MapOptions");
            try
            {
                akT.onInflate(e.k(activity), bundle, bundle1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                throw new RuntimeRemoteException(activity);
            }
        }

        public void onLowMemory()
        {
            try
            {
                akT.onLowMemory();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onPause()
        {
            try
            {
                akT.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                akT.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                akT.onSaveInstanceState(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public a(Fragment fragment, IMapFragmentDelegate imapfragmentdelegate)
        {
            akT = (IMapFragmentDelegate)jx.i(imapfragmentdelegate);
            TG = (Fragment)jx.i(fragment);
        }
    }

}