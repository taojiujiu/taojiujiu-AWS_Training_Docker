package com.aws.training.docker.tracker

import org.springframework.stereotype.Service

@Service
class TrackerService(val trackerDetailRepository: TrackerDetailRepository,
                     val trackerTypeRepository: TrackerTypeRepository,
                     val accountRepository: AccountRepository) {

    fun getTrackerInfos(accountId: Int): List<TrackerInfosDTO>? {
        return trackerTypeRepository.findAllByAccountId(accountId)
            .map { type ->
                TrackerInfosDTO(accountId, type.mapToDTO(),
                    trackerDetailRepository.findAllByAccountIdAndTrackerTypeId(accountId, type.id)
                        .map { detail ->
                            System.out.println(detail);
                            TrackerDetailDTO(detail.xValue, detail.yValue)
                        }
                )
            }
    }

    fun addTrackerDetail(info: TrackerInfoDTO): TrackerDetailDTO {
        val account =accountRepository.findById(info.userId).get()
        val trackerType = trackerTypeRepository.findByName(info.type.name)
        return trackerDetailRepository.save(
            TrackerDetail(trackerType = trackerType,
                account = account,
                xValue = info.details.xValue,
                yValue = info.details.yValue
            )).mapToDTO()
    }
}

fun TrackerType.mapToDTO(): TrackerTypeDTO {
    return TrackerTypeDTO(this.name, this.xName, this.yName)
}

fun TrackerDetail.mapToDTO(): TrackerDetailDTO {
    return TrackerDetailDTO(this.xValue, this.yValue)
}

