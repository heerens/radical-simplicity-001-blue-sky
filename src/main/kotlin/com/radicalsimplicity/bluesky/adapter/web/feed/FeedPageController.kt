package com.radicalsimplicity.bluesky.adapter.web.feed

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FeedPageController {
    @GetMapping("/")
    fun index(): String = "feed/FeedPage"
}
