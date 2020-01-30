package io.pivotal.pal.tracker.allocations

import org.springframework.web.client.RestOperations

open class ProjectClient(
        private val restOperations: RestOperations,
        private val registrationServerEndpoint: String) {

    open fun getProject(projectId: Long): ProjectInfo? {
        return restOperations.getForObject("$registrationServerEndpoint/projects/$projectId", ProjectInfo::class.java)
    }
}