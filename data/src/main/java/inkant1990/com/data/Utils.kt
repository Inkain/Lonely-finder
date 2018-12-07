package inkant1990.com.data

class Utils {
    class Utils {
        companion object {
            fun transformToRequest(data: String?): String {
                return "name LIKE'${data}%'"
            }
        }
    }
}