package com.aws.training.docker.tracker

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class TrackerDetail (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String? = null,
    var xValue: String,
    var yValue: String,
    @ManyToOne
    var account: Account,
    @ManyToOne
    var trackerType:TrackerType,
    val created_at: Instant? = Instant.now())

@Entity
class TrackerType (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var xName: String,
    var yName: String,
    @ManyToOne
    var account: Account)


@Entity
class Account (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String)
