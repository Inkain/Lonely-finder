package inkant1990.com.lonelyfinder.screen.map

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import inkant1990.com.lonelyfinder.R
import inkant1990.com.lonelyfinder.base.BaseMvvmActivity
import inkant1990.com.lonelyfinder.databinding.ActivityMapBinding

class MapActivity : BaseMvvmActivity<
        MapViewModel,
        ActivityMapBinding,
        MapRouter>() {

    override fun prodiveViewModel()
            : MapViewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)

    override fun provideLayoutId()
            : Int = R.layout.activity_map

    override fun provideRouter()
            : MapRouter = MapRouter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync {
            it.mapType = GoogleMap.MAP_TYPE_NORMAL
        }
    }



}