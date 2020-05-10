package com.aws.training.docker.tracker

import org.springframework.data.repository.CrudRepository

interface TrackerDetailRepository : CrudRepository<TrackerDetail, Long> {
    fun findAllByAccountIdAndTrackerTypeId(accountId: Int, trackerType: Int) : List<TrackerDetail>
}

interface TrackerTypeRepository : CrudRepository<TrackerType, Long> {
    fun findAllByAccountId(accountId: Int) : List<TrackerType>
    fun findByName(name: String): TrackerType
}

interface AccountRepository : CrudRepository<Account, Int> {
}
