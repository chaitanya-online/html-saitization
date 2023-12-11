package com.dijta.ses

import io.restassured.RestAssured
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import javax.sql.DataSource

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
class DxSesApiApplicationSpec extends Specification implements TestConstants {

    @LocalServerPort
    private int localServerPort

    DataSource dataSource

    def setup() {
        RestAssured.port = localServerPort
        dataSource = inMemoryDataSource()
    }

    def cleanup() {
        RestAssured.reset()
    }

  /*  def 'application context created' () {
        expect:
        1 == 1
    }*/
}
