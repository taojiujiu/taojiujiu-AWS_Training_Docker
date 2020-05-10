package com.aws.training.docker.tracker

data class TrackerInfosDTO(val userId: Int, val type: TrackerTypeDTO, val details: List<TrackerDetailDTO>)

data class TrackerInfoDTO(val userId: Int, val type: TrackerTypeDTO, val details: TrackerDetailDTO)

data class TrackerDetailDTO (val xValue : String, val yValue : String)

data class TrackerTypeDTO (val name: String, val xName: String, val yName: String)
