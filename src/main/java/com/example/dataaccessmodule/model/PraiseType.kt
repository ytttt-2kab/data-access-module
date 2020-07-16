package com.example.dataaccessmodule.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

enum class PraiseType(@get:JsonValue val intValue: Int) {
    NO_VALUE(0),
    THANK_YOU(1),
    GOOD_PROPOSAL(2);

    companion object {
        @JvmStatic
        fun getByIntValue(value: Int) : PraiseType? {
            return values().firstOrNull{it.intValue == value}
        }

        @JvmStatic
        @JsonCreator
        fun create(value: Int): PraiseType? {
            return getByIntValue(value)
        }

        @JvmStatic
        @JsonCreator
        fun create(value: String): PraiseType? {
            return getByIntValue(Integer.parseInt(value))
        }
    }
}

//@MappedTypes(PraiseType::class)
class PraiseTypeHandler : BaseTypeHandler<PraiseType>() {
    override fun getNullableResult(p0: ResultSet, p1: String): PraiseType? {
        return PraiseType.create(p0.getInt(p1))
    }

    override fun getNullableResult(p0: ResultSet, p1: Int): PraiseType? {
        return PraiseType.create(p0.getInt(p1))
    }

    override fun getNullableResult(p0: CallableStatement, p1: Int): PraiseType? {
        return PraiseType.create(p0.getInt(p1))
    }

    override fun setNonNullParameter(p0: PreparedStatement, p1: Int, p2: PraiseType, p3: JdbcType?) {
        p0.setInt(p1, p2.intValue)
    }
}
