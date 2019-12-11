package com.rego.jorge.main

import com.rego.jorge.stringcalculator.MainPresenter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class MainPresenterTest(val username: String, val password: String, val expected: Boolean) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("","",false),
                arrayOf("admin","",false),
                arrayOf("","admin",false),
                arrayOf("asdas","asdasd",false),
                arrayOf("admin","asdasd",false),
                arrayOf("sada","asdasd",false),
                arrayOf("admin","admin",true)
            )
        }
    }

    private lateinit var sutPresenter: MainPresenter


    @Before
    fun setup() {
        sutPresenter = MainPresenter()
    }

    @Test
    fun `when pressing login with fields, we return `() {
        val result = sutPresenter.onLoginButtonClick(username, password)

        Assert.assertEquals(result, expected)
    }


}