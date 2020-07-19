package com.example.dataaccessmodule.dao

import com.example.dataaccessmodule.model.PraiseType
import org.apache.ibatis.annotations.Mapper

@Mapper
interface PraiseDao {
    fun countAll(): Int
    fun countByUserId(userId: Int): Int
    fun countByPraiseType(praiseType: PraiseType): Int
}
