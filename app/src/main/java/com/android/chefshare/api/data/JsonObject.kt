import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser

val gson = Gson()

fun convertToJsonObject(input: Any): JsonObject {
    val jsonElement: JsonElement = when (input) {
        is String -> JsonParser.parseString(input) // Nếu đã là chuỗi JSON
        else -> gson.toJsonTree(input) // Convert object bất kỳ sang JsonElement
    }

    if (!jsonElement.isJsonObject) {
        throw IllegalStateException("Expected JSON object but got: ${jsonElement.javaClass.simpleName}")
    }

    return jsonElement.asJsonObject
}
