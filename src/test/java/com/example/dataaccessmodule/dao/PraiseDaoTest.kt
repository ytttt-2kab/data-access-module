package com.example.dataaccessmodule.dao

import com.example.dataaccessmodule.model.PraiseType
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component

@SpringBootTest
@Component
class PraiseDaoTest {
    @Autowired
    private lateinit var praiseDao: PraiseDao

    @Test
    fun testCountAll(){
        val ret = praiseDao.countAll()
        Assertions.assertThat(ret).isEqualTo(8)
    }

    @Test
    fun testCountByUserId(){
        val ret1 = praiseDao.countByUserId(1)
        Assertions.assertThat(ret1).isEqualTo(2)

        val ret2 = praiseDao.countByUserId(2)
        Assertions.assertThat(ret2).isEqualTo(3)

        val ret3 = praiseDao.countByUserId(3)
        Assertions.assertThat(ret3).isEqualTo(3)
    }

    @Test
    fun testCountByPraiseType(){
        val ret0 = praiseDao.countByPraiseType(PraiseType.NO_VALUE)
        Assertions.assertThat(ret0).isEqualTo(0)

        val ret1 = praiseDao.countByPraiseType(PraiseType.THANK_YOU)
        Assertions.assertThat(ret1).isEqualTo(3)

        val ret2 = praiseDao.countByPraiseType(PraiseType.GOOD_PROPOSAL)
        Assertions.assertThat(ret2).isEqualTo(5)
    }
}
