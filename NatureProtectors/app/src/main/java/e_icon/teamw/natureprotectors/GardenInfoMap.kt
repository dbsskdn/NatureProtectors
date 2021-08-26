package e_icon.teamw.natureprotectors

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.MarkerOptions

class GardenInfoMap : Fragment(), OnMapReadyCallback {

    private lateinit var mContext: Context
    private lateinit var map: GoogleMap

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is GardenRegistration) {
            mContext = context
        }
    }

    private lateinit var mView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.garden_info_map, container, false)
        mView = rootView.findViewById(R.id.garden_info_map_view)
        mView.onCreate(savedInstanceState)
        mView.getMapAsync(this)
        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val markerOptions = MarkerOptions()
        markerOptions.position(gardenLocation)
        map.clear()
        map.animateCamera(CameraUpdateFactory.newLatLng(gardenLocation))
        map.addMarker(markerOptions)
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(10f))
    }

    override fun onStart() {
        super.onStart()
        mView.onStart()
    }
    override fun onStop() {
        super.onStop()
        mView.onStop()
    }
    override fun onResume() {
        super.onResume()
        mView.onResume()
    }
    override fun onPause() {
        super.onPause()
        mView.onPause()
    }
    override fun onLowMemory() {
        super.onLowMemory()
        mView.onLowMemory()
    }
    override fun onDestroy() {
        mView.onDestroy()
        super.onDestroy()
    }
}
