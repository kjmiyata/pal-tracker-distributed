package io.pivotal.pal.tracker.users.data

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement
import javax.sql.DataSource

@Repository
open class UserDataGateway(dataSource: DataSource) {

    private val jdbcTemplate = JdbcTemplate(dataSource)

    open fun create(name: String?): UserRecord? {
        val keyholder: KeyHolder = GeneratedKeyHolder()
        jdbcTemplate.update({ connection: Connection ->
            val ps = connection.prepareStatement("insert into users (name) values (?)", Statement.RETURN_GENERATED_KEYS)
            ps.setString(1, name)
            ps
        }, keyholder)
        return find(keyholder.key!!.toLong())
    }

    open fun find(id: Long): UserRecord? {
        val list = jdbcTemplate.query("select id, name from users where id = ? limit 1", rowMapper, id)
        return if (list.isEmpty()) {
            null
        } else
            list[0]
    }

    private val rowMapper = RowMapper { rs: ResultSet, _: Int ->
        UserRecord(rs.getLong("id"), rs.getString("name"))
    }
}