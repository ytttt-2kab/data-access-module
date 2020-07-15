package com.example.dataaccessmodule.model

import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

enum class PraiseType(val intValue: Int) {
    NO_VALUE(0),
    THANK_YOU(1),
    GOOD_PROPOSAL(2);

    companion object {
        fun getByIntValue(intValue: Int) : PraiseType {
            return Arrays.stream(values())
                    .filter{it.equals(intValue)}
                    .findFirst()
                    .orElse(NO_VALUE);
        }
    }
}

@MappedTypes(PraiseType::class)
class PraiseTypeHandler : BaseTypeHandler<PraiseType>() {
    override fun getNullableResult(p0: ResultSet, p1: String): PraiseType {
        return PraiseType.getByIntValue(p0.getInt(p1))
    }

    override fun getNullableResult(p0: ResultSet, p1: Int): PraiseType {
        return PraiseType.getByIntValue(p0.getInt(p1))
    }

    override fun getNullableResult(p0: CallableStatement, p1: Int): PraiseType {
        return PraiseType.getByIntValue(p0.getInt(p1))
    }

    override fun setNonNullParameter(p0: PreparedStatement, p1: Int, p2: PraiseType, p3: JdbcType) {
        p0.setInt(p1, p2.intValue)
    }
}
