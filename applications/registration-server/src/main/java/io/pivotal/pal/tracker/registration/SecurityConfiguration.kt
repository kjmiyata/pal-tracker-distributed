package io.pivotal.pal.tracker.registration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
open class SecurityConfiguration(disableDefaults: Boolean = false) : WebSecurityConfigurerAdapter(disableDefaults) {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable()
    }
}