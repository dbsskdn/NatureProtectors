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
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

lateinit var gardenLocation: LatLng
var isInGardenInfo = false

class GoogleMapView : Fragment(), OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private lateinit var mContext: Context
    private lateinit var map: GoogleMap

    private val countryLatLngList: HashMap<String, LatLng> = object : HashMap<String, LatLng>() {
        init {
            put("Andorra", LatLng(42.546245, 1.601554))
            put("United Arab Emirates", LatLng(23.424076, 53.847818))
            put("Afghanistan", LatLng(33.93911, 67.709953))
            put("Antigua and Barbuda", LatLng(17.060816, -61.796428))
            put("Anguilla", LatLng(18.220554, -63.068615))
            put("Albania", LatLng(41.153332, 20.168331))
            put("Armenia", LatLng(40.069099, 45.038189))
            put("Netherlands Antilles", LatLng(12.226079, -69.060087))
            put("Angola", LatLng(-11.202692, 17.873887))
            put("Antarctica", LatLng(-75.250973, -0.071389))
            put("Argentina", LatLng(-38.416097, -63.616672))
            put("American Samoa", LatLng(-14.270972, -170.132217))
            put("Austria", LatLng(47.516231, 14.550072))
            put("Australia", LatLng(-25.274398, 133.775136))
            put("Aruba", LatLng(12.52111, -69.968338))
            put("Azerbaijan", LatLng(40.143105, 47.576927))
            put("Bosnia and Herzegovina", LatLng(43.915886, 17.679076))
            put("Barbados", LatLng(13.193887, -59.543198))
            put("Bangladesh", LatLng(23.684994, 90.356331))
            put("Belgium", LatLng(50.503887, 4.469936))
            put("Burkina Faso", LatLng(12.238333, -1.561593))
            put("Bulgaria", LatLng(42.733883, 25.48583))
            put("Bahrain", LatLng(25.930414, 50.637772))
            put("Burundi", LatLng(-3.373056, 29.918886))
            put("Benin", LatLng(9.30769, 2.315834))
            put("Bermuda", LatLng(32.321384, -64.75737))
            put("Brunei", LatLng(4.535277, 114.727669))
            put("Bolivia", LatLng(-16.290154, -63.588653))
            put("Brazil", LatLng(-14.235004, -51.92528))
            put("Bahamas", LatLng(25.03428, -77.39628))
            put("Bhutan", LatLng(27.514162, 90.433601))
            put("Bouvet Island", LatLng(-54.423199, 3.413194))
            put("Botswana", LatLng(-22.328474, 24.684866))
            put("Belarus", LatLng(53.709807, 27.953389))
            put("Belize", LatLng(17.189877, -88.49765))
            put("Canada", LatLng(56.130366, -106.346771))
            put("Cocos [Keeling] Islands", LatLng(-12.164165, 96.870956))
            put("Congo [DRC]", LatLng(-4.038333, 21.758664))
            put("Central African Republic", LatLng(6.611111, 20.939444))
            put("Congo [Republic]", LatLng(-0.228021, 15.827659))
            put("Switzerland", LatLng(46.818188, 8.227512))
            put("Côte d Ivoire", LatLng(7.539989, -5.54708))
            put("Cook Islands", LatLng(-21.236736, -159.777671))
            put("Chile", LatLng(-35.675147, -71.542969))
            put("Cameroon", LatLng(7.369722, 12.354722))
            put("China", LatLng(35.86166, 104.195397))
            put("Colombia", LatLng(4.570868, -74.297333))
            put("Costa Rica", LatLng(9.748917, -83.753428))
            put("Cuba", LatLng(21.521757, -77.781167))
            put("Cape Verde", LatLng(16.002082, -24.013197))
            put("Christmas Island", LatLng(-10.447525, 105.690449))
            put("Cyprus", LatLng(35.126413, 33.429859))
            put("Czech Republic", LatLng(49.817492, 15.472962))
            put("Germany", LatLng(51.165691, 10.451526))
            put("Djibouti", LatLng(11.825138, 42.590275))
            put("Denmark", LatLng(56.26392, 9.501785))
            put("Dominica", LatLng(15.414999, -61.370976))
            put("Dominican Republic", LatLng(18.735693, -70.162651))
            put("Algeria", LatLng(28.033886, 1.659626))
            put("Ecuador", LatLng(-1.831239, -78.183406))
            put("Estonia", LatLng(58.595272, 25.013607))
            put("Egypt", LatLng(26.820553, 30.802498))
            put("Western Sahara", LatLng(24.215527, -12.885834))
            put("Eritrea", LatLng(15.179384, 39.782334))
            put("Spain", LatLng(40.463667, -3.74922))
            put("Ethiopia", LatLng(9.145, 40.489673))
            put("Finland", LatLng(61.92411, 25.748151))
            put("Fiji", LatLng(-16.578193, 179.414413))
            put("Falkland Islands [Islas Malvinas]", LatLng(-51.796253, -59.523613))
            put("Micronesia", LatLng(7.425554, 150.550812))
            put("Faroe Islands", LatLng(61.892635, -6.911806))
            put("France", LatLng(46.227638, 2.213749))
            put("Gabon", LatLng(-0.803689, 11.609444))
            put("United Kingdom", LatLng(55.378051, -3.435973))
            put("Grenada", LatLng(12.262776, -61.604171))
            put("Georgia", LatLng(42.315407, 43.356892))
            put("French Guiana", LatLng(3.933889, -53.125782))
            put("Guernsey", LatLng(49.465691, -2.585278))
            put("Ghana", LatLng(7.946527, -1.023194))
            put("Gibraltar", LatLng(36.137741, -5.345374))
            put("Greenland", LatLng(71.706936, -42.604303))
            put("Gambia", LatLng(13.443182, -15.310139))
            put("Guinea", LatLng(9.945587, -9.696645))
            put("Guadeloupe", LatLng(16.995971, -62.067641))
            put("Equatorial Guinea", LatLng(1.650801, 10.267895))
            put("Greece", LatLng(39.074208, 21.824312))
            put("South Georgia and the South Sandwich Islands", LatLng(-54.429579, -36.587909))
            put("Guatemala", LatLng(15.783471, -90.230759))
            put("Guam", LatLng(13.444304, 144.793731))
            put("Guinea-Bissau", LatLng(11.803749, -15.180413))
            put("Guyana", LatLng(4.860416, -58.93018))
            put("Gaza Strip", LatLng(31.354676, 34.308825))
            put("Hong Kong", LatLng(22.396428, 114.109497))
            put("Heard Island and McDonald Islands", LatLng(-53.08181, 73.504158))
            put("Honduras", LatLng(15.199999, -86.241905))
            put("Croatia", LatLng(45.1, 15.2))
            put("Haiti", LatLng(18.971187, -72.285215))
            put("Hungary", LatLng(47.162494, 19.503304))
            put("Indonesia", LatLng(-0.789275, 113.921327))
            put("Ireland", LatLng(53.41291, -8.24389))
            put("Israel", LatLng(31.046051, 34.851612))
            put("Isle of Man", LatLng(54.236107, -4.548056))
            put("India", LatLng(20.593684, 78.96288))
            put("British Indian Ocean Territory", LatLng(-6.343194, 71.876519))
            put("Iraq", LatLng(33.223191, 43.679291))
            put("Iran", LatLng(32.427908, 53.688046))
            put("Iceland", LatLng(64.963051, -19.020835))
            put("Italy", LatLng(41.87194, 12.56738))
            put("Jersey", LatLng(49.214439, -2.13125))
            put("Jamaica", LatLng(18.109581, -77.297508))
            put("Jordan", LatLng(30.585164, 36.238414))
            put("Japan", LatLng(36.204824, 138.252924))
            put("Kenya", LatLng(-0.023559, 37.906193))
            put("Kyrgyzstan", LatLng(41.20438, 74.766098))
            put("Cambodia", LatLng(12.565679, 104.990963))
            put("Kiribati", LatLng(-3.370417, -168.734039))
            put("Comoros", LatLng(-11.875001, 43.872219))
            put("Saint Kitts and Nevis", LatLng(17.357822, -62.782998))
            put("North Korea", LatLng(40.339852, 127.510093))
            put("South Korea", LatLng(35.907757, 127.766922))
            put("Kuwait", LatLng(29.31166, 47.481766))
            put("Cayman Islands", LatLng(19.513469, -80.566956))
            put("Kazakhstan", LatLng(48.019573, 66.923684))
            put("Laos", LatLng(19.85627, 102.495496))
            put("Lebanon", LatLng(33.854721, 35.862285))
            put("Saint Lucia", LatLng(13.909444, -60.978893))
            put("Liechtenstein", LatLng(47.166, 9.555373))
            put("Sri Lanka", LatLng(7.873054, 80.771797))
            put("Liberia", LatLng(6.428055, -9.429499))
            put("Lesotho", LatLng(-29.609988, 28.233608))
            put("Lithuania", LatLng(55.169438, 23.881275))
            put("Luxembourg", LatLng(49.815273, 6.129583))
            put("Latvia", LatLng(56.879635, 24.603189))
            put("Libya", LatLng(26.3351, 17.228331))
            put("Morocco", LatLng(31.791702, -7.09262))
            put("Monaco", LatLng(43.750298, 7.412841))
            put("Moldova", LatLng(47.411631, 28.369885))
            put("Montenegro", LatLng(42.708678, 19.37439))
            put("Madagascar", LatLng(-18.766947, 46.869107))
            put("Marshall Islands", LatLng(7.131474, 171.184478))
            put("Macedonia [FYROM]", LatLng(41.608635, 21.745275))
            put("Mali", LatLng(17.570692, -3.996166))
            put("Myanmar [Burma]", LatLng(21.913965, 95.956223))
            put("Mongolia", LatLng(46.862496, 103.846656))
            put("Macau", LatLng(22.198745, 113.543873))
            put("Northern Mariana Islands", LatLng(17.33083, 145.38469))
            put("Martinique", LatLng(14.641528, -61.024174))
            put("Mauritania", LatLng(21.00789, -10.940835))
            put("Montserrat", LatLng(16.742498, -62.187366))
            put("Malta", LatLng(35.937496, 14.375416))
            put("Mauritius", LatLng(-20.348404, 57.552152))
            put("Maldives", LatLng(3.202778, 73.22068))
            put("Malawi", LatLng(-13.254308, 34.301525))
            put("Mexico", LatLng(23.634501, -102.552784))
            put("Malaysia", LatLng(4.210484, 101.975766))
            put("Mozambique", LatLng(-18.665695, 35.529562))
            put("Namibia", LatLng(-22.95764, 18.49041))
            put("New Caledonia", LatLng(-20.904305, 165.618042))
            put("Niger", LatLng(17.607789, 8.081666))
            put("Norfolk Island", LatLng(-29.040835, 167.954712))
            put("Nigeria", LatLng(9.081999, 8.675277))
            put("Nicaragua", LatLng(12.865416, -85.207229))
            put("Netherlands", LatLng(52.132633, 5.291266))
            put("Norway", LatLng(60.472024, 8.468946))
            put("Nepal", LatLng(28.394857, 84.124008))
            put("Nauru", LatLng(-0.522778, 166.931503))
            put("Niue", LatLng(-19.054445, -169.867233))
            put("New Zealand", LatLng(-40.900557, 174.885971))
            put("Oman", LatLng(21.512583, 55.923255))
            put("Panama", LatLng(8.537981, -80.782127))
            put("Peru", LatLng(-9.189967, -75.015152))
            put("French Polynesia", LatLng(-17.679742, -149.406843))
            put("Papua New Guinea", LatLng(-6.314993, 143.95555))
            put("Philippines", LatLng(12.879721, 121.774017))
            put("Pakistan", LatLng(30.375321, 69.345116))
            put("Poland", LatLng(51.919438, 19.145136))
            put("Saint Pierre and Miquelon", LatLng(46.941936, -56.27111))
            put("Pitcairn Islands", LatLng(-24.703615, -127.439308))
            put("Puerto Rico", LatLng(18.220833, -66.590149))
            put("Palestinian Territories", LatLng(31.952162, 35.233154))
            put("Portugal", LatLng(39.399872, -8.224454))
            put("Palau", LatLng(7.51498, 134.58252))
            put("Paraguay", LatLng(-23.442503, -58.443832))
            put("Qatar", LatLng(25.354826, 51.183884))
            put("Réunion", LatLng(-21.115141, 55.536384))
            put("Romania", LatLng(45.943161, 24.96676))
            put("Serbia", LatLng(44.016521, 21.005859))
            put("Russia", LatLng(61.52401, 105.318756))
            put("Rwanda", LatLng(-1.940278, 29.873888))
            put("Saudi Arabia", LatLng(23.885942, 45.079162))
            put("Solomon Islands", LatLng(-9.64571, 160.156194))
            put("Seychelles", LatLng(-4.679574, 55.491977))
            put("Sudan", LatLng(12.862807, 30.217636))
            put("Sweden", LatLng(60.128161, 18.643501))
            put("Singapore", LatLng(1.352083, 103.819836))
            put("Saint Helena", LatLng(-24.143474, -10.030696))
            put("Slovenia", LatLng(46.151241, 14.995463))
            put("Svalbard and Jan Mayen", LatLng(77.553604, 23.670272))
            put("Slovakia", LatLng(48.669026, 19.699024))
            put("Sierra Leone", LatLng(8.460555, -11.779889))
            put("San Marino", LatLng(43.94236, 12.457777))
            put("Senegal", LatLng(14.497401, -14.452362))
            put("Somalia", LatLng(5.152149, 46.199616))
            put("Suriname", LatLng(3.919305, -56.027783))
            put("São Tomé and Príncipe", LatLng(0.18636, 6.613081))
            put("El Salvador", LatLng(13.794185, -88.89653))
            put("Syria", LatLng(34.802075, 38.996815))
            put("Swaziland", LatLng(-26.522503, 31.465866))
            put("Turks and Caicos Islands", LatLng(21.694025, -71.797928))
            put("Chad", LatLng(15.454166, 18.732207))
            put("French Southern Territories", LatLng(-49.280366, 69.348557))
            put("Togo", LatLng(8.619543, 0.824782))
            put("Thailand", LatLng(15.870032, 100.992541))
            put("Tajikistan", LatLng(38.861034, 71.276093))
            put("Tokelau", LatLng(-8.967363, -171.855881))
            put("Timor-Leste", LatLng(-8.874217, 125.727539))
            put("Turkmenistan", LatLng(38.969719, 59.556278))
            put("Tunisia", LatLng(33.886917, 9.537499))
            put("Tonga", LatLng(-21.178986, -175.198242))
            put("Turkey", LatLng(38.963745, 35.243322))
            put("Trinidad and Tobago", LatLng(10.691803, -61.222503))
            put("Tuvalu", LatLng(-7.109535, 177.64933))
            put("Taiwan", LatLng(23.69781, 120.960515))
            put("Tanzania", LatLng(-6.369028, 34.888822))
            put("Ukraine", LatLng(48.379433, 31.16558))
            put("Uganda", LatLng(1.373333, 32.290275))
            put("United States", LatLng(37.09024, -95.712891))
            put("Uruguay", LatLng(-32.522779, -55.765835))
            put("Uzbekistan", LatLng(41.377491, 64.585262))
            put("Vatican City", LatLng(41.902916, 12.453389))
            put("Saint Vincent and the Grenadines", LatLng(12.984305, -61.287228))
            put("Venezuela", LatLng(6.42375, -66.58973))
            put("British Virgin Islands", LatLng(18.420695, -64.639968))
            put("U.S. Virgin Islands", LatLng(18.335765, -64.896335))
            put("Vietnam", LatLng(14.058324, 108.277199))
            put("Vanuatu", LatLng(-15.376706, 166.959158))
            put("Wallis and Futuna", LatLng(-13.768752, -177.156097))
            put("Samoa", LatLng(-13.759029, -172.104629))
            put("Kosovo", LatLng(42.602636, 20.902977))
            put("Yemen", LatLng(15.552727, 48.516388))
            put("Mayotte", LatLng(-12.8275, 45.166244))
            put("South Africa", LatLng(-30.559482, 22.937506))
            put("Zambia", LatLng(-13.133897, 27.849332))
            put("Zimbabwe", LatLng(-19.015438, 29.154857))
        }
    }

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
        val rootView = inflater.inflate(R.layout.garden_registration_map, container, false)
        mView = rootView.findViewById(R.id.garden_registration_map_view)
        mView.onCreate(savedInstanceState)
        mView.getMapAsync(this)
        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        userCountry = Prefs.infos.userInfoGetString("userCountry", "South Korea")
        gardenLocation = LatLng(Prefs.infos.gardenLocationGetLocation("Garden")[0].toDouble(), Prefs.infos.gardenLocationGetLocation("Garden")[1].toDouble())
        val userCountryLocation = countryLatLngList[userCountry]
        if(isInGardenInfo) {
            val markerOptions = MarkerOptions()
            markerOptions.position(gardenLocation)
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(gardenLocation))
            googleMap.addMarker(markerOptions)
        }
        else {
            if (userCountryLocation != null) {
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(userCountryLocation))
            }
        }
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(5f))
        map = googleMap
        map.setOnMapLongClickListener(this)
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
    override fun onMapLongClick(point: LatLng) {
        val markerOptions = MarkerOptions()
        markerOptions.position(point)
        gardenLocation = point
        Prefs.infos.gardenLocationSetLocation("Garden", gardenLocation.latitude.toFloat(), gardenLocation.longitude.toFloat())
        map.clear()
        map.animateCamera(CameraUpdateFactory.newLatLng(point))
        map.addMarker(markerOptions)
    }
}
