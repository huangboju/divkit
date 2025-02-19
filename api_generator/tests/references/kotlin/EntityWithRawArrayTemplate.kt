// Generated code. Do not modify.

package com.yandex.div2

import android.graphics.Color
import android.net.Uri
import androidx.annotation.ColorInt
import com.yandex.div.json.*
import com.yandex.div.json.expressions.Expression
import com.yandex.div.json.expressions.ExpressionsList
import com.yandex.div.json.schema.*
import com.yandex.div.core.annotations.Mockable
import java.io.IOException
import java.util.BitSet
import org.json.JSONObject
import com.yandex.div.data.*
import org.json.JSONArray

@Mockable
class EntityWithRawArrayTemplate : JSONSerializable, JsonTemplate<EntityWithRawArray> {
    @JvmField final val array: Field<JSONArray>

    constructor (
        env: ParsingEnvironment,
        parent: EntityWithRawArrayTemplate? = null,
        topLevel: Boolean = false,
        json: JSONObject
    ) {
        val logger = env.logger
        array = JsonTemplateParser.readField(json, "array", topLevel, parent?.array, logger, env)
    }

    override fun resolve(env: ParsingEnvironment, data: JSONObject): EntityWithRawArray {
        return EntityWithRawArray(
            array = array.resolve(env = env, key = "array", data = data, reader = ARRAY_READER)
        )
    }

    override fun writeToJSON(): JSONObject {
        val json = JSONObject()
        json.writeField(key = "array", field = array)
        json.write(key = "type", value = TYPE)
        return json
    }

    companion object {
        const val TYPE = "entity_with_raw_array"

        val ARRAY_READER: Reader<JSONArray> = { key, json, env -> JsonParser.read(json, key, env.logger, env) }
        val TYPE_READER: Reader<String> = { key, json, env -> JsonParser.read(json, key, env.logger, env) }

        val CREATOR = { env: ParsingEnvironment, it: JSONObject -> EntityWithRawArrayTemplate(env, json = it) }
    }

}
