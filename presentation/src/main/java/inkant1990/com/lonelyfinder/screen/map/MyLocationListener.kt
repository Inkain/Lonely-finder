package inkant1990.com.lonelyfinder.screen.map

import android.location.Location
import android.location.LocationListener
import android.os.Bundle

class MyLocationListener : LocationListener {

    lateinit var myPos : Location

    override fun onLocationChanged(location: Location) {
        myPos = location
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

    override fun onProviderEnabled(provider: String?) {}

    override fun onProviderDisabled(provider: String?) {}

}