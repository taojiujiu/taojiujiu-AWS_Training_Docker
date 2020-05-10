package com.aws.training.docker.tracker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TrackerController(val trackerService: TrackerService){

    @GetMapping("/{id}/track-info")
    fun getUserTrackerInfos(@PathVariable id: Int): List<TrackerInfosDTO>? {
        return trackerService.getTrackerInfos(id)
    }

    @PostMapping("/track-info")
    fun addTrackerDetail(@RequestBody info:TrackerInfoDTO): TrackerDetailDTO{
        return trackerService.addTrackerDetail(info)
    }

}
