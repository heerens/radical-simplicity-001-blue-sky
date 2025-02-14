package com.radicalsimplicity.bluesky.adapter.web.index

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexPageController {
    @GetMapping("/")
    fun index(): String = "index/IndexPage"
}
