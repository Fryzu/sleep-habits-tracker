package com.example.sleephabitstracker.state

import com.example.sleephabitstracker.state.datastore.SleepEventsSubscriptionStatus
import com.example.sleephabitstracker.state.sleepevent.SleepEvent
import com.example.sleephabitstracker.state.sleepevent.SleepEventDAO
import kotlinx.coroutines.flow.Flow

/**
 * Zapewnia abstrakcje do obslugi kilku zrodel danych
 */
class SleepHabitsTrackerRepository(
    private val sleepEventDAO: SleepEventDAO,
    private val sleepEventsSubscriptionStatus: SleepEventsSubscriptionStatus
) {

    val getAllSleepEvents: Flow<List<SleepEvent>> = sleepEventDAO.getAll()

    val subscribedToSleepEvents: Flow<Boolean> = sleepEventsSubscriptionStatus.subscribedToSleepEvents

    suspend fun insertSleepEvents(sleepEvents: List<SleepEvent>) {
        sleepEventDAO.insertList(sleepEvents)
    }

    suspend fun updateSubscribedToSleepEvents(subscribedToSleep: Boolean) =
        sleepEventsSubscriptionStatus.updateSubscribedToSleepEvents(subscribedToSleep)

}