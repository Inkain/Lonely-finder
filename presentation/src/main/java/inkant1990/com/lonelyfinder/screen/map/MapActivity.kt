package inkant1990.com.lonelyfinder.screen.map

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import inkant1990.com.data.Utils
import inkant1990.com.data.net.ApiGet
import inkant1990.com.data.repository.UserRepository
import inkant1990.com.domain.interactor.GetUsers
import inkant1990.com.domain.repository.UserRepositoryImpl
import inkant1990.com.lonelyfinder.AndroidApplication
import inkant1990.com.lonelyfinder.R
import inkant1990.com.lonelyfinder.base.BaseMvvmActivity
import inkant1990.com.lonelyfinder.databinding.ActivityMapBinding
import inkant1990.com.lonelyfinder.executor.UIThread
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MapActivity : BaseMvvmActivity<
        MapViewModel,
        ActivityMapBinding,
        MapRouter>() {

    lateinit var imHere: Location

    val locationListener = MyLocationListener()

    val getUsers: GetUsers = GetUsers(UserRepository(Utils(), ApiGet()),UIThread())

    val directionDisplay = new .maps.DirectionRenders()

    override fun prodiveViewModel()
            : MapViewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)

    override fun provideLayoutId()
            : Int = R.layout.activity_map

    override fun provideRouter()
            : MapRouter = MapRouter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
//        appComponent.inject(this)
        super.onCreate(savedInstanceState)

        val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000L,
                    10F,
                    locationListener
            )
            imHere = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        } catch (ex: SecurityException) {
            Log.e("AA", ex.message)
        }
        val pos = LatLng(imHere.latitude, imHere.longitude)
        val cameraPosition = CameraPosition.Builder()
                .target(pos)
                .zoom(14F)
                .build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        val maps = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        maps.getMapAsync { map ->
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            map.isMyLocationEnabled
            map.animateCamera(cameraUpdate)
            map.addMarker(MarkerOptions()
                    .position(pos)
                    .title("im free")
                    .snippet("free im")
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
                    .showInfoWindow()

        }

        getUsers.execute(Unit).subscribeBy(
                onNext = { list ->
                    list.map {
                        maps.getMapAsync { map ->
                            map.addMarker(MarkerOptions()
                                    .position(LatLng(it.latitude, it.longitude!!))
                                    .icon(BitmapDescriptorFactory
                                            .defaultMarker(BitmapDescriptorFactory.HUE_RED)))
                                    .title = it.status
                        }
                    }
                },
                onError = {
                    Log.e("AAA", it.message)
                }
        )

    }


}