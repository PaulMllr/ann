/*
 * Copyright Rhonda Software Ltd. 2018.
 * All rights reserved.
 */

package io.codenetics.ann.web.filter

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class RequestLoggingFilter : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        logger.info("Incoming REST request : ${request.method} ${request.requestURI}")
        filterChain.doFilter(request, response)
    }
}