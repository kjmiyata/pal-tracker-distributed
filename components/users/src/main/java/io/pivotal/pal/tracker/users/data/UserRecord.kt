package io.pivotal.pal.tracker.users.data

data class UserRecord(val id: Long, val name: String) {

    override fun toString(): String {
        return "UserRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'
    }
}