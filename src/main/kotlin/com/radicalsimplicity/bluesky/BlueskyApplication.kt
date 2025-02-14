package com.radicalsimplicity.bluesky

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlueskyApplication

fun main(args: Array<String>) {
	runApplication<BlueskyApplication>(*args)
}
