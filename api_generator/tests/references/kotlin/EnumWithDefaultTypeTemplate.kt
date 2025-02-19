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
sealed class EnumWithDefaultTypeTemplate : JSONSerializable, JsonTemplate<EnumWithDefaultType> {
    class WithDefaultCase(val value: WithDefaultTemplate) : EnumWithDefaultTypeTemplate()
    class WithoutDefaultCase(val value: WithoutDefaultTemplate) : EnumWithDefaultTypeTemplate()

    fun value(): Any {
        return when (this) {
            is WithDefaultCase -> value
            is WithoutDefaultCase -> value
        }
    }

    override fun writeToJSON(): JSONObject {
        return when (this) {
            is WithDefaultCase -> value.writeToJSON()
            is WithoutDefaultCase -> value.writeToJSON()
        }
    }

    override fun resolve(env: ParsingEnvironment, data: JSONObject): EnumWithDefaultType {
        return when (this) {
            is WithDefaultCase -> EnumWithDefaultType.WithDefaultCase(value.resolve(env, data))
            is WithoutDefaultCase -> EnumWithDefaultType.WithoutDefaultCase(value.resolve(env, data))
        }
    }

    val type: String
        get() {
            return when (this) {
                is WithDefaultCase -> WithDefaultTemplate.TYPE
                is WithoutDefaultCase -> WithoutDefaultTemplate.TYPE
            }
        }

    companion object {
        @Throws(ParsingException::class)
        operator fun invoke(
            env: ParsingEnvironment,
            topLevel: Boolean = false,
            json: JSONObject
        ): EnumWithDefaultTypeTemplate {
            val logger = env.logger
            val receivedType: String = json.read("type", logger = logger, env = env)
            val parent = env.templates[receivedType] as? EnumWithDefaultTypeTemplate
            val type = parent?.type ?: receivedType
            when (type) {
                WithDefaultTemplate.TYPE -> return WithDefaultCase(WithDefaultTemplate(env, parent?.value() as WithDefaultTemplate?, topLevel, json))
                WithoutDefaultTemplate.TYPE -> return WithoutDefaultCase(WithoutDefaultTemplate(env, parent?.value() as WithoutDefaultTemplate?, topLevel, json))
                else -> throw typeMismatch(json = json, key = "type", value = type)
            }
        }
        val CREATOR = { env: ParsingEnvironment, it: JSONObject -> EnumWithDefaultTypeTemplate(env, json = it) }
    }
}
