package com.dijta.ses


import com.dijta.common.security.SecurityPrincipal
import io.vavr.API
import org.apache.tomcat.jdbc.pool.DataSource

trait TestConstants {
	
	String asJwt(String previlege, String overAllPrevilage = "TEST_APP_ALLOWED") {
		return SecurityPrincipal.builder().id(1L).name("Test User").privileges(API.Set(previlege, overAllPrevilage)).build().toJwt()
	}
	
	String asJwtWithTenant(String previlege, Long tenantId, String overAllPrevilage = "TEST_APP_ALLOWED") {
		return SecurityPrincipal
				.builder()
				.id(1L)
				.name("Test User")
				.tenantId(tenantId)
				.privileges(API.Set(previlege, overAllPrevilage))
				.build()
				.toJwt()
	}

	DataSource inMemoryDataSource() {
        return new DataSource().with { dataSource ->
            dataSource.driverClassName = 'org.h2.Driver'
            dataSource.url = 'jdbc:h2:mem:testdb'
            dataSource.username = 'sa'
            dataSource.password = ''
            dataSource
        }
    }

}
